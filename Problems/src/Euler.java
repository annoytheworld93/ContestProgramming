import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by wap5053 on 9/9/16.
 */
public class Euler {
	private static int height;
	private static int width;
	private char map[][] = new char[width][height];

	static class Cell {
		int row, col;
		char symbol;
		public Cell(int r, int c, char s) {
			row = r;
			col = c;
			symbol = s;
		}
	}


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		height = scanner.nextInt();
		width = scanner.nextInt();
		for (int lineCount = 0; lineCount < height; lineCount++){
			matrixPoplation(scanner.nextLine().toCharArray(), lineCount);
		}
		Queue<Cell> queue = new LinkedList<>();
		//starting node
		int cellCount = 1;
		queue.add(new Cell(0,0));
		while (counter)
	}
	public static void matrixPoplation(char[] charArray, int lineCount){
		//Populate the map...
		for (int i = 0; i < width; i++){
			map[i][lineCount] = charArray[i];
		}
	}
}
