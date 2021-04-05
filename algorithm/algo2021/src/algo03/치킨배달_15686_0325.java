package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달_15686_0325 {

	static int[][] arr;
	static int[] trr;
	static int n, m, result = Integer.MAX_VALUE;
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
				// 치킨집 리스트에 추가하기
				if (arr[i][j] == 2)
					list.add(new int[] { i, j });
			}
		}
		trr = new int[m];
		comb(list.size(), m);
		System.out.println(result);

	}

	public static void comb(int idx, int r) {
		// 조합으로 전체 치킨집에서 m개만 추출
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < m; i++) {
				int[] t = list.get(trr[i]);
				arr[t[0]][t[1]] = 3;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						int val = cal_distance(i, j);
						sum += val;
					}
				}
			}

			for (int i = 0; i < m; i++) {
				int[] t = list.get(trr[i]);
				arr[t[0]][t[1]] = 2;
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

	public static int cal_distance(int x, int y) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 3) {
					int re = Math.abs(x - i) + Math.abs(y - j);
					if (ans > re)
						ans = re;
				}
			}
		}

		return ans;
	}

}
