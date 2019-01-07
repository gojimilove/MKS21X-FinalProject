public class TenTen {
    private Tile[][] board;
    //private Piece[] pieces;
    private int score;

    public TenTen() {
      board = new Tile[10][10];
      //pieces = new Piece[3];
      score = 0;
    }

    public String toString() {
      String s = "";
      for (int i = 0; i < board.length; i++) {
        s+="|";
        for (int j = 0; j < board[i].length; j++) {
          s+="-";
        }
        s+="|\n";
      }
      return s;
    }

    public static void main(String[] args) {
      TenTen a = new TenTen();
      System.out.println(a);
    }
}
