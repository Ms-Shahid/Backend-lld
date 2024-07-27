package org.backend.session.lld3.machinecoding.tictactoe.models;

public class Move{

  private Player player;
  private Cell cell;

  public Move(Player player, Cell cell){
    this.player = player;
    this.cell = cell;
  }

  public Player getPlayer(){
    return player;
  }
  public Cell getCell(){
    return cell;
  }
  public void setCell(Cell cell){
    this.cell = cell;
  }

  public void setPlayer(Player player){
    this.player = player;
  }
  
}