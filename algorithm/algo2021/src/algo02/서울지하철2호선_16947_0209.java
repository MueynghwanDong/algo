package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 서울지하철2호선_16947_0209 {

	static int n;
	static int[] arr;
	static ArrayList<Integer> list[];
	static boolean[] brr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		brr = new boolean[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			boolean check = dfs(i, i, i);
			if (check)
				break;
			else
				brr = new boolean[n + 1];
		}
		for (int i = 1; i <= n; i++) {
			if (!brr[i]) {
				int cnt = bfs(i);
				arr[i] = cnt;
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int bfs(int v) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		queue.add(new int[] { v, 0 });
		visited[v] = true;
		while (!queue.isEmpty()) {
			int[] tp = queue.poll();
			int vv = tp[0];
			int count = tp[1];
			if (brr[vv])
				return count;
			for (int i = 0; i < list[vv].size(); i++) {
				int e = list[vv].get(i);
				if (!visited[e]) {
					visited[e] = true;
					queue.add(new int[] { e, count + 1 });
				}
			}

		}
		return 0;
	}

	public static boolean dfs(int cur, int before, int start) {
		brr[cur] = true;
		for (int next : list[cur]) {
			if (!brr[next]) {
				if (dfs(next, cur, start))
					return true;
			} else if (next != before && next == start) {
				return true;
			}
		}
		brr[cur] = false;
		return false;
	}
}
