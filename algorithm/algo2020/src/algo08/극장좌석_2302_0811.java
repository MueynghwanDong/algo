package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ±ÿ¿Â¡¬ºÆ_2302_0811 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[41];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
		}
		int end = 0;
		int start = 0;
		int result = 1;
		for (int i = 0; i < m; i++) {
			end = Integer.parseInt(br.readLine());
			result *= arr[end - start - 1];
			start = end;
		}
		result *= arr[n - end];

		System.out.println(result);
	}

}
