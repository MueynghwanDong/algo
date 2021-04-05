package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이조각_14391_0220_2 {

	static int n, m;
	static int[] arr;
	static boolean[] brr;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n * m];
		brr = new boolean[n * m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i * m + j] = str.charAt(j) - '0';
			}
		}
		fun(0);
		System.out.println(ans);

	}

	public static void fun(int idx) {
		if (idx == n * m) {
			cal();
			return;
		}
		brr[idx] = true;
		fun(idx + 1);
		brr[idx] = false;
		fun(idx + 1);
	}

	public static void cal() {
		int temp = 0;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			temp = 0;
			for (int j = 0; j < m; j++) {
				if (brr[i * m + j]) {
					temp *= 10;
					temp += arr[i * m + j];
				} else {
					ret += temp;
					temp = 0;
				}
			}
			ret += temp;
		}

		for (int i = 0; i < m; i++) {
			temp = 0;
			for (int j = 0; j < n; j++) {
				if (!brr[j * m + i]) {
					temp *= 10;
					temp += arr[j * m + i];
				} else {
					ret += temp;
					temp = 0;
				}
			}
			ret += temp;
		}
		ans = Math.max(ans, ret);
	}

}
