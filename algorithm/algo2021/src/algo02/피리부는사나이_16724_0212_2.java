package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피리부는사나이_16724_0212_2 {

	static int n, m, ans = 0;
	static char[][] arr;
	static int[] arr2;
	static boolean[] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	// UDRL
	static int finish;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		arr2 = new int[n * m];
		brr = new boolean[n * m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				int d = 0;
				if (arr[i][j] == 'U')
					d = 0;
				else if (arr[i][j] == 'D')
					d = 1;
				else if (arr[i][j] == 'R')
					d = 2;
				else if (arr[i][j] == 'L')
					d = 3;

				int nx = i + dirs[d][0];
				int ny = j + dirs[d][1];
				arr2[i * m + j] = nx * m + ny;

			}
		}

		for (int i = 0; i < n * m; i++) {
			if (!brr[i]) {
				brr[i] = true;
				finish = i;
				dfs(i);
			}
		}

		System.out.println(ans);
	}

	public static boolean dfs(int v) {
		if (!brr[arr2[v]]) {
			brr[arr2[v]] = true;
			boolean c = dfs(arr2[v]);
			if (c)
				return true;
			brr[arr2[v]] = false;
		}
		if (finish == arr2[v]) {
			ans++;
			return true;
		}
		return false;

	}
}
