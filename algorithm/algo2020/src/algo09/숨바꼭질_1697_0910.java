package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú_1697_0910 {

	static int n;
	static int m;
	static int[] arr = new int[100001];
	static boolean[] brr = new boolean[100001];
	// static int min = Integer.MAX_VALUE;
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		bfs();

	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { n, 0 });
		brr[n] = true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int loc = temp[0];
			int cnt = temp[1];
			if (loc == m) {
				System.out.println(cnt);
				break;
				// return;
			}
			int dir[] = { loc - 1, loc + 1, loc * 2 };
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i];
				if (nx < 0 || nx > 100000)
					continue;
				if (!brr[nx]) {
					queue.add(new int[] { nx, cnt + 1 });
					brr[nx] = true;

				}
			}
		}

	}

}
