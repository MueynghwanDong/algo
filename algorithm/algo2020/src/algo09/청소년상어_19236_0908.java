package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class û�ҳ���_19236_0908 {

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
		} // �Է�
		nodes[arr[0][0]].alive = false; // ���� ���� �Ǵ�
		int n = arr[0][0]; 
		arr[0][0] = -1;
		dfs(0, 0, nodes[n].d, n);
		
		System.out.println(ans);
	}

	public static void move() {
		for (int i = 1; i <= 16; i++) {
			if (nodes[i].alive == false)
				continue; // ��Ƹ��� �����
			
			Node cur = nodes[i]; // ������ �����
			int cd = cur.d;
			boolean flag = false;

			int nx = cur.x + dirs[cd][0];
			int ny = cur.y + dirs[cd][1];

			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && arr[nx][ny] != -1) {
				// ������ �� �ִ� ���
				flag = true;
				if (arr[nx][ny] == 0) { // ��ĭ 
					dead_fish_change(i, cur.x, cur.y, nx, ny, cd);

				} else {
					alive_fish_change(i, cur.x, cur.y, nx, ny, cd);

				}
			}

			if (!flag) { // �̵����ϴ� ���
				int ndir = cd + 1;
				if (ndir == 9)
					ndir = 1;
				while (ndir != cd) {
					int tx = cur.x + dirs[ndir][0];
					int ty = cur.y + dirs[ndir][1];
					if (tx < 0 || ty < 0 || tx >= 4 || ty >= 4 || arr[tx][ty] == -1) {
						ndir++;
						if (ndir == 9)
							ndir = 1;
						continue;
					} else {
						if (arr[tx][ty] == 0) {
							dead_fish_change(i, cur.x, cur.y, tx, ty, ndir);
							break;
						} else {
							alive_fish_change(i, cur.x, cur.y, tx, ty, ndir);
							break;
						}
					}
				}
			}
		}
	}

	public static void dead_fish_change(int num, int x, int y, int nx, int ny, int dir) {
		// x,y�� ������ġ nx,ny�� �����̰� �ٲ� ��ġ
		nodes[num].x = nx;
		nodes[num].y = ny;
		nodes[num].d = dir;
		arr[nx][ny] = num;
		arr[x][y] = 0;
	}

	public static void alive_fish_change(int num, int x, int y, int nx, int ny, int dir) {
		// x,y�� ������ġ nx,ny�� �ٲ���ġ
		int other_fish = arr[nx][ny];

		nodes[num].x = nx;
		nodes[num].y = ny;
		nodes[num].d = dir;

		nodes[other_fish].x = x;
		nodes[other_fish].y = y;

		arr[x][y] = other_fish;
		arr[nx][ny] = num;
	}

	public static void dfs(int x, int y, int dir, int sum) {
		ans = Math.max(sum, ans);
		
		int[][] copyarr = new int[4][4];
		Node[] copynode = new Node[17];
		for(int i=1; i<=16; i++) {
			copynode[i] = new Node(0,0,0,true);
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
		// ����� �̵�
		move();
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		// ��� �̵�
		// System.out.println(sum + " " + dir);
		for (int i = 1; i <= 3; i++) { // 3�� ��� �̵��ؼ� ó��
			int nx = x + dirs[dir][0] * i;
			int ny = y + dirs[dir][1] * i;
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || arr[nx][ny] == 0)
				continue;

			// �Ա�
			int temp = arr[nx][ny];
			arr[x][y] = 0;
			arr[nx][ny] = -1;
			nodes[temp].alive = false;

			dfs(nx, ny, nodes[temp].d, sum + temp);
			// ����
			nodes[temp].alive = true;
			arr[nx][ny] = temp;
			arr[x][y] = -1;

		}
		// �迭 ����
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
}
