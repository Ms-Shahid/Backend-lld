package org.backend.session.ll3.machinecoding.tictactoe;

import org.backend.session.ll3.machinecoding.tictactoe.controllers.GameController;
import org.backend.session.ll3.machinecoding.tictactoe.exceptions.InvalidMoveException;
import org.backend.session.ll3.machinecoding.tictactoe.models.*;
import org.backend.session.ll3.machinecoding.tictactoe.startegies.winningstategies.ColumnWinningStrategy;
import org.backend.session.ll3.machinecoding.tictactoe.startegies.winningstategies.DiagonalWinningStrategy;
import org.backend.session.ll3.machinecoding.tictactoe.startegies.winningstategies.RowWinningStrategy;
import org.backend.session.ll3.machinecoding.tictactoe.startegies.winningstategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) throws InvalidMoveException {

        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        int dimension = 3;

        List<Player> playerList = new ArrayList<>();
        playerList.add(
                new Player( new Symbol('X'), "Shahid", PlayerType.HUMAN)
        );
        playerList.add(
                new Bot( new Symbol('O'), "Scaler", PlayerType.BOT, BotDifficultLevel.EASY )
        );

        List<WinningStrategies> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        Game startGame = GameController.startGame(dimension, playerList, winningStrategies);

//        gameController.printBoard();

        while( gameController.gameState(startGame).equals(GameStatus.IN_PROGRESS) ){
            //1. show the board
            //2. make a move

            gameController.printBoard(startGame);
            System.out.println("Do you want to undo ?");
            String isUndo = scanner.next();

            if( isUndo.equalsIgnoreCase("y")){
                //make the undo
                gameController.undo(startGame);
                continue;
            }
            gameController.makeMove(startGame);
        }

        gameController.printBoard(startGame);

        if(gameController.gameState(startGame).equals(GameStatus.ENDED)){
            System.out.println(gameController.getWinner(startGame).getName() + " has won the game.");
        }else{
            System.out.println("GAME DRAW");
        }
        System.out.println("DEBUG");

    }
}
