import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1258_행렬찾기_동명환 {

	private static int[][] arr;
	private static int n;
	private static boolean[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int rmax;
	static int cmax;

	public static class rc {
		int r;
		int c;

		public rc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < dirs.length; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= n || newy >= n)
				continue;
			if (!brr[newx][newy]) {
				if (rmax < newx)
					rmax = newx;
				if (cmax < newy)
					cmax = newy;
				brr[newx][newy] = true;
				dfs(newx, newy);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int testCase = 1; testCase <= t; testCase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			brr = new boolean[n][n];
			int count = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 0)
						brr[i][j] = true;
				}
			}
			int index = 0;
			int[] rr = new int[n];
			int[] cc = new int[n];

			for (int i = 0; i < n; i++) {
				int j;
				for (j = 0; j < n; j++) {
					if (!brr[i][j]) {
						brr[i][j] = true;
						rmax = 0;
						cmax = 0;
						dfs(i, j);
						rr[index] = rmax - i + 1;
						cc[index] = cmax - j + 1;
						index++;
						count++;
					}

				}
			}
			rc[] rcrr = new rc[index];
			for (int i = 0; i < rcrr.length; i++) {
				rcrr[i] = new rc(rr[i], cc[i]);
			}
			Arrays.sort(rcrr, new Comparator<rc>() {
				@Override
				public int compare(rc o1, rc o2) {
					if (o1.r * o1.c == o2.r * o2.c) {
						return o1.r - o2.r;
					} else
						return o1.r * o1.c - o2.r * o2.c;
				}
			});
			System.out.print("#" + testCase + " " + count + " ");
			for (int i = 0; i < index; i++) {
				System.out.print(rcrr[i].r + " " + rcrr[i].c + " ");
			}
			System.out.println();
		}
	}
}