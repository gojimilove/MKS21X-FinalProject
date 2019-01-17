# TenTen

Welcome to 1010!
1010 is a game where there is a 10x10 board of empty tiles that the player has to fill in. The player is given 3 randomly generated shapes
that they have to place onto the board. Once the player places all 3 shapes, another 3 will be given to the player, and this continues until the player loses. The goal of the game is to fill up each row and column on the board. Once a row or column is filled, that row or column wil clear and grant the player score. There is no score limit, the player will try to achieve the highest score they can. The player will lose if they cannot place another shape onto the board with the shapes they have left. 


Instructions: 
1. Compiling and Running
  $ javac -cp lanterna.jar:. TenTen.java
  $ java -cp lanterna.jar:. TenTen
2. To use:
  To select a shape, hit 1, 2, or 3 to toggle between the 3 you're given and hit enter to confirm. 
  This will bring you onto the board with a cursor that you can move around to place the shape you selected. 
  Hit enter to place the shape.
  Repeat this process indefinitely. 
  
APCS FINAL PROJECT DEVLOG

1/4/19
Today we worked on our Tile class. We wrote attributes, the constructor, and added new methods, fillTile(). We discussed how the pieces should be constructed and how to check them against the board.

1/7/19
Today we worked on our Board and discussed our piece class mechanics. We talked about how to move the pieces, how the player controls the pieces, and how to place the pieces on the board. We made our board. Added method clearTile().

1/8/19
Today we worked on our tile and piece class. Tried to print out a piece to test if it works. Made the random piece constructor, added its toString(), tested to see if it prints successfully. Printed basic squares, 1x1, 2x2, 3x3.

1/9/19
Today we successfully tested adding pieces to our board, successfully generated random pieces, working on test cases for piece placement and working on new variations of pieces.  Implemented some parts of addPiece(), worked on pieceFits(), added a get method for the length of pieces. Added documentation for TenTen, Tile, and Piece classes. Added test cases for overlapping pieces and out of bounds pieces with function pieceFits().

