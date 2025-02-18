import battleship.Board;

import battleship.entity.AircraftCarrier;
import battleship.entity.Ship;

import battleship.exception.InvalidPositionException;
import battleship.exception.InvalidShipSizeException;
import battleship.validate.ShipPlacementValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class Battleship {
        private final UserInput inputHandler;
        private final Board board;

        public Battleship() {
            this.inputHandler = new UserInput();
            this.board = new Board();
        }

        public void startGame() {
            board.printBoard();

            placeShip(new AircraftCarrier());
       }

    private void placeShip(Ship ship) {
        ShipPlacementValidator shipValidator = new ShipPlacementValidator(ship, board);
        boolean placedSuccessfully = false;

        while (!placedSuccessfully) {
            String[] inputPositions = inputHandler.getCoordinates(ship.getPrompt());

            try {
                int[] posStart = ShipPlacementValidator.parsePosition(inputPositions[0]);
                int[] posEnd = ShipPlacementValidator.parsePosition(inputPositions[1]);

                shipValidator.isValidPlacement(posStart, posEnd);

                Set<String> positions = shipValidator.getPositions(posStart, posEnd);

                if (board.isOccupied(positions)) {
                    System.out.println("Error! You placed it on an occupied cell. Try again:");
                    continue;
                }

                if (board.isClose(positions)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    continue;
                }

                board.add(positions);
                board.testBoard();
                placedSuccessfully = true;

            } catch (InvalidPositionException | InvalidShipSizeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
