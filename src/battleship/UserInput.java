package battleship;

import java.util.Scanner;

public class UserInput {

    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getCoordinates() {

        while (true) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("invalid input.");
                continue;
            }

            String[] coordinates = line.split("\\s+");

            if (coordinates.length != 2) {
                System.out.println("You must enter two values separated by a space.");
                continue;
            }

            return coordinates;
        }
    }

    public void close() {
        this.scanner.close();
    }

}
