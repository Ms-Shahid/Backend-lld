package org.backend.session.ll3.machinecoding.tictactoe.startergies.botstategies;

import org.backend.session.ll3.machinecoding.tictactoe.models.Board;
import org.backend.session.ll3.machinecoding.tictactoe.models.Move;

public interface BotPlayingStrategy {

    Move makeMove(Board board);
}
