import java.util.Scanner;

public class Solution_1224_SW문제해결기본6일차_계산기3_동명환 {

	static char[] crr;
	static int[] irr;
	static int itop = -1;
	static int ctop =-1;
	public static void cal(char c) {
		if (c == '*') {
			int num2 = irr[itop--];
			int num1 = irr[itop--];
			int reuslt = num1 * num2;
			irr[++itop] = reuslt;
		} else {
			int num2 = irr[itop--];
			int num1 = irr[itop--];
			int reuslt = num1 + num2;
			irr[++itop] = reuslt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			int num = sc.nextInt();
			String s = sc.next();
			crr = new char[s.length()];
			irr = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch (c) {
				case '(':
					crr[++ctop] = c;
					break;
				case '*':
					while (ctop >= 0 && itop >= 0 && crr[ctop] == '*') {
						char c1 = crr[ctop--];
						cal(c1);
					}
					crr[++ctop] = c;
					break;
				case '+':
					while (ctop >= 0 && itop >= 0 && !(crr[ctop] == '(')) {
						char c1 = crr[ctop--];
						cal(c1);
					}
					crr[++ctop] = c;
					break;
				case ')':
					while (ctop >= 0 && itop >= 0 && !(crr[ctop] == '(')) {
						char c1 = crr[ctop--];
						cal(c1);
					}
					if (crr[ctop] == '(')
						ctop--;
					break;
				default:
					irr[++itop] = c - '0';
					break;
				}
			}
			System.out.println("# " + testCase + " " + irr[itop]);
		} // end of testCase
	}
}