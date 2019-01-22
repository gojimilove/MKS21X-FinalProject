import java.util.Random;

public class Piece {
	private int id,length,width,points;
  private Tile[][] piece;
  private int[][] coordinates;

  //generates a piece, 2D array of Tiles (rectangle) that are filled or unfilled
  //there are 19 different pieces, each with different length, width, and number of blocks
  public Piece() {
  	Random rand = new Random();
  	int randomID = rand.nextInt(19) + 1;
  	id = randomID;
  	if (id == 1) {
  		length = 1;
  		width = 1;
  		points = 1;
  		coordinates = new int[][] {{0,0}};
  	}
  	if (id == 2) {
  		length = 1;
  		width = 2;
  		points = 2;
  		coordinates = new int[][] {{0,0},{0,2}};
  	}
  	if (id == 3) {
  		length = 2;
  		width = 1;
  		points = 2;
  		coordinates = new int[][] {{0,0},{1,0}};
  	}
  	if (id == 4) {
  		length = 2;
  		width = 2;
  		points = 3;
  		coordinates = new int[][] {{0,0},{1,0},{1,2}};
  	}
  	if (id == 5) {
  		length = 2;
  		width = 2;
  		points = 3;
  		coordinates = new int[][] {{0,2},{1,0},{1,2}};
  	}
  	if (id == 6) {
  		length = 2;
  		width = 2;
  		points = 3;
  		coordinates = new int[][] {{0,0},{0,2},{1,0}};
  	}
  	if (id == 7) {
  		length = 2;
  		width = 2;
  		points = 3;
  		coordinates = new int[][] {{0,0},{0,2},{1,2}};
  	}
  	if (id == 8) {
  		length = 2;
  		width = 2;
  		points = 4;
  		coordinates = new int[][] {{0,0},{0,2},{1,0},{1,2}};
  	}
  	if (id == 9) {
  		length = 1;
  		width = 3;
  		points = 3;
  		coordinates = new int[][] {{0,0},{0,2},{0,4}};
  	}
  	if (id == 10) {
  		length = 3;
  		width = 1;
  		points = 3;
  		coordinates = new int[][] {{0,0},{1,0},{2,0}};
  	}
  	if (id == 11) {
  		length = 3;
  		width = 3;
  		points = 9;
  		coordinates = new int[][] {{0,0},{0,2},{0,4},{1,0},{1,2},{1,4},{2,0},{2,2},{2,4}};
  	}
  	if (id == 12) {
  		length = 3;
  		width = 3;
  		points = 5;
  		coordinates = new int[][] {{0,0},{1,0},{2,0},{2,2},{2,4}};
  	}
  	if (id == 13) {
  		length = 3;
  		width = 3;
  		points = 5;
  		coordinates = new int[][] {{0,4},{1,4},{2,0},{2,2},{2,4}};
  	}
  	if (id == 14) {
  		length = 3;
  		width = 3;
  		points = 5;
  		coordinates = new int[][] {{0,0},{0,2},{0,4},{1,0},{2,0}};
  	}
  	if (id == 15) {
  		length = 3;
  		width = 3;
  		points = 5;
  		coordinates = new int[][] {{0,0},{0,2},{0,4},{1,4},{2,4}};
  	}
  	if (id == 16) {
  		length = 1;
  		width = 4;
  		points = 4;
  		coordinates = new int[][] {{0,0},{0,1},{0,2},{0,3}};
  	}
  	if (id == 17) {
  		length = 4;
  		width = 1;
  		points = 4;
  		coordinates = new int[][] {{0,0},{1,0},{2,0},{3,0}};
  	}
  	if (id == 18) {
  		length = 1;
  		width = 5;
  		points = 5;
  		coordinates = new int[][] {{0,0},{0,2},{0,4},{0,6},{0,8}};
  	}
  	if (id == 19) {
  		length = 5;
  		width = 1;
  		points = 5;
  		coordinates = new int[][] {{0,0},{1,0},{2,0},{3,0},{4,0}};
  	}

  	piece = new Tile[length][width];
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[i].length; j++) {
      	piece[i][j] = new Tile();
      }
    }

    if (id == 4) {
    	piece[0][0].fillTile();
    	piece[1][0].fillTile();
    	piece[1][1].fillTile();
    }
    else if (id == 5) {
    	piece[0][1].fillTile();
    	piece[1][0].fillTile();
    	piece[1][1].fillTile();
    }
    else if (id == 6) {
    	piece[0][0].fillTile();
    	piece[0][1].fillTile();
    	piece[1][0].fillTile();
    }
    else if (id == 7) {
    	piece[0][0].fillTile();
    	piece[0][1].fillTile();
    	piece[1][1].fillTile();
    }
    else if (id == 12) {
    	piece[0][0].fillTile();
    	piece[1][0].fillTile();
    	piece[2][0].fillTile();
    	piece[2][1].fillTile();
    	piece[2][2].fillTile();
    }
    else if (id == 13) {
    	piece[0][2].fillTile();
    	piece[1][2].fillTile();
    	piece[2][0].fillTile();
    	piece[2][1].fillTile();
    	piece[2][2].fillTile();
    }
    else if (id == 14) {
    	piece[0][0].fillTile();
    	piece[0][1].fillTile();
    	piece[0][2].fillTile();
    	piece[1][0].fillTile();
    	piece[2][0].fillTile();
    }
    else if (id == 15) {
    	piece[0][0].fillTile();
    	piece[0][1].fillTile();
    	piece[0][2].fillTile();
    	piece[1][2].fillTile();
    	piece[2][2].fillTile();
    }
    else {
    	for (int i = 0; i < piece.length; i++) {
      	for (int j = 0; j < piece[i].length; j++) {
        	piece[i][j].fillTile();
      	}
    	}
    }
  }

   public Piece(int x) {
  	id = x;
  	if (id == 1) {
  		length = 1;
  		width = 1;
  		points = 1;
  	}
  	if (id == 2) {
  		length = 1;
  		width = 2;
  		points = 2;
  	}
  	if (id == 3) {
  		length = 2;
  		width = 1;
  		points = 2;
  	}
  	if (id > 3 && id < 8) {
  		length = 2;
  		width = 2;
  		points = 3;
  	}
  	if (id == 8) {
  		length = 2;
  		width = 2;
  		points = 4;
  	}
  	if (id == 9) {
  		length = 1;
  		width = 3;
  		points = 3;
  	}
  	if (id == 10) {
  		length = 3;
  		width = 1;
  		points = 3;
  	}
  	if (id == 11) {
  		length = 3;
  		width = 3;
  		points = 9;
  	}
  	if (id > 11 && id < 16) {
  		length = 3;
  		width = 3;
  		points = 5;
  	}
  	if (id == 16) {
  		length = 1;
  		width = 4;
  		points = 4;
  	}
  	if (id == 17) {
  		length = 4;
  		width = 1;
  		points = 4;
  	}
  	if (id == 18) {
  		length = 1;
  		width = 5;
  		points = 5;
  	}
  	if (id == 19) {
  		length = 5;
  		width = 1;
  		points = 5;
  	}

  	piece = new Tile[length][width];
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[i].length; j++) {
      	piece[i][j] = new Tile();
      }
    }

    if (id == 4) {
    	piece[0][0].fillTile();
    	piece[1][0].fillTile();
    	piece[1][1].fillTile();
    }
    else if (id == 5) {
    	piece[0][1].fillTile();
    	piece[1][0].fillTile();
    	piece[1][1].fillTile();
    }
    else if (id == 6) {
    	piece[0][0].fillTile();
    	piece[0][1].fillTile();
    	piece[1][0].fillTile();
    }
    else if (id == 7) {
    	piece[0][0].fillTile();
    	piece[0][1].fillTile();
    	piece[1][1].fillTile();
    }
    else if (id == 12) {
    	piece[0][0].fillTile();
    	piece[1][0].fillTile();
    	piece[2][0].fillTile();
    	piece[2][1].fillTile();
    	piece[2][2].fillTile();
    }
    else if (id == 13) {
    	piece[0][2].fillTile();
    	piece[1][2].fillTile();
    	piece[2][0].fillTile();
    	piece[2][1].fillTile();
    	piece[2][2].fillTile();
    }
    else if (id == 14) {
    	piece[0][0].fillTile();
    	piece[0][1].fillTile();
    	piece[0][2].fillTile();
    	piece[1][0].fillTile();
    	piece[2][0].fillTile();
    }
    else if (id == 15) {
    	piece[0][0].fillTile();
    	piece[0][1].fillTile();
    	piece[0][2].fillTile();
    	piece[1][2].fillTile();
    	piece[2][2].fillTile();
    }
    else {
    	for (int i = 0; i < piece.length; i++) {
      	for (int j = 0; j < piece[i].length; j++) {
        	piece[i][j].fillTile();
      	}
    	}
    }
  }

  //returns a specific Tile in the array
  public Tile getTile(int x, int y) {
  	return piece[x][y];
  }

  //returns the length of the piece
  public int length() {
    return length;
  }

  //returns the width of the piece
  public int width() {
    return width;
  }

  //the id identifies which of the 19 pieces it is, returns that
  public int id() {
    return id;
  }

  //returns the number of blocks each piece takes up (number of filled tiles), or the number of points it would recieve for being placed
  public int score() {
  	return points;
  }

  public int xCoord(int coord) {
  	return coordinates[coord][0];
  }

  public int yCoord(int coord) {
  	return coordinates[coord][1];
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[i].length; j++) {
        if (piece[i][j].isFilled()) s+="- ";
        else s+="  ";
      }
      s+="\n";
    }
    return s;
  }

  public static void main(String[] args) {
    /*
    Piece test1 = new Piece(1);
    Piece test2 = new Piece(2);
    Piece test3 = new Piece(3);
    Piece test4 = new Piece(4);
    Piece test5 = new Piece(5);
    Piece test6 = new Piece(6);
    Piece test7 = new Piece(7);
    Piece test8 = new Piece(8);
    Piece test9 = new Piece(9);
    Piece test10 = new Piece(10);
    Piece test11 = new Piece(11);
    Piece test12 = new Piece(12);
    Piece test13 = new Piece(13);
    Piece test14 = new Piece(14);
    Piece test15 = new Piece(15);
    Piece test16 = new Piece(16);
    Piece test17 = new Piece(17);
    Piece test18 = new Piece(18);
    Piece test19 = new Piece(19);
    
    System.out.println(test1+"\n");
    System.out.println(test2+"\n");
    System.out.println(test3+"\n");
    System.out.println(test4+"\n");
    System.out.println(test5+"\n");
    System.out.println(test6+"\n");
    System.out.println(test7+"\n");
    System.out.println(test8+"\n");
    System.out.println(test9+"\n");
    System.out.println(test10+"\n");
    System.out.println(test11+"\n");
    System.out.println(test12+"\n");
    System.out.println(test13+"\n");
    System.out.println(test14+"\n");
    System.out.println(test15+"\n");
    System.out.println(test16+"\n");
    System.out.println(test17+"\n");
    System.out.println(test18+"\n");
    System.out.println(test19+"\n");
    */
    Piece test = new Piece();
    System.out.println(test.id());
    System.out.println(test.score());
    System.out.println(test);
  }
}