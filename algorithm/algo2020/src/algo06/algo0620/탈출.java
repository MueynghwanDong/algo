package algo06.algo0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {

	static int n;
	static int m;
	static char[][] crr;
	static boolean[][] check;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<int[]> queue = new LinkedList<>();
	static int cnt;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		crr = new char[n][m];
		check = new boolean[n][m];
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				crr[i][j] = str.charAt(j);
				if (crr[i][j] == 'S') {
					x = i;
					y = j;
					check[i][j] = true;
				} else if (crr[i][j] == '*') {
					queue.offer(new int[] { i, j, -1 });
				}
			}
		} // 입력
		cnt = -1;
		queue.offer(new int[] { x, y, 0 });
		bfs();
		if(cnt == -1) {
			System.out.println("KAKTUS");
		}else {			
			System.out.println(cnt);
		}
	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int r = q[0];
			int c = q[1];
			int time = q[2];
			if (crr[r][c] == 'D') {				
					cnt = time;
					return;				
			}
			if (time == -1) { // 물
				for (int i = 0; i < dirs.length; i++) {
					int newx = r + dirs[i][0];
					int newy = c + dirs[i][1];
					if (newx < 0 || newy < 0 || newx >= n || newy >= m || crr[newx][newy] == 'D')
						continue;
					if (crr[newx][newy] == '.') { // 물일 경우
						crr[newx][newy] = '*';
						queue.offer(new int[] { newx, newy, -1 });
					}

				}
			} else { // 고슴도치
				for (int i = 0; i < dirs.length; i++) {
					int newx = r + dirs[i][0];
					int newy = c + dirs[i][1];
					if (newx < 0 || newy < 0 || newx >= n || newy >= m || crr[newx][newy] == '*'
							|| crr[newx][newy] == 'X' || check[newx][newy])
						continue;
					queue.offer(new int[] { newx, newy, time + 1 });
					check[newx][newy] = true;
				}
			}
		}

	}
}
