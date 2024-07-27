package org.backend.session.ll3.machinecoding.tictactoe.models;

import org.backend.session.ll3.machinecoding.tictactoe.exceptions.InvalidMoveException;
import org.backend.session.ll3.machinecoding.tictactoe.startergies.winningstategies.WinningStrategies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Board board;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategies> winningStrategies; //if we want to have one specific winning strategy

    public static GameBuilder getGameBuilder(){
        return new GameBuilder();
    }

    private Game(List<Player> players, List<WinningStrategies> winningStrategies, int dimension) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public List<WinningStrategies> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategies> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void printBoard(){
        board.printBoard();
    }

    public boolean validatePlayerMove(Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        //move is not valid
        if( row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension() ) return false;

        //check wheaten the cell, which player is trying to make a move is empty or not
        if(!board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) return false;

        return true;
    }

    public void makeMove() throws InvalidMoveException {

        Player currentPlayer = players.get(nextPlayerIndex);

        System.out.println("This is " + currentPlayer.getName() + "'s move");

        //Player will choose the move that they want to make
        Move playerChoosenMove = currentPlayer.makeMove(board);

        //Game will validate the move, if the move is valid or not
        if(!validatePlayerMove(playerChoosenMove)){
            throw new InvalidMoveException("Invalid Move, please try again");
        }

        //Move is valid, so apply this move to the board
        int row = playerChoosenMove.getCell().getRow();
        int col = playerChoosenMove.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        //this playerChooseMove is not a final move applied to player
        Move finalMove = new Move(currentPlayer, cell);
        moves.add(finalMove);

        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        //check for winner
        if(checkWinner(finalMove)){
            //if its true then we have the winner
            winner = currentPlayer;
            gameStatus = GameStatus.ENDED;
        }else if(moves.size() == board.getDimension() * board.getDimension()){
            gameStatus = GameStatus.DRAW;
        }

    }

    public boolean checkWinner(Move move){
        for(WinningStrategies winningStrategy : winningStrategies ){
            if(winningStrategy.checkWinner(board, move)){
               return true;
            }
        }
        return false;
    }
    public static class GameBuilder {
        //only the minimum attributes required for builder / initial validations
        private int dimension;
        private List<WinningStrategies> winningStrategies; //if we want to have one specific winning strategy
        private List<Player> players;

        public GameBuilder(){
            this.dimension = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }


        public void validateDimension(){
            if( dimension <= 0 ) throw new RuntimeException("Dimension must be greater than zero");
        }

        public void validateBotCount(){
            int count = 0;
            for( Player player : players ){
                if( player.getPlayerType().equals(PlayerType.BOT)){
                    count += 1;
                    if( count > 1 ) throw new RuntimeException("Only one bot is available per game");
                }
            }
        }

        public void validateUniquePlayerSymbol(){
            Set<Character> symbolSet = new HashSet<>();
            for(Player player : players ){
                symbolSet.add(player.getSymbol().getaChar());
            }
            if( symbolSet.size() != dimension -1 )
                throw new RuntimeException("Player must have unique symbol");

        }

        public Game build(){
            //validations
            validateBotCount();
            validateDimension();
            validateUniquePlayerSymbol();
            return new Game(players, winningStrategies, dimension);
        }


        public List<WinningStrategies> getWinningStrategies() {
            return winningStrategies;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
    }
}
