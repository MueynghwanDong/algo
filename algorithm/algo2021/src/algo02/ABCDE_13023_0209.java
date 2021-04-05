package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023_0209 {

	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] brr;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		brr = new boolean[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		ans = 0;
		for (int i = 0; i < n; i++) {
			dfs(i, 1);
		}
		System.out.println(ans);

	}

	public static void dfs(int v, int cnt) {
		// System.out.println("v: " + v);
		if (cnt == 5) {
			ans = 1;
			System.out.println(ans);
			System.exit(0);
		}
		brr[v] = true;
		for (int i = 0; i < list[v].size(); i++) {
			int nx = list[v].get(i);
			if (!brr[nx]) {
				dfs(nx, cnt + 1);
			}
		}
		brr[v] = false;
	}
}
