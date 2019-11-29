import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			Long num = sc.nextLong();
			while (true) {
				if (num > 3) {
					if (num % 2l == 0) {
						num = num / 2l;
					} else if (num % 2l == 1) {
						num = num / 2l + 1;
					}
				} else {
					if (num % 2l == 0) {
						System.out.println("Bob");
					} else {
						System.out.println("Alice");
					}
					break;
				}

			}

		}

	}

}
