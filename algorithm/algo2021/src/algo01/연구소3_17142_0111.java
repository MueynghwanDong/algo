package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3_17142_0111 {

	static int n, m;
	static int[][] arr;
	static boolean[] brr;
	static int ans = Integer.MAX_VALUE;
	static int count = 0;
	static ArrayList<int[]> list = new ArrayList<>();
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list.add(new int[] { i, j });
				} else if (arr[i][j] == 0) {
					count++;
				}
			}
		}
		brr = new boolean[list.size()]; // 활성인지 비활성인지 체크
		if (count != 0) {
			comb(0, 0);
		} else {
			ans = 0;
		}
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	public static void comb(int depth, int start) {
		if (depth == m) {
			int[][] temp = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp[i][j] = arr[i][j];
				}
			} // 배열 복사
			for (int i = 0; i < list.size(); i++) {
				if (!brr[i]) {
					int[] idx = list.get(i);
					temp[idx[0]][idx[1]] = 3; // 선택되지 않은 바이러스 3으로 처리
				}
			}

			bfs(temp, count);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			brr[i] = true;
			comb(depth + 1, i + 1);
			brr[i] = false;
		}
	}

	public static void bfs(int[][] arr, int count) {
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			if (brr[i]) {
				queue.add(list.get(i));
			}
		}
		int time = 0;
		while (!queue.isEmpty()) {
			if (ans <= time)
				break;
			int len = queue.size();
			for (int j = 0; j < len; j++) {
				int[] q = queue.poll();
				int cx = q[0];
				int cy = q[1];
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 1 || arr[nx][ny] == 2)
						continue;
					if (arr[nx][ny] == 0) {
						count--;
					}
					arr[nx][ny] = 2;
					queue.add(new int[] { nx, ny });
				}
			}
			time++;
			if (count == 0) {
				ans = time;
				return;
			}
		}
	}
}
