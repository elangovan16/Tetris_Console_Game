package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int score;

	public static void main(String[] args) {
		Main game = new Main();
		game.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		List<char[][]> shapeList = new ArrayList<>();
		System.out.print("Enter m x n: ");
		int m = sc.nextInt();
		int n = sc.nextInt();
		char[][] screen = new char[m][n];
		loadShapes(shapeList);
		boolean gameOn = true;

		while (gameOn) {
			System.out.print("Shape No, RotateCount, IndexOfColumn: ");
			int shapeNo = sc.nextInt();
			int rotateCount = sc.nextInt();
			int indexOfColumn = sc.nextInt();

			if (shapeNo < 1 || shapeNo > shapeList.size() || indexOfColumn < 0 || indexOfColumn >= n) {
				System.err.println("Invalid input. Try again.");
				continue;
			}

			char[][] shape = shapeList.get(shapeNo - 1);
			char[][] rotatedShape = rotateMatrixNTimes(shape, rotateCount);
			int rotatedShapeCol = rotatedShape[0].length;

			if (indexOfColumn + rotatedShapeCol > n) {
				System.err.println("Shape does not fit in the specified column. Try again.");
				continue;
			}

			int indexOfRow = findIndexOfRow(rotatedShape, screen, indexOfColumn);
			System.out.println("Index of Row : " + indexOfRow);
			if (indexOfRow < 0) {
				System.out.println("\t+-------------+");
				System.out.println("\t|  Game Over  |");
				System.out.println("\t+-------------+");
				gameOn = false;
			} else {
				addShapeInScreen(indexOfRow, indexOfColumn, rotatedShape, screen);
			}
		}
		System.out.println("+--------------------+");
		System.out.println("| 1. Play Again      |");
		System.out.println("| 2. Exit the Game   |");
		System.out.println("+--------------------+");
		System.out.print("Enter : ");
		int choice = sc.nextInt();

		if (choice == 1) {
			score = 0;
			start();
		} else {
			sc.close();
			System.out.println("\t+--------------+");
			System.out.println("\t|  Game Closed |");
			System.out.println("\t+--------------+");
		}
	}

	private void addShapeInScreen(int indexOfRow, int indexOfColumn, char[][] rotatedShape, char[][] screen) {
		int shapeRow = rotatedShape.length;
		int shapeCol = rotatedShape[0].length;

		for (int i = 0; i < shapeRow; i++) {
			for (int j = 0; j < shapeCol; j++) {
				if (rotatedShape[i][j] == '#') {
					screen[indexOfRow + i][indexOfColumn + j] = '#';
				}
			}
		}
		printScreen(screen);
		findScore(rotatedShape, screen);
		System.out.println("\nScore: " + Main.score + "\n");
	}

	private void findScore(char[][] rotatedShape, char[][] screen) {
		int count = 0;
		int row = screen.length;
		int col = screen[0].length;
		int j;
		for (int i = 0; i < row; i++) {
			int temp = 0;
			for (j = 0; j < col; j++) {
				if (screen[i][j] == '#') {
					temp++;
				}
			}
			if (temp == col) {
				removeColumnInScreen(i, screen, col);
				j--;
				count++;
			}
		}
		Main.score += (count * count) * 10;
	}

	private void removeColumnInScreen(int index, char[][] screen, int col) {
		for (int i = index; i >= 1; i--) {
			for (int j = 0; j < col; j++) {
				screen[i][j] = screen[i - 1][j];
			}
		}
		for (int i = 0; i < col; i++) {
			screen[0][i] = '\u0000';
		}
	}

	private int findIndexOfRow(char[][] rotatedShape, char[][] screen, int indexOfColumn) {
		int shapeHeight = rotatedShape.length;
		int shapeWidth = rotatedShape[0].length;
		int screenHeight = screen.length;

		for (int i = 0; i <= screenHeight - shapeHeight; i++) {

			for (int row = 0; row < shapeHeight; row++) {
				for (int col = 0; col < shapeWidth; col++) {
					if (rotatedShape[row][col] == '#' && screen[i + row][indexOfColumn + col] == '#') {
						return i - 1;
					}
				}
			}
		}
		return screenHeight - shapeHeight;
	}

	private void printScreen(char[][] matrix) {
		for (char[] row : matrix) {
			for (char cell : row) {
				if (cell == '#') {
					System.out.print("# ");
				} else {
					System.out.print("_ ");
				}
			}
			System.out.println();
		}
	}

	private char[][] rotateMatrixNTimes(char[][] matrix, int n) {
		int rotations = n % 4;
		char[][] result = matrix;
		for (int i = 0; i < rotations; i++) {
			result = rotateClockwise(result);
		}
		return result;
	}

	public static char[][] rotateClockwise(char[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		char[][] rotated = new char[cols][rows];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				rotated[c][rows - 1 - r] = matrix[r][c];
			}
		}

		return rotated;
	}

	private void loadShapes(List<char[][]> shapeList) {
		shapeList.add(new char[][] { { '#', '#' }, { '#', '#' } });
		shapeList.add(new char[][] { { '#', '#', '#', '#' } });
		shapeList.add(new char[][] { { '#', ' ' }, { '#', ' ' }, { '#', '#' } });
		shapeList.add(new char[][] { { '#', '#', ' ' }, { ' ', '#', '#' } });
		shapeList.add(new char[][] { { ' ', '#', ' ' }, { '#', '#', '#' } });
	}
}
