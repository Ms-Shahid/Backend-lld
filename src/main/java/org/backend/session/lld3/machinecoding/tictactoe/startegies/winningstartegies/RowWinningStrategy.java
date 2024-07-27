package org.backend.session.ll3.machinecoding.tictactoe.startergies.winningstategies;

import org.backend.session.ll3.machinecoding.tictactoe.models.Board;
import org.backend.session.ll3.machinecoding.tictactoe.models.Move;
import org.backend.session.ll3.machinecoding.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategies {

    private final Map<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>(); //TC : O(1)

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        Character character = move.getPlayer().getSymbol().getaChar();

        if (!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }

        Map<Character, Integer> currRowMap = rowMaps.get(row);

        if (!currRowMap.containsKey(character)) {
            currRowMap.put(character, 0);
        }
        rowMaps.get(row).put(character, currRowMap.get(character) + 1);


        return currRowMap.get(character).equals(board.getDimension()); //becomes equal to dimension
    }
}