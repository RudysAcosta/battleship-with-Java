import battleship.Board;

import battleship.entity.*;

import battleship.entity.Ship;
import battleship.exception.InvalidPositionException;
import battleship.exception.InvalidShipSizeException;
import battleship.validate.ShipPlacementValidator;

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
            board.printBoard();

            placeShip(new battleship.entity.Battleship());
            board.printBoard();

            placeShip(new Submarine());
            board.printBoard();

            placeShip(new Cruiser());
            board.printBoard();

            placeShip(new Destroyer());
            board.printBoard();

       }

    private void placeShip(Ship ship) {
        ShipPlacementValidator shipValidator = new ShipPlacementValidator(ship, board);
        boolean placedSuccessfully = false;

        System.out.println("\n" + ship.getPrompt() + "\n");

        while (!placedSuccessfully) {
            String[] inputPositions = inputHandler.getCoordinates();

            try {
                int[] posStart = ShipPlacementValidator.parsePosition(inputPositions[0]);
                int[] posEnd = ShipPlacementValidator.parsePosition(inputPositions[1]);

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
