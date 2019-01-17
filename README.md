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
