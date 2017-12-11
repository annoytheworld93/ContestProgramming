import java.util.Scanner;

/**
 * Created by ParksW on 7/19/2017.
 */
public class Kabloom {
  static int n;
  static char a[] = new char[1005];
  static char b[] = new char[1005];

  static boolean f[][] = new boolean[2002][2002];
  static int m[][] = new int[2002][2002];

  public static int points(char card) {
    if (card == 'A') return 20;
    if (card == 'J' || card == 'Q' || card == 'K') return 15;
    if (card == 'T') return 10;
    return card - '0';
  }

  public static int points(char card1, char card2) {
    if (card1 == 'R' && card2 == 'R') return 50;
    if (card1 == 'R') return points(card2);
    if (card2 == 'R') return points(card1);
    if (card1 == card2) return points(card1);
    return 0;
  }

  public static int len( int l, int r) {
    if (l >= n || r >= n) return 0;

    if (f[l][r])
      return m[l][r];

    if (a[l] == b[r] || a[l] == 'R' || b[r] == 'R') {
      m[l][r] = 2 * points(a[l], b[r]) + len(l+1, r+1);
    } else m[l][r] = 0;
    m[l][r] = Math.max(len(l + 1, r) , m[l][r]);
    m[l][r] = Math.max(len(l, r + 1), m[l][r]);

    f[l][r] = true;
    return m[l][r];
  }

  public static void clear() {
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        f[i][j] = false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      n = sc.nextInt();
      if (n == 0)
        break;
      for (int i = 0; i < n; i++) {
        a[i] = sc.next().charAt(0);
      }
      for (int i = 0; i < n; i++) {
        b[i] = sc.next().charAt(0);
      }
      System.out.println(len(0,0));
      clear();
    }
  }
}
