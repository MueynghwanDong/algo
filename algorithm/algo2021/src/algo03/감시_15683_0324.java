package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시_15683_0324 {

	static class Node {
		int x, y, c;

		Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static int n, m, min = Integer.MAX_VALUE, cnt = 0;
	static Node[] narr = new Node[8];// cctv는 최대 8개를 넘지 않음..
	static int[][] arr;
	static int[][] dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } }; // 번호별 감시 영역
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					narr[cnt++] = new Node(i, j, arr[i][j]); // cctv를 저장
				}
			}
		}
		fun(0, arr);
		System.out.println(min);

	}

	public static void fun(int idx, int[][] arr) {
		if (idx == cnt) {
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0)
						result++;
				}
			}
			if (result < min) {
				min = result;
			}
			return;
		}
		Node cur = narr[idx]; // 현재
		for (int i = 0; i < dirs.length; i++) {
			int[][] temp = new int[n][m];
			for (int j = 0; j < n; j++) {
				temp[j] = arr[j].clone();
			}

			for (int j = 0; j < dir[cur.c].length; j++) {
				int nx = cur.x;
				int ny = cur.y;
				int nd = (dir[cur.c][j] - i + 3) % 4;
				while (true) {
					nx += dirs[nd][0];
					ny += dirs[nd][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || temp[nx][ny] == 6)
						break;
					temp[nx][ny] = 9;
				}
			}
			fun(idx + 1, temp);
		}
	}

}
