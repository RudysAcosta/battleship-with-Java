package entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {

    private final String name;
    private final int size;
    private final List<int[]> positions;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.positions =  new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public List<int[]> getPositions() {
        return positions;
    }

    public void addPosition(int x, int y) {
        positions.add(new int[]{x, y});
    }
}