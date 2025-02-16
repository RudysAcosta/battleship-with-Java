import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int[] startCoordinate;
    private int[] endCoordinate;

    private int length;

    public Ship(int[] startCoordinate, int[] endCoordinate) {
        if (endCoordinate[0] > startCoordinate[0]) {
            this.startCoordinate = startCoordinate;
            this.endCoordinate = endCoordinate;
        } else {
            this.startCoordinate = endCoordinate;
            this.endCoordinate = startCoordinate;
        }

        this.length =  (this.endCoordinate[0] - this.startCoordinate[0]) + 1;
    }

    public int getLength() {
        return length;
    }

    public List<Coordinate> cells() {
        List<Coordinate> coordinates = new ArrayList();

        for (int i = this.startCoordinate[0]; i <= this.endCoordinate[0]; i++) {
            coordinates.add(new Coordinate(i, this.startCoordinate[1]));
        }

        return coordinates;
    }

}
