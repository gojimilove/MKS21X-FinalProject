public class TenTen {
    private Tile[][] board;
    //private Piece[] pieces;
    private int score, count;

    public TenTen() {
      //board is 10x10 array of empty tiles, initialize tiles
      board = new Tile[10][10];
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
        	board[i][j] = new Tile();
        }
      }
      //pieces = new Piece[3];
      //start with no points, no pieces on the board
      score = 0;
      count = 0;
    }

    private void fillTile(int row, int col) {
      board[row][col].fillTile();
    }

    private boolean rowFilled(int row) {
    	for (int i = 0; i < board.length; i++) {
        if (!board[row][i].isFilled()) return false;
      }
      return true;
    }

    private boolean columnFilled(int col) {
      for (int i = 0; i < board.length; i++) {
        if (!board[i][col].isFilled()) return false;
      }
      return true;
    }

    private boolean pieceFits(Piece x, int row, int col) {
      //if the piece goes out of bounds return false
      if (row+x.length() > board.length || col+x.length() > board[0].length) return false;
      //if a space on board where we're trying to put the piece is already filled, return false
      for (int i=0; i < x.length();i++){
        for(int j=0; j < x.length();j++){
          if (board[row+i][col+j].isFilled()) return false;
        }
      }
    	return true;
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
      //if the piece fits fill in the tiles on the board where piece would go
      if (pieceFits(x, row, col)) {
        for (int i=0; i < x.length();i++){
          for(int j=0; j < x.length();j++){
            board[row+i][col+j].fillTile();
          }
        }
        count++;
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
        s+="| ";
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j].isFilled()) s+="F ";
          else s+="- ";
        }
        s+="|\n";
      }
      return s;
    }
    public int bnunmb(){
      return count;
    }
    public static void main(String[] args) {
      TenTen a = new TenTen();
      a.addPiece(new Piece(2),0,0);
      a.addPiece(new Piece(3),5,1);
      a.addPiece(new Piece(3),8,8);
      System.out.println(a);
      System.out.println("Pieces on board: "+a.bnunmb());
    }
}
