package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int score;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main obj = new Main();
		List<char[][]> shape = new ArrayList<>();
		obj.loadShapes(shape);
		
		boolean flag = true;
		do {
		} while (flag);

		sc.close();

	}

	private void loadShapes(List<char[][]> shape) {
		shape.add(new char[][] { { '#', '#' }, { '#', '#' } });

		shape.add(new char[][] { { '#', '#', '#', '#' } });

		shape.add(new char[][] { { '#', ' ' }, { '#', ' ' }, { '#', '#' } });

		shape.add(new char[][] { { '#', '#', ' ' }, { ' ', '#', '#' } });

		shape.add(new char[][] { { ' ', '#', ' ' }, { '#', '#', '#' } });
	}

}
