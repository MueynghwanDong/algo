package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_3109_0313 {

	static int r, c, cnt = 0;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < r; i++) {
			if (dfs(i, 0)) { // 왼쪽줄 부터 시작
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	public static boolean dfs(int x, int y) {
		brr[x][y] = true;
		if (y == c - 1) { // 종료조건
			return true;
		}
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny] || arr[nx][ny] == 'x')
				continue;
			boolean c = dfs(nx, ny); // 이미 true한 것에 대해 true로 리턴
			if (c)
				return true;
		}
		return false;
	}

}
