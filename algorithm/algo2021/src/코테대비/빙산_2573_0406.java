package 코테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙산_2573_0406 {

	static int r, c, ans = 0;
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			int cnt = check();
			if (cnt >= 2) {
				System.out.println(ans);
				break;
			} else if (cnt == 0) {
				System.out.println(0);
				break;
			} else {
				down();
				ans++;
			}
		}
	}

	public static void down() {
		int[][] temp = new int[r][c];
		for (int i = 0; i < r; i++) {
			temp[i] = arr[i].clone();
		}
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cnt = 0;
				for (int k = 0; k < dirs.length; k++) {
					int nx = i + dirs[k][0];
					int ny = j + dirs[k][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (arr[nx][ny] == 0)
						cnt++;
				}
				temp[i][j] = temp[i][j] - cnt;
				if (temp[i][j] < 0)
					temp[i][j] = 0;
			}
		}
		for (int i = 0; i < r; i++) {
			arr[i] = temp[i].clone();
		}
	}

	public static int check() {
		int result = 0;
		brr = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != 0 && !brr[i][j]) {
					dfs(i, j);
					result++;
				}
			}
		}
		return result;
	}

	public static void dfs(int x, int y) {
		brr[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == 0 || brr[nx][ny])
				continue;
			dfs(nx, ny);
		}
	}

}
