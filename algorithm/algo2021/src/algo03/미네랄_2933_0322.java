package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미네랄_2933_0322 {

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int r, c, n;
	static int[] h;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		n = Integer.parseInt(br.readLine());
		h = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		// 입력
		for (int i = 0; i < n; i++) {
			int height = r - h[i];
			if (i % 2 == 0) { // 왼쪽에서 막대기 던짐
				for (int j = 0; j < c; j++) {
					if (arr[height][j] == 'x') {
						arr[height][j] = '.';
						break;
					}
				}
			} else { // 오른족에서 막대기 던짐
				for (int j = c - 1; j >= 0; j--) {
					if (arr[height][j] == 'x') {
						arr[height][j] = '.';
						break;
					}
				}
			}
			find();
			if (list.size() != 0) {
				down();
			}
			list.clear();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void down() {
		for (Node node : list) {
			arr[node.x][node.y] = '.';
		}
		int cnt = 0;
		outer: for (int i = 1; i < r; i++) {
			for (Node cur : list) {
				if (cur.x + i >= r || arr[cur.x + i][cur.y] == 'x') {
					break outer;
				}
			}
			cnt = i;
		}
		for (Node node : list) {
			arr[node.x + cnt][node.y] = 'x';
		}
	}

	public static void find() {
		list = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		brr = new boolean[r][c];
		for (int i = 0; i < c; i++) {
			if (arr[r - 1][i] == 'x') {
				q.add(new Node(r - 1, i));
				brr[r - 1][i] = true;
			}
		}
		// 초기에 큐에 들어갈 것 맨 밑에있는 줄의 x
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.x + dirs[i][0];
				int ny = cur.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny] || arr[nx][ny] == '.')
					continue;
				q.add(new Node(nx, ny));
				brr[nx][ny] = true;
			}
		}
		// 연결 되지 않는 x 값 찾아 list에 추가
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 'x' && !brr[i][j]) {
					list.add(new Node(i, j));
				}
			}
		}
	}

}
