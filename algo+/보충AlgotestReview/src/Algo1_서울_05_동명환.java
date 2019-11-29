import java.util.Scanner;

/*
12
5 7
T 0 T 0 G 0 G
0 W T W W W 0
T W G 0 T W T
0 0 0 T G W 0
0 0 T 0 0 W 0
2 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0
7 7
W W W W W W W
W T G W G T W
W T T T T T W
W T T T T T W
W T G G G T W
W T T T T T W
W W W W W W W
9 9
T 0 T 0 T 0 T 0 T
0 0 W W W W W 0 T
T W T T T T T W 0
0 W T G G G T W T
T W T G T G T W 0
0 W T G G G T W T
T W T T T T T W 0
0 0 W W W W W 0 T
T 0 T 0 T 0 T 0 T
7 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0
T W 0 T 0 W 0 G 0 W
T W 0 G 0 W 0 T 0 W
G 0 T W T 0 T W T 0
T W 0 G 0 W T G T W
0 G T W T 0 T W T 0
10 11
T W 0 G 0 W 0 G 0 W 0
G 0 T W T 0 T W T 0 0
T W 0 T 0 W 0 G 0 W G
T W 0 G 0 W 0 T 0 W 0
G 0 T W T 0 T W T 0 T
T W 0 G 0 W T G T W G
T G T W T 0 T W T T T
G W T W G 0 G W G T G
T G T W T 0 T W T T W
W T T 0 W 0 T T T W T
10 14
T 0 T 0 G 0 G T 0 T 0 G 0 G
0 W T W W W 0 0 W T W W W 0
T W G 0 T W T T W G 0 T W T
0 0 0 T G W 0 0 0 0 T G W 0
0 0 0 T G W 0 0 0 0 T G W 0
T 0 T 0 G 0 G T 0 T 0 G 0 G
0 W T W W W 0 0 W T W W W 0
T W G 0 T W T T W G 0 T W T
0 0 0 T G W 0 0 0 0 T G W 0
0 0 T 0 0 W 0 0 0 T G T W 0
15 10
G 0 G 0 G 0 G 0 G 0
0 G 0 W 0 W 0 W 0 G
G 0 W 0 G 0 G W W 0
0 G 0 W 0 W 0 T W G
G 0 W 0 G 0 G W W 0
0 G 0 W 0 0 0 W 0 G
G 0 W 0 G W G W W 0
0 G 0 W 0 W 0 T W G
G 0 W 0 G W G W W 0
0 G 0 W 0 0 0 W 0 G
G 0 W 0 G W G W W 0
0 G 0 W W T W W 0 G
G 0 W 0 W W W 0 W 0
0 G G G 0 G 0 G 0 G
G W G W G W G W G W
1 20
G W G T T G G T W T T G T 0 T 0 G 0 T W
15 1
T
G
G
T
W
T
W
G
G
T
T
G
G
T
T
20 20
G 0 0 T 0 0 T 0 0 T 0 0 T 0 0 T 0 0 0 T
0 G 0 0 G 0 G 0 G W G 0 G 0 G 0 G 0 T 0
0 0 G 0 W 0 0 T 0 0 T 0 0 0 0 W 0 T 0 0
0 0 0 G W 0 0 0 0 W 0 0 0 0 T W T 0 0 0
0 G W W W 0 0 0 0 0 0 0 0 0 0 W W W G 0
0 0 0 0 0 G 0 0 T W 0 T 0 0 T 0 0 0 0 0
0 G T 0 0 0 0 0 T 0 0 T 0 0 0 0 T G T 0
0 0 0 G 0 G 0 0 T W 0 0 0 0 G 0 0 T 0 0
0 T 0 0 0 0 0 0 T 0 T 0 0 0 T 0 G W 0 0
0 0 0 0 T T T T T W T T T T T T 0 0 G 0
0 W 0 W 0 W 0 W G W G W 0 W 0 W T W 0 W
0 G T 0 T 0 0 0 0 W T T T T 0 T G T 0 0
0 0 0 0 0 0 G G G G G G G G 0 0 T 0 G 0
0 0 G 0 W W W 0 W W W 0 W W W 0 0 0 0 0
0 G 0 0 T T 0 T 0 0 T 0 G 0 G T 0 0 T G
0 0 W W W 0 0 0 0 W 0 0 0 0 0 W W W 0 0
0 0 0 T W 0 T 0 T 0 0 T 0 0 G W T 0 0 0
0 0 T 0 W 0 G 0 0 W 0 0 0 0 0 W 0 0 T 0
0 T 0 0 0 G 0 G 0 G 0 0 G 0 0 0 0 0 0 0
T 0 0 0 G 0 0 T 0 W G 0 T 0 G 0 G 0 T G 
20 20
G 0 W T 0 0 0 0 0 T 0 0 W 0 0 T 0 0 0 T
0 G 0 0 G 0 G 0 G W G 0 G 0 G 0 G 0 W 0
0 0 G W W 0 0 T 0 0 W 0 0 0 W W W T 0 0
0 0 0 G W 0 0 0 0 W 0 0 0 0 T W T 0 0 0
0 G W W W 0 0 0 W 0 0 0 0 0 0 W W W G 0
0 0 0 0 0 G 0 W T W 0 T 0 0 T 0 0 0 0 0
0 G W 0 0 0 0 0 T 0 0 T 0 0 W 0 W G W 0
0 W 0 G 0 G G W T W 0 0 0 0 G 0 0 0 0 0
0 T 0 0 0 0 0 0 T 0 T 0 W 0 W 0 G W 0 0
0 0 0 0 T W G W W W W T T T T W G 0 G 0
0 W 0 W 0 W 0 W G W G W W W 0 W 0 W 0 W
0 G W 0 T 0 0 0 0 W W 0 0 W 0 0 G 0 0 0
0 0 0 0 0 0 G G G G G G G G 0 0 0 0 G 0
0 0 G 0 W W W 0 W W W 0 W W W 0 0 0 0 0
0 G W 0 T T G 0 0 G T W G 0 W T 0 0 W G
0 0 W W W 0 0 0 0 W 0 0 0 0 0 W W W 0 0
0 0 0 T W 0 W 0 T 0 0 T W 0 G W T 0 0 0
0 W T 0 W 0 G 0 0 W 0 0 0 0 0 W 0 0 T 0
W T W 0 0 G 0 G 0 G 0 0 G 0 0 0 W 0 0 0
T 0 0 0 G 0 0 W 0 W G 0 W 0 G 0 G 0 W G
 */
