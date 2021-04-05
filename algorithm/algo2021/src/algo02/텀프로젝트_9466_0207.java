package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ерга╥на╖ф╝_9466_0207 {

	static int T, n, cnt = 0;
	static boolean[] visited;
	static boolean[] brr;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			cnt = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			brr = new boolean[n + 1];
			visited = new boolean[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				if (!brr[i]) {
					dfs(i);
				}
			}
			System.out.println(n - cnt);
		}
	}

	public static void dfs(int v) {
		// System.out.println("v: " + v +" " + visited[v]);
		if (visited[v]) {
			brr[v] = true;
			cnt++;
		} else {
			visited[v] = true;
		}
		if (!brr[arr[v]]) {
			dfs(arr[v]);
		}
		visited[v] = false;
		brr[v] = true;
	}

}
