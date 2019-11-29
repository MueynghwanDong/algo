import java.util.Scanner;

public class swea_7810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {

			int n = sc.nextInt();
			int arr[] = new int[n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > max)
					max = arr[i];
			}
			int r = 0;
			while (max >= 0) {
				int temp = 0;
				int result = 0;
				for (int i = 0; i < arr.length; i++) {
					if (max <= arr[i])
						temp++;
				}
				if (temp >= max)
					result = max;
				if (r < result) {
					r = result;
				}
				max--;
			}
			System.out.println("#" + testCase + " " +r);
		}
	}

}
