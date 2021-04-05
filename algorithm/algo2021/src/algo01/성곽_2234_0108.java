package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 성곽_2234_0108 {

	static int n, m;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] map;
	static int cnt, result, max = 0;
	static ArrayList<Integer> wd = new ArrayList<>();
	static int dirs[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		map = new int[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력
		cnt = 0;
		// cnt = 방의 개수
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
		// 방의 갯수 만큼 반복!!
		for (int i = 0; i < cnt; i++) {
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
		Queue<int[]> queue = new LinkedList<>();
		brr[x][y] = true;
		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int cx = q[0];
			int cy = q[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
					continue;
				// ** 현재 방의 map 값이 다를 때 두방의 크기를 더한 값의 최대값을 구하기
				if (map[nx][ny] != val) {
					int value = wd.get(map[nx][ny]) + wd.get(val);
					if (result < value)
						result = value;
					continue;
				}
				brr[nx][ny] = true;
				queue.add(new int[] { nx, ny });
			}
		}

	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		brr[x][y] = true;
		queue.add(new int[] { x, y, arr[x][y] });
		int size = 0; // 방의 크기를 얻기위한 변수
		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int val = q[2];
			size++;
			map[cx][cy] = cnt; // map 배열에 cnt 값을 넣어 같은 방이라는 것을 나타냄
			int d[] = { val & 1, val & 2, val & 4, val & 8 };
			// 비트마스킹 &연산을 수행함으로 해당 값이 모두 있을 때 1 아니면 0을 반환 - **
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || d[i] != 0)
					continue;
				brr[nx][ny] = true;
				queue.add(new int[] { nx, ny, arr[nx][ny] });
			}
		}
		wd.add(size); // list 배열에 넣어주어 나중에 3번 문제에 활용
		if (size > max)
			max = size;
	}

}
