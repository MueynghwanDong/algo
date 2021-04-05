package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ·Îº¿Ã»¼Ò±â_4991_0324 {

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int w, h, ans;
	static char[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[] brr;
	static int[][] dis;
	static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		outer: while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			list = new ArrayList<>();
			arr = new char[h][w];
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '*') {
						list.add(new Node(i, j));
					} else if (arr[i][j] == 'o') {
						list.add(0, new Node(i, j));

					}
				}
			}
			int size = list.size();
			dis = new int[size][size];

			for (int i = 0; i < size; i++) {
				int[][] dist = bfs(i);
				for (int j = 0; j < list.size(); j++) {
					Node end = list.get(j);
					dis[i][j] = dist[end.x][end.y];
					if (dis[i][j] == Integer.MAX_VALUE) {
						System.out.println(-1);
						continue outer;
					}
				}

			}
			brr = new boolean[size];
			ans = Integer.MAX_VALUE;
			brr[0] = true;
			dfs(0, 0, 0);
			System.out.println(ans);
		}
	}

	public static void dfs(int idx, int sum, int v) {
		if (idx == brr.length - 1) {
			if (ans > sum)
				ans = sum;
			return;
		}
		for (int i = 1; i < brr.length; i++) {
			if (!brr[i]) {
				brr[i] = true;
				dfs(idx + 1, sum + dis[v][i], i);
				brr[i] = false;
			}
		}
	}

	public static int[][] bfs(int v) {
		Queue<Node> q = new LinkedList<>();

		int[][] drr = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				drr[i][j] = Integer.MAX_VALUE;
			}
		}

		Node s = list.get(v);
		drr[s.x][s.y] = 0;
		q.add(s);

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int j = 0; j < dirs.length; j++) {
				int nx = cur.x + dirs[j][0];
				int ny = cur.y + dirs[j][1];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w || arr[nx][ny] == 'x'
						|| drr[nx][ny] <= drr[cur.x][cur.y] + 1)
					continue;
				drr[nx][ny] = drr[cur.x][cur.y] + 1;
				q.add(new Node(nx, ny));
			}
		}
		return drr;
	}
}
