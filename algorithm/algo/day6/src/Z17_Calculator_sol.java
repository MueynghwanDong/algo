import java.util.Scanner;

/**
 * 계산기 3 + 4 * 2 + 7 * 2
 */
public class Z17_Calculator_sol {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int[] s = new int[9];
		int top = -1;

		String[] str = sc.nextLine().split(" ");
		s[++top] = Integer.parseInt(str[0]); // 첫번째 피연산자
		for (int i = 1; i < str.length; i += 2) { // 연산자, 피연산자
			char op = str[i].charAt(0); // 연산자
			int num = Integer.parseInt(str[i + 1]); // 숫자
			if(op == '+') {// 숫자는 스택에 넣기
				s[++top] = num;
			}else { // * 스택에서 숫자꺼내 곱셉 연산후, 숫자를 스택에 넣기
				int pre = s[top--];
				s[++top] = pre * num;
			}
		}
		int result = 0; // 덧셈 연산자에 대해 항등원으로 초기화
		for (int i = 0; i <= top; i++) {
			result += s[i];
		}
		System.out.println(result);

	} // end of main
} // end of class
