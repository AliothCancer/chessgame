// Record per il comando parsato
public record Command(Type type, String[] args) {
    enum Type { QUIT, HELP, SHOW, SELECT, MOVE, UNKNOWN }
    
    public static Command parse(String input) {
        
    	String[] parts = input.strip().toLowerCase().split("\\s+");
        
        if (parts.length == 0) return new Command(Type.HELP, parts);

        return switch (parts[0]) {
            case "q", "quit"         -> new Command(Type.QUIT, parts);
            case "show"              -> parts.length >= 2
                                        ? new Command(Type.SHOW, parts)
                                        : new Command(Type.HELP, parts);
            case "sel", "select"     -> parts.length >= 2
                                        ? new Command(Type.SELECT, parts)
                                        : new Command(Type.HELP, parts);
            case "move"              -> parts.length == 4 && parts[2].equals("in")
                                        ? new Command(Type.MOVE, parts)
                                        : new Command(Type.UNKNOWN, parts);
            default                  -> new Command(Type.UNKNOWN, parts);
        };
    }
}