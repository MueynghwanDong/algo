package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2023.01.01
 * 벽의 개수 3개
 * 0 빈칸 1 벽 2 바이러스 
 */
public class n1_연구소_14502 {

	static int n, m, ans = 0;
	static int[][] arr, dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

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
		// 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(1);// 벽 세우기
					arr[i][j] = 0;
				}
			}
		}
		System.out.println(ans);

	}

	public static int calc() {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		} // 새로운 배열에 기존 배열 복사

		Queue<int[]> q = new LinkedList<>(); // 바이러스 위치를 넣을 큐
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] t = q.poll(); // 큐에서 하나 꺼내기
			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || temp[nx][ny] != 0)
					continue;
				// 0이아닌 경우 건너뛰기(벽이거나 바이러스인경우) - 기존 바이러스는 이미 큐에 존재!
				temp[nx][ny] = 2;
				q.add(new int[] { nx, ny });
			}
		}
		// 안전영역 구하기
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					result++;
				}
			}
		}

		return result;
	}

	public static void wall(int w) {

		if (w == 3) { // 세울 수 있는 벽의 갯수 완료
			int result = calc(); // 안전영역 수 구하기
			if (ans < result)
				ans = result;
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(w + 1); 
					arr[i][j] = 0;
				}
			}
		}
	}

}
