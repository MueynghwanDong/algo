package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502_1224 {

	static int n;
	static int m;
	static int[][] arr;
	static int max = 0;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

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
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(1);
					arr[i][j] = 0;
				}
			}
		}
		System.out.println(max);

	}

	public static void wall(int cnt) {
		if(cnt ==3) { 
			int count = transaction();
			if(max < count) max = count;
			return;
		}else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j] == 0) {
						arr[i][j] = 1;
						wall(cnt+1);
						arr[i][j] = 0;
					}
				}
			}
		}		
	}

	public static int transaction() { // 바이러스 전파
		Queue<int[]> q = new LinkedList<int[]>();

		int re[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			re[i] = arr[i].clone();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (re[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] v = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = v[0] + dirs[i][0];
				int ny = v[1] + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (re[nx][ny] == 0) {
					re[nx][ny] = 2;
					q.add(new int[] { nx, ny });
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (re[i][j] == 0)
					count++;
			}
		}
		return count;
	}
}
