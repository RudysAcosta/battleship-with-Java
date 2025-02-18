package battleship.util;

public class CoordinateUtil {
    public static String formatPosition(int x, int y) {
        return (char)(x - 1 + 'A') + "" + y;
    }

    public static int[] parsePosition(String pos) {
        String[] position = new String[2];

        position[0] = pos.substring(0, 1);
        position[1] = pos.substring(1);

        int y = position[0].charAt(0) - 64;
        int x = Integer.parseInt(position[1]);

        return new int[]{x, y};
    }

    public static boolean isWithinBounds(int x, int y, int limit) {
        return x >= 1 && x <= limit && y >= 1 && y <= limit;
    }
}
