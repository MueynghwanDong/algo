package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¾ËÆÄºª_1987_1222 {

	static int r;
	static int c;
	static char[][] crr;
	static boolean[] brr;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		crr = new char[r][c];
		brr = new boolean[26];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				crr[i][j] = str.charAt(j);
			}
		}

		brr[crr[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt) {
		for (int i = 0; i < dir.length; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[crr[nx][ny] - 'A'])
				continue;
			brr[crr[nx][ny] - 'A'] = true;
			dfs(nx, ny, cnt + 1);
			brr[crr[nx][ny] - 'A'] = false;
		}
		if (max < cnt)
			max = cnt;
	}

}
