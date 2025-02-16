import java.util.Arrays;

public class Board {

    private final int dimantion = 10;

    private char[][] board;

    public Board() {
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

    public boolean isValidCoordinate(String startCoordinate, String endCoordinate) {

        int[] startNormalize  = normalizeCoordinate(startCoordinate);
        int[] endNormalize  = normalizeCoordinate(endCoordinate);

        if (startNormalize[0] != endNormalize[0] && startNormalize[1] != endNormalize[1]) {
            return false;
        }

        return isValidCoordinate(startCoordinate) && isValidCoordinate(endCoordinate);
    }

    public boolean isValidCoordinate(String coordinate) {
        int[] normalizeCoordinate = normalizeCoordinate(coordinate);

        return normalizeCoordinate[0] > 0 && normalizeCoordinate[0] <= this.dimantion
                && normalizeCoordinate[1] > 0 && normalizeCoordinate[1] <= this.dimantion;
    }

    public int[] normalizeCoordinate(String coordinate) {
        String[] position = new String[2];

        position[0] = coordinate.substring(0, 1);
        position[1] = coordinate.substring(1);

        int y = position[0].charAt(0) - 64;
        int x = Integer.parseInt(position[1]);

        return new int[]{x, y};
    }

}
