package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 비트마스크!!!
public class 달아차오른다가자_1194_0812 {

	static int n;
	static int m;
	static int sx, sy;
	static char[][] arr;
	static boolean[][][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		sx = 0;
		sy = 0;
		brr = new boolean[n][m][64]; // 키가 6개이므로 2^6
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
		queue.offer(new int[] { sx, sy, 0, 0 });
		brr[sx][sy][0] = true;
		arr[sx][sy] = '.';
		while (!queue.isEmpty()) {

			for (int k = 0; k < queue.size(); k++) {

				int[] q = queue.poll();
				int cx = q[0];
				int cy = q[1];
				int key = q[2];
				int cnt = q[3];
//				System.out.println(cx + " " + cy + " " + key);
				if (arr[cx][cy] == '1')
					return cnt;
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == '#' || brr[nx][ny][key])
						continue;
					if (arr[nx][ny] >= 'a' && arr[nx][ny] <= 'f') { // 열쇠
//						System.out.println(nx + " " + ny);
//						System.out.println((arr[nx][ny] - 'a') + " " + arr[nx][ny]);
						int ck = 1 << (arr[nx][ny] - 'a');
//						System.out.println(ck);
						int tempkey = ck | key;
//						System.out.println(tempkey);
						if (!brr[nx][ny][tempkey]) {
							brr[nx][ny][tempkey] = true;
							queue.offer(new int[] { nx, ny, tempkey, cnt + 1 });
						}
					} else if (arr[nx][ny] >= 'A' && arr[nx][ny] <= 'F') { // 문인 경우

						int cd = 1 << (arr[nx][ny] - 'A');
						int tempdoor = cd & key;
						if (tempdoor > 0) {
							brr[nx][ny][key] = true;
							queue.offer(new int[] { nx, ny, key, cnt + 1 });
						}
					} else {
						queue.offer(new int[] { nx, ny, key, cnt + 1 });
						brr[nx][ny][key] = true;
					}
				}
			}
		}
		return -1;
	}
}
