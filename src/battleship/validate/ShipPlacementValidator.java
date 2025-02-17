package battleship.validate;

import battleship.Board;
import battleship.entity.Ship;
import battleship.exception.InvalidPositionException;
import battleship.exception.InvalidShipSizeException;

import java.util.Arrays;

public class ShipPlacementValidator {
    private Ship ship;
    private Board board;

    public ShipPlacementValidator(Ship ship, Board board) {
        this.ship = ship;
        this.board = board;
    }

    private int[] parsePosition(String pos) {
        String[] position = new String[2];

        position[0] = pos.substring(0, 1);
        position[1] = pos.substring(1);

        int y = position[0].charAt(0) - 64;
        int x = Integer.parseInt(position[1]);

        return new int[]{x, y};
    }

    public void isValidPlacement(String start, String end) throws InvalidShipSizeException, InvalidPositionException {

        int[] posStart = parsePosition(start);
        int[] posEnd = parsePosition(end);

        int size = calculateSize(posStart, posEnd);

        if (size == -1) {
            throw new InvalidPositionException();
        }

        if (ship.getSize() != size) {
            throw new InvalidShipSizeException(ship.getName());
        }

        System.out.println(size);

    }

    public void isOccupied() {

    }

    private void getPositions() {

    }

    private int calculateSize(int[] start, int[] end) {
        if (start[0] == end[0]) { //Horizontal
            return Math.abs(start[1] - end[1]) + 1;
        } else if (start[1] == end[1]) { // Vertical
            return Math.abs(start[0] - end[0]) + 1;
        }

        return -1; // The position is invalid
    }
}
