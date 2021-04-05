package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크_5014_0107 {

	static int f, s, g, u, d;
	static boolean brr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		f = Integer.parseInt(st.nextToken()); // 총 높이
		s = Integer.parseInt(st.nextToken()); // 강호 위치
		g = Integer.parseInt(st.nextToken()); // 스타트링크 위치
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		brr = new boolean[f + 1];
		
		int result = bfs();
		if( result == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(result);
		}

	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { s, 0 });
		brr[s] = true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int loc = temp[0];
			int cnt = temp[1];
			if (loc == g)
				return cnt;
			int nu = loc + u;
			if (nu <= f && !brr[nu]) {
				queue.add(new int[] { nu, cnt + 1 });
				brr[nu] = true;
			}
			int nd = loc - d;
			if (nd > 0 && !brr[nd]) {
				queue.add(new int[] { nd, cnt + 1 });
				brr[nd] = true;
			}
		}
		return -1;
	}

}
