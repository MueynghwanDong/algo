package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_5427_0317 {

	static int w, h, ans, sx, sy;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int testcase = 0; testcase < t; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			q = new LinkedList<>();
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new char[h][w];
			brr = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '@') {
						sx = i;
						sy = j;
					} else if (arr[i][j] == '*') {
						q.add(new int[] { i, j, -1 });
						brr[i][j] = true;
					}
				}
			}
			ans = Integer.MAX_VALUE;
			brr[sx][sy] = true;
			q.add(new int[] { sx, sy, 1 });
			bfs();
			if (ans == Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(ans);
			}

		}

	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int t[] = q.poll();
			int cx = t[0];
			int cy = t[1];
			int cnt = t[2];
			if (cnt == -1) { // 불 인경우
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= h || ny >= w || brr[nx][ny] || arr[nx][ny] == '#')
						continue;
					if (arr[nx][ny] == '.') { // 빈칸인경우
						q.add(new int[] { nx, ny, -1 });
						arr[nx][ny] = '*';
						brr[nx][ny] = true;
					} else if (arr[nx][ny] == '@') { // 불이 지훈이를 만난경우
						ans = Integer.MAX_VALUE;
						return;
					}
				}
			} else { // 지훈이인 경우
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= h || ny >= w) { // 영역밖으로 나간 경우 --> 탈출 성공
						ans = cnt;
						return;
					}
					if (arr[nx][ny] == '*' || brr[nx][ny])
						continue;
					if (arr[nx][ny] == '.') { // 빈칸인 경우
						arr[nx][ny] = '@';
						arr[cx][cy] = '.';
						brr[nx][ny] = true;
						q.add(new int[] { nx, ny, cnt + 1 });
					}
				}
			}
		}
	}

}
