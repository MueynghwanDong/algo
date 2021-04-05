package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선발명단_3980_0114 {

	static int[][] arr;
	static boolean[] brr;
	static int max = 0;
	static int t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int test = 0; test < t; test++) {
			max = 0;
			arr = new int[11][11];
			brr = new boolean[11];
			for (int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 11; i++) {
				if (arr[0][i] != 0) {
					brr[i] = true;
					dfs(1, arr[0][i]);
					brr[i] = false;
				}
			}
			System.out.println(max);
		}
	}

	public static void dfs(int cnt, int val) {
		if (cnt == 11) {
			if (max < val)
				max = val;
			return;
		}
		for (int i = 0; i < 11; i++) {
			if (arr[cnt][i] != 0 && !brr[i]) {
				brr[i] = true;
				dfs(cnt + 1, val + arr[cnt][i]);
				brr[i] = false;
			}
		}
	}

}
