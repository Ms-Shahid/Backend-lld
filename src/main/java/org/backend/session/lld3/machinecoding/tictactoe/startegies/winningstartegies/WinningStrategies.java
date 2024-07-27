package org.backend.session.ll3.machinecoding.tictactoe.startergies.winningstategies;

import org.backend.session.ll3.machinecoding.tictactoe.models.Board;
import org.backend.session.ll3.machinecoding.tictactoe.models.Cell;
import org.backend.session.ll3.machinecoding.tictactoe.models.Move;
import org.backend.session.ll3.machinecoding.tictactoe.models.Player;

public interface WinningStrategies {

    boolean checkWinner(Board board, Move move);
}
