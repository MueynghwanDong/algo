package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 성곽_2234_0321 {

	static int n, m, cnt, result, max = 0;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] map;
	static ArrayList<Integer> wd = new ArrayList<>();
	static int dirs[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		map = new int[n][m]; // 방 번호를 매기기 위한 배열
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0; // 구역의 갯수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!brr[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		result = 0;
		brr = new boolean[n][m];
		for (int i = 0; i < cnt; i++) { // 구역 수 만큼 반복!!
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k] == i && !brr[j][k]) {
						bfs2(j, k, i);
					}
				}
			}
		}
		System.out.println(result);
	}

	public static void bfs2(int x, int y, int val) {
		Queue<int[]> q = new LinkedList<>();
		brr[x][y] = true;
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
					continue;
				if (map[nx][ny] != val) {
					int value = wd.get(map[nx][ny]) + wd.get(val);
					if (result < value)
						result = value;
					continue;
				}
				brr[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		brr[x][y] = true;
		q.add(new int[] { x, y, arr[x][y] });
		int size = 0;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			int val = t[2];
			size++;
			map[cx][cy] = cnt;

			int[] d = { val & 1, val & 2, val & 4, val & 8 };
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || d[i] != 0 || brr[nx][ny])
					continue;
				q.add(new int[] { nx, ny, arr[nx][ny] });
				brr[nx][ny] = true;
			}
		}
		// cnt를 인덱스로 하여금 size를 추가한다 // 구역별 크기
		wd.add(size);
		if (size > max)
			max = size;
	}

}
