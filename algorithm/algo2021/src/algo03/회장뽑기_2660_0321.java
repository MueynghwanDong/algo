package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class »∏¿ÂªÃ±‚_2660_0321 {

	static int[] depth;
	static boolean[] brr;
	static int[][] arr;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		depth = new int[n + 1];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (s == -1 && e == -1) {
				break;
			}
			arr[s][e] = 1;
			arr[e][s] = 1;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			bfs(i);
			if (depth[i] < min)
				min = depth[i];
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (depth[i] == min) {
				list.add(i);
			}
		}
		System.out.println(min +" " +list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}

	public static void bfs(int s) {
		Queue<int[]> q = new LinkedList<>();
		brr = new boolean[n + 1];
		brr[s] = true;
		q.add(new int[] { s, 0 });
		int max = 0;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cur = t[0];
			int cnt = t[1];
			for (int i = 1; i <= n; i++) {
				if (brr[i] || arr[cur][i] == 0)
					continue;
				q.add(new int[] { i, cnt + 1 });
				brr[i] = true;
				if (max < cnt + 1)
					max = cnt + 1;
			}
		}
		depth[s] = max;
	}
}
