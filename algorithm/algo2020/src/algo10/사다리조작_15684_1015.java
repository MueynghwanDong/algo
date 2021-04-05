package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작_15684_1015 {

	static int N;
	static int M;
	static int H;
	// static int ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H + 1][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;
			map[a][b + 1] = -1;
		}
		if (searchOdd() > 3) {
			System.out.println("-1");
			return;
		} else {
			for (int i = 0; i <= 3; i++) {
				if (dfs(0, 0, 0, i))
					return;
			}
		}
		System.out.println("-1");

	}

	public static boolean dfs(int x, int y, int cnt, int size) {

		if (cnt == size) {
			if (check()) {
				System.out.println(size);
				return true;
			}
			return false;
		}
		for (int i = x; i < H; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] != 0 || map[i][j + 1] != 0)
					continue;
				map[i][j] = 1;
				map[i][j + 1] = -1;
				if(dfs(i, j + 2, cnt + 1, size)) return true;
				map[i][j] = 0;
				map[i][j + 1] = 0;
			}
		}
		return false;
	}

	public static boolean check() {
		for (int i = 0; i < N; i++) {
			int x = 0;
			int y = i;
			while (x <= H) {
				if (map[x][y] == 1)
					y++;
				else if (map[x][y] == -1)
					y--;
				x++;
			}
			if (y != i)
				return false;
		}
		return true;
	}

	public static int searchOdd() {
		int odd = 0;
		for (int i = 0; i < N - 1; i++) {
			int num = 0;
			for (int j = 0; j < H; j++)
				if (map[j][i] == 1)
					num++;
			if (num % 2 == 1)
				odd++;

		}
		return odd;
	}

}
