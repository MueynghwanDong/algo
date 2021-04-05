package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ������2_17141_0903 {

	static int n;
	static int m;
	static int arr[][];
	static int count = 0;
	static boolean check[];
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<int[]> list = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;

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
				if (arr[i][j] == 2)
					list.add(new int[] { i, j });

				if (arr[i][j] == 0)
					count++;
			}
		}
		count += list.size() - m; // ���õ��� ���� ���� count ���� �߰�
		check = new boolean[list.size()];
		if (count != 0) {
			comb(0, 0);
		} else {
			answer = 0;
		}

		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	public static void comb(int depth, int start) {
		if (depth == m) { // ��������
			int[][] copyarr = copy();
			bfs(copyarr, count);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			check[i] = true;
			comb(depth + 1, i + 1);
			check[i] = false;
		}
	}

	public static int[][] copy() {
		int result[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (!check[i]) {
				int[] idx = list.get(i);
				result[idx[0]][idx[1]] = 0; // ���õ��� ���� ���� 0���� ������ֱ�
			}
		}
		return result;

	}

	public static void bfs(int[][] carr, int count) {
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < list.size(); i++) {
			if (check[i])
				queue.add(list.get(i));
		}
		int time = 0;
		while (!queue.isEmpty()) {
			if (answer <= time) {
				break;
			}
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int[] temp = queue.poll();
				int cx = temp[0];
				int cy = temp[1];
				for (int j = 0; j < dirs.length; j++) {
					int nx = cx + dirs[j][0];
					int ny = cy + dirs[j][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || carr[nx][ny] != 0)
						continue;
					count--;
					carr[nx][ny] = 2;
					queue.add(new int[] { nx, ny });
				}
			}
			time++;
			if (count == 0) {
				answer = time;
				return;
			}
		}

	}

}
