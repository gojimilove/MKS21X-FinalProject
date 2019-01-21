import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;

public class TenTen {
    private Tile[][] board;
    private Piece[] pieces;
    private int score, count;

    //creates a new, empty 10x10 board (array of Tiles), resets the score, preps pieces
    public TenTen() {
      //board is 10x10 array of empty tiles, initialize tiles
      board = new Tile[10][10];
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
        	board[i][j] = new Tile();
        }
      }
      //pieces to be spawned
      pieces = new Piece[3];
      //start with no points, no pieces on the board
      score = 0;
      count = 0;
    }

    //fills a single tile on the board
    private void fillTile(int row, int col) {
      board[row][col].fillTile();
    }

    //tests if entire row is filled (will later be cleared)
    private boolean rowFilled(int row) {
      //checks if all tiles in the
    	for (int i = 0; i < board.length; i++) {
        if (!board[row][i].isFilled()) return false;
      }
      return true;
    }

    //tests if the column is completely filled (will later be cleared)
    private boolean columnFilled(int col) {
      for (int i = 0; i < board.length; i++) {
        if (!board[i][col].isFilled()) return false;
      }
      return true;
    }

    //tests if the piece "fits" in a specific spot, whether it overlaps anything
    private boolean pieceFits(Piece x, int row, int col) {
      //if the piece goes out of bounds return false
      if (row+x.length() > board.length || col+x.width() > board[0].length) return false;
      //if a space on board where we're trying to put the piece is already filled, return false
      for (int i=0; i < x.length();i++){
        for(int j=0; j < x.width();j++){
          if (x.getTile(i,j).isFilled() && board[row+i][col+j].isFilled()) return false;
        }
      }
    	return true;
    }

    //clearing a row when entirely filled
    private void clearRow(int row) {
			for (int i = 0; i < board[row].length; i++) {
        board[row][i].clearTile();
      }
      score+=10;
    }

    //clearing a column when entirely filled
    private void clearColumn(int col) {
      for (int i = 0; i < board.length; i++){
        board[i][col].clearTile();
      }
      score+=10;
    }

    //clear the whole board
    private void clear() {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          board[i][j].clearTile();
        }
      }
    }

    //spawns the 3 pieces next to the board that the player can select
    // private void spawnPieces(Terminal t) {
    //   for (int i = 0; i < pieces.length; i++) {
    //     pieces[i] = new Piece();
    //     if (i == 0) putString(0,22,t,pieces[i].toString());
    //     else if (i == 1) putString(0,26,t,pieces[i].toString());
    //     else if (i == 2) putString(0,30,t,pieces[i].toString());
    //     //System.out.println(pieces[i]);
    //   }
    //   count = 3;
    // }

    private Piece[] spawnPieces() {
      for (int i = 0; i < pieces.length; i++) {
        pieces[i] = new Piece();
        //System.out.println(pieces[i]);
      }
      count = 3;
      return pieces;
    }

    //puts the piece on the board if it fits
    private void addPiece(Piece x, int row, int col){
      //if the piece fits fill in the tiles on the board where piece would go
      if (pieceFits(x, row, col)) {
        for (int i=0; i < x.length();i++){
          for(int j=0; j < x.width();j++){
            if (x.getTile(i,j).isFilled()) board[row+i][col+j].fillTile();
          }
        }
      }
      score+=x.score();
      count--;
    }

    //returns the current score
    private int getScore() {
    	return score;
    }

    //increases score, whether it be by clearing pieces, placing pieces, getting combos
    private void addPoints(int added) {
    	score+= added;
    }

    //resets the score
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

    //number of pieces player can select that are not on the board
    public int piecesWaiting(){
      return count;
    }

    public static void putString(int r, int c,Terminal t, String s){
      t.moveCursor(r,c);
      for(int i = 0; i < s.length();i++){
        t.putCharacter(s.charAt(i));
      }
    }

    public static void main(String[] args) {

      int x = 2;
      int y = 9;
      //create terminal
      Terminal terminal = TerminalFacade.createTextTerminal();
      terminal.enterPrivateMode();

      TerminalSize size = terminal.getTerminalSize();
      terminal.setCursorVisible(false);
      boolean running = true;

      TenTen a = new TenTen();
      Piece[] selection = a.spawnPieces();
      putString(0,22,terminal,selection[0].toString());
      putString(0,28,terminal,selection[1].toString());
      putString(0,34,terminal,selection[2].toString());

      boolean pieceOneUsed = false;
      boolean pieceTwoUsed = false;
      boolean pieceThreeUsed = false;

      while(running){
        //set up cursor
        terminal.moveCursor(x,y);
        //terminal.applyBackgroundColor(Terminal.Color.WHITE);
        terminal.applyForegroundColor(Terminal.Color.RED);
        //applySGR(a,b) for multiple modifiers (bold,blink) etc.
        terminal.putCharacter('\u00a4');
        //terminal.putCharacter(' ');
        //terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
        terminal.applyForegroundColor(Terminal.Color.DEFAULT);
        //terminal.applySGR(Terminal.SGR.RESET_ALL);
        //putString(0, 40, terminal, ""+a.piecesWaiting());
        if (a.piecesWaiting() == 0) {
          selection = a.spawnPieces();
          putString(0,22,terminal,selection[0].toString());
          putString(0,28,terminal,selection[1].toString());
          putString(0,34,terminal,selection[2].toString());
          pieceOneUsed = false;
          pieceTwoUsed = false;
          pieceThreeUsed = false;
        }
        
        

        Key key = terminal.readInput();

        if (key != null){
          //exiting the game
          if (key.getKind() == Key.Kind.Escape) {
            terminal.exitPrivateMode();
            running = false;
          }
          //moving cursor around
          if (key.getKind() == Key.Kind.ArrowLeft) {
            if (x != 2) {
              terminal.moveCursor(x,y);
              terminal.putCharacter(' ');
              x-=2;
            }
          }

          if (key.getKind() == Key.Kind.ArrowRight) {
            if (x != 20) {
              terminal.moveCursor(x,y);
              terminal.putCharacter(' ');
              x+=2;
            }
          }

          if (key.getKind() == Key.Kind.ArrowUp) {
            if (y != 9) {
              terminal.moveCursor(x,y);
              terminal.putCharacter(' ');
              y--;
            }
          }

          if (key.getKind() == Key.Kind.ArrowDown) {
            if (y != 18) {
              terminal.moveCursor(x,y);
              terminal.putCharacter(' ');
              y++;
            }
          }
          //selecting pieces to put on the board
          if (key.getCharacter() == '1') {
            if (pieceOneUsed == false && a.pieceFits(selection[0], y-9, ((x/2) - 1))) {
              a.addPiece(selection[0], y-9, ((x/2) - 1));
              putString(0,22,terminal,"          \n          \n          \n          \n          ");
              pieceOneUsed = true;
            }
          }

          if (key.getCharacter() == '2') {
            if (pieceTwoUsed == false && a.pieceFits(selection[1], y-9, ((x/2) - 1))) {
              a.addPiece(selection[1], y-9, ((x/2) - 1));
              putString(0,28,terminal,"          \n          \n          \n          \n          ");
              pieceTwoUsed = true;
            }
          }

          if (key.getCharacter() == '3') {
            if (pieceThreeUsed == false && a.pieceFits(selection[2], y-9, ((x/2) - 1))) {
              a.addPiece(selection[2], y-9, ((x/2) - 1));
              putString(0,34,terminal,"          \n          \n          \n          \n          ");
              pieceThreeUsed = true;
            }
          }

        }
        for (int i = 0; i < 10; i++) {
          if (a.rowFilled(i)) {
            for (int j = 0; j < 10; j++) {
              if (a.columnFilled(j)) a.clearColumn(j);
            }
            a.clearRow(i);
           }
          if (a.columnFilled(i)) a.clearColumn(i);
        }

        //instructions, shows position, indicates pieces
        putString(0,0,terminal,"Welcome to our version of TenTen!\nTo place a piece, move the cursor with the arrow keys to where you would like to place the piece.\nThen, click either 1, 2, or 3 to select one of the pieces shown below the board, and if it fits where you tried to place it, it will be placed on the board. You earn points by placing and clearing pieces; when you place a piece, you get the same amount of points as the number of tiles that block takes up. You also recieve 10 points for each row or column you clear. \nNote: a piece is selected from its top left corner.");
        putString(0,8,terminal,"Current position on board: ["+(x/2 - 1)+","+(y-9)+"]     ");
        putString(0,7,terminal,"Current position: ["+x+","+y+"]     ");
        putString(0,9,terminal,a.toString());
        putString(0,20,terminal,"Pieces:");
        
        putString(0,40,terminal,"Score: "+a.getScore());
        
      }
    }

}
