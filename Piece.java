import java.util.Random;

public class Piece{
  private int length;
  private Tile[][] piece;

  public Piece() {
    Random rand = new Random();
    int randomLength = rand.nextInt(3) + 1;
    length = randomLength;
    piece = new Tile[length][length];
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[i].length; j++) {
      	piece[i][j] = new Tile();
        piece[i][j].fillTile();
      }
    }
  }

  public Piece(int len) {
    length = len;
    piece = new Tile[length][length];
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[i].length; j++) {
        piece[i][j] = new Tile();
        piece[i][j].fillTile();
      }
    }
  }

  public int length() {
    return length;
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < piece.length; i++) {
      s+="|";
      for (int j = 0; j < piece[i].length; j++) {
        if (piece[i][j].isFilled()) s+="F";
        else s+="-";
        //s+="-";
      }
      s+="|\n";
    }
    return s;
  }

  public static void main(String[] args) {
    Piece test = new Piece();
    System.out.println(test);
  }
}
