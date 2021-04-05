package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¾ËÆÄºª_1987_0311 {

	static int r, c, ans = 0;
	static char[][] arr;
	static boolean[] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[26];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		brr[arr[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	public static void dfs(int x, int y, int cnt) {
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[arr[nx][ny] - 'A'])
				continue;
			brr[arr[nx][ny] - 'A'] = true;
			dfs(nx, ny, cnt + 1);
			brr[arr[nx][ny] - 'A'] = false;
		}
		if (ans < cnt)
			ans = cnt;
	}
}
