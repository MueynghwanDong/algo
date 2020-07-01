package algo0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테르로미노 {

	static int r;
	static int c;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		brr = new boolean[r][c];
		max = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				dfs(i, j, 0, 0);
			}
		}
		except();
		System.out.println(max);

	}

	public static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			if (max < sum)
				max = sum;
			return;
		}
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
				continue;

			brr[nx][ny] = true;
			dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
			brr[nx][ny] = false;
		}
	}

	public static void except() {

		int sum = 0;
		for (int i = 0; i < r - 1; i++) {
			for (int j = 0; j < c - 2; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1];
				if (max < sum)
					max = sum;
			}
		}
		for (int i = 0; i < r - 2; i++) {
			for (int j = 0; j < c- 1; j++) {
				sum = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j + 1];
				if (max < sum)
					max = sum;
			}
		}
		for (int i = 0; i < r - 1; i++) {
			for (int j = 1; j < c - 1; j++) {
				sum = arr[i][j] + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
				if (max < sum)
					max = sum;
			}
		}
		for (int i = 1; i < r - 1; i++) {
			for (int j = 0; j < c - 1; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i - 1][j + 1] + arr[i + 1][j + 1];
				if (max < sum)
					max = sum;
			}
		}

	}

}
