package org.backend.session.ll3.machinecoding.tictactoe.models;

import java.util.Scanner;

public class Player {

    private Symbol symbol;
    private String name;
    private PlayerType playerType;
    private  Scanner scanner;
    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Move makeMove(Board board) {

        //get the row & col for which player wants to make a move
        System.out.println("Please enter the row number where you want to make a move");
        int row = scanner.nextInt();

        System.out.println("Please enter the col number where you want to make a move");
        int col = scanner.nextInt();

        //Now, we need to validate the player move, its the Game's resposibility to validate the move
        return new Move(this, new Cell(row, col)); //this is just a cell object -> to encapsulate row & col together of this player
    }
}
