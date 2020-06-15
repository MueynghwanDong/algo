import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17144_미세먼지안녕_동명환 {

	private static int n;
	private static int m;
	private static int t;
	private static int[][] arr;
	private static int airY;
	private static int airX;
	private static int[][] arr2;

	public static void mise() {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (arr[r][c] == 0 || arr[r][c] == -1)
					continue;
				int v = arr[r][c] / 5; // 인접칸에 퍼트릴 값
				int cnt = 0; // 퍼트린 횟수
				if (0 <= r - 1 && arr2[r - 1][c] != -1) { // 상
					arr2[r - 1][c] += v;
					cnt++;
				}
				if (r + 1 < n && arr2[r + 1][c] != -1) { // 하
					arr2[r + 1][c] += v;
					cnt++;
				}
				if (0 <= c - 1 && arr2[r][c - 1] != -1) { // 좌
					arr2[r][c - 1] += v;
					cnt++;
				}
				if (c + 1 < m && arr2[r][c + 1] != -1) { // 우
					arr2[r][c + 1] += v;
					cnt++;
				}
				arr2[r][c] += arr[r][c] - cnt * v;
			}
		}
	}

	public static void fresh() {

		int r = airY - 1;
		// 공기청정기 -위 , 초기 시작위치를 공기청정기 -1
		int c = airX;
		for (; r - 1 >= 0; r--) { // 상
			arr2[r][c] = arr2[r - 1][c];
		}
		for (; c + 1 < m; c++) { // 우
			arr2[r][c] = arr2[r][c + 1];
		}
		for (; r + 1 <= airY; r++) { // 하
			arr2[r][c] = arr2[r + 1][c];
		}
		for (; c - 1 >= 1; c--) { // 좌
			arr2[r][c] = arr2[r][c - 1];
		}
		arr2[r][c] = 0;

	}

	public static void fresh2() {

		int r = airY + 2; // 공기청정기 시작위치, 공기청정기 변하지 않기위한 +1/+1
		; // 공기청정기 -위 , 초기 시작위치를 공기청정기 -1
		int c = airX;
		for (; r + 1 < n; r++) { // 하
			arr2[r][c] = arr2[r + 1][c];
		}
		for (; c + 1 < m; c++) { // 우
			arr2[r][c] = arr2[r][c + 1];
		}

		for (; r - 1 >= airY + 1; r--) { // 상
			arr2[r][c] = arr2[r - 1][c];
		}
		for (; c - 1 >= 1; c--) { // 좌
			arr2[r][c] = arr2[r][c - 1];
		}
		arr2[r][c] = 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		arr2 = new int[n][m];
		airY = -1; // 공기청정기 행 첫번째 좌표
		airX = -1; // 공기 청정기 열

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (airY == -1 && arr[i][j] == -1) {
					airY = i;
					airX = j;
				}
			}
		}
		for (int i = 0; i < t; i++) {

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					arr2[r][c] = 0;
				}
			}
			arr2[airY][airX] = -1;
			arr2[airY + 1][airX] = -1;
			mise();
			fresh();
			fresh2();
			int[][] temp = arr;
			arr = arr2;
			arr2 = temp;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum + 2);
	} // end of main
} // end of class
