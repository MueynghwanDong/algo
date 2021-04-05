package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 청소년상어_19236_1022 {

	static class Node {
		int x;
		int y;
		int d;
		boolean alive;

		Node(int x, int y, int d, boolean alive) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.alive = alive;
		}
	}

	static Node[] nodes;
	static int[][] dirs = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
			{ -1, 1 } };

	static int ans = Integer.MIN_VALUE;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[4][4];
		nodes = new Node[17];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int loc = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				arr[i][j] = loc;
				nodes[loc] = new Node(i, j, d, true);
			}
		} // 입력

		nodes[arr[0][0]].alive = false;
		int n = arr[0][0];
		arr[0][0] = -1;
		dfs(0, 0, nodes[n].d, n);
		System.out.println(ans);
	}

	public static void dfs(int x, int y, int dir, int sum) {
		ans = Math.max(ans, sum);
		// 배열 복사
		int[][] copyarr = new int[4][4];
		Node[] copynode = new Node[17];
		for (int i = 1; i <= 16; i++) {
			copynode[i] = new Node(0, 0, 0, true);
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyarr[i][j] = arr[i][j];
			}
		}

		for (int i = 1; i <= 16; i++) {
			copynode[i].x = nodes[i].x;
			copynode[i].y = nodes[i].y;
			copynode[i].d = nodes[i].d;
			copynode[i].alive = nodes[i].alive;
		}
		move();
		// 상어 이동
		for (int i = 1; i <= 3; i++) { // 3번 모두 이동해서 처리
			int nx = x + dirs[dir][0] * i;
			int ny = y + dirs[dir][1] * i;
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || arr[nx][ny] == 0)
				continue;

			// 먹기
			int temp = arr[nx][ny];
			arr[x][y] = 0;
			arr[nx][ny] = -1;
			nodes[temp].alive = false;

			dfs(nx, ny, nodes[temp].d, sum + temp);
			// 원복
			nodes[temp].alive = true;
			arr[nx][ny] = temp;
			arr[x][y] = -1;

		}
		// 배열 복사
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = copyarr[i][j];
			}
		}
		for (int i = 1; i <= 16; i++) {
			nodes[i].x = copynode[i].x;
			nodes[i].y = copynode[i].y;
			nodes[i].d = copynode[i].d;
			nodes[i].alive = copynode[i].alive;
		}
	}

	public static void dead_fish_change(int num, int x, int y, int nx, int ny, int dir) {
		// x,y는 원래위치 nx,ny는 움직이고 바뀐 위치
		nodes[num].x = nx;
		nodes[num].y = ny;
		nodes[num].d = dir;
		arr[nx][ny] = num;
		arr[x][y] = 0;
	}

	public static void alive_fish_change(int num, int x, int y, int nx, int ny, int dir) {
		// x,y는 원래위치 nx,ny는 바뀐위치
		int other_fish = arr[nx][ny];

		nodes[num].x = nx;
		nodes[num].y = ny;
		nodes[num].d = dir;

		nodes[other_fish].x = x;
		nodes[other_fish].y = y;

		arr[x][y] = other_fish;
		arr[nx][ny] = num;
	}

	public static void move() {
		for (int i = 1; i < 17; i++) {
			if (nodes[i].alive == false)
				continue;

			Node current = nodes[i];
			int cd = current.d;
			boolean flag = false;

			int nx = current.x + dirs[cd][0];
			int ny = current.y + dirs[cd][1];
			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && arr[nx][ny] != -1) {
				flag = true;
				if (arr[nx][ny] == 0) {
					dead_fish_change(i, current.x, current.y, nx, ny, cd);

					// nodes[i].x = nx;
					// nodes[i].y = ny;
					// nodes[i].d = cd;
					// arr[nx][ny] = i;
					// arr[current.x][current.y] = 0;
				} else {
					alive_fish_change(i, current.x, current.y, nx, ny, cd);

					// int ofish = arr[nx][ny];
					//
					// nodes[i].x = nx;
					// nodes[i].y = ny;
					// nodes[i].d = cd;
					//
					// nodes[ofish].x = current.x;
					// nodes[ofish].y = current.y;
					//
					// arr[current.x][current.y] = ofish;
					// arr[nx][ny] = i;
				}
			}
			if (!flag) {
				int ndir = cd + 1;
				if (ndir == 9)
					ndir = 1;
				while (ndir != cd) {
					int nnx = current.x + dirs[ndir][0];
					int nny = current.y + dirs[ndir][1];
					if (nnx < 0 || nny < 0 || nnx >= 4 || nny >= 4 || arr[nnx][nny] == -1) {
						ndir++;
						if (ndir == 9)
							ndir = 1;
						continue;
					} else {
						if (arr[nnx][nny] == 0) {
							dead_fish_change(i, current.x, current.y, nnx, nny, ndir);
							// nodes[i].x = nnx;
							// nodes[i].y = nny;
							// nodes[i].d = ndir;
							// arr[nnx][nny] = i;
							// arr[current.x][current.y] = 0;

							break;
						} else {
							alive_fish_change(i, current.x, current.y, nnx, nny, ndir);

							// int ofish = arr[nnx][nny];
							//
							// nodes[i].x = nnx;
							// nodes[i].y = nny;
							// nodes[i].d = ndir;
							//
							// nodes[ofish].x = current.x;
							// nodes[ofish].y = current.y;
							//
							// arr[current.x][current.y] = ofish;
							// arr[nnx][nny] = i;

							break;
						}
					}
				}
			}
		}

	}

}
