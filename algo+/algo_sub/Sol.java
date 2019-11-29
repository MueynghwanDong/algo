import java.util.Scanner;

public class Sol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {

			long n = sc.nextLong();
			long maxnum = 0;
			long minnum = 0;
			long ss = n * n;
			long ss2 = (n - 1) * (n - 1);
			maxnum = 2l * (ss) - 1l;
			minnum = 2l * (ss2 + 1l) - 1l;
			System.out.println("#" + testCase + " " + minnum + " " + maxnum);
		}

	}

}
