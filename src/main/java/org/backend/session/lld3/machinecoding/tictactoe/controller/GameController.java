package org.backend.session.ll3.machinecoding.tictactoe.controllers;

import org.backend.session.ll3.machinecoding.tictactoe.exceptions.InvalidMoveException;
import org.backend.session.ll3.machinecoding.tictactoe.models.Game;
import org.backend.session.ll3.machinecoding.tictactoe.models.GameStatus;
import org.backend.session.ll3.machinecoding.tictactoe.models.Player;
import org.backend.session.ll3.machinecoding.tictactoe.startergies.winningstategies.WinningStrategies;

import java.util.List;

public class GameController {

    //start the game
    public static Game startGame(int dimension, List<Player> players, List<WinningStrategies> winningStrategies ){
        return Game.getGameBuilder().setDimension(dimension)
                .setPlayers(players).setWinningStrategies(winningStrategies).build();
    }

    public  void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameStatus gameState(Game game){
        return game.getGameStatus();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){
        game.printBoard();
    }


    public void undo(Game game){
        System.out.println("Undo .. ");
    }

}
