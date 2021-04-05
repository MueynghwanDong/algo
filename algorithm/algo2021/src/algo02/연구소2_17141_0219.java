package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¿¬±¸¼Ò2_17141_0219 {

	static int n, m, cnt = 0, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<int[]> list = new ArrayList<>();

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
				} else if (arr[i][j] == 0)
					cnt++;
			}
		}
		cnt+= (list.size()-m);
		brr = new boolean[list.size()];
		if (cnt != 0) {
			fun(0, 0);
		} else {
			ans = 0;
		}
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	public static void bfs(int[][] arr, int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			if (brr[i])
				queue.add(list.get(i));
		}
		int time = 0;
		while (!queue.isEmpty()) {
			if (ans <= time)
				break;
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int[] t = queue.poll();
				int cx = t[0];
				int cy = t[1];
				for (int j = 0; j < dirs.length; j++) {
					int nx = cx + dirs[j][0];
					int ny = cy + dirs[j][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] != 0)
						continue;
					cnt--;
					arr[nx][ny] = 2;
					queue.add(new int[] { nx, ny });
				}
			}
			time++;
			if (cnt == 0) {
				ans = time;
				return;

			}
		}
	}

	public static void fun(int depth, int s) {
		if (depth == m) {
			int[][] temp = copy(arr);
			for (int i = 0; i < list.size(); i++) {
				if (!brr[i]) {
					int[] t = list.get(i);
					temp[t[0]][t[1]] = 0;
				}
			}
			bfs(temp, cnt);
			return;
		}
		for (int i = s; i < list.size(); i++) {
			brr[i] = true;
			fun(depth + 1, i + 1);
			brr[i] = false;
		}
	}

	public static int[][] copy(int[][] arr) {
		int[][] re = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				re[i][j] = arr[i][j];
			}
		}
		return re;
	}

}
