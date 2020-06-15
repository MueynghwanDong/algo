import java.util.Scanner;

public class Solution_1223_SW문제해결기본6일차_계산기2_동명환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = sc.nextInt();
			String s = sc.next();
			int top = -1;
			int[] st = new int[n];
			st[++top] = s.charAt(0) - '0';
			for (int i = 1; i < s.length(); i = i + 2) {
				char op = s.charAt(i);
				int num = s.charAt(i + 1) - '0';
				if (op == '+') {
					st[++top] = num;
				} else {
					int pre = st[top--];
					st[++top] = pre * num;
				}
			}
			int result = 0;
			for (int i = 0; i < st.length; i++) {
				result += st[i];
			}
			System.out.println("#" + testCase + " " + result);
		} // end of test case
	}
}