package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú3_13549_0910 {

	static int n;
	static int m;
	static int[] arr = new int[100001];
	static int min = Integer.MAX_VALUE;
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		if (n >= m) {
			System.out.println((n - m));
			return;
		}

		bfs();

		System.out.println(min);

	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { n, 0 });
		arr[n] = 0;
		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			int loc = temp[0];
			int cnt = temp[1];
			// System.out.println(loc + " " + arr[loc] + " "+ cnt);
			if (min < cnt)
				return;
			if (loc == m) {
				if (min > cnt)
					min = cnt;
			}
			int dir[] = { loc * 2, loc - 1, loc + 1 };
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i];

				if (nx < 0 || nx > 100000)
					continue;

				if (arr[nx] == 0 || arr[nx] == arr[loc] + 1) {
					arr[nx] = arr[loc] + 1;
					if (i == 0) {
						queue.add(new int[] { nx, cnt });
					} else {
						queue.add(new int[] { nx, cnt + 1 });

					}
				}
			}
		}
	}
}
