package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500_0218 {

	static int n, m, max = 0;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j, 0, 0);
				checkWing(i, j); // ㅓ,ㅏ,ㅗ,ㅜ 모양 확인
			}
		}
		System.out.println(max);
	}

	public static void dfs(int x, int y, int dep, int sum) {

		if (dep == 4) {
			if (sum > max)
				max = sum;
			return;
		}
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
				continue;
			brr[nx][ny] = true;
			dfs(nx, ny, dep + 1, sum + arr[nx][ny]);
			brr[nx][ny] = false;
		}

	}

	public static void checkWing(int x, int y) {
		int min = Integer.MAX_VALUE;
		int sum = arr[x][y];
		int wing = 4;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (wing <= 2) // 윙이 3개 이상 되어야 조건 성립
				return;
			// 범위 밖으로 넘어가면 wing--
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
				wing--;
				continue;
			}

			if (min > arr[nx][ny])
				min = arr[nx][ny];
			sum = sum + arr[nx][ny];
		}
		if (wing == 4) // 가장 작은 거 빼주면 모양 완성
			sum = sum - min;
		if (max < sum)
			max = sum;

	}

}
