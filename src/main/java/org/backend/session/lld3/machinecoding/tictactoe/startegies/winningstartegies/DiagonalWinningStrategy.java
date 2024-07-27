package org.backend.session.ll3.machinecoding.tictactoe.startergies.winningstategies;

import org.backend.session.ll3.machinecoding.tictactoe.models.Board;
import org.backend.session.ll3.machinecoding.tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategies{

    //2 Diagonals, one starting at (0, 0) & another at (0, n-1)
    private final Map<Character, Integer> leftDiagonalMap = new HashMap<>();
    private final Map<Character, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getaChar();

        //condition for leftDiagonalMap -> row == col
        if( row == col ){
            if(!leftDiagonalMap.containsKey(character)){
                leftDiagonalMap.put(character, 0);
            }
            leftDiagonalMap.put(character, leftDiagonalMap.get(character) + 1);
        }

        //condition for right diagonal map -> row + col == N - 1
        if( row + col == board.getDimension() - 1){
            if(!rightDiagonalMap.containsKey(character)){
                rightDiagonalMap.put(character, 0);
            }
            rightDiagonalMap.put(character, rightDiagonalMap.get(character) + 1);
        }

        //winning move
        if( (row == col && leftDiagonalMap.get(character) == board.getDimension()) ||
                (row + col == board.getDimension() - 1 && rightDiagonalMap.get(character) == board.getDimension())   )
            return true;

        return false;
    }
}
