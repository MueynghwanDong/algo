package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class »∏¿ÂªÃ±‚_2660_0924_bfs {

	static int[][] arr;
	static int n;
	static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		depth = new int[n + 1];

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (s == -1 && e == -1)
				break;
			arr[s][e] = 1;
			arr[e][s] = 1;
		}

		int min = 100;
		for (int i = 1; i <= n; i++) {
			bfs(i);
			if (min > depth[i])
				min = depth[i];
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (depth[i] == min)
				list.add(i);
		}
		
		System.out.println(min + " " + list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	public static void bfs(int start) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { start, 0 });
		boolean[] brr = new boolean[n + 1];
		brr[start] = true;
		int max = 0;

		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cur = t[0];
			int d = t[1];
			for (int i = 1; i <= n; i++) {
				if (brr[i] || arr[cur][i] == 0)
					continue;
				q.offer(new int[] { i, d + 1 });
				if (max < d + 1)
					max = d + 1;
				brr[i] = true;
			}
			depth[start] = max;
		}
	}
}
