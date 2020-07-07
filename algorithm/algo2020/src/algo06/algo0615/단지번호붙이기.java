package algo06.algo0615;
import java.util.Arrays;
import java.util.Scanner;

// 백준 2667번 단지번호 붙이기
public class 단지번호붙이기 {

	static int n;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] arr;
	static boolean[][] check;
	static int cnt;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		check = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		cnt = 0;
		String temp = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1 && !check[i][j]) {
					count = dfs(i, j);
					cnt++;
					temp = temp + count + " ";
					count = 0;
				}
			}
		}
		System.out.println(cnt);
		String[] result = temp.split(" ");
		int[] wrr = new int[result.length];
		for (int i = 0; i < wrr.length; i++) {
			wrr[i] = Integer.valueOf(result[i]);
		}
		Arrays.sort(wrr);
		for (int k = 0; k < wrr.length; k++) {
			System.out.println(wrr[k]);
		}

	} // END OF main

	public static int dfs(int x, int y) {
		check[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= n || newy >= n)
				continue;
			if (arr[newx][newy] == 1 && !check[newx][newy]) {
				count++;
				dfs(newx, newy);
			}
		}
		return count;
	}
}
