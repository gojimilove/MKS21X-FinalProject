public class TenTen {
    private Tile[][] board;
    //private Piece[] pieces;
    private int score;

    public TenTen() {
      board = new Tile[10][10];
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
        	board[i][j] = new Tile();
        }
      }
      //pieces = new Piece[3];
      score = 0;
    }

    private boolean rowFilled(int row) {
    	return false;
    }

    private boolean columnFilled(int col) {
    	return false;
    }

    private boolean pieceFits(Piece x) {
    	return false;
    }

    private void clearRow(int row) {

    }

    private void clearColumn(int col) {

    }

    private void clear() {

    }

    private void spawnPieces() {

    }

    private void addPiece(Piece x, int row, int col){
      for (int i=0; i < x.length();i++){
        for(int j=0; j < x.length();j++){
          board[row+i][col+j].fillTile();
        }
      }
    }

    private int getScore() {
    	return score;
    }

    private void addPoints(int added) {
    	score+= added;
    }

    private void clearPoints() {
    	score = 0;
    }

    public String toString() {
      String s = "";
      for (int i = 0; i < board.length; i++) {
        s+="|";
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j].isFilled()) s+="F";
          else s+="-";
        }
        s+="|\n";
      }
      return s;
    }

    public static void main(String[] args) {
      TenTen a = new TenTen();
      a.addPiece(new Piece(3),5,4);
      a.addPiece(new Piece(3),1,1);
      a.addPiece(new Piece(3),6,1);
      System.out.println(a);
    }
}
