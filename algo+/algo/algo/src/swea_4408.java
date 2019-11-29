import java.util.Arrays;
import java.util.Scanner;

public class swea_4408 {

	private static int[] start;
	private static int[] end;
	private static int cnt;
	private static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {

			n = sc.nextInt();
			start = new int[n];
			end = new int[n];
			for (int j = 0; j < end.length; j++) {
				start[j] = sc.nextInt();
				end[j] = sc.nextInt();
			} // 입력
			cnt = 1;
			int arr[] = new int[401];
			for (int j = 0; j < n; j++) {
				boolean check = false;
				if (j == 0) {
					for (int k = start[0]; k <= end[0]; k++) {
						arr[k] = cnt;
					}
				} else {
					check = false;
					for (int k = start[j]; k <= end[j]; k++) {
						if (arr[k] != 0) {
							check = true;
						} else {
							arr[k] = cnt;
						}

					}
				}
				if (check)
					cnt++;
			}
			System.out.println(Arrays.toString(arr));
			System.out.println("#" + i + " " + cnt);

		}
	}
}
