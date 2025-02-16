import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship {
    private int[] startCoordinate;
    private int[] endCoordinate;

    private int length;

    private final boolean isHorizontal;

    public Ship(int[] startCoordinate, int[] endCoordinate) {
        this.isHorizontal = (startCoordinate[1] == endCoordinate[1]);
        assignCoordinates(startCoordinate, endCoordinate);
        calculateLength();
    }

    private void assignCoordinates(int[] start, int[] end) {
        if (isHorizontal) {
            this.startCoordinate = (start[0] < end[0]) ? start : end;
            this.endCoordinate = (this.startCoordinate == start) ? end : start;
        } else {
            this.startCoordinate = (start[1] < end[1]) ? start : end;
            this.endCoordinate = (this.startCoordinate == start) ? end : start;
        }
    }

    private void calculateLength() {
        if (isHorizontal) {
            this.length = (this.endCoordinate[0] - this.startCoordinate[0]) + 1;
        } else {
            this.length = (this.endCoordinate[1] - this.startCoordinate[1]) + 1;
        }
    }

    public int getLength() {
        return length;
    }

    public List<Coordinate> cells() {
        List<Coordinate> coordinates = new ArrayList<>();

        if (isHorizontal) {
            generateHorizontalCoordinates(coordinates);
        } else {
            generateVerticalCoordinates(coordinates);
        }

        return coordinates;
    }

    private void generateHorizontalCoordinates(List<Coordinate> coordinates) {
        for (int col = startCoordinate[0]; col <= endCoordinate[0]; col++) {
            coordinates.add(new Coordinate(col, startCoordinate[1]));
        }
    }

    private void generateVerticalCoordinates(List<Coordinate> coordinates) {
        for (int row = startCoordinate[1]; row <= endCoordinate[1]; row++) {
            coordinates.add(new Coordinate(startCoordinate[0], row));
        }
    }

}
