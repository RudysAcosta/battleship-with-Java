package battleship.validate;

import battleship.Board;
import battleship.entity.Ship;
import battleship.exception.InvalidPositionException;
import battleship.exception.InvalidShipSizeException;

import java.util.HashSet;
import java.util.Set;

public class ShipPlacementValidator {
    private Ship ship;
    private Board board;

    public ShipPlacementValidator(Ship ship, Board board) {
        this.ship = ship;
        this.board = board;
    }

    public static int[] parsePosition(String pos) {
        String[] position = new String[2];

        position[0] = pos.substring(0, 1);
        position[1] = pos.substring(1);

        int y = position[0].charAt(0) - 64;
        int x = Integer.parseInt(position[1]);

        return new int[]{x, y};
    }

    public static String formatPosition(int x, int y) {
        return (char)(x - 1 + 'A') + "" + y;
    }

    public boolean isValidPlacement(int[] posStart, int[] posEnd) throws InvalidShipSizeException, InvalidPositionException {
        int size = calculateSize(posStart, posEnd);

        if (size == -1) {
            throw new InvalidPositionException();
        }

        if (ship.getSize() != size) {
            throw new InvalidShipSizeException(ship.getName());
        }

        return true;
    }

    public Set<String> getPositions(int[] start, int[] end) {
        Set<String> positions = new HashSet<>();
        if (start[0] == end[0]) { // Horizontal
            for (int i = Math.min(start[1], end[1]); i <= Math.max(start[1], end[1]); i++) {
                positions.add(getLetter(i) +""+ start[0]);
            }
        } else if (start[1] == end[1]) { // Vertical
            for (int i = Math.min(start[0], end[0]); i <= Math.max(start[0], end[0]); i++) {
                positions.add(getLetter(start[1])  + "" + i);
            }
        }
        return positions;
    }

    private char getLetter(int pos) {
        return (char)(pos - 1 + 'A');
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
