package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크_5014_0811 {

	static int f;
	static int s;
	static int g;
	static int u;
	static int d;
	static boolean[] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		brr = new boolean[f + 1];

		int result = bfs();
		if (result == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(result);
		}
	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { s, 0 });
		brr[s] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int loc = tmp[0];
			int cnt = tmp[1];
//			System.out.println(loc + " " + cnt);
			if (loc == g)
				return cnt;
			// up
			int nup = loc + u;
			if (nup <= f && !brr[nup]) {
				queue.offer(new int[] { nup, cnt + 1 });
				brr[nup] = true;
			}
			// down
			int ndown = loc - d;
			if (ndown > 0 && !brr[ndown]) {
				queue.offer(new int[] { ndown, cnt + 1 });
				brr[ndown] = true;
			}

		}
		return -1;
	}

}
