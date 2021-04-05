package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ³¬½Ã¿Õ_17143_0327 {

	static class Shark implements Comparable<Shark> {
		int x, y, s, d, z;

		Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			return this.z - o.z;
		}
	}

	static int r, c, m, ans = 0;
	static Shark[][] arr;
	static int[][] dirs = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<Shark> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if (m == 0) {
			System.out.println(0);
			return;
		}
		arr = new Shark[r + 1][c + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(x, y, s, d, z);
			arr[x][y] = shark;
			list.add(shark);
		}
		for (int j = 1; j <= c; j++) {
			// System.out.println(list.size());
			for (int i = 1; i <= r; i++) {
				if (arr[i][j] != null) {
					ans += arr[i][j].z;
					list.remove(arr[i][j]);
					arr[i][j] = null;
					break;
				}
			}
			// »ó¾î ÀÌµ¿
			Collections.sort(list);
			smove();
		}
		System.out.println(ans);
	}

	public static void smove() {
		Shark[][] temp = new Shark[r + 1][c + 1];
		// for (int i = 1; i <= r; i++) {
		// for (int j = 1; j <= c; j++) {
		// temp[i][j] = arr[i][j];
		// }
		// }
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.size());
			Shark shark = list.get(i);
			int cx = shark.x;
			int cy = shark.y;
			// System.out.println(cx + " " + cy + " ds" + list.size());
			int nx = cx, ny = cy;
			for (int j = 0; j < shark.s; j++) {
				nx = nx + dirs[shark.d][0];
				ny = ny + dirs[shark.d][1];
				// System.out.println(nx + " " + ny);
				// && nx+dirs[shark.d][0]>=r || nx+dirs[shark.d][0]<=1)
				if (shark.d <= 2) {
					// if (nx == 1 || nx == r) {
					if (nx + dirs[shark.d][0] > r || nx + dirs[shark.d][0] < 1) {
						if (shark.d == 1)
							shark.d = 2;
						else if (shark.d == 2)
							shark.d = 1;
					}
				} else {
					// if (ny == 1 || ny == c) {
					if (ny + dirs[shark.d][1] > c || ny + dirs[shark.d][1] < 1) {
						if (shark.d == 3)
							shark.d = 4;
						else if (shark.d == 4)
							shark.d = 3;
					}
				}
			}

			// if (temp[nx][ny] != null) {
			// System.out.println(nx+" " +ny);
			// // System.out.println(temp[nx][ny].z);
			// // System.out.println(shark.z);
			// shark.x = nx;
			// shark.y = ny;
			// list.remove(temp[nx][ny]);
			// temp[cx][cy] = null;
			// temp[nx][ny] = shark;

			// } else {
			// System.out.println(nx+" " +ny);
			shark.x = nx;
			shark.y = ny;

			// list.remove(temp[nx][ny]);
			// temp[cx][cy] = null;
			temp[nx][ny] = shark;
			// }
		}
		list.clear();
		for (int i = 1; i <= r; i++) {
			for (int k = 1; k <= c; k++) {
				if (temp[i][k] == null) {
					// System.out.print("null");
				}
				if (temp[i][k] != null) {
					list.add(temp[i][k]);
					// System.out.print( temp[i][k].z +" " );
					// System.out.println(temp[i][k].x + " " + temp[i][k].y + " " + temp[i][k].z + "
					// " + temp[i][k].d);
				}
			}
		}
		// System.out.println();
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}

}
