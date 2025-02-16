import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserInput inputHandler = new UserInput();

        Board board = new Board();
        board.printBoard();

        String[] inputCoordinates = inputHandler.getCoordinates("Enter the coordinates of the ship:");

        if (board.isValidCoordinate(inputCoordinates[0], inputCoordinates[1])) {
            int[] startCoordinate = board.normalizeCoordinate(inputCoordinates[0]);
            int[] endCoordinate = board.normalizeCoordinate(inputCoordinates[1]);

            Ship ship = new Ship(startCoordinate, endCoordinate);

            System.out.printf("Length: %d\n", ship.getLength());
            System.out.printf("Parts: ");

            List<Coordinate> coordinates = ship.cells();

            for (Coordinate coordinate: coordinates) {
                System.out.printf("%c%d ", coordinate.rowToChar(), coordinate.getColumn());
            }
        } else {
            System.out.println("Error!");
        }

    }
}