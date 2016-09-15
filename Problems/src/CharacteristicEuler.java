/**
 * Created by wap5053 on 9/15/16.
 */
public class CharacteristicEuler {
	static int width, height;
	static char initialMap[][] = new char[width][height];
	static char map[][] = new char[width+2][height+2];
	static class Cell {
		int row, col;
		char symbol;
		public Cell(int r, int c, char s){
			row = r;
			col = c;
			symbol = s;
		}
		public int getRow(){
			return row;
		}
		public int getCol(){
			return col;
		}
		public char getSymbol(){
			return symbol;
		}
		public void setSymbol(char s){
			symbol = s;
		}
	}

	public static void main(String[] args){
		//TODO Get the user input w/ Scanner
	}

	public static void floodFillO(int x, int y, char oldChar, char newChar){
		//TODO Check left, right, up, and down for start
		//Base Cases, if we are out of index, i.e. less than one
		if (x < 0) return;
		if (y < 0) return;
		if (x >= map.length) return;
		if (y >= map[x].length) return;

		oldChar = map[x][y];

		if (newChar == map[x][y]) return;
		if (oldChar != map[x][y]) return;

		floodFillO(x -1, y, oldChar, newChar);
		floodFillO(x + 1, y, oldChar, newChar);
		floodFillO(x, y - 1, oldChar, newChar);
		floodFillO(x, y + 1, oldChar, newChar);

		}

	public static void floodFillX(int x, int y, char oldChar, char newChar){
		//TODO Check, left, right, up, down, and diagonals for start
		//Base Cases, if we are out of index, i.e. less than one
		if (x < 0) return;
		if (y < 0) return;
		if (x >= map.length) return;
		if (y >= map[x].length) return;

		oldChar = map[x][y];

		if (newChar == map[x][y]) return;
		if (oldChar != map[x][y]) return;

		//Cross Shape
		floodFillX(x -1, y, oldChar, newChar);
		floodFillX(x + 1, y, oldChar, newChar);
		floodFillX(x, y - 1, oldChar, newChar);
		floodFillX(x, y + 1, oldChar, newChar);
		//Diagonals
		floodFillX(x - 1, y + 1, oldChar, newChar);
		floodFillX(x + 1, y + 1, oldChar, newChar);
		floodFillX(x - 1, y - 1, oldChar, newChar);
		floodFillX(x + 1, y - 1, oldChar, newChar);
	}

	public static void debug(char map[][]){
		//TODO: Print the contents of the map at any given point.
	}
}
