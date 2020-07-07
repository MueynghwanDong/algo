package algo06.algo0617;

import java.util.Scanner;

public class ¾ËÆÄºª {

	static int R;
	static int C;
	static char[][] crr;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[] visited;
	static int max;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		crr = new char[R][C];
		visited = new boolean[R * C];
		max = 0;
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				crr[i][j] = str.charAt(j);
			}
		} // ÀÔ·Â
		visited[crr[0][0]-'A'] =true;
		dfs(0, 0, 1);
		System.out.println(max);
	} // end of main

	public static void dfs(int x, int y, int cnt) {
		
		for (int i = 0; i < dirs.length; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= R || newy >= C || visited[crr[newx][newy]-'A'])
				continue;
			if (!visited[crr[newx][newy] - 'A']) {
				visited[crr[newx][newy] - 'A'] = true;
				dfs(newx, newy, cnt + 1);
				visited[crr[newx][newy] - 'A'] = false;
			}
		}
		if (max < cnt)
			max = cnt;
	}
}
