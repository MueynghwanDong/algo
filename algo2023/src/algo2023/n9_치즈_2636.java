package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n9_치즈_2636 {

	static int n, m, cnt = 0;
	static int[][] arr, dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] brr;

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
				if (arr[i][j] == 1) { // 현재  치즈의 갯수
					cnt++;
				}
			}
		}

		int pre = 0, time = 0;
		while (true) {
			pre = cnt;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 9) { // 치즈가 녹아 없어진 경우, 0으로 변경하고 cnt값 줄이기
						arr[i][j] = 0;
						cnt--;
					}
				}
			}

			if (cnt == 0) { // 치즈가 0이될대까지 반복, 0이되면 종료
				break;
			}
			brr = new boolean[n][m];
			bfs();
			time++;

		}
		System.out.println(time);
		System.out.println(pre);

	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		brr[0][0] = true;

		while (!q.isEmpty()) {
			int[] t = q.poll();

			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
					// 범위를 벗어나거나 이미 방문한 곳이라면 제외
					continue;
				if (arr[nx][ny] == 1) { // 치즈인 경우 9로 치환
					arr[nx][ny] = 9;
				} else if (arr[nx][ny] == 0) {// 치즈가 아닌 경우 방문 표시하고 큐에 넣어두기
					brr[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

}
