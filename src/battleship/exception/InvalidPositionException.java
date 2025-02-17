package battleship.exception;

public class InvalidPositionException extends ShipException {
    public InvalidPositionException() {
        super("Error! Wrong ship location! Try again:");
    }
}
