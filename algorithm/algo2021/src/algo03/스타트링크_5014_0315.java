package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크_5014_0315 {

	static int f, s, g, u, d;
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
		if(result == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(result);
		}
	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { s, 0 });
		brr[s] = true;

		while (!q.isEmpty()) {
			int[] t = q.poll();
			int loc = t[0];
			int cnt = t[1];
			if (loc == g) {
				return cnt;
			}
			int up = loc + u;
			if (up <= f && !brr[up]) {
				brr[up] = true;
				q.add(new int[] { up, cnt + 1 });
			}
			int ud = loc - d;
			if (ud > 0 && !brr[ud]) {
				brr[ud] = true;
				q.add(new int[] { ud, cnt + 1 });
			}
		}
		return -1;
	}
}
