import java.util.Scanner;

public class swea_1206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			boolean flag = false;
			int max = 0;
			int n = sc.nextInt();
			int cnt = 0;
			int arr[] = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 2; i < arr.length - 2; i++) {
				max = 0;
				if (arr[i - 1] > arr[i] || arr[i - 2] > arr[i] || arr[i + 1] > arr[i] || arr[i + 2] > arr[i]) {
					flag = false;
					// continue;
				} else {
					for (int j = 1; j <= 2; j++) {
						if (arr[i - j] > max)
							max = arr[i - j];
						if (arr[i + j] > max)
							max = arr[i + j];
					}
					flag = true;
				}
				if (flag)
					cnt = cnt + (arr[i] - max);
			}
			System.out.println("#" + testCase + " " + cnt);
		} // end of testCase

	}
}
