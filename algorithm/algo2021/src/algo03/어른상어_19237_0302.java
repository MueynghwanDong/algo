package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ¾î¸¥»ó¾î_19237_0302 {

	static class Shark implements Comparable<Shark> {
		int x, y, d, num;

		Shark(int x, int y, int d, int num) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.num = num;
		}

		@Override
		public int compareTo(Shark o) {
			return this.num - o.num;
		}
	}

	static int n, m, k;
	static int[][] dirs = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// À§, ¾Æ, ¿Þ, ¿À
	static List<Shark> sharks = new ArrayList<>();
	static int[][][] arr;
	static int[][][] op;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		// nodes = new Node[n][n];
		arr = new int[n][n][2];
		op = new int[m + 1][4][4];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j][0] = num;
				if (num != 0) {
					arr[i][j][1] = k;
					sharks.add(new Shark(i, j, 0, num));
				}
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= m; i++) {
			int dir = Integer.parseInt(st.nextToken());
			for (int j = 0; j < sharks.size(); j++) {
				if (sharks.get(j).num == i) {
					sharks.get(j).d = dir;
					break;
				}
			}
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 4; k++) {
					op[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		Collections.sort(sharks);
		int time = 0;

		while (time <= 1000) {
			if (sharks.size() <= 1)
				break;

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(arr[i][j][1] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			smove();
			downsmell();
			time++;
			// ³¿»õ Ã¼Å© -1ÇÏ±â
			// »ó¾îÀÌµ¿

		}
		if (sharks.size() > 1)
			System.out.println(-1);
		else
			System.out.println(time);
	}

	public static void downsmell() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j][0] != 0) {
					arr[i][j][1]--;
					if (arr[i][j][1] == 0) {
						arr[i][j][0] = 0; // ºóÄ­ ¸¸µé±â
					}
				}
			}
		}
	}

	public static void smove() {
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = arr[i][j][0];
			}
		}
		outer: for (int i = 0; i < sharks.size(); i++) {
			Shark s = sharks.get(i);
			boolean c = false;
			boolean cc = false;
			// ºóÄ­ÀÌ ÀÖ´Â °æ¿ì

			// System.out.println(s.num + " " + s.d);
			for (int j = 0; j < op[s.num][s.d - 1].length; j++) {
				int nx = s.x + dirs[op[s.num][s.d - 1][j]][0];
				int ny = s.y + dirs[op[s.num][s.d - 1][j]][1];
				// System.out.println(nx + " " + ny + " d");
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (arr[nx][ny][0] == 0) {
					if (copy[nx][ny] != 0) {
						sharks.remove(s);
						continue outer;
					} else {
						copy[nx][ny] = s.num;
						arr[nx][ny][1] = k + 1;
						s.x = nx;
						s.y = ny;
						s.d = op[s.num][s.d - 1][j];
						c = true;
						break;
					}
				}
			}
			if (!c) {
				for (int j = 0; j < op[s.num][s.d - 1].length; j++) {
					int nx = s.x + dirs[op[s.num][s.d - 1][j]][0];
					int ny = s.y + dirs[op[s.num][s.d - 1][j]][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;
					if (copy[nx][ny] == s.num) {
						arr[nx][ny][1] = k + 1;
						s.x = nx;
						s.y = ny;
						s.d = op[s.num][s.d - 1][j];
						cc = true;
						break;
					}
				}
			}
			if (!c && !cc) {
				sharks.remove(s);
				return;
			}

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j][0] = copy[i][j];
			}
		}

	}
}
