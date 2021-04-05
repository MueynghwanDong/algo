package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피리부는사나이_16724_1203_실패 {

	static int n, m;
	static int[][] arr;
	static int[][] check;
	static boolean[][] brr;
	static int cnt;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new int[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				char d = str.charAt(j);
				if (d == 'U')
					arr[i][j] = 0;
				else if (d == 'D')
					arr[i][j] = 1;
				else if (d == 'L')
					arr[i][j] = 2;
				else
					arr[i][j] = 3;
				check[i][j] = -1;
			}
		}
		// UDLR
		cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!brr[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(check[i][j]);
//			}
//			System.out.println();
//		}
		 System.out.println(cnt);

	}

	public static void dfs(int x, int y) {
		// if(check[x][y] != -1) return check[x][y];
		// int ret = check[x][y];
		// check[x][y] = cnt;
		// int d = arr[x][y];
		//
		// int nx = x + dirs[d][0];
		// int ny = y + dirs[d][1];
		// ret = dfs(nx,ny);
		// check[x][y] = ret;
		// return check[x][y];

		brr[x][y] = true;
		int d = arr[x][y];
		int nx = x + dirs[d][0];
		int ny = y + dirs[d][1];
		int nd = arr[nx][ny];
		if ((d == 0 && nd == 1) || (d == 1 && nd == 0) || (d == 2 && nd == 3) || (d == 3 && nd == 2)) {
			// System.out.println(x+" " + y);
			brr[nx][ny] = true;
			return;
		}
		if (brr[nx][ny]) {
			// System.out.println(x+" " + y);
			return;
		}
		if (!brr[nx][ny]) {
			dfs(nx, ny);
		}

	}

}
