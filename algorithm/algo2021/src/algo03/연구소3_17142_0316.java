package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3_17142_0316 {

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, ans = Integer.MAX_VALUE, cnt = 0;
	static int[][] arr;
	static boolean[] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<Node> list = new ArrayList<>();

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
					list.add(new Node(i, j));
				} else if (arr[i][j] == 0) {
					cnt++;
				}
			}
		}
		brr = new boolean[list.size()];
		if (cnt != 0) {
			comb(0, 0);
		} else {
			ans = 0;
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}

	}

	// list.size 중에 m개 선택
	public static void comb(int dep, int s) {
		if (dep == m) {
			int[][] temp = new int[n][n];
			for (int i = 0; i < n; i++) {
				temp[i] = arr[i].clone();
			}
			for (int i = 0; i < list.size(); i++) {
				if (!brr[i]) {
					// 선택되지 않은 바이러스 3으로!
					Node node = list.get(i);
					temp[node.x][node.y] = 3;
				}
			}
			bfs(temp, cnt);
			return;
		}
		for (int i = s; i < list.size(); i++) {
			brr[i] = true;
			comb(dep + 1, i + 1);
			brr[i] = false;
		}
	}

	public static void bfs(int[][] arr, int cnt) {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			if (brr[i]) {				
				q.add(list.get(i));
			}
		}
		int time = 0;
		while (!q.isEmpty()) {
			if (ans <= time)
				break;
			int len = q.size(); // 선택된 바이러스 갯수 만큼** 
			for (int j = 0; j <len; j++) {
				Node t = q.poll();
				for (int i = 0; i < dirs.length; i++) {
					int nx = t.x + dirs[i][0];
					int ny = t.y + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 1 || arr[nx][ny] == 2)
						continue;
					if (arr[nx][ny] == 0) {
						cnt--;
					}
					arr[nx][ny] = 2;
					q.add(new Node(nx, ny));
				}
			}
			time++;
			if (cnt == 0) {
				ans = time;
				return;
			}
		}
	}

}
