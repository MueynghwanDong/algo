package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144_0329 {

	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int n, m, t, ans = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < t; i++) {
			fun();
			gongi();
		}

		// 결과 산정
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != -1) {
					ans += arr[i][j];
				}
			}
		}
		System.out.println(ans);
	}

	public static void fun() {
		// 확산
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			copy[i] = arr[i].clone();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] != 0) {
					int cnt = 0;
					for (int k = 0; k < dirs.length; k++) {
						int nx = i + dirs[k][0];
						int ny = j + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == -1)
							continue;
						// 확산되는 양 만큼 인접한 곳에 확산
						arr[nx][ny] += (copy[i][j] / 5);
						cnt++;
					}
					// 확산한 양만큼 줄여주기
					arr[i][j] = arr[i][j] - ((copy[i][j] / 5) * cnt);
				}
			}
		}
	}

	public static void gongi() {
		// 공기청정기 작동
		boolean check = false;
		for (int i = 0; i < n; i++) {
			// 위 - 반시계 방향
			if (arr[i][0] == -1 && !check) {
				check = true;
				for (int j = i - 1; j > 0; j--) {
					arr[j][0] = arr[j - 1][0];
				}

				for (int j = 0; j < m - 1; j++) {
					arr[0][j] = arr[0][j + 1];
				}

				for (int j = 0; j < i; j++) {
					arr[j][m - 1] = arr[j + 1][m - 1];
				}
				for (int j = m - 1; j > 0; j--) {
					arr[i][j] = arr[i][j - 1];
				}
				arr[i][1] = 0;
			} else if (arr[i][0] == -1 && check) { // 아래 - 시계방향
				for (int j = i + 1; j < n - 1; j++) {
					arr[j][0] = arr[j + 1][0];
				}
				for (int j = 0; j < m - 1; j++) {
					arr[n - 1][j] = arr[n - 1][j + 1];
				}
				for (int j = n - 1; j > i; j--) {
					arr[j][m - 1] = arr[j - 1][m - 1];
				}
				for (int j = m - 1; j > 0; j--) {
					arr[i][j] = arr[i][j - 1];
				}
				arr[i][1] = 0;
			}
		}
	}

}
