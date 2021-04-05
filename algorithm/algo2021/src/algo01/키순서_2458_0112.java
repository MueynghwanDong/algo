package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키순서_2458_0112 {

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
		arr = new int[n+1][n+1];
		brr = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s][e] = 1;
			arr[e][s] = -1;
		}
		for (int i = 1; i <= n; i++) {
			if (!brr[i]) {
				visited = new boolean[n+1];
				b = 0; // 큰거
				s = 0; // 작은거
				for (int k = 1; k < n+1; k++) {
					if (arr[i][k] != 0 && !visited[k])
						dfs(k, arr[i][k]);
					brr[i] = true;
				}
				int sum = s + b;
				if (sum == n-1)
					ans++;
			}
		}
		System.out.println(ans);
	}

	public static void dfs(int v, int num) {
//		System.out.println(v + " " + num);
		visited[v] = true;
		if (num == 1)
			b++;
		else if (num == -1)
			s++;
		for (int i = 1; i <= n; i++) {
			if (arr[v][i] == num && !visited[i]) {
				dfs(i, arr[v][i]);
			}
		}

	}

}
