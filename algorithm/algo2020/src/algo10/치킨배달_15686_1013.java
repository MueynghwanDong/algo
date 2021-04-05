package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달_15686_1013 {

	static int[][] arr;
	static int[] trr;
	static int k;
	static int n;
	static int tsum;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list.add(new int[] { i, j });
				}
			}
		}
		//
		tsum = Integer.MAX_VALUE;
		trr = new int[list.size()];

		comb(list.size(), k);
		System.out.println(tsum);
	}

	public static void comb(int idx, int r) {
		// 2의 갯수 중 k개 선택
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < k; i++) {
				int[] temp = list.get(trr[i]);
				int nx = temp[0];
				int ny = temp[1];
				arr[nx][ny] = 3;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						int re = fun(i, j);
						sum += re;
					}
				}
			}
			for (int i = 0; i < k; i++) {
				int[] temp = list.get(trr[i]);
				int nx = temp[0];
				int ny = temp[1];
				arr[nx][ny] = 2;
			}
			if (tsum > sum)
				tsum = sum;
		} else if (idx < r)
			return;
		else {
			trr[r - 1] = idx - 1;
			comb(idx - 1, r - 1);
			comb(idx - 1, r);
		}
	}

	public static int fun(int x, int y) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 3) {
					int temp = Math.abs(x - i) + Math.abs(y - j);
					if (result > temp)
						result = temp;
				}
			}

		}
		return result;
	}
}
