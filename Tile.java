public class Tile {
  private boolean filled;

  //Our tiles have boolean to check if there is already a block there
  //if tile is filled then the pieces can't be placed
  public Tile() {
    filled = false;
  }

  //functions will use this to determine if a piece can be placed on the board
  public boolean isFilled() {
    return filled;
  }

  //pieces will use this to fill the board
  public void fillTile() {
    filled = true;
  }

  public void clearTile() {
    filled = false;
  }

  public String toString() {
  	String s = "";
  	s+= filled;
  	return s;
  }

}
