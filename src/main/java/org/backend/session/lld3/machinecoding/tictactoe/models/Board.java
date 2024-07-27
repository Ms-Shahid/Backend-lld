package org.backend.session.lld3.machinecoding.tictactoe.models;

public class Board{

  private int dimensions;
  private List<List<Cell>> board;

  public Board(int dimensions){
    this.dimensions = dimensions;

    board = new ArrayList<>();

    for(int i = 0; i < dimensions; i++){
      board.add(new ArrayList<>()); //one every arraylist create a new row/col

      for(int j = 0; j < dimensions; j++){
        board.get(j).add(new Cell(i, j)); //adding a new cell in every row & col
      }
    }
  }

  /* for Board creation think if it as the keyboard, in which the keyboard without keys is the board, then the keys-line
    * is the new arraylist within the board, now on each line there are cells, first get this key-line value & then create
    * a cell in it.*/

    public void printBoard(){
        for(List<Cell> row : board ){
            for(Cell cell : row ){
  //                System.out.println(cell.getPlayer().getSymbol().getaChar()); //if the player is null, then it will be null pointer exception
                cell.display();
            }
            System.out.println("\n");
        }
  }
  public int getDimensions(){
    return dimensions;
  }

  public List<List<Cell>> getBoard(){
    return board;
  }

  public List<Cell> getRow(int row){
    return board.get(row);
  }

  public void setCell(int row, int col, CellState cellState){
    board.get(row).get(col).setState(cellState);
  }
}