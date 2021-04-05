package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023_0115 {

	static int n, m;
	static int ans = 0;
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
		System.out.println(ans);

	}

	public static void dfs(int cur, int cnt) {
//		System.out.println(cur + " " + cnt);
		if (cnt == 5) {
			ans = 1;
			System.out.println(ans);
//			return;
			System.exit(0);
		}
		brr[cur] = true;
		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i);
			if (!brr[next]) {
				dfs(next, cnt + 1);
			}
		}
		brr[cur] = false;
	}

}
