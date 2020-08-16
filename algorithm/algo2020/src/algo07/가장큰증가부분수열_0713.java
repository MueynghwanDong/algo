package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가부분수열_0713 {

	static int n;
	static int[] arr;
	static int[] sum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		sum = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i];
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					sum[i] = Math.max(sum[j] + arr[i], sum[i]);
				}
			}
			if (max < sum[i])
				max = sum[i];
		}
		// for (int i = 0; i < sum.length; i++) {
		// System.out.print(sum[i] + " ");
		// }
		System.out.println(max);
	}

}
