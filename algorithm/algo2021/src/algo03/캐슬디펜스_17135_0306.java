package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 캐슬디펜스_17135_0306 {

	static class Node implements Comparable<Node> {
		int x, y, d;

		Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			if (this.d == o.d) {
				return this.y - o.y;
			} else {
				return this.d - o.d;
			}
		}
	}

	static int n, m, d, ans = 0, result = 0, enermy = 0;
	static int[][] arr;
	static int[][] map;
	static int[] trr;

	static boolean[][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 거리
		arr = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					enermy++;
			}
		}
		for (int i = 0; i < m; i++) {
			arr[n][i] = 2; // 성
		}
		// 궁수 위치 선택
		trr = new int[3];
		comb(m, 3, enermy);
		System.out.println(result);
	}

	public static void comb(int num, int gs, int e) {
		if (gs == 0) {
			// 궁수 공격
			ans = 0;
			map = new int[n + 1][m];
			for (int i = 0; i < n + 1; i++) {
				map[i] = arr[i].clone();
			}
			for (int i = 0; i < trr.length; i++) {
				arr[n][trr[i]] = 3; // 궁수가 있는 성
			}
			for (int i = 0; i < trr.length; i++) {
				System.out.print(trr[i] + " ");
			}
			enermy = e;
			while (enermy > 0) {
				attack();
				System.out.println("attack");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println(ans + " " + enermy);
				System.out.println();
				downenermy();
				System.out.println("down");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println(ans + " " + enermy);
				System.out.println();
			}
			if (result < ans)
				result = ans;
			return;
		} else if (num < gs)
			return;
		else {
			trr[gs - 1] = num - 1;
			comb(num - 1, gs - 1, e);
			comb(num - 1, gs, e);
		}
	}

	public static void downenermy() {

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					if (i + 1 == n) {
						map[i][j] = 0;
						enermy--;
					} else {
						map[i + 1][j] = 1;
						map[i][j] = 0;
					}
				}
			}
		}
	}

	public static void attack() {

		Node[] nodes = new Node[3];
		int idx = 0;
		for (int i = 0; i < trr.length; i++) {
			int num = trr[i];
			List<Node> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k] == 1) {
						int dist = Math.abs((n) - j) + Math.abs(num - k);
						if (dist <= d) {
							list.add(new Node(j, k, dist));
						}
					}
				}
			}
			if (list.size() > 0) {
				Collections.sort(list);
				Node node = list.get(0); // 가장 우선순위에 있는 것
				nodes[idx++] = node;
			}

			// System.out.println(list.get(0).x + " " + list.get(0).y + " " +
			// list.get(0).d);
		}
		for (int i = 0; i < idx; i++) {
			Node node = nodes[i];
			if (map[node.x][node.y] == 1) {
				ans++;
				enermy--;
				map[node.x][node.y] = 0;
			}
		}

	}
}
