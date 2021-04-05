package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class »§Áý_3109_1023 {

	static int r;
	static int c;
	static char[][] arr;
	static boolean[][] brr;
	static int ans;
	static int[][] dirs = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[r][c];
		ans = 0;
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (dfs(i, 0))
				cnt++;
		}
		System.out.println(cnt);
	}

	public static boolean dfs(int x, int y) {
//		System.out.println(x+" "+ y);
		brr[x][y] = true;
		if (y == c - 1) {
			return true;
		}
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == 'x' || brr[nx][ny])
				continue;
			boolean c = dfs(nx, ny);
			if (c)
				return true;

		}
		return false;
	}

}
