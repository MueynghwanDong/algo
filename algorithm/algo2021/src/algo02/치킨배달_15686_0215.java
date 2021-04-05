package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달_15686_0215 {

	static int n, m, result = Integer.MAX_VALUE;
	static int arr[][];
	static int[] trr;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					list.add(new int[] { i, j });
			}
		}
		trr = new int[m];
		comb(list.size(), m);
		System.out.println(result);

	}

	public static void comb(int idx, int r) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < m; i++) {
				int[] temp = list.get(trr[i]);
				int nx = temp[0];
				int ny = temp[1];
				arr[nx][ny] = 3;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						int val = cal_distanse(i, j);
						sum += val;
					}
				}
			}

			for (int i = 0; i < m; i++) {
				int[] temp = list.get(trr[i]);
				int nx = temp[0];
				int ny = temp[1];
				arr[nx][ny] = 2;
			}
			if (result > sum)
				result = sum;
			return;

		} else if (idx < r) {
			return;
		} else {
			trr[r - 1] = idx - 1;
			comb(idx - 1, r - 1);
			comb(idx - 1, r);
		}
	}

	public static int cal_distanse(int x, int y) {
		int re = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 3) {
					int temp = Math.abs(x - i) + Math.abs(y - j);
					if (re > temp)
						re = temp;
				}
			}
		}
		return re;
	}

}
