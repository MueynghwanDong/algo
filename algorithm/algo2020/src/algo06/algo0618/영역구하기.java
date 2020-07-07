package algo06.algo0618;

import java.util.Arrays;
import java.util.Scanner;

public class 영역구하기 {

	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		brr = new boolean[n][m];
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for (int j = ((n - 1) - y1); j >= (n - y2); j--) {
				for (int l = x1; l <= (x2 - 1); l++) {
					arr[j][l] = 1;
				}
			}
		}
		int cnt = 0;
		String temp = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && !brr[i][j]) {
					dfs(i, j);
					temp = temp +count+ " " ;
					cnt++;
					count =0;
				}
			}
		}
		System.out.println(cnt);
		String[] t = temp.split(" ");
		int[] tt = new int[t.length];
		for (int i = 0; i < tt.length; i++) {
			tt[i] = Integer.valueOf(t[i]);
		}
		Arrays.sort(tt);
		for (int i = 0; i < tt.length; i++) {
			System.out.print(tt[i]+" ");
		}
	}

	public static void dfs(int x, int y) {
		brr[x][y] = true;
		count++;
		for (int i = 0; i < dirs.length; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= n || newy >= m)
				continue;
			if (arr[newx][newy] == 0 && !brr[newx][newy]) {
				dfs(newx, newy);
			}
		}
	}
}
