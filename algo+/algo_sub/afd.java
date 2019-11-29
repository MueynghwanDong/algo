import java.util.Scanner;

public class afd {

	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // 우,좌,상,하
	static int r;
	static int c;

	public static void dfs(int x, int y) {

		brr[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= r || newy >= c)
				continue;
			if (!brr[newx][newy] && arr[newx][newy] == 1) {
				dfs(newx, newy);

			}
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TestCase = 1; TestCase <= T; TestCase++) {
			int cnt = 0;
			r = sc.nextInt();
			c = sc.nextInt();
			int k = sc.nextInt();
			arr = new int[r][c];
			brr = new boolean[r][c];
			for (int i = 0; i < k; i++) {
				int rx = sc.nextInt();
				int rc = sc.nextInt();
				arr[rx][rc] = 1;
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (!brr[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}