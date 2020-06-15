import java.util.Scanner;

public class Solution_3459_승자예측하기_동명환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			long n = sc.nextLong();
			long num = 1;
			long step = 4;
			int r = 0;
			if (n != 1) {
				while (num <= n) {
					num = num + step;
					r = 1;
					if (num >= n)
						break;
					num = num + step;
					r = 0;
					if (num >= n)
						break;
					step *= 4;
				}
			}
			if (r == 1) {
				System.out.println("#" + testCase + " " + "Alice");
			} else {
				System.out.println("#" + testCase + " " + "Bob");
			}
		}
	}
}