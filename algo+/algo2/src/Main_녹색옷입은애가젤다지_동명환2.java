import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_녹색옷입은애가젤다지_동명환2 {

	private static int[][] arr;
	private static int n;
	private static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	// private static boolean[][] brr;
	private static int[][] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int problem = 1;
		while (true) {

			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < n; j++, index += 2) {
					arr[i][j] = str.charAt(index) - '0';
				}
			} // 입력
			if (n == 0)
				break;
			temp = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < temp.length; j++) {
					temp[i][j] = Integer.MAX_VALUE;
				}
			}
			temp[0][0] = arr[0][0];
			fun(0, 0);
			for (int i = 0; i < temp.length; i++) {
				System.out.println(Arrays.toString(temp[i]));
			}
			System.out.println("Problem " + problem++ + ": " + temp[n - 1][n - 1]);
		}
	}

	private static void fun(int x, int y) {

		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx >= n || ny >= n || nx < 0 || ny < 0 || arr[nx][ny] + temp[x][y] >= temp[nx][ny])
				continue;
			if (arr[nx][ny] + temp[x][y] < temp[nx][ny]) {
				temp[nx][ny] = arr[nx][ny] + temp[x][y];
				fun(nx, ny);
			}

		}
	}

}