public class Algo1_서울_05_동명환 {

	static String[][] srr;
	static int R;
	static int C;
	static boolean[][] visited;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static int cnt;

	public static void dfs(int x, int y) {
		for (int i = 0; i < dirs.length; i++) {
			if (i == 0) { // 하
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				outerloop: for (int j = nx; j < R; j++) {
					if (srr[j][ny].equals("T")) {
						srr[j][ny] = "W";
						cnt++;
						break;
					} else if (srr[j][ny].equals("W") || srr[j][ny].equals("G"))
						break outerloop;
				}
			} else if (i == 1) { // 상
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				outerloop: for (int j = nx; j >= 0; j--) {
					if (srr[j][ny].equals("T")) {
						srr[j][ny] = "W";
						cnt++;
						break;
					} else if (srr[j][ny].equals("W") || srr[j][ny].equals("G"))
						break outerloop;
				}
			} else if (i == 2) { // 좌
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				outerloop: for (int j = ny; j >= 0; j--) {
					if (srr[nx][j].equals("T")) {
						srr[nx][j] = "W";
						cnt++;
						break;
					} else if (srr[nx][j].equals("W") || srr[nx][j].equals("G"))
						break outerloop;
				}
			} else if (i == 3) { // 우
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				outerloop: for (int j = ny; j < C; j++) {
					if (srr[nx][j].equals("T")) {
						srr[nx][j] = "W";
						cnt++;
						break;
					} else if (srr[nx][j].equals("W") || srr[nx][j].equals("G"))
						break outerloop;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			cnt = 0;
			R = sc.nextInt();
			C = sc.nextInt();
			srr = new String[R][C];
			visited = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					srr[i][j] = sc.next();
					if (srr[i][j].equals("W"))
						visited[i][j] = true;
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (srr[i][j].equals("G")) {
						dfs(i, j);
					}
				}
			}
			System.out.println("#" + testCase + " " + cnt);
		}
	}// end of main
} // end of class
