package algo0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 중량제한_0701 {

	static int n;
	static ArrayList<int[]> arrlist[];
	static int high;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arrlist = new ArrayList[n + 1];
		for (int i = 0; i < arrlist.length; i++) {
			arrlist[i] = new ArrayList<>();
		}
		high = 0;
		max = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (high < weight)
				high = weight;
			arrlist[from].add(new int[] { to, weight });
			arrlist[to].add(new int[] { from, weight });
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		findmax(start, end);
		System.out.println(max);
	}

	public static void findmax(int s, int e) {
		int l = 1;
		int h = high;
		Queue<Integer> queue = new LinkedList<>();
		boolean brr[] = new boolean[n + 1];
		while (l <= h) {
			int mid = (l + h) / 2;
			queue.offer(s);
			brr[s] = true;
			boolean check = bfs(queue, brr, mid, e);
			if (check) {
				if (max < mid)
					max = mid;
				l = mid + 1;
			} else {
				h = mid - 1;
			}
			queue.clear();
			Arrays.fill(brr, false);
		}

	}

	public static boolean bfs(Queue<Integer> queue, boolean[] brr, int mid, int end) {

		while (!queue.isEmpty()) {
			int q = queue.poll();

			for (int[] v : arrlist[q]) {
				if (v[1] >= mid) {
					if (q == end)
						return true;
					if (!brr[v[0]]) {
						brr[v[0]] = true;
						queue.offer(v[0]);
					}
				}
			}
		}
		return false;
	}
}
