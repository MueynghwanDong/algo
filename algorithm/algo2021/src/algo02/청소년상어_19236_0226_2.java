package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 청소년상어_19236_0226_2 {

	static class Node {
		int x, y, d;
		boolean alive;

		Node(int x, int y, int d, boolean alive) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.alive = alive;
		}
	}

	static int[][] arr = new int[4][4];
	static Node[] nodes = new Node[17];
	static int[][] dirs = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
			{ -1, 1 } };
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				nodes[a] = new Node(i, j, b, true);
			}
		}
		int n = arr[0][0];
		nodes[n].alive = false;
		arr[0][0] = -1;
		dfs(0, 0, nodes[n].d, n);

		System.out.println(ans);
	}

	public static void dfs(int x, int y, int dir, int sum) {
		if (ans < sum)
			ans = sum;
		int[][] copy = new int[4][4];
		Node[] cnode = new Node[17];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		for (int i = 1; i < 17; i++) {
			cnode[i] = new Node(0, 0, 0, true);
			cnode[i].x = nodes[i].x;
			cnode[i].y = nodes[i].y;
			cnode[i].d = nodes[i].d;
			cnode[i].alive = nodes[i].alive;
		}
		move();
		// 상어이동
		for (int i = 1; i <= 3; i++) {
			int nx = x + (dirs[dir][0] * i);
			int ny = y + (dirs[dir][1] * i);
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || arr[nx][ny] == 0)
				continue;

			int num = arr[nx][ny];
			arr[nx][ny] = -1;
			arr[x][y] = 0;
			nodes[num].alive = false;
			dfs(nx, ny, nodes[num].d, sum + num);

			nodes[num].alive = true;
			arr[x][y] = -1;
			arr[nx][ny] = num;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = copy[i][j];
			}
		}
		for (int i = 1; i < 17; i++) {
			nodes[i].x = cnode[i].x;
			nodes[i].y = cnode[i].y;
			nodes[i].d = cnode[i].d;
			nodes[i].alive = cnode[i].alive;
		}

	}

	public static void move() {
		for (int i = 1; i <= 16; i++) {
			Node cur = nodes[i];
			if (!cur.alive)
				continue;
			int cx = cur.x;
			int cy = cur.y;
			int cd = cur.d;
			boolean check = false;

			int nx = cx + dirs[cd][0];
			int ny = cy + dirs[cd][1];
			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && arr[nx][ny] != -1) {
				check = true;
				if (arr[nx][ny] == 0) {
					nodes[i].x = nx;
					nodes[i].y = ny;

					arr[nx][ny] = i;
					arr[cx][cy] = 0;
				} else {
					int num = arr[nx][ny];
					nodes[i].x = nx;
					nodes[i].y = ny;
					nodes[num].x = cx;
					nodes[num].y = cy;
					arr[nx][ny] = i;
					arr[cx][cy] = num;
				}

			}
			if (!check) {
				int nd = cd + 1;
				if (nd > 8)
					nd = 1;
				while (nd != cd) {
					int nnx = cx + dirs[nd][0];
					int nny = cy + dirs[nd][1];
					if (nnx < 0 || nny < 0 || nnx >= 4 || nny >= 4 || arr[nnx][nny] == -1) {
						nd = nd + 1;
						if (nd > 8)
							nd = 1;
						continue;
					} else {
						if (arr[nnx][nny] == 0) {
							nodes[i].x = nnx;
							nodes[i].y = nny;
							nodes[i].d = nd;

							arr[nnx][nny] = i;
							arr[cx][cy] = 0;
							break;
						} else {
							int num = arr[nnx][nny];
							nodes[i].x = nnx;
							nodes[i].y = nny;
							nodes[i].d = nd;
							nodes[num].x = cx;
							nodes[num].y = cy;
							arr[nnx][nny] = i;
							arr[cx][cy] = num;
							break;
						}

					}
				}
			}
		}

	}
}
