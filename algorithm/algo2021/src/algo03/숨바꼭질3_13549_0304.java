package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú3_13549_0304 {

	static int n, m, min = Integer.MAX_VALUE;
	static int[] arr = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if (n >= m) {
			System.out.println(n - m);
			return;
		}
		bfs();
		System.out.println(min);
	}

	public static void bfs() {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { n, 0 });
		arr[n] = 0;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int loc = t[0];
			int count = t[1];

			if (min < count)
				return;
			if (loc == m) {
				if (min > count)
					min = count;
			}

			int[] dirs = { loc * 2, loc - 1, loc + 1 };
			for (int i = 0; i < dirs.length; i++) {
				int nx = dirs[i];
				if (nx < 0 || nx > 100000)
					continue;

				if (arr[nx] == 0 || arr[nx] == arr[loc] + 1) {
					arr[nx] = arr[loc] + 1;
					if (i == 0) {
						q.add(new int[] { nx, count });
					} else {
						q.add(new int[] { nx, count + 1 });
					}
				}
			}

		}

	}

}
