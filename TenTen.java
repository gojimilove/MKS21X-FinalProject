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

    //loops through every spot in the board and if the piece fits in at least one spot, it "fits on the board", returns true
    private boolean pieceFitsBoard(Piece x) {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          if (pieceFits(x, i, j)) return true;
        }
      }
      return false;
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

    //number of pieces player can select that are not on the board
    private int piecesWaiting(){
      return count;
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

    //prints stuff on the terminal
    public static void putString(int r, int c,Terminal t, String s){
      t.moveCursor(r,c);
      for(int i = 0; i < s.length();i++){
        t.putCharacter(s.charAt(i));
      }
    }

    public static void putPiece(int r, int c,Terminal t, Piece piece, Terminal.Color back ){
      t.moveCursor(r,c);
      t.applyBackgroundColor(back);
      t.applyForegroundColor(Terminal.Color.BLACK);
      for(int i = 0; i < piece.score();i++){
        t.moveCursor((piece.yCoord(i)+1) + r,piece.xCoord(i) + c);
        t.putCharacter(' ');
        t.moveCursor(piece.yCoord(i) + r,piece.xCoord(i) + c);
        t.putCharacter('-');
      }
      t.applyBackgroundColor(Terminal.Color.DEFAULT);
      t.applyForegroundColor(Terminal.Color.DEFAULT);
    }










    public static void main(String[] args) {

      int x = 2;
      int y = 1;
      //create terminal
      Terminal terminal = TerminalFacade.createTextTerminal();
      terminal.enterPrivateMode();

      TerminalSize size = terminal.getTerminalSize();
      terminal.setCursorVisible(false);
      boolean running = true;
      int mode = 0;
      boolean playerLost = false;

      TenTen a = new TenTen();
      //putString(0,1,terminal,a.toString());
      //spawn new pieces, print the 3
      Piece[] selection = a.spawnPieces();
      putPiece(1,14,terminal,selection[0],Terminal.Color.YELLOW);
      putPiece(12,14,terminal,selection[1],Terminal.Color.YELLOW);
      putPiece(23,14,terminal,selection[2],Terminal.Color.YELLOW);

      //indicates whether pieces 1 2 or 3 have been placed on the board or are still waiting
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

        Key key = terminal.readInput();

        if (key != null){
          if (mode == 0) {
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
              if (y != 1) {
                terminal.moveCursor(x,y);
                terminal.putCharacter(' ');
                y--;
              }
            }

            if (key.getKind() == Key.Kind.ArrowDown) {
              if (y != 10) {
                terminal.moveCursor(x,y);
                terminal.putCharacter(' ');
                y++;
              }
            }
            //selecting pieces to put on the board
            if (key.getCharacter() == '1') {
              if (pieceOneUsed == false && a.pieceFits(selection[0], y-1, ((x/2) - 1))) {
                a.addPiece(selection[0], y-1, ((x/2) - 1));
                //putPiece(x,y,terminal,selection[0],Terminal.Color.YELLOW);
                putString(1,14,terminal,"          ");
                putString(1,15,terminal,"          ");
                putString(1,16,terminal,"          ");
                putString(1,17,terminal,"          ");
                putString(1,18,terminal,"          ");
                pieceOneUsed = true;
              }
            }

            if (key.getCharacter() == '2') {
              if (pieceTwoUsed == false && a.pieceFits(selection[1], y-1, ((x/2) - 1))) {
                a.addPiece(selection[1], y-1, ((x/2) - 1));
                //putPiece(x,y,terminal,selection[1],Terminal.Color.YELLOW);
                putString(12,14,terminal,"          ");
                putString(12,15,terminal,"          ");
                putString(12,16,terminal,"          ");
                putString(12,17,terminal,"          ");
                putString(12,18,terminal,"          ");
                pieceTwoUsed = true;
              }
            }

            if (key.getCharacter() == '3') {
              if (pieceThreeUsed == false && a.pieceFits(selection[2], y-1, ((x/2) - 1))) {
                a.addPiece(selection[2], y-1, ((x/2) - 1));
                //putPiece(x,y,terminal,selection[2],Terminal.Color.YELLOW);
                putString(23,14,terminal,"          ");
                putString(23,15,terminal,"          ");
                putString(23,16,terminal,"          ");
                putString(23,17,terminal,"          ");
                putString(23,18,terminal,"          ");
                pieceThreeUsed = true;
              }
            }
          }
          if (key.getCharacter() == 'F') {
            terminal.exitPrivateMode();
            running = false;
            // terminal.clearScreen();
            // mode = 0;
            // running = true;
          }
        }

        if (mode == 0) {
          //checks to see if any rows and/or columns are filled, clears them and adds points if they are
          for (int i = 0; i < 10; i++) {
            if (a.rowFilled(i)) {
              for (int j = 0; j < 10; j++) {
                if (a.columnFilled(j)) a.clearColumn(j);
              }
              a.clearRow(i);
             }
            if (a.columnFilled(i)) a.clearColumn(i);
          }

          //if all 3 pieces have been used, generate 3 new ones and print them
          if (a.piecesWaiting() == 0) {
            selection = a.spawnPieces();
            putPiece(1,14,terminal,selection[0],Terminal.Color.YELLOW);
            putPiece(12,14,terminal,selection[1],Terminal.Color.YELLOW);
            putPiece(23,14,terminal,selection[2],Terminal.Color.YELLOW);
            pieceOneUsed = false;
            pieceTwoUsed = false;
            pieceThreeUsed = false;
          }

          //instructions, shows position, indicates pieces
          putString(0,0,terminal,"WELCOME TO TENTEN!");
          putString(0,1,terminal,a.toString());
          //putString(0,7,terminal,"Current position: ["+x+","+y+"]     ");
          //putString(0,8,terminal,"Current position on board: ["+(x/2 - 1)+","+(y-1)+"]     ");
          putString(0,12,terminal,"PIECES:");
          putString(0,20,terminal,"SCORE: "+a.getScore());
          putString(0,22,terminal,"INSTRUCTIONS:\nTo place a piece, move the cursor with the arrow keys to where you would like to place the piece. Then, click either 1, 2, or 3 to select one of the pieces shown below the board, and if it fits where you tried to place it, it will be placed on the board. You earn points by placing and clearing pieces; when you place a piece, you get the same amount of points as the number of tiles that block takes up. You also recieve 10 points for each row or column you clear. YOU LOSE IF there is no more room on the board for any of the pieces displayed below. GOOD LUCK!!\n\n***Note: a piece is selected from its top left corner.");

          //cases that would trigger "endgame", basically, none of the available pieces fit on the board
          //if all 3 are waiting AND they all dont fit
          if (!pieceOneUsed && !a.pieceFitsBoard(selection[0]) && 
              !pieceTwoUsed && !a.pieceFitsBoard(selection[1]) && 
              !pieceThreeUsed && !a.pieceFitsBoard(selection[2])) {
            playerLost = true;
            //putString(0,45,terminal,"NONE OF THE PIECES FIT");
          }

          //if just 1 and 2 are waiting AND both dont fit
          if (!pieceOneUsed && !a.pieceFitsBoard(selection[0]) &&
              !pieceTwoUsed && !a.pieceFitsBoard(selection[1]) &&
              pieceThreeUsed) {
            playerLost = true;
            //putString(0,45,terminal,"NONE OF THE PIECES FIT");
          }

          //if just 1 and 3 waiting AND both dont fit
          if (!pieceOneUsed && !a.pieceFitsBoard(selection[0]) &&
              !pieceThreeUsed && !a.pieceFitsBoard(selection[2]) &&
              pieceTwoUsed) {
            playerLost = true;
            //putString(0,45,terminal,"NONE OF THE PIECES FIT");
          }

          //if just 2 and 3 waiting AND both dont fit
          if (!pieceTwoUsed && !a.pieceFitsBoard(selection[1]) &&
              !pieceThreeUsed && !a.pieceFitsBoard(selection[2]) &&
              pieceOneUsed) {
            playerLost = true;
            //putString(0,45,terminal,"NONE OF THE PIECES FIT");
          }

          //if just 1 is waiting AND it doesnt fit
          if (!pieceOneUsed && !a.pieceFitsBoard(selection[0]) &&
              pieceTwoUsed &&
              pieceThreeUsed) {
            playerLost = true;
            //putString(0,45,terminal,"NONE OF THE PIECES FIT");
          }

          //if just 2 is waiting AND it doesnt fit
          if (!pieceTwoUsed && !a.pieceFitsBoard(selection[1]) &&
              pieceOneUsed &&
              pieceThreeUsed) {
            playerLost = true;
            //putString(0,45,terminal,"NONE OF THE PIECES FIT");
          }

          //if just 3 is waiting AND it doesnt fit
          if (!pieceThreeUsed && !a.pieceFitsBoard(selection[2]) &&
              pieceOneUsed &&
              pieceTwoUsed) {
            playerLost = true;
            //putString(0,45,terminal,"NONE OF THE PIECES FIT");
          }

          if (playerLost) mode = 1;
        }
        else {
          //running = false;
          terminal.clearScreen();
          //terminal.applySGR(Terminal.SGR.ENTER_BOLD,Terminal.SGR.ENTER_BLINK);
          //putString(1,3,terminal, "YOU LOST press F to reset the game");
          //terminal.applySGR(Terminal.SGR.RESET_ALL);
          terminal.exitPrivateMode();
          running = false;
          System.out.println("\nYou lost!! None of the remaining pieces could fit on the board. Better luck next time! \nYour score was "+a.getScore()+"\n");
        }
      }
    }

}
