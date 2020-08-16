package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 성곽_0707 {

	static int m;
	static int n;
	static int[][] arr;
	static int[][] map;
	static boolean[][] brr;
	static int max, result;
	static int cnt;
	static ArrayList<Integer> widths = new ArrayList<>(); // 영역별 사이즈 값을 가지고 있기 위함
	static int dirs[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		map = new int[n][m]; // 영역별 구간 나누는 배열
		brr = new boolean[n][m];
		max = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력
		cnt = 0;
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
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k] == i && !brr[j][k])
						bfs2(j, k, i);
				}
			}
		}
		System.out.println(result);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		brr[x][y] = true;
		queue.offer(new int[] { x, y, arr[x][y] });
		int size = 0;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int val = q[2];
			size++;
			map[cx][cy] = cnt;
			int[] d = { val & 1, val & 2, val & 4, val & 8 }; // 이부분이 중요함 ..
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || d[i] != 0)
					continue;
				// 벽이 아닌곳만 이동하기
				brr[nx][ny] = true;
				queue.offer(new int[] { nx, ny, arr[nx][ny] });
			}

		}
		widths.add(size);
		if (size > max)
			max = size;

	}

	public static void bfs2(int x, int y, int val) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int cx = q[0];
			int cy = q[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
					continue;
				if (map[nx][ny] != val) { // 같은 영역이 아닌 경우 체크하기
					int value = widths.get(val) + widths.get(map[nx][ny]);
					if (result < value)
						result = value;
					continue;
				}
				brr[nx][ny] = true;
				queue.offer(new int[] { nx, ny });
			}
		}	
	}
}