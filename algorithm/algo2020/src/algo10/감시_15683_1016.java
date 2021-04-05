package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_15683_1016 {

	static class Node {
		int x;
		int y;
		int c;

		Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static int r;
	static int c;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;

	static Node[] nodes = new Node[8]; // �ִ� 8���� ���� ����
	static int cnt = 0;
	static int[][] dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } }; // c���� ���� dirs�� ����, �̺κ� �ٽ�!!
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					nodes[cnt++] = new Node(i, j, arr[i][j]); // ��峪 ����Ʈ�� �־ ���ʴ�� �����ϱ�
				}
			}
		}
		solve(0, arr);
		System.out.println(min);

	}

	public static void solve(int idx, int[][] arr) {

		if (idx == cnt) { // ���� ����..., ��忡 �� ���� �� �����ϰ� ���� 
			// 0�ΰ� ���� ī��Ʈ�ϱ�
			int result = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == 0)
						result++;
				}
			}
			if (min > result)
				min = result;
			return;
		}

		Node node = nodes[idx]; // idx�� ���, idx�� �����ϸ鼭 node ���� ���� ����!
		for (int i = 0; i < dirs.length; i++) { // 4���⿡ ���� ����
			int map[][] = copy(arr); // �迭 ����
			for (int j = 0; j < dir[node.c].length; j++) { // ����� ��ȣ�� ���� ����
				int nx = node.x;
				int ny = node.y;
				int nd = (dir[node.c][j] - i + 3) % 4; // �̺κ��� �ٽ�!!!
				while (true) {
					nx += dirs[nd][0];
					ny += dirs[nd][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == 6)
						break; // ���̳� ������ ����� break
					map[nx][ny] = 9; // #��� 9��..
				}
			}
			solve(idx + 1, map);
		}

	}

	public static int[][] copy(int arr[][]) { // �迭 ����
		int map[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = arr[i][j];
			}
		}
		return map;
	}

}
