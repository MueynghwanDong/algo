package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class °¡½º°ü_2931_0308_2 {

	static int r, c, sx, sy, ex, ey;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'M') {
					sx = i;
					sy = j;
				} else if (arr[i][j] == 'Z') {
					ex = i;
					ey = j;
				}
			}
		}
		fun(sx, sy, ex, ey);

	}

	public static void fun(int sx, int sy, int ex, int ey) {
		Queue<int[]> q = new LinkedList<>();
		brr[sx][sy] = true;
		for (int i = 0; i < dirs.length; i++) {
			int nx = sx + dirs[i][0];
			int ny = sy + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == '.')
				continue;

			q.add(new int[] { nx, ny });
			brr[nx][ny] = true;
			break;
		}

		while (!q.isEmpty()) {
			int t[] = q.poll();
			int cx = t[0];
			int cy = t[1];
			char curpip = arr[cx][cy];
			if (curpip == '.') {
				check(cx, cy);
				return;
			}
			switch (curpip) {
			case '|':
				for (int i = 0; i <= 1; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
						continue;
					q.add(new int[] { nx, ny });
					brr[nx][ny] = true;
				}
				break;
			case '-':
				for (int i = 2; i <= 3; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
						continue;
					q.add(new int[] { nx, ny });
					brr[nx][ny] = true;
				}
				break;
			case '+':
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
						continue;
					q.add(new int[] { nx, ny });
					brr[nx][ny] = true;
				}
				break;
			case '1':
				for (int i = 0; i < dirs.length; i++) {
					if (i == 1 || i == 2) {
						int nx = cx + dirs[i][0];
						int ny = cy + dirs[i][1];
						if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
							continue;
						q.add(new int[] { nx, ny });
						brr[nx][ny] = true;
					}
				}
				break;
			case '2':
				for (int i = 0; i < dirs.length; i++) {
					if (i == 0 || i == 2) {
						int nx = cx + dirs[i][0];
						int ny = cy + dirs[i][1];
						if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
							continue;
						q.add(new int[] { nx, ny });
						brr[nx][ny] = true;
					}
				}
				break;
			case '3':
				for (int i = 0; i < dirs.length; i++) {
					if (i == 0 || i == 3) {
						int nx = cx + dirs[i][0];
						int ny = cy + dirs[i][1];
						if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
							continue;
						q.add(new int[] { nx, ny });
						brr[nx][ny] = true;
					}
				}
				break;
			case '4':
				for (int i = 0; i < dirs.length; i++) {
					if (i == 1 || i == 3) {
						int nx = cx + dirs[i][0];
						int ny = cy + dirs[i][1];
						if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
							continue;
						q.add(new int[] { nx, ny });
						brr[nx][ny] = true;
					}
				}
				break;
			default:

			}
		}
	}

	public static void check(int x, int y) {
		// List<Character> list = new ArrayList<>();
		boolean[] b = new boolean[4];
		// System.out.println(x + " " + y + "sdd");

		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == '.' || arr[nx][ny] == 'Z')
				continue;
			if (i == 0) {
				if (arr[nx][ny] == '|' || arr[nx][ny] == '+' || arr[nx][ny] == '1' || arr[nx][ny] == '4') {
					b[i] = true;
				}
			} else if (i == 1) {
				if (arr[nx][ny] == '|' || arr[nx][ny] == '+' || arr[nx][ny] == '2' || arr[nx][ny] == '3') {
					b[i] = true;
				}
			} else if (i == 2) {
				if (arr[nx][ny] == '-' || arr[nx][ny] == '+' || arr[nx][ny] == '3' || arr[nx][ny] == '4') {
					b[i] = true;
				}
			} else if (i == 3) {
				if (arr[nx][ny] == '-' || arr[nx][ny] == '+' || arr[nx][ny] == '1' || arr[nx][ny] == '2') {
					b[i] = true;
				}
			}
			// System.out.println(nx + " " + ny);
		}
		if (b[0] && b[1] && !b[2] && !b[3]) {
			System.out.println((x + 1) + " " + (y + 1) + " " + "|");
		} else if (b[2] && b[3] && !b[0] && !b[1]) {
			System.out.println((x + 1) + " " + (y + 1) + " " + "-");
		} else if (b[1] && b[2] && !b[0] && !b[3]) {
			System.out.println((x + 1) + " " + (y + 1) + " " + "1");
		} else if (b[0] && b[2] && !b[1] && !b[3]) {
			System.out.println((x + 1) + " " + (y + 1) + " " + "2");
		} else if (b[0] && b[3] && !b[2] && !b[1]) {
			System.out.println((x + 1) + " " + (y + 1) + " " + "3");
		} else if (b[1] && b[3] && !b[2] && !b[0]) {
			System.out.println((x + 1) + " " + (y + 1) + " " + "4");
		} else if (b[0] && b[1] && b[2] && b[3]) {
			System.out.println((x + 1) + " " + (y + 1) + " " + "+");
		}
		return;

	}

}
