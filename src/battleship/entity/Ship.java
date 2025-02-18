package battleship.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {

    private final String name;
    private final int size;
    private final List<int[]> positions;
    protected final String prompt;

    public Ship(String name, int size, String prompt) {
        this.name = name;
        this.size = size;
        this.prompt = prompt;
        this.positions =  new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<int[]> getPositions() {
        return positions;
    }

    public void addPosition(int x, int y) {
        positions.add(new int[]{x, y});
    }
}