package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시_15683_0907 {

	static int n;
	static int m;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;
	
	static Node[] nodes = new Node[8]; // cctv를 담아둘 배열
	
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
				if (arr[i][j] >= 1 && arr[i][j] <= 5) { // cctv 노드 배열에 넣어주기 / 리스트에 넣어도 됨..
					nodes[cnt++] = new Node(i, j, arr[i][j]);
				}
			}
		}
		solve(0,arr);
		System.out.println(min);
	}

	public static void solve(int idx, int[][] arr) { // idx는 cctv 인덱스 번호
		if (idx == cnt) { // 종료조건, 0 개수 파악
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
		Node node = nodes[idx]; // cctv 위치, 숫자
		for (int i = 0; i < 4; i++) { // 4방향 다 돌리기
			int map[][] = copy(arr);
			for (int j = 0; j < dir[node.c].length; j++) { // 숫자에 따라 위치 조정하기 
				int nx = node.x;
				int ny = node.y;
				int nd = (dir[node.c][j] - i + 3) % 4; // 이부분이 핵심
				// node.c -> cctv 숫자, dir[node.c] -> 숫자에 따른 방향
				while (true) { // 범위 밖이나 벽을 만날때 까지 9로 표시
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

	public static int[][] copy(int arr[][]) {  // 배열 복사
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
