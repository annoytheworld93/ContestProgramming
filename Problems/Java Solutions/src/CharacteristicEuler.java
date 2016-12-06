import java.util.Arrays;
import java.util.Scanner;




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
			char[][] bigMap = new char[height+2][width+2];
			for(int i = 0; i< height+2; i++)
				for(int k = 0; k< width+2; k++ )
					bigMap[i][k]='O';
			for(int i = 1; i< height+1; i++)
				for(int k = 1; k< width+1; k++)
				{
					bigMap[i][k] = map[i-1][k-1];
				}

			System.out.println(Arrays.deepToString(bigMap));
//System.out.println(map[height - 1][width - 1]);
			debug(map);
			floodFillO(0, 0, 'O', '*', map);
			debug(map);
			floodFillStar(0, 0, '*', '@', map);
			debug(map);
//map[0][0] = '*';
//System.out.println(Arrays.deepToString(map));
			System.out.println("Shaded Regions: " + shadedRegions);
			System.out.println("Hole Counter: " + holeCounter);
			System.out.println((shadedRegions - holeCounter));
		}
	}

	public static void floodFillO(int x, int y, char oldChar, char newChar, char[][] bigMap) {
//TODO Check left, right, up, and down for start
//Base Cases, if we are out of index, i.e. less than one
		if (x < 0) return;
		if (y < 0) return;
		if (x >= bigMap.length) return;
		if (y >= bigMap[x].length) return;

	//oldChar = map[x][y];


		if (newChar == bigMap[x][y]) return;

		//if (oldChar != map[x][y]) return;

		if (bigMap[x][y] == 'X'){
			shadedRegions++;
			floodFillX(x, y, 'X', '*', bigMap);
		}
		if (bigMap[x][y] == oldChar) {
			bigMap[x][y] = newChar;

			floodFillO(x - 1, y, oldChar, newChar, bigMap);
			floodFillO(x + 1, y, oldChar, newChar, bigMap);
			floodFillO(x, y - 1, oldChar, newChar, bigMap);
			floodFillO(x, y + 1, oldChar, newChar, bigMap);
		}
	}

	public static void floodFillX(int x, int y, char oldChar, char newChar, char[][] bigMap){
//TODO Check, left, right, up, down, and diagonals for start
//Base Cases, if we are out of index, i.e. less than one
		if (x < 0) return;
		if (y < 0) return;
		if (x >= bigMap.length) return;
		if (y >= bigMap[x].length) return;


		if (newChar == bigMap[x][y]) return;
		if (oldChar != bigMap[x][y]) return;

		bigMap[x][y]= newChar;
//Cross Shape
			floodFillX(x - 1, y, oldChar, newChar, bigMap);
			floodFillX(x + 1, y, oldChar, newChar, bigMap);
			floodFillX(x, y - 1, oldChar, newChar, bigMap);
			floodFillX(x, y + 1, oldChar, newChar, bigMap);
//Diagonals
			floodFillX(x - 1, y + 1, oldChar, newChar, bigMap);
			floodFillX(x + 1, y + 1, oldChar, newChar, bigMap);
			floodFillX(x - 1, y - 1, oldChar, newChar, bigMap);
			floodFillX(x + 1, y - 1, oldChar, newChar, bigMap);
	}

	public static void floodFillStar(int x, int y, char oldChar, char newChar, char[][] bigMap){
		if (x < 0) return;
		if (y < 0) return;
		if (x >= bigMap.length) return;
		if (y >= bigMap[x].length) return;

		if (newChar == bigMap[x][y]) return;
		//if (oldChar != map[x][y]) return;

		if (bigMap[x][y] == 'O'){
			holeCounter++;
			//FIXME
			floodFillO(x, y, 'O', '@', bigMap);
		}

		bigMap[x][y] = newChar;


		//TODO Need to call floodFillO and then increment hole counter if we encounter an O!!!!
		floodFillStar(x - 1, y, oldChar, newChar, bigMap);
		floodFillStar(x + 1, y, oldChar, newChar, bigMap);
		floodFillStar(x, y - 1, oldChar, newChar, bigMap);
		floodFillStar(x, y + 1, oldChar, newChar, bigMap);

	}

	public static void debug(char [][] map){
		System.out.println(Arrays.deepToString(map));
	}
}
