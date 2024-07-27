package org.backend.session.ll3.machinecoding.tictactoe.startergies.winningstategies;

import org.backend.session.ll3.machinecoding.tictactoe.models.Board;
import org.backend.session.ll3.machinecoding.tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategies{

    private final Map<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>(); //TC : O(1)

    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getaChar();

        //check if this col is already present
        if(!colMaps.containsKey(col)){
            colMaps.put( col, new HashMap<>());
        }

        //check if the char is present in this colMaps
        Map<Character, Integer> colMap = colMaps.get(col);

        if(!colMap.containsKey(character)){
            colMap.put(character, 0); //first value
        }

        colMap.put(character, colMap.get(character) + 1);

        return colMap.get(character).equals(board.getDimension());
    }
}
