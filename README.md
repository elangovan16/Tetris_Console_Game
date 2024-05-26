# Java Console Tetris Game

This Java application is a simplified version of a Tetris-like game. Players are prompted to insert predefined shapes into a grid, rotate the shapes, and attempt to fit them in the best possible manner. The objective is to fill rows completely to score points, and the game ends when no more shapes can be placed.

## How to Run the Game

### 1 . Requirements :

* Java Development Kit (JDK) installed on your machine (JDK 8 or later).

### 2. Compilation :

* Save the code in a file named  `Main.java`.
* Open a terminal/command prompt.
* Navigate to the directory where `Main.java` is saved.

```sh
javac Main.java
```

### 3. Execution : 
* Run the compiled program using the command:
```sh
java Main
```

## Gameplay Instructions :

### 1. Starting the Game :
* The game will prompt you to enter the dimensions of the grid`(m x n)`.

### 2. Inserting Shapes :

* You will be asked to provide the shape number, the number of rotations (clockwise), and the starting column index where the shape will be inserted.
* Example input: `2 1 3` (Shape number 2, rotated once, placed starting from column index 3).

### 3. Shapes :
* Shape 1: Square (2x2)
```sh
##
##
```
* Shape 2: Line (4x1)
```sh
####
```
* Shape 3: L-shape (3x2)
```sh
#
#
##
```
* Shape 4: Z-shape (2x3)
```sh
##
 ##
```
* Shape 5: T-shape (2x3)
```sh
 #
###
```
### 4. Rotations :
* You can rotate shapes `0 to 3` times (0° to 270°).
### 5. Placing Shapes :
* If the shape does not fit in the specified column, an error message will prompt you to try again.
### 6. Game Over :
* The game ends if there is no room to place a shape.
### 7. Scoring :

* You score points by completely filling rows.
The score is calculated as `(number of rows cleared)^2 * 10.`
### 8. Restarting/Exiting :
* After a game ends, you will have the option to play again or exit.

## Code Overview
### Main Class:
* `main(String[] args)`: Starts the game.
* `start()`: Handles the game loop and user input.
* `addShapeInScreen(int indexOfRow, int indexOfColumn, char[][] rotatedShape, char[][] screen)`: Adds the shape to the screen and updates the score.
* `findScore(char[][] rotatedShape, char[][] screen)`: Calculates the score.
* `removeColumnInScreen(int index, char[][] screen, int col)`: Removes a filled row and shifts rows down.

* `findIndexOfRow(char[][] rotatedShape, char[][] screen, int   indexOfColumn)`: Determines the row index where the shape should be placed.
* `printScreen(char[][] matrix)`: Prints the current state of the grid.
* `rotateMatrixNTimes(char[][] matrix, int n)`: Rotates the matrix n times clockwise.
* `rotateClockwise(char[][] matrix)`: Rotates a matrix 90° clockwise.
* `loadShapes(List<char[][]> shapeList)`: Loads predefined shapes into a list.
## Note
* Ensure valid inputs to avoid errors and unexpected behavior.
* Customize shapes and grid sizes by modifying the `loadShapes` method and input prompts, respectively.