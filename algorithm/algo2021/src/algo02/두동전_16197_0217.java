package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 두동전_16197_0217 {
	static int n, m;
	static char[][] arr;
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
				if (d1 && d2) // 둘다 떠러진 경우
					continue;
				if (d1 || d2) {// 둘중하나만 떨어진 경우
					System.out.println(cnt + 1);
					return;
				}
				if (arr[r1][c1] == '#' && arr[r2][c2] == '#')
					continue;
				if (arr[r1][c1] == '#') { // 원상태로 이동
					r1 = n1[0];
					c1 = n1[1];
				}
				if (arr[r2][c2] == '#') {// 원상태로 이동
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
