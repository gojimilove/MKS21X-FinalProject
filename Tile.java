public class Tile {
  private boolean filled;

  public Tile() {
    filled = false;
  }

  public boolean isFilled() {
    return filled;
  }

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
