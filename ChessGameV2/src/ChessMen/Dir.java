package ChessMen;

public enum Dir {
    UP, DOWN, LEFT, RIGHT,
    UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;

    Dir rotateClockWise() {
        return switch (this) {
            case UP         -> RIGHT;
            case RIGHT      -> DOWN;
            case DOWN       -> LEFT;
            case LEFT       -> UP;
            case UP_RIGHT   -> DOWN_RIGHT;
            case DOWN_RIGHT -> DOWN_LEFT;
            case DOWN_LEFT  -> UP_LEFT;
            case UP_LEFT    -> UP_RIGHT;
        };
    }

    Dir rotateCounterClockWise() {
        return switch (this) {
            case UP         -> LEFT;
            case LEFT       -> DOWN;
            case DOWN       -> RIGHT;
            case RIGHT      -> UP;
            case UP_LEFT    -> DOWN_LEFT;
            case DOWN_LEFT  -> DOWN_RIGHT;
            case DOWN_RIGHT -> UP_RIGHT;
            case UP_RIGHT   -> UP_LEFT;
        };
    }

    boolean isDiagonal() {
        return switch (this) {
            case UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT -> true;
            default -> false;
        };
    }
}