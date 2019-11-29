import java.util.Scanner;

public class swea_8104 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int data = 1;
			int arr[][] = new int[r][c];
			String s = "";
			for (int i = 0; i < r; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < c; j++) {
						arr[i][j] = data++;
					}
				} else if (i % 2 == 1) {
					for (int j = c - 1; j >= 0; j--) {
						arr[i][j] = data++;
					}
				}
			}
			for (int i = 0; i < c; i++) {
				int sum = 0;
				for (int j = 0; j < r; j++) {
					sum += arr[j][i];
				}
				s = s + sum + " ";
			}
			System.out.println("#" + testCase + " " + s);
		}

	}

}
