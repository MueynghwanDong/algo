package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자_1194_0320 {

	static int n, m, sx, sy;
	static char[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[n][m][64];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}
		int result = bfs();
		System.out.println(result);
	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { sx, sy, 0, 0 });
		brr[sx][sy][0] = true;
		arr[sx][sy] = '.';
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				int[] t = queue.poll();
				int cx = t[0];
				int cy = t[1];
				int key = t[2];
				int cnt = t[3];
				if (arr[cx][cy] == '1') {
					return cnt;
				}
				for (int j = 0; j < dirs.length; j++) {
					int nx = cx + dirs[j][0];
					int ny = cy + dirs[j][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny][key] || arr[nx][ny] == '#')
						continue;
					if (arr[nx][ny] >= 'a' && arr[nx][ny] <= 'f') { // 열쇠인경우
						int ck = 1 << (arr[nx][ny] - 'a');
						int tk = ck | key;
						// System.out.println(ck +" " + (arr[nx][ny]-'a') +" " +tk +" "+ key);
						if (!brr[nx][ny][tk]) {
							brr[nx][ny][tk] = true;
							queue.add(new int[] { nx, ny, tk, cnt + 1 });
						}
					} else if (arr[nx][ny] >= 'A' && arr[nx][ny] <= 'F') { // 문인경우
						int cd = 1 << (arr[nx][ny] - 'A');
						int td = cd & key;
						// System.out.println(cd +" " + (arr[nx][ny]-'A') +" " + td +" " + key);
						if (td > 0) {
							brr[nx][ny][key] = true;
							queue.add(new int[] { nx, ny, key, cnt + 1 });
						}
					} else {
						queue.add(new int[] { nx, ny, key, cnt + 1 });
						brr[nx][ny][key] = true;
					}
				}
			}
		}
		return -1;
	}
}
