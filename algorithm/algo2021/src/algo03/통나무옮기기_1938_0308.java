package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 통나무옮기기_1938_0308 {

	static class Node {
		int r, c, p, d;

		Node(int r, int c, int p, int d) {
			this.r = r;
			this.c = c;
			this.p = p;
			this.d = d;
		}
	}

	static int n, ans = 0;
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1, }, { -1, 0 }, { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };
	static char[][] arr;
	static boolean[][][] check;
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		check = new boolean[n][n][2];
		int sr = 0, sc = 0, d = 0;
		int flag = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'B') {
					if (flag == 1) {
						sr = i;
						sc = j;
						if (j > 0 && arr[i][j - 1] == 'B')
							d = 0;
						else
							d = 1;
						flag++;
					} else
						flag++;
				}
			}
		}
		bfs(sr, sc, d);
		System.out.println(ans);
	}

	public static boolean checking(int r, int c, int d) {

		if (d == 0) {
			if (c - 1 >= 0 && c + 1 < n && arr[r][c] == 'E' && arr[r][c + 1] == 'E' && arr[r][c - 1] == 'E')
				return true;
		} else if (d == 1) {
			if (r - 1 >= 0 && r + 1 < n && arr[r - 1][c] == 'E' && arr[r + 1][c] == 'E' && arr[r][c] == 'E')
				return true;
		}
		return false;
	}

	public static void bfs(int sr, int sc, int sd) {

		q.add(new Node(sr, sc, 0, sd));
		check[sr][sc][sd] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int p = cur.p;
			int d = cur.d;

			boolean isDes = checking(r, c, d);
			if (isDes) {
				ans = p;
				break;
			}
			boolean isRotate = true; // 회전 가능한지 확인할 변수
			int nd = (d + 1) % 2;
			if (!check[r][c][nd]) {
				for (int i = 0; i < dirs.length; i++) {
					int nr = r + dirs[i][0];
					int nc = c + dirs[i][1];
					if (nr < 0 || nc < 0 || nr >= n || nc >= n || arr[nr][nc] == '1') {
						isRotate = false; // 회전 불가
						break;
					}
				}
			}
			if (isRotate && !check[r][c][nd]) { // 회전 가능한 경우
				check[r][c][nd] = true;
				q.add(new Node(r, c, p + 1, nd));
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dirs[i][0];
				int nc = c + dirs[i][1];
				if (nr < 0 || nc < 0 || nr >= n || nc >= n || arr[nr][nc] == '1' || check[nr][nc][d])
					continue;

				if (d == 0) { // 좌우 이동
					if (nc - 1 >= 0 && nc + 1 < n && arr[nr][nc + 1] != '1' && arr[nr][nc - 1] != '1') {
						check[nr][nc][d] = true;
						q.add(new Node(nr, nc, p + 1, d));
					}
				} else if (d == 1) { // 상하이동
					if (nr - 1 >= 0 && nr + 1 < n && arr[nr + 1][nc] != '1' && arr[nr - 1][nc] != '1') {
						check[nr][nc][d] = true;
						q.add(new Node(nr, nc, p + 1, d));
					}
				}
			}

		}
	}

}
