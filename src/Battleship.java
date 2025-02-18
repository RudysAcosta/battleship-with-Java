import battleship.Board;
import battleship.entity.AircraftCarrier;
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
//            placeShip();
            coordinatesAircraft();
       }

       private void coordinatesAircraft() {
            String[] inputPositions = inputHandler.getCoordinates("Enter the coordinates of the Aircraft Carrier (5 cells):");

            try {
                ShipPlacementValidator shipValidator = new ShipPlacementValidator(new AircraftCarrier(), board);

                int[] posStart = ShipPlacementValidator.parsePosition(inputPositions[0]);
                int[] posEnd = ShipPlacementValidator.parsePosition(inputPositions[1]);

                shipValidator.isValidPlacement(posStart, posEnd);

                Set<String> positions = shipValidator.getPositions(posStart, posEnd);

                if (board.isOccupied(positions)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                };

                board.isClose(positions);

            } catch (InvalidPositionException | InvalidShipSizeException e) {
                System.out.println(e.getMessage());
            }

       }

//        private void placeShip() {
//            String[] inputCoordinates = inputHandler.getCoordinates("Enter the coordinates of the ship:");
//
//            if (!board.isValidCoordinate(inputCoordinates[0], inputCoordinates[1])) {
//                System.out.println("Error!");
//                return;
//            }
//
//            int[] startCoordinate = board.normalizeCoordinate(inputCoordinates[0]);
//            int[] endCoordinate = board.normalizeCoordinate(inputCoordinates[1]);
//
//            Ship ship = new Ship(startCoordinate, endCoordinate);
//            printShipDetails(ship);
//        }

//        private void printShipDetails(Ship ship) {
//            System.out.printf("Length: %d\n", ship.getLength());
//            System.out.printf("Parts: ");
//
//            List<Coordinate> coordinates = ship.cells();
//            for (Coordinate coordinate : coordinates) {
//                System.out.printf("%c%d ", coordinate.rowToChar(), coordinate.getColumn());
//            }
//            System.out.println();
//        }
    }
