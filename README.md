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

1/10/19
Today we started working on smaller functions and implementing game mechanics, like clearing rows and columns with clearRow() and clearColumn(), added boolean rowFilled() and columnFilled() to see if row and column are entirely filled. Worked on spawnPieces() to generate pieces outside the board. We also added documentation. 

1/13/19
Today we were able to set up the board and print the board in the terminal and we have a cursor that we can move around on the board. We were able to implement all the lanterna code with a working main function. 

1/14/19
Started with terminal manipulation, printed board and pieces as well a instructions and side notes. Can move the cursor with the arrow keys, exit the game with escape, and place 1x1, 2x2, and 3x3 pieces with 1, 2, and 3, respectively. Points accumulate with score as the player places and clears tiles. Tiles are cleared by filling up entire rows or columns. THINGS TO WORK ON: cursor cannot move outside of the board, place the tiles that are shown below and remove them instead of the ones we’re using now, add more types of pieces, change background color of board and pieces

1/15/19
Today we added the feature of keeping the cursor inside the board so the player won’t break the game/ attempt to place a piece outside the board. Added lanterna file to repo. 

1/16/19
Today we updated our board to look nicer by adding spaces, adjusting our adding pieces because of the board change. We also added ability to clear both row and column at the same time when needed. We made several branches but didn’t push, just merged. We also updated the README so it displays instructions and the devlog.

1/17/19
Today we attempted to add coloration but we didn’t push the branches because it didn’t work. We discussed about rewriting some of our functions because we needed to implement new pieces.

1/18/19
Today we tried to get the pieces to have color but that didn’t work out again, we discussed revamping our piece class to make it easier for placement and coloration, and also to be able to generate different pieces, as we only have 1x1, 2x2, 3x3 pieces so far. We discussed changing the pieces so instead of being 2D arrays of Tiles, they would be arrays of coordinates, which might make it easier to move them around the board (before placing, so the player can see what it would look like) and color them too.

1/20/19
Made it so 1 2 and 3 correspond to the pieces that are printed on the board rather than just a 1x1, 2x2, or 3x3 piece.
