package algo03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어른상어_19237_0302_2 {
	public static class Arr {
		int sharknum;
		int smell;

		Arr(int sharknum, int smell) {
			this.sharknum = sharknum;
			this.smell = smell;
		}
	}

	public static class Shark {
		int x, y, d;
		int[][] posPrioriny;
		boolean isAlive;

		Shark(int x, int y) {
			this.x = x;
			this.y = y;
			this.d = 0;
			this.posPrioriny = new int[5][5];
			this.isAlive = true;
		}

	}

	public static int n, m, k;
	public static Arr arr[][];
	public static int dy[] = { 0, 0, 0, -1, 1 };
	public static int dx[] = { 0, -1, 1, 0, 0 }; // 위, 아래, 왼쪽, 오른쪽

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new Arr[n][n];
		Shark[] sharks = new Shark[m + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = new Arr(Integer.parseInt(st.nextToken()), -1);

				if (arr[i][j].sharknum != 0) {
					sharks[arr[i][j].sharknum] = new Shark(i, j);
					arr[i][j].smell = k;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			sharks[i].d = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= 4; k++) {
					sharks[i].posPrioriny[j][k] = Integer.parseInt(st.nextToken());
				}
			}

		}
		int time = 0;
		while (time < 1001) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j].smell--;
				}
			} // 냄새 하나씩 줄이고
			int sharkcount = 0;
			aa: for (int i = m; i > 0; i--) {
				if (!sharks[i].isAlive)
					continue;
				if (arr[sharks[i].x][sharks[i].y].sharknum != i) {
					sharks[i].isAlive = false;
					continue;
				}

				sharkcount++;
				int ny = 0, nx = 0;

				int sd = sharks[i].d;
				for (int j = 1; j <= 4; j++) {
					int pps = sharks[i].posPrioriny[sd][j];
					nx = sharks[i].x + dx[pps];
					ny = sharks[i].y + dy[pps];
					if (ny < 0 || nx < 0 || ny >= n || nx >= n)
						continue;

					if (arr[nx][ny].smell < 0) {

						sharks[i].x = nx;
						sharks[i].y = ny;
						sharks[i].d = pps;
						continue aa;
					}
				}

				sd = sharks[i].d;
				for (int j = 1; j <= 4; j++) {
					int pps = sharks[i].posPrioriny[sd][j];
					nx = sharks[i].x + dx[pps];
					ny = sharks[i].y + dy[pps];
					if (ny < 0 || nx < 0 || ny >= n || nx >= n)
						continue;

					if (arr[nx][ny].sharknum == i && arr[nx][ny].smell >= 0) {

						sharks[i].y = ny;
						sharks[i].x = nx;
						sharks[i].d = pps;
						continue aa;

					}
				}

			} // 상어들 이동
			for (int i = m; i > 0; i--) {
				if (!sharks[i].isAlive)
					continue;
				arr[sharks[i].x][sharks[i].y].smell = k;
				arr[sharks[i].x][sharks[i].y].sharknum = i;
			}

			if (sharkcount == 1)
				break;
			time++;
		}
		if (time > 1000) {
			System.out.println(-1);
		} else
			System.out.println(time);

	}

}