package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class °úÁ¦_13904_0211_2 {

	static int n, ans = 0;
	static int[] result;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		result = new int[1001];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
		});
		// for (int i = 0; i < n; i++) {
		// System.out.println(arr[i][0] +" " + arr[i][1]);
		// }
		for (int i = 0; i < n; i++) {
			for (int j = arr[i][0]; j > 0; j--) {

				if (result[j] == 0) {
					result[j] = arr[i][1];
					break;
				}
			}
		}

		int sum = 0;
		for (int temp : result) {
			sum += temp;
		}
	
		System.out.println(sum);

	}
}
