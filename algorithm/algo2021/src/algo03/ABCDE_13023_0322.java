package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023_0322 {

	static int n, m, ans;
	static ArrayList<Integer>[] list;
	static boolean[] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		brr = new boolean[n];
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < n; i++) {
			dfs(i, 1);
		}
		System.out.println(0);
	}

	public static void dfs(int v, int cnt) {
		if (cnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		brr[v] = true;
		for (int i = 0; i < list[v].size(); i++) {
			int cur = list[v].get(i);
			if (!brr[cur]) {
				dfs(cur, cnt + 1);
			}
		}
		brr[v] = false;
	}
}
