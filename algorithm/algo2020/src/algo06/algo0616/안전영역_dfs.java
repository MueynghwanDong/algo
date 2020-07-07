package algo06.algo0616;

import java.util.Scanner;

public class 안전영역_dfs {

	static int n;
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] check;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = 0;
		n = sc.nextInt();
		arr = new int[n][n];
		check = new boolean[n][n];
		int max = 0; // 가장 높이를 찾기위한 변수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				if (max < arr[i][j])
					max = arr[i][j];
			}
		} // 입력

		for (int i = 0; i < max; i++) {
			flood(i);
			reseting();
			
		}
		System.out.println(result);
	}

	public static void flood(int height) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] <= height) {
					check[i][j] = true; // 침수된 곳
				}
			}
		}


		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (!check[i][j] && arr[i][j] > height) {
					dfs(i, j, height);
					count++;
				}
			}
		}
		if (count > result) {
			result = count;
		}

	}

	public static void reseting() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				check[i][j] = false;
			}
		}
	}

	public static void dfs(int x, int y, int height) {
		check[x][y] = true;

		for (int i = 0; i < dirs.length; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= n || newy >= n)
				continue;
			if (!check[newx][newy] && arr[newx][newy] > height) {
				dfs(newx, newy, height);
			}
		}
	}

}
