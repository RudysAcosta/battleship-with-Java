package battleship.exception;

public class InvalidShipSizeException extends ShipException {
    public InvalidShipSizeException(String type) {
        super("Error! Wrong length of the " + type + "! Try again:");
    }
}
