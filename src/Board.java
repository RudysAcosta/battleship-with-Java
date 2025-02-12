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

}
