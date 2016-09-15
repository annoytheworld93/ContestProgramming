import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alexander on 9/15/2016.
 */
public class CharacteristicEuler {

	static int shadedRegions = 0;
	static int holeCounter = 0;

	////////////////////////////////////
	public static void main(String[] args) {
//TODO Get the user input w/ Scanner
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for(int j = 0; j< testCases; j++) {
			shadedRegions = 0;
			holeCounter = 0;
			int height = scanner.nextInt();
			int width = scanner.nextInt();
			scanner.nextLine();
//Populating the map
			char[][] map = new char[height][width];
			for (int i = 0; i < height; i++) {
				map[i] = scanner.nextLine().toCharArray();
			}
			//System.out.println(Arrays.deepToString(map));
			//System.out.println(map[height - 1][width - 1]);
			floodFillO(0, 0, 'O', '*', map);
			floodFillStar(0, 0, '*', '@', map);
			//map[0][0] = '*';
			//System.out.println(Arrays.deepToString(map));
			//System.out.println("Shaded Regions: " + shadedRegions);
			//System.out.println("Hole Counter: " + holeCounter);
			System.out.println((shadedRegions - holeCounter));
		}
	}

	public static void floodFillO(int x, int y, char oldChar, char newChar, char[][] map) {
//TODO Check left, right, up, and down for start
//Base Cases, if we are out of index, i.e. less than one
		if (x < 0) return;
		if (y < 0) return;
		if (x >= map.length) return;
		if (y >= map[x].length) return;

	//oldChar = map[x][y];


		if (newChar == map[x][y]) return;

		//if (oldChar != map[x][y]) return;

		if (map[x][y] == 'X'){
			shadedRegions++;
			floodFillX(x, y, 'X', '*', map);
		}
		if (map[x][y] == oldChar) {
			map[x][y] = newChar;

			floodFillO(x - 1, y, oldChar, newChar, map);
			floodFillO(x + 1, y, oldChar, newChar, map);
			floodFillO(x, y - 1, oldChar, newChar, map);
			floodFillO(x, y + 1, oldChar, newChar, map);
		}
	}

	public static void floodFillX(int x, int y, char oldChar, char newChar, char[][]map){
//TODO Check, left, right, up, down, and diagonals for start
//Base Cases, if we are out of index, i.e. less than one
		if (x < 0) return;
		if (y < 0) return;
		if (x >= map.length) return;
		if (y >= map[x].length) return;


		if (newChar == map[x][y]) return;
		if (oldChar != map[x][y]) return;

		map[x][y]= newChar;
//Cross Shape
			floodFillX(x - 1, y, oldChar, newChar, map);
			floodFillX(x + 1, y, oldChar, newChar, map);
			floodFillX(x, y - 1, oldChar, newChar, map);
			floodFillX(x, y + 1, oldChar, newChar, map);
//Diagonals
			floodFillX(x - 1, y + 1, oldChar, newChar, map);
			floodFillX(x + 1, y + 1, oldChar, newChar, map);
			floodFillX(x - 1, y - 1, oldChar, newChar, map);
			floodFillX(x + 1, y - 1, oldChar, newChar, map);
	}

	public static void floodFillStar(int x, int y, char oldChar, char newChar, char[][] map){
		if (x < 0) return;
		if (y < 0) return;
		if (x >= map.length) return;
		if (y >= map[x].length) return;

		if (newChar == map[x][y]) return;
		//if (oldChar != map[x][y]) return;

		if (map[x][y] == 'O'){
			holeCounter++;
			//FIXME
			floodFillO(x, y, 'O', '@', map);
		}

		map[x][y] = newChar;


		//TODO Need to call floodFillO and then increment hole counter if we encounter an O!!!!
		floodFillStar(x - 1, y, oldChar, newChar, map);
		floodFillStar(x + 1, y, oldChar, newChar, map);
		floodFillStar(x, y - 1, oldChar, newChar, map);
		floodFillStar(x, y + 1, oldChar, newChar, map);

	}

	public static void debug(char [][] map){
		System.out.println(Arrays.deepToString(map));
	}
}
