package 코테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미네랄_2933_0405 {

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int r, c;
	static int[] h;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] arr;
	static boolean[][] brr;
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
		int n = Integer.parseInt(br.readLine());
		h = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int height = r - h[i];
			if (i % 2 == 0) { // 왼쪽
				for (int j = 0; j < c; j++) {
					if (arr[height][j] == 'x') {
						arr[height][j] = '.';
						break;
					}
				}
			} else { // 오른쪽
				for (int j = c - 1; j >= 0; j--) {
					if (arr[height][j] == 'x') {
						arr[height][j] = '.';
						break;
					}
				}
			}
			
			find();
			if (list.size() > 0) {
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
		for (Node n : list) {
			arr[n.x][n.y] = '.';
		}

		int cnt = 0;
		outer: for (int i = 1; i < r; i++) {
			for (Node n : list) {
				if (n.x + i >= r || arr[n.x + i][n.y] == 'x') { // 범위를 벗어나거나 x가 있을 경우 outer를 벗어나기 -> cnt 값은 이전 값으로 남음
					break outer;
				}
			}
			cnt = i;
		}
		for (Node n : list) {
			arr[n.x + cnt][n.y] = 'x';
		}
	}

	public static void find() {
		list = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		brr = new boolean[r][c];
		// 초기 큐에 넣어줄 것
		for (int i = 0; i < c; i++) {
			if (arr[r - 1][i] == 'x') {
				q.add(new Node(r - 1, i));
				brr[r - 1][i] = true;
			}
		}
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
		// 방문하지 않는 곳과 x인 곱을 리스트에 넣기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 'x' && !brr[i][j]) {
					list.add(new Node(i, j));
				}
			}
		}
	}
}
