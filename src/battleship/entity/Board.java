package battleship.entity;

import battleship.util.CoordinateUtil;
import battleship.validate.ShipPlacementValidator;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private final int dimantion = 10;
    private char[][] board;
    private final Set<String> occupiedCells;

    public Board() {
        this.occupiedCells = new HashSet<>();

        board = new char[dimantion][dimantion];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = '~';
            }
        }
    }

    public void printBoard() {
        int rowTitle = 65;
        System.out.print("  ");

        for (int i = 0; i < board.length; i++) {
            System.out.printf("%d ", i + 1);
        }

        System.out.println();

        for(int i = 0; i < board.length; i++) {
            System.out.printf("%c ", (char)rowTitle + i);
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isOccupied(Set<String> positions) {
        for (String position: positions) {
            if (occupiedCells.contains(position)) return true;
        }

        return false;
    }

    public boolean isClose(Set<String> positions) {
        for(String position : positions) {
            Set<String> neighbors = getNeighbors(position);
            for (String neighbor: neighbors) {
                if (occupiedCells.contains(neighbor)) return true;
            }
        }

        return false;
    }

    private Set<String> getNeighbors(String pos) {
        Set<String> neighbors = new HashSet<>();
        int[] position = CoordinateUtil.parsePosition(pos);
        int x = position[0];
        int y = position[1];

        int[][] directions = {
                {1, 0},  {-1, 0},
                {0, 1},  {0, -1},
                {1, 1},  {-1, -1},
                {1, -1}, {-1, 1}
        };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (CoordinateUtil.isWithinBounds(newX, newY, dimantion)) {
                neighbors.add(CoordinateUtil.formatPosition(newY, newX));
            }
        }

        return neighbors;
    }

    public void add(Set<String> positions) {
        occupiedCells.addAll(positions);

        for (String position: positions) {
            int[] pos = CoordinateUtil.parsePosition(position);
            int x = pos[1] - 1;
            int y = pos[0] - 1;

            board[x][y] = 'O';
        }
    }

}
