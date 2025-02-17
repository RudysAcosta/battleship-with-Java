import java.util.Arrays;
import java.util.List;

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
            String[] coordinates = inputHandler.getCoordinates("Enter the coordinates of the Aircraft Carrier (5 cells):");
            System.out.println(Arrays.toString(coordinates));
       }

        private void placeShip() {
            String[] inputCoordinates = inputHandler.getCoordinates("Enter the coordinates of the ship:");

            if (!board.isValidCoordinate(inputCoordinates[0], inputCoordinates[1])) {
                System.out.println("Error!");
                return;
            }

            int[] startCoordinate = board.normalizeCoordinate(inputCoordinates[0]);
            int[] endCoordinate = board.normalizeCoordinate(inputCoordinates[1]);

            Ship ship = new Ship(startCoordinate, endCoordinate);
            printShipDetails(ship);
        }

        private void printShipDetails(Ship ship) {
            System.out.printf("Length: %d\n", ship.getLength());
            System.out.printf("Parts: ");

            List<Coordinate> coordinates = ship.cells();
            for (Coordinate coordinate : coordinates) {
                System.out.printf("%c%d ", coordinate.rowToChar(), coordinate.getColumn());
            }
            System.out.println();
        }
    }
