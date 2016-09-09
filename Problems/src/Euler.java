import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by wap5053 on 9/9/16.
 */
public class Euler {
	private static int height;
	private static int width;
	private static char[][] map = new char[width][height];

	private static Queue<Cell> queueX = new LinkedList<>();
	private static Queue<Cell> queueO = new LinkedList<>();

	static class Cell {
		int row, col;
		char symbol;
		public Cell(){}
		public Cell(int r, int c, char s) {
			row = r;
			col = c;
			symbol = s;
		}
		public void setRow(int r){row = r;}
		public void setCol(int c){col = c;}
		public void setSymbol(char c){symbol = c;}
		public int getRow(){
			return row;
		}
		public int getCol(){
			return col;
		}
		public char getSymbol(){
			return symbol;
		}
	}


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		height = scanner.nextInt();
		width = scanner.nextInt();

		//Get input for map

		String input = scanner.nextLine();
		for (int heightIndex = 0; heightIndex < height; heightIndex++){
			for (int widthIndex = 0; widthIndex < width; widthIndex++){
				char lineChar = input.charAt(widthIndex);
				map[widthIndex][heightIndex] = lineChar;
			}
		}

	}

	public static void mapSearch(){

		for (int heightIndex = 0; heightIndex < height; heightIndex++){
			for (int widthIndex = 0; widthIndex < width; widthIndex++){
				char mapIndex = map[widthIndex][heightIndex];
				Cell cell = new Cell(widthIndex, heightIndex, mapIndex);
				if (cell.getSymbol() == 'O'){
					//TODO Do something when we encounter an O
					queueO.add(cell);
					//Look at the neighbors of cell...
					while (!queueO.isEmpty()){
						//TODO Check to make sure that we don't go out of bounds

						//Check the surrounding elements of each cell.
						if (map[cell.getRow()-1][cell.getCol()] == 'O'){
							Cell oCell = new Cell(cell.getRow()-1, cell.getCol(), 'O');
							queueO.add(oCell);
						}
						if (map[cell.getRow()][cell.getCol()-1] == 'O'){
							Cell oCell = new Cell(cell.getRow(), cell.getCol()-1, 'O');
							queueO.add(oCell);
						}
						if (map[cell.getRow()+1][cell.getCol()] == 'O'){
							Cell oCell = new Cell(cell.getRow()+1, cell.getCol(), 'O');
							queueO.add(oCell);
						}
						if (map[cell.getRow()][cell.getCol()+1] == 'O'){
							Cell oCell = new Cell(cell.getRow(), cell.getCol()+1, 'O');
							queueO.add(oCell);
						}

						if (map[cell.getRow()-1][cell.getCol()] == 'X'){
							Cell xCell= new Cell(cell.getRow()-1, cell.getCol(), 'X');
							queueX.add(xCell);
						}
						if (map[cell.getRow()][cell.getCol()-1] == 'X'){
							Cell xCell = new Cell(cell.getRow(), cell.getCol()-1, 'X');
							queueX.add(xCell);
						}
						if (map[cell.getRow()+1][cell.getCol()] == 'X'){
							Cell xCell = new Cell(cell.getRow()+1, cell.getCol(), 'X');
							queueX.add(xCell);
						}
						if (map[cell.getRow()][cell.getCol()+1] == 'X'){
							Cell xCell = new Cell(cell.getRow(), cell.getCol()+1, 'X');
							queueX.add(xCell);
						}
						if (map[cell.getRow()+1][cell.getCol()] == 'X'){
							Cell xCell = new Cell(cell.getRow()+1, cell.getCol(), 'X');
							queueX.add(xCell);
						}
						//If we already visited this cell, it has been indicated with a '*'

						cell.setSymbol('*');
						queueO.remove();
					}
				}
				else if (map[widthIndex][heightIndex] == 'X'){
					//TODO Do something when we encounter a X
					queueX.add(new Cell(0,0,'X'));
				}
				else{
					//TODO Do something when we already visited that cell...

				}
			}
		}
	}


}
