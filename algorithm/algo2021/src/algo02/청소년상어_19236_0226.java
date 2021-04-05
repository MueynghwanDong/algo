package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class û�ҳ���_19236_0226 {

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

	static Node[] nodes;
	static int[][] dirs = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
			{ -1, 1 } };

	static int ans = Integer.MIN_VALUE;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[4][4];
		nodes = new Node[17]; // �����鿡 ���� �迭
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				nodes[a] = new Node(i, j, b, true);
			}
		} // �Է�
		int n = arr[0][0];
		nodes[arr[0][0]].alive = false; // ù ���� ��ġ false-> ���������
		arr[0][0] = -1;
		dfs(0, 0, nodes[n].d, n);
		System.out.println(ans);

	}

	public static void dfs(int x, int y, int dir, int sum) {
		ans = Math.max(ans, sum);
		// ������ ���� �ӽ� �迭
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
		// �迭 ����
		move(); // ����� �̵�

		// ��� �̵�
		for (int i = 1; i <= 3; i++) {
			int nx = x + (dirs[dir][0] * i);
			int ny = y + (dirs[dir][1] * i);
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || arr[nx][ny] == 0)
				continue;
			// �Դ� ���
			int t = arr[nx][ny];
			arr[x][y] = 0;
			arr[nx][ny] = -1;
			nodes[t].alive = false;
			// System.out.println(sum + " " + t);
			dfs(nx, ny, nodes[t].d, sum + t);
			// ����
			nodes[t].alive = true;
			arr[nx][ny] = t;
			arr[x][y] = -1;
		}

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

	public static void move() {
		for (int i = 1; i <= 16; i++) {
			if (nodes[i].alive == false)
				continue;
			Node cur = nodes[i]; // ���� �����
			int cx = cur.x;
			int cy = cur.y;
			int cd = cur.d;
			boolean flag = false;

			int nx = cx + dirs[cd][0];
			int ny = cy + dirs[cd][1];
			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && arr[nx][ny] != -1) {
				flag = true; // ���� ��ȯ ���� �̵� ����
				if (arr[nx][ny] == 0) { // ����Ⱑ ���� ���

					nodes[i].x = nx;
					nodes[i].y = ny;
					arr[nx][ny] = i;
					arr[cx][cy] = 0;
				} else { // ���� �����ؾ� �ϴ� ���
					int temp = arr[nx][ny];
					nodes[i].x = nx;
					nodes[i].y = ny;

					nodes[temp].x = cx;
					nodes[temp].y = cy;

					arr[nx][ny] = i;
					arr[cx][cy] = temp;

				}
			}
			if (!flag) { // ���� ��ȯ�ؾ� �ϴ� ���
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

						if (arr[nnx][nny] == 0) { // ����Ⱑ ���� ���
							nodes[i].x = nnx;
							nodes[i].y = nny;
							nodes[i].d = nd; // ** ���ϴ� ���� ���� �־��־����

							arr[nnx][nny] = i;
							arr[cx][cy] = 0;
							break;
						} else { // ���� �����ؾ� �ϴ� ���
							int temp = arr[nnx][nny];
							nodes[i].x = nnx;
							nodes[i].y = nny;
							nodes[i].d = nd;

							nodes[temp].x = cx;
							nodes[temp].y = cy;

							arr[nnx][nny] = i;
							arr[cx][cy] = temp;
							break;
						}
					}
				}
			}
		}

	}
}
