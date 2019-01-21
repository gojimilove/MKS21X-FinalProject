import java.util.Random;

public class Piece {
	private int id,length,width,points;
  private Tile[][] piece;

  // public Piece() {
  // 	Random rand = new Random();
  //   int randomLength = rand.nextInt(20) + 1;
  //   id = randomLength;
  //   if (id == 1) piece = new int[1][2];
  //   if (id == 2 || id == 3) piece = new int[2][2];
  //   if ()
  // }

  public Piece() {
  	Random rand = new Random();
  	int randomID = rand.nextInt(19) + 1;
  	id = randomID;
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



  // public Piece() {
  //   Random rand = new Random();
  //   int randomLength = rand.nextInt(3) + 1;
  //   length = randomLength;
  //   piece = new Tile[length][length];
  //   for (int i = 0; i < piece.length; i++) {
  //     for (int j = 0; j < piece[i].length; j++) {
  //     	piece[i][j] = new Tile();
  //       piece[i][j].fillTile();
  //     }
  //   }
  // }

  // public Piece(int len) {
  //   length = len;
  //   piece = new Tile[length][length];
  //   for (int i = 0; i < piece.length; i++) {
  //     for (int j = 0; j < piece[i].length; j++) {
  //       piece[i][j] = new Tile();
  //       piece[i][j].fillTile();
  //     }
  //   }
  // }

  public int length() {
    return length;
  }

  public int width() {
    return width;
  }

  public int id() {
    return id;
  }

  public int score() {
  	return points;
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < piece.length; i++) {
      for (int j = 0; j < piece[i].length; j++) {
        if (piece[i][j].isFilled()) s+="F ";
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