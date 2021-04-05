package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선발명단_3980_1026 {

	static boolean[] brr;
	static int[][] arr;
	static int t;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int k = 0; k < t; k++) {
			max = 0;
			arr = new int[11][11];
			brr = new boolean[11];
			for (int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < brr.length; i++) {
				if (arr[0][i] != 0) {
					brr[i] = true;
					dfs(1, arr[0][i]);
					brr[i] = false;
				}
			}
			System.out.println(max);
		}
	}

	public static void dfs(int cnt, int sum) {
		// System.out.println(cnt+" " + sum);
		if (cnt == 11) {
			if (max < sum)
				max = sum;
			// System.out.println(sum);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[cnt][i] != 0 && !brr[i]) {
				brr[i] = true;
				dfs(cnt + 1, sum + arr[cnt][i]);
				brr[i] = false;
			}
		}
	}

}
