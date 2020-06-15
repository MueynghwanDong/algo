import java.util.Arrays;
import java.util.Scanner;

public class swea_4050 {
	static int result;
	private static int[] arr;
	private static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testCase = 1; testCase <= t; testCase++) {
			int n = sc.nextInt();
			sum = 0;
			result = Integer.MAX_VALUE;
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			if (arr.length % 3 == 0) {
				for (int i = 0; i < arr.length; i++) {
					if (i % 3 != 0)
						sum += arr[i];
				}
			} else {
				int k = arr.length %3;
				for (int i = 0; i < arr.length; i++) {
					if (i % 3 != k)
						sum += arr[i];
				}
			}
			// perm(0);
			System.out.println("#" + testCase + " " + sum);

		}
	}
}