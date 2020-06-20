package algo0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class »§Áý {

	static int n;
	static int m;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'x')
					brr[i][j] = true;
			}
		}
		int cnt = 0;

		for (int i = 0; i < n; i++) {

			if (fun(i, 0))
				cnt++;
		}
		System.out.println(cnt);

	}

	public static boolean fun(int x, int y) {
		brr[x][y] = true;
		if (y == m - 1) {
			return true;
		}
		for (int i = 0; i < dir.length; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 'x' || brr[nx][ny])
				continue;
			boolean c = fun(nx, ny);
			if (c)
				return true;

		}
		return false;

	}

}
