package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Å°¼ø¼­_2458_0207 {

	static int n, m;
	static int[][] arr;
	static boolean[] brr;
	static boolean[] visited;
	static int b, s;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		brr = new boolean[n + 1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = -1;
		}
		for (int i = 1; i <= n; i++) {
			if (!brr[i]) {
				visited = new boolean[n + 1];
				b = 0;
				s = 0;
				for (int j = 1; j <= n; j++) {
					if (arr[i][j] != 0 && !visited[j])
						dfs(j, arr[i][j]);
					brr[i] = true;
				}
				int sum = b + s;
				if (sum == n - 1)
					ans++;
			}
		}
		System.out.println(ans);
	}

	public static void dfs(int index, int value) {
		visited[index] = true;
		if (value == 1)
			b++;
		else if (value == -1)
			s++;
		for (int i = 1; i <= n; i++) {
			if (arr[index][i] == value && !visited[i])
				dfs(i, arr[index][i]);
		}

	}

}
