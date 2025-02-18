package battleship;

import battleship.entity.Board;
import battleship.entity.Ship;
import battleship.exception.InvalidPositionException;
import battleship.exception.InvalidShipSizeException;
import battleship.util.CoordinateUtil;
import battleship.validate.ShipPlacementValidator;

import java.util.Set;

public class ShipPlacer {
    private final Board board;
    private final UserInput inputHandler;

    public ShipPlacer(Board board, UserInput inputHandler) {
        this.board = board;
        this.inputHandler = inputHandler;
    }

    public void placeShip(Ship ship) {
        ShipPlacementValidator shipValidator = new ShipPlacementValidator(ship, board);
        boolean placedSuccessfully = false;

        System.out.println("\n" + ship.getPrompt() + "\n");

        while (!placedSuccessfully) {
            String[] inputPositions = inputHandler.getCoordinates();

            try {
                int[] posStart = CoordinateUtil.parsePosition(inputPositions[0]);
                int[] posEnd = CoordinateUtil.parsePosition(inputPositions[1]);

                shipValidator.isValidPlacement(posStart, posEnd);

                Set<String> positions = shipValidator.getPositions(posStart, posEnd);

                if (board.isOccupied(positions)) {
                    System.out.println("\nError! You placed it on an occupied cell. Try again:\n");
                    continue;
                }

                if (board.isClose(positions)) {
                    System.out.println("\nError! You placed it too close to another one. Try again:\n");
                    continue;
                }

                board.add(positions);
                placedSuccessfully = true;

            } catch (InvalidPositionException | InvalidShipSizeException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }
    }
}
