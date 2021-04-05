package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¼ÒÇ³_2026_0121 {

	static int k, n, f;
	static int[][] arr;
	static int[] student;
	static boolean[] brr;
	static boolean done = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		student = new int[n + 1];
		brr = new boolean[n + 1];
		arr = new int[n + 1][n + 1];
		for (int i = 0; i < f; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
			student[a]++;
			student[b]++;
		}

		for (int i = 1; i <= n; i++) {			
			if (student[i] < k - 1)
				continue;
			if (done)
				break;
			brr[i] = true;
			dfs(i, 1);
			brr[i] = false;
		}
		if (!done)
			System.out.println(-1);
	}

	public static void dfs(int cur, int d) {
		
		if (done)
			return;
		if (d == k) {
			for (int i = 1; i <= n; i++) {
				if (brr[i]) {
					System.out.println(i);
				}
			}
			done = true;
			return;
		}
		for (int i = cur + 1; i <= n; i++) {
			if (arr[cur][i] == 1 && isCheck(i)) {
				brr[i] = true;
				dfs(i, d + 1);
				brr[i] = false;
			}
		}
	}

	public static boolean isCheck(int temp) {
		for (int i = 1; i <= n; i++) {
			if (brr[i] && arr[temp][i] != 1)
				return false;
		}
		return true;
	}
}
