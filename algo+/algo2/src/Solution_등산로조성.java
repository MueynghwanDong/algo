import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_등산로조성 {

	private static int k;
	private static int n;
	private static int[][] arr;
	private static int max;
	private static int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	private static boolean[][] brr;
	private static int[][] temp;

	// dfs + 백트래킹 ?
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // (3 ≤ N ≤ 8)
			k = Integer.parseInt(st.nextToken()); // 깊이 (1 ≤ K ≤ 5)
			arr = new int[n][n];
			temp = new int[n][n];
			brr = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < n; j++, index += 2) {
					arr[i][j] = str.charAt(index) - '0';
				}
			}
			for (int i = 0; i < temp.length; i++) {
				temp[i] = arr[i].clone();
			}
			max = -1; // 최장 길이의 값을 저장할 변수
			// 큰 것부터 시작해서 작은 값으로 이동하는 형식으로 진행하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					brr[i][j] = true;
					fun(i, j, 1, 1);
					brr[i][j] = false;
				}
			}
			System.out.println(max);
		} // end for tc
	} // end of main

	private static void fun(int x, int y, int cnt, int one) { // 지도에서 가장 높은 것을 찾아서 낮은 위치로 이동하기

		System.out.println(x + " " + y + " " + cnt + " " + one);
		for (int j = 0; j < n; j++) {
			System.out.println(Arrays.toString(temp[j]));
		}
		System.out.println();
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (temp[nx][ny] >= temp[x][y]) { // 다음 것이 현재 것 보다 같거나 큰 경우
					// 깍을 수 있는지 확인하기
					if (one > 0) {
						// 깍았을 때 다음 것이 현재보다 작아지는 지 -> 작아지지 않았다면 종료
						if (temp[nx][ny] - k >= temp[x][y]) { // 깥아도 다음것이 클거나 같을 때
							if (max < cnt) {
								max = cnt;
							}
							continue;
						} else {
							brr[nx][ny] = true;
							temp[nx][ny] = temp[nx][ny] - k;
							fun(nx, ny, cnt + 1, one - 1);
							temp[nx][ny] = temp[nx][ny] + k;
							brr[nx][ny] = false;
						}
						// 작아졌다면 계속 진행하고 kk-1

					} else { // 깍을 수 있는 권한이 없을 때 -> 종료
						if (max < cnt) {
							max = cnt;
						}
						continue;
					}
				} else { // 다음 것이 현재 보다 작은 경우
					brr[nx][ny] = true;
					fun(nx, ny, cnt + 1, one);
					brr[nx][ny] = false;
				}
			}
		}

		// k가 0인경우

		// k값이 0>k 인경우 -> 현재 크기가 다음위치 크기 보다 작은 경우 -> k값 있다면 깍기 아니면 현재 길이 확인 후 max값 업데이트

		// 진행 후 원복

	}
} // end of class
