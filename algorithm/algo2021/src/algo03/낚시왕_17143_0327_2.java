package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ³¬½Ã¿Õ_17143_0327_2 {

	static class Shark {
		int x, y, s, d, z;

		Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int r, c, m, ans = 0, scnt = 0;
	static int[][] arr, arr2;
	static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static Queue<Shark> q = new LinkedList<>();

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
		arr = new int[r + 1][c + 2];
		arr2 = new int[r + 1][c + 2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if (d == 1)
				d = 0;
			else if (d == 4)
				d = 1;
			q.add(new Shark(x, y, s, d, z));
			arr[x][y] = z;
		}
		int max = 0;
		while (max <= c) {
			if (m == 0 || m == scnt)
				break;
			max++;
			if (max % 2 == 1) {
				for (int i = 1; i <= r; i++) {
					if (arr[i][max] != 0) {
						ans += arr[i][max];
						arr[i][max] = 0;
						scnt++;
						break;
					}
				}
				smove(arr, arr2);
			} else {
				for (int i = 1; i <= r; i++) {
					if (arr2[i][max] != 0) {
						ans += arr2[i][max];
						arr2[i][max] = 0;
						scnt++;
						break;
					}
				}
				smove(arr2, arr);
			}
		}
		System.out.println(ans);
	}

	public static void smove(int[][] pre, int[][] now) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Shark temp = q.poll();
			if (pre[temp.x][temp.y] != temp.z)
				continue;
			int nx = temp.x;
			int ny = temp.y;
			int d = temp.d;
			int dist = temp.s;
			int z = temp.z;
			if (d == 0 || d == 2)
				dist = dist % ((r - 1) * 2);
			else
				dist = dist % ((c - 1) * 2);
			for (int j = 0; j < dist; j++) {
				if (nx + dirs[d][0] <= 0 || nx + dirs[d][0] >= r + 1 || ny + dirs[d][1] <= 0
						|| ny + dirs[d][1] >= c + 1)
					d = (d + 2) % 4;
				nx += dirs[d][0];
				ny += dirs[d][1];
			}
			if (now[nx][ny] > z)
				continue;
			now[nx][ny] = z;
			q.add(new Shark(nx, ny, dist, d, z));

			pre[temp.x][temp.y] = 0;
		}

	}

}
