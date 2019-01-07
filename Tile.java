public class Tile {
  private boolean empty;

  public Tile() {
    empty = true;
  }

  private boolean isFilled() {
    return empty;
  }

  private void fillTile() {
    empty = false;
  }

  private void clearTile() {
    empty = true;
  }

}
