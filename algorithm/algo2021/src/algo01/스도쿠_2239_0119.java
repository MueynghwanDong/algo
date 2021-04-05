package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ½ºµµÄí_2239_0119 {

	static int[][] arr = new int[9][9];
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';
				if (arr[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}
		dfs(0);
	}

	public static void dfs(int idx) {
		if (idx == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		for (int i = 1; i <= 9; i++) {
			if (check(idx, i) && checkbox(idx, i)) {
				arr[list.get(idx)[0]][list.get(idx)[1]] = i;
				dfs(idx + 1);
			}
		}
		arr[list.get(idx)[0]][list.get(idx)[1]] = 0;
	}

	public static boolean check(int idx, int val) {
		int cx = list.get(idx)[0];
		for (int i = 0; i < 9; i++) {
			if (arr[cx][i] == val) {
				return false;
			}
		}
		int cy = list.get(idx)[1];
		for (int i = 0; i < 9; i++) {
			if (arr[i][cy] == val) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkbox(int idx, int val) {
		int cx = list.get(idx)[0];
		int cy = list.get(idx)[1];
		int bx = cx / 3;
		bx *= 3;
		int by = cy / 3;
		by *= 3;
		for (int i = bx; i < bx + 3; i++) {
			for (int j = by; j < by + 3; j++) {
				if (cx == i && cy == j)
					continue;
				if (arr[i][j] == val)
					return false;
			}
		}
		return true;
	}
}
