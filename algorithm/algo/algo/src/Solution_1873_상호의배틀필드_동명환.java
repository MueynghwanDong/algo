import java.util.Scanner;

public class Solution_1873_상호의배틀필드_동명환 {

	private static int h;
	private static int w;
	private static char[][] crr;
	private static char[] test;
	private static int num;
	static int cx;
	static int cy;

	public static boolean check(int x, int y) {
		if (x < 0 || y < 0 || x >= h || y >= w)
			return false;
		else
			return true;
	}

	public static void shoot(int x, int y) {
		if (crr[x][y] == '<') {
			for (int i = y - 1; i >= 0; i--) {
				if (crr[x][i] == '#')
					break;
				else if (crr[x][i] == '*') {
					crr[x][i] = '.';
					break;
				}
			}
		} else if (crr[x][y] == '>') {
			for (int i = y + 1; i < w; i++) {
				if (crr[x][i] == '#')
					break;
				else if (crr[x][i] == '*') {
					crr[x][i] = '.';
					break;
				}
			}
		} else if (crr[x][y] == '^') {
			for (int i = x - 1; i >= 0; i--) {
				if (crr[i][y] == '#')
					break;
				else if (crr[i][y] == '*') {
					crr[i][y] = '.';
					break;
				}
			}
		} else if (crr[x][y] == 'v') {
			for (int i = x + 1; i < h; i++) {
				if (crr[i][y] == '#')
					break;
				else if (crr[i][y] == '*') {
					crr[i][y] = '.';
					break;
				}
			}
		}
	}

	public static void game(int x, int y, char c) {
		switch (c) {
		case 'S':
			shoot(x, y);
			break;
		case 'U':
			if (check(x - 1, y)) {
				if (crr[x - 1][y] == '-') {
					crr[x][y] = '^';
					break;
				}
				if (crr[x - 1][y] == '.') {
					crr[x - 1][y] = '^';
					cx = x - 1;
					crr[x][y] = '.';
				} else {
					crr[x][y] = '^';
				}
			} else {
				crr[x][y] = '^';
			}
			break;
		case 'D':
			if (check(x + 1, y)) {
				if (crr[x + 1][y] == '-') {
					crr[x][y] = 'v';
					break;
				}
				if (crr[x + 1][y] == '.') {
					crr[x + 1][y] = 'v';
					cx = x + 1;
					crr[x][y] = '.';
				} else {
					crr[x][y] = 'v';
				}
			} else {
				crr[x][y] = 'v';
			}
			break;
		case 'R':
			if (check(x, y + 1)) {
				if (crr[x][y + 1] == '-') {
					crr[x][y] = '>';
					break;
				}
				if (crr[x][y + 1] == '.') {
					crr[x][y + 1] = '>';
					cy = y + 1;
					crr[x][y] = '.';
				} else {
					crr[x][y] = '>';
				}
			} else {
				crr[x][y] = '>';
			}

			break;
		case 'L':
			if (check(x, y - 1)) {
				if (crr[x][y - 1] == '-') {
					crr[x][y] = '<';
					break;
				}
				if (crr[x][y - 1] == '.') {
					crr[x][y - 1] = '<';
					cy = y - 1;
					crr[x][y] = '.';
				} else {
					crr[x][y] = '<';
				}
			} else {
				crr[x][y] = '<';
			}
			break;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int testCase = 1; testCase <= t; testCase++) {
			h = sc.nextInt();
			w = sc.nextInt();
			crr = new char[h][w];

			for (int i = 0; i < h; i++) {
				String s = sc.next();
				for (int j = 0; j < w; j++) {
					crr[i][j] = s.charAt(j);
					if (crr[i][j] == '<' || crr[i][j] == '>' || crr[i][j] == '^' || crr[i][j] == 'v') {
						cx = i;
						cy = j;
					}
				}
			}
			num = sc.nextInt();
			test = new char[num];
			String str = sc.next();
			char[][] arr = new char[h][w];
			arr = crr.clone();
			for (int i = 0; i < num; i++) {
				test[i] = str.charAt(i);

			}
			for (int i = 0; i < test.length; i++) {
				game(cx, cy, test[i]);
			}
			// SSSSDDRSDRSRDSU LUURSSSSRRRR DSSSSDDLSDLSDLSSD
			System.out.print("#" + testCase + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(crr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
