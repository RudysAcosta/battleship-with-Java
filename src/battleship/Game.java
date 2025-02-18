package battleship;

import battleship.entity.*;

public class Game {
    private final UserInput inputHandler;
    private final Board board;
    private final ShipPlacer shipPlacer;

    public Game() {
        this.inputHandler = new UserInput();
        this.board = new Board();
        this.shipPlacer = new ShipPlacer(board, inputHandler);
    }

    public void startGame() {
        board.printBoard();

        shipPlacer.placeShip(new AircraftCarrier());
        board.printBoard();

        shipPlacer.placeShip(new Battleship());
        board.printBoard();

        shipPlacer.placeShip(new Submarine());
        board.printBoard();

        shipPlacer.placeShip(new Cruiser());
        board.printBoard();

        shipPlacer.placeShip(new Destroyer());
        board.printBoard();
    }
}