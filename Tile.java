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

  private void clearTile() {
    filled = false;
  }

}
