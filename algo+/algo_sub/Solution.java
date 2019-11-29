import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testCase = 1; testCase <= t; testCase++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}

			int sum = 0;
			int temp = n / 2;
			for (int i = 0; i < temp; i++) {
				for (int j = temp - i; j <= temp + i; j++) {
					sum += arr[i][j];
				}
			}
			for (int i = n - 1; i >= temp; i--) {
				for (int j = i - temp; j <= (n - 1) - i + temp; j++) {
					sum += arr[i][j];
				}
			}
			System.out.println("#" + testCase + " " + sum);
		}

	}

}
