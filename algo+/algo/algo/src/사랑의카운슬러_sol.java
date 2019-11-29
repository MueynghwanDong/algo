import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
2
4
6 0
3 3
-7 2
-4 -1
2
-100000 100000
100000 -100000 */
public class 사랑의카운슬러_sol {

	private static int N;
	private static int[][] map;
	private static int sumx;
	private static int sumy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][2];
			min = Long.MAX_VALUE;
			sumx = 0;
			sumy = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				map[i][0] = Integer.parseInt(st.nextToken());
				sumx += map[i][0];
				map[i][1] = Integer.parseInt(st.nextToken());
				sumy += map[i][1];

			}
			a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			t = new int[N / 2];
			comb(N, N / 2, 0, 0);
			System.out.println(min);
		} // end of tc
	} // end of main

	public static int[] a;
	public static int[] t;
	private static long min;

	public static void comb(int n, int r, int selX, int selY) {
		if (r == 0) {
			long unselX = sumx - selX;
			long unselY = sumy - selY;
			long result = (selX - unselX) * (selX - unselX) + (selY - unselY) * (selY - unselY);
			if (min > result)
				min = result;
			// return;
		} else if (n < r) {
			return;
		} else {
			t[r - 1] = a[n - 1];
			comb(n - 1, r - 1, selX + map[n - 1][0], selY + map[n - 1][1]); // 현재 뽑은 것을 사용하는 경우
			comb(n - 1, r, selX, selY); // 현재 뽑은 것을 사용안하고 다시 뽑는 경우
		}
	}
} // end of class
