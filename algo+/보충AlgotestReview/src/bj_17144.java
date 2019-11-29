import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_17144 {

	private static int n;
	private static int m;
	private static int t;
	private static int[][] arr;
	private static int[][] gc;
	private static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void mise() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int count = 0;
				if (arr[i][j] != 0 && arr[i][j] != -1) {
					for (int k = 0; k < dirs.length; k++) {
						int nx = i + dirs[k][0];
						int ny = j + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == -1)
							continue;
						arr[nx][ny] = arr[nx][ny] + arr[i][j] / 5;
						count++;
					}
					int num = arr[i][j] / 5;
					arr[i][j] = arr[i][j] - (count * num);
				}
			}
		}
	}

	public static void fresh() {
		for (int i = 0; i < gc.length; i++) {
			int x = gc[i][0];
			int y = gc[i][1];
			if (i == 0) {
				int r = x - 1;
				int c = y;
				int temp = arr[r][c];
				for (int j = 0; j < x - 1; j++) {
					arr[r][c] = arr[r - 1][c];
					r--;
				}
				for (int j = 0; j < n; j++) {
					arr[r][c] = arr[r][c + 1];
					c++;
				}
				for (int j = 0; j < x; j++) {
					arr[r][c] = arr[r + 1][c];
					r++;
				}
				for (int j = 0; j < n - 1; j++) {
					arr[r][c] = arr[r][c - 1];
					c--;
				}

			} else {
				int r = x + 1;
				int c = y;
				for (int j = x + 1; j < n - 1; j++) {
					arr[r][c] = arr[r + 1][c];
					r++;
				}

				for (int j = 0; j < n; j++) {
					arr[r][c] = arr[r][c + 1];
					c++;
				}
				for (int j = x + 1; j < n; j++) {
					arr[r][c] = arr[r - 1][c];
					r--;
				}
				for (int j = 0; j < n - 1; j++) {
					arr[r][c] = arr[r][c - 1];
					c--;
				}
				arr[r][c] = 0;

			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		gc = new int[2][2]; // 공기청정기 위치
		int index = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					gc[index][0] = i;
					gc[index][1] = j;
					index++;
				}
			}
		}
		for (int i = 0; i < t; i++) {
			mise();
			fresh();
			for (int j = 0; j < n; j++) {
				System.out.println(Arrays.toString(arr[j]));
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += arr[i][j];
			}
			// System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println(sum + 2);
	} // end of main
} // end of class
