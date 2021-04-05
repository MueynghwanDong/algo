package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú2_12851_0304 {

	static int n, m, min = Integer.MAX_VALUE, cnt = 0;
	static int[] arr = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if (n >= m) {
			System.out.println(n - m);
			System.out.println(1);
			return;
		}
		bfs();
		System.out.println(min);
		System.out.println(cnt);
	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		arr[n] = 1;
		while (!q.isEmpty()) {
			int loc = q.poll();
			if (min < arr[loc])
				return;

			int[] dirs = { loc - 1, loc + 1, loc * 2 };
			for (int i = 0; i < dirs.length; i++) {
				int nx = dirs[i];
				if (nx == m) {
					min = arr[loc];
					cnt++;
				}
				if (nx < 0 || nx > 100000)
					continue;
				
				if (arr[nx] == 0 || arr[nx] == arr[loc] + 1) {
					q.add(nx);
					arr[nx] = arr[loc] + 1;
				}
			}
//			for (int i = 0; i < m; i++) {
//				System.out.print(arr[i]+" ");
//			}
//			System.out.println();

		}

	}

}
