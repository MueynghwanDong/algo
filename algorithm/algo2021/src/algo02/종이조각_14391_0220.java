package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이조각_14391_0220 {

	static int n, m;
	static int[][] arr;
	static boolean[][] brr;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		fun(0, 0);
		System.out.println(ans);

	}

	public static void fun(int x, int y) {
		if (x >= n) {
			cal();
			return;
		}
		if (y >= m) {
			fun(x + 1, 0);
			return;
		}
		brr[x][y] = true;
		fun(x, y + 1);
		brr[x][y] = false;
		fun(x, y + 1);
	}

	public static void cal() {
		int temp = 0;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			temp = 0;
			for (int j = 0; j < m; j++) {
				if (brr[i][j]) {
					temp *= 10;
					temp += arr[i][j];
				} else {
					ret += temp;
					temp = 0;
				}
			}
			ret += temp;
		}

		for (int i = 0; i < m; i++) {
			temp = 0;
			for (int j = 0; j < n; j++) {
				if (!brr[j][i]) {
					temp *= 10;
					temp += arr[j][i];
				} else {
					ret += temp;
					temp = 0;
				}
			}
			ret += temp;
		}
		ans = Math.max(ans, ret);
	}

}
