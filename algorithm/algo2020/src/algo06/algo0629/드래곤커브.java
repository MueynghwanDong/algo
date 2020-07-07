package algo06.algo0629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브 {

	static final int len = 101;
	static boolean[][] brr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		brr = new boolean[len][len];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			moving(x, y, d, g);
		}
		CountOfSquare();
	}

	public static void moving(int x, int y, int d, int g) { // 이부분이 핵심, 방향 따라 brr 배값 true해주기
		List<Integer> directions = new ArrayList<>();
		directions.add(d);
		for (int i = g; i > 0; i--) {
			for (int j = directions.size() - 1; j >= 0; j--) {
				int dir = (directions.get(j) + 1) % 4;
				directions.add(dir);
			}
		}

		brr[x][y] = true;
		for (int direction : directions) {
			if (direction == 0) {
				brr[++x][y] = true;
			} else if (direction == 1) {
				brr[x][--y] = true;
			} else if (direction == 2) {
				brr[--x][y] = true;
			} else {
				brr[x][++y] = true;
			}
		}
	}

	public static int CountOfSquare() {
		int cnt = 0;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1; j++) {
				if (brr[i][j] && brr[i + 1][j] && brr[i][j + 1] && brr[i + 1][j + 1])
					cnt++;
			}
		}
		System.out.println(cnt);
		return cnt;
	}
}
