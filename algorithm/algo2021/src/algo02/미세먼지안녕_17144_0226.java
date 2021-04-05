package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144_0226 {

	static int r, c, t;
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < t; i++) {
			fun(); // 확산
			gongi(); // 공기청정기 작동
		}
		//
		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != -1) {
					result += arr[i][j];
				}
			}
		}
		System.out.println(result);

	}

	public static void gongi() {
		boolean f = false;
		for (int i = 0; i < r; i++) {
			if (arr[i][0] == -1 && !f) { // 1번 공기청정기
				f = true;
				for (int j = i - 1; j > 0; j--) {
					arr[j][0] = arr[j - 1][0];
				}
				for (int j = 0; j < c - 1; j++) {
					arr[0][j] = arr[0][j + 1];
				}
				for (int j = 0; j < i; j++) {
					arr[j][c - 1] = arr[j + 1][c - 1];
				}
				for (int j = c - 1; j > 0; j--) {
					arr[i][j] = arr[i][j - 1];
				}
				arr[i][1] = 0;

			} else if (arr[i][0] == -1 && f) { // 2번 공기청정기

				for (int j = i + 1; j < r - 1; j++) {
					arr[j][0] = arr[j + 1][0];
				}
				for (int j = 0; j < c - 1; j++) {
					arr[r - 1][j] = arr[r - 1][j + 1];
				}
				for (int j = r - 1; j > i; j--) {
					arr[j][c - 1] = arr[j - 1][c - 1];
				}
				for (int j = c - 1; j > 0; j--) {
					arr[i][j] = arr[i][j - 1];
				}
				arr[i][1] = 0;
			}

		}
	}

	public static void fun() {
		int[][] copy = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (copy[i][j] != 0) {
					int cnt = 0;
					for (int k = 0; k < dirs.length; k++) {
						int nx = i + dirs[k][0];
						int ny = j + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] ==-1)
							continue;
						arr[nx][ny] += (copy[i][j] / 5);
						cnt++;
					}
					arr[i][j] = arr[i][j] - ((copy[i][j] / 5) * cnt);
				}
			}
		}
	}

}
