import java.util.Scanner;

public class swea_7733 {

	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int n;

	public static void dfs(int x, int y, boolean[][] temp) {

		temp[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= n || newy >= n)
				continue;
			if (!temp[newx][newy]) {
				dfs(newx, newy, temp);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			n = sc.nextInt();
			int max = 0;
			int arr[][] = new int[n][n];
			boolean brr[][] = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] > max)
						max = arr[i][j];
				}
			} // 입력
			int idx = 1;
			int cnt = 0;
			int r = 0;
			while (max >= 1) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						brr[i][j] = false;
					}

				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (arr[i][j] <= idx) {
							brr[i][j] = true;
						}
					}
				}
				idx++;
				boolean temp[][] = brr;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (!temp[i][j]) {
							dfs(i, j, temp);
							cnt++;
						}
					}
				}
				max--;
				if (r < cnt)
					r = cnt;
				cnt = 0;
			}
			if (r == 0)
				r = 1;
			System.out.println("#" + testCase + " " + r);
		} // end of tescase
	}
}