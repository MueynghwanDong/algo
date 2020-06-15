import java.util.Scanner;

public class Solution_1218_SW문제해결기본4일차_괄호짝짓기_동명환 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			int num = sc.nextInt();
			String s = sc.next();
			int top = -1;
			char[] arr = new char[s.length()];
			for (int i = 0; i < arr.length; i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '<' || s.charAt(i) == '[') {
					arr[++top] = s.charAt(i);
				} else {
					if (s.charAt(i) == ')') {
						if (arr[top] == '(') {
							top--;
						} else
							break;
					} else if (s.charAt(i) == '}') {
						if (arr[top] == '{') {
							top--;
						} else
							break;
					} else if (s.charAt(i) == '>') {
						if (arr[top] == '<') {
							top--;
						} else
							break;
					} else if (s.charAt(i) == ']') {
						if (arr[top] == '[') {
							top--;
						} else
							break;
					}
				}
			}
			if (top != -1)
				System.out.println("#" + testCase + " " + 0);
			if (top == -1)
				System.out.println("#" + testCase + " " + 1);
		}
	}
}