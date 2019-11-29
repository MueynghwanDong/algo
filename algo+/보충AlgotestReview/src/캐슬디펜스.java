import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 캐슬디펜스 {

	private static int N;
	private static int M;
	private static int[][] arr;
	private static int D;
	private static boolean[] temp;
	private static int[][] arr2;
	private static int killpoint;
	private static int count;
	private static int max;
	static int location; // 성의 위치

	static class pos implements Comparable<pos> {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pos o) {
			return this.x - o.x;
		}
	}

	public static void shot() { // 궁수가 공격하는 메서드 // 여럿일 경우 생각해줘야함..
		for (int i = 0; i < M; i++) {
			if (arr2[N][i] == 3) {
				pos[] kill = new pos[2 * D - 1];
				int index = 0;
				for (int tt = D; tt >= 1; tt--) {

					for (int j = 1; j < tt; j++) {
						if (arr2[N - j][i - (tt - j)] < 0 || arr2[N - j][i - (tt - j)] >= M)
							continue;
						if (arr2[N - j][i - (tt - j)] == 1) {
							kill[index++] = new pos(N - j, i - (tt - j));
							// arr2[N - j][i - (D - j)] = 0;
							// killpoint++;
						}
					}
					if (arr2[N - tt][i] == 1) {
						kill[index++] = new pos(N - tt, i);
						// arr2[N - D][i] = 0;
						// killpoint++;
					}
				}
				if (index > 0) {
					Arrays.sort(kill);
				}
				for (int j = 0; j < kill.length; j++) {
					if (kill[j] != null) {
						arr2[kill[0].x][kill[0].y] = 0;
						killpoint++;
						count--;
					}
					break;
				}

			}
		}
	}

	public static void move() { // 적 이동하는 메서드
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (arr2[N - 1][i] == 1)
				cnt++;
		}
		for (int r = N - 2; r > 0; r--) { // 마지막행부터 올리기
			for (int c = 0; c < M; c++) {
				arr2[r + 1][c] = arr2[r][c];

			}
		}
		for (int c = 0; c < M; c++) {
			arr2[0][c] = 0; // 윗줄은 0으로 초기화
		}
		count = count - cnt;
	}

	public static void comb(int n, int r) { // 궁수 위치 찾는 메서드
		if (r == 0) {
			// System.out.println(Arrays.toString(temp));
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = arr[i].clone();
			}
			for (int i = 0; i < temp.length; i++) {
				if (temp[i]) {
					arr2[N][i] = 3; // 궁수
				}
			}
//			for (int i = 0; i < N+1; i++) {
//				System.out.println(Arrays.toString(arr2[i]));
//			}
			killpoint = 0;
			// System.out.println("aaa");
			while (count >= 0) {
				if (count == 0)
					break;
				shot();
				move();
			}
			if (killpoint > max) {
				max = killpoint;
			}
		} else if (n < r) {
			return;
		} else {
			temp[n - 1] = true;
			comb(n - 1, r - 1);
			temp[n - 1] = false;
			comb(n - 1, r);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M];
		arr2 = new int[N + 1][M];
		temp = new boolean[M];
		killpoint = 0;
		count = 0;
		max = 0;
		location = N;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					count++;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			arr[N][i] = 2;// 성
		}
		comb(temp.length, 3);
		System.out.println(max);
	}

}
