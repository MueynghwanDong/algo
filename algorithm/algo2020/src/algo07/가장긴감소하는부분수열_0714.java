package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열_0714 {

	static int n;
	static int[] arr;
	static int[] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		d[0] = 1;
		for (int i = 1; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j] && d[i] <= d[j])
					d[i] = d[j] + 1;

			}
		}
		int max = 0;
		for (int i : d) {
			if (max < i)
				max = i;
		}

		System.out.println(max);
	}

}
