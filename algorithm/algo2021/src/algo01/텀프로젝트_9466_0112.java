package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트_9466_0112 {

	static int arr[];
	static boolean[] brr;
	static boolean[] visited;
	static int n, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			cnt = 0;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n + 1];
			brr = new boolean[n + 1];
			visited = new boolean[n + 1];
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			for (int k = 1; k <= n; k++) {
				if (!brr[k]) {
					dfs(k);
				}
			}
			System.out.println(n - cnt);
		}
	}
	// 사이클 되는거
	//visited[1] true  3 true 2 4 7 6
	// brr[3] truee  1 true 2 true 
	public static void dfs(int v) {
		if (visited[v]) {
//			System.out.println(v + " " + arr[v]);
			brr[v] = true;
			cnt++;
		} else
			visited[v] = true;
		if (!brr[arr[v]]) {
			dfs(arr[v]);
		}
		visited[v] = false;
		brr[v] = true;

	}

}
