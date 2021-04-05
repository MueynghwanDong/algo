package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 두동전_16197_0119 {

	static int n, m;
	static char arr[][];
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'o') {
					queue.add(new int[] { i, j, 0 });
				}
			}
		}
		bfs();
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] n1 = queue.poll();
			int[] n2 = queue.poll();
			int cnt = n1[2];
			if (cnt >= 10) {
				System.out.println(-1);
				return;
			}
			// 두 동전을 동시에 체크해야하는 것이 핵심!
			for (int i = 0; i < dirs.length; i++) {
				boolean d1 = false;
				boolean d2 = false;
				int r1 = n1[0] + dirs[i][0];
				int c1 = n1[1] + dirs[i][1];
				int r2 = n2[0] + dirs[i][0];
				int c2 = n2[1] + dirs[i][1];
				if (r1 < 0 || c1 < 0 || r1 >= n || c1 >= m) {
					d1 = true;
				}
				if (r2 < 0 || c2 < 0 || r2 >= n || c2 >= m) {
					d2 = true;
				}
				// 둘다 나가면 X
				if (d1 && d2)
					continue;

				if (d1 || d2) {
					System.out.println(cnt + 1);
					return;
				}
				// 둘다 벽이면 건너뛰기
				if (arr[r1][c1] == '#' && arr[r2][c2] == '#')
					continue;
				// 하나만 벽인 경우
				if (arr[r1][c1] == '#') {
					r1 = n1[0];
					c1 = n1[1];
				}
				if (arr[r2][c2] == '#') {
					r2 = n2[0];
					c2 = n2[1];
				}
				queue.add(new int[] { r1, c1, cnt + 1 });
				queue.add(new int[] { r2, c2, cnt + 1 });
			}
		}
		System.out.println(-1);
	}
}
