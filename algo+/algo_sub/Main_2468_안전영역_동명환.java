import java.util.Scanner;

public class Main_2468_안전영역_동명환 {

	static int n;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void dfs(int x, int y) {
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (!brr[nx][ny]) {
				brr[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

	public static void out(int height) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] <= height) {
					brr[i][j] = true;
				}
			}
		}
	}

	public static int test() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!brr[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		brr = new boolean[n][n];
		int arrmax = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				if (arrmax < arr[i][j]) {
					arrmax = arr[i][j];
				}
			}
		} // 입력
		int max = 0;
		int temp = 0;
		for (int k = 0; k < arrmax; k++) {
			out(k);
			temp = test();
			max = Math.max(max, temp);
			if (max < temp) {
				max = temp;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					brr[i][j] = false;
				}
			}
		}
		System.out.print(max);
	}
}