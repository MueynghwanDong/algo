package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기_17136_0217 {

	static int[] square = { 0, 5, 5, 5, 5, 5 };
	static int[][] arr = new int[10][10];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	public static void dfs(int n, int cnt) {
		if (n == 100) {
			if (ans > cnt)
				ans = cnt;
			return;
		}
		if (ans <= cnt)
			return;
		int r = n / 10;
		int c = n % 10;
		if (arr[r][c] == 1) {
			for (int i = 5; i > 0; i--) {
				if (square[i] > 0) {
					if (check(r, c, i)) {
						square[i]--;
						for (int a = 0; a < i; a++) {
							for (int b = 0; b < i; b++) {
								arr[r + a][c + b] = 0;
							}
						}
						dfs(n + 1, cnt + 1);
						//원복
						for (int a = 0; a < i; a++) {
							for (int b = 0; b < i; b++) {
								arr[r + a][c + b] = 1;
							}
						}
						square[i]++;
					}
				}
			}
		} else {
			dfs(n + 1, cnt);
		}
	}

	public static boolean check(int r, int c, int size) {
		if (r + size > 10 || c + size > 10)
			return false;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != 1)
					return false;
			}
		}
		return true;
	}
}
