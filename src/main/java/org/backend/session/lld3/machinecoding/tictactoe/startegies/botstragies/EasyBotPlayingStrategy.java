package org.backend.session.ll3.machinecoding.tictactoe.startergies.botstategies;

import org.backend.session.ll3.machinecoding.tictactoe.models.Board;
import org.backend.session.ll3.machinecoding.tictactoe.models.Cell;
import org.backend.session.ll3.machinecoding.tictactoe.models.CellState;
import org.backend.session.ll3.machinecoding.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {

        //Iterate over the board & make a move at the first empty cell

        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(null, cell);
                }
            }
        }

        return null;
    }
}
