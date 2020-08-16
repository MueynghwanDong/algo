package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501_0725 {

	static int[] arr;
	static int n;
	static int max;
	static int[] brr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		brr = new int[n];
		max = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			brr[i] = Integer.parseInt(st.nextToken());
		}
		fun(0, 0);
		System.out.println(max);
	}

	public static void fun(int d, int m) {

		if (d >= n) { // n일 이후
			max = Math.max(m, max);
			return;
		}

		if (d + arr[d] <= n) { // 추가로 일할 수 있는 경우
			fun(d + arr[d], m + brr[d]);
		}
		// 일 안하고 다음날로 넘어가는 경우
		fun(d + 1, m);
	}

}
