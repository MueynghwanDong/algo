package algo0628;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {

	static int n;
	static int l;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int g[] = new int[n];
			int s[] = new int[n];
			for (int j = 0; j < n; j++) {
				g[j] = arr[i][j];
				s[j] = arr[j][i];
			}

			if (checking(g)) {
				cnt++;
			}
			if (checking(s)) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	public static boolean checking(int[] temp) {

		// for (int i = 0; i < temp.length; i++) {
		// System.out.print(temp[i] + " ");
		// }
		// System.out.println();
		boolean c = true;
		boolean[] check = new boolean[temp.length];
		outer: for (int i = 0; i < temp.length; i++) {
			if (i + 1 >= n) {
				break;
			}
			if (temp[i] != temp[i + 1]) {

				if (temp[i] > temp[i + 1]) {
					if (i + l >= n) {
						c = false;
						break;
					}
					for (int j = i + 1; j <= i + l; j++) {
						if ((temp[i] - 1) != temp[j]) {
							c = false;
							break outer;
						}
					}
					for (int j = i + 1; j <= i + l; j++) {
						if (check[j]) {
							c = false;
							break outer;
						}
						check[j] = true;
					}
					i = i + l - 1;
				} else {
					if (i - l + 1 < 0) {
						c = false;
						break;
					}
					for (int j = i; j > i - l; j--) {
						if ((temp[i + 1] - 1) != temp[j]) {
							c = false;
							break outer;
						}
					}
					for (int j = i; j > i - l; j--) {
						if (check[j]) {
							c = false;
							break outer;
						}
						check[j] = true;
					}
				}
			}

		}
		return c;
	}
}
