import java.util.Random;

public class Piece{
  private int length;
  private Tile[][] piece;

  public Piece() {
    Random rand = new Random();
    int randomLength = rand.nextInt(4);
    length = randomLength;
    piece = new Tile[length][length];
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[i].length; j++) {
        piece[i][j].fillTile();
      }
    }
  }

  public Piece(int len) {
    length = len;
    piece = new Tile[length][length];
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[i].length; j++) {
        piece[i][j].fillTile();
      }
    }
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < piece.length; i++) {
      s+="|";
      for (int j = 0; j < piece[i].length; j++) {
        //if (piece[i][j].isFilled()) s+="F";
        //else s+="-";
        s+="F";
      }
      s+="|\n";
    }
    return s;
  }

  public static void main(String[] args) {
    Piece test = new Piece(3);
    System.out.println(test);
  }
}
