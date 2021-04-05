package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_15683_0907 {

	static int n;
	static int m;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;
	
	static Node[] nodes = new Node[8]; // cctv�� ��Ƶ� �迭
	
	static int[][] dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };
	
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
				if (arr[i][j] >= 1 && arr[i][j] <= 5) { // cctv ��� �迭�� �־��ֱ� / ����Ʈ�� �־ ��..
					nodes[cnt++] = new Node(i, j, arr[i][j]);
				}
			}
		}
		solve(0,arr);
		System.out.println(min);
	}

	public static void solve(int idx, int[][] arr) { // idx�� cctv �ε��� ��ȣ
		if (idx == cnt) { // ��������, 0 ���� �ľ�
			int res = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0)
						res++;
				}
			}
			if(min > res) min = res;
			return;
		}
		Node node = nodes[idx]; // cctv ��ġ, ����
		for (int i = 0; i < 4; i++) { // 4���� �� ������
			int map[][] = copy(arr);
			for (int j = 0; j < dir[node.c].length; j++) { // ���ڿ� ���� ��ġ �����ϱ� 
				int nx = node.x;
				int ny = node.y;
				int nd = (dir[node.c][j] - i + 3) % 4; // �̺κ��� �ٽ�
				// node.c -> cctv ����, dir[node.c] -> ���ڿ� ���� ����
				while (true) { // ���� ���̳� ���� ������ ���� 9�� ǥ��
					nx += dirs[nd][0];
					ny += dirs[nd][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 6)
						break;
					map[nx][ny] = 9;
				}
			}
			solve(idx+1, map);
		}
	}

	public static int[][] copy(int arr[][]) {  // �迭 ����
		int result[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}

}

class Node {
	int x;
	int y;
	int c;

	Node(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}
