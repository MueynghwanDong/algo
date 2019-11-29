import java.util.Stack;

/**
 * 계산기2 중위표기식을 후위표기식으로 변환하기
 * 
 * @author student
 * 
 *         토큰 isp icp 
 *         ============
 *           ) | -   - 
 *          *,/| 2   2 
 *          +,-| 1   1 
 *           ( | 0   3    무조건 넣음, 스택안에 있으면 무조건 위로 쌓을 수 있음.
 * 
 *         마지막엔 스택에 남아있는 연산자를 모두 출력해야한다. 
 *         ( 6 + 5 * ( 2 - 8 ) / 2 ) 6 5 2 8 - * 2
 *         / + -9
 */
public class Z18_Calculator2 {

	public static void main(String[] args) {
		String str = "( 6 + 5 * ( 2 - 8 ) / 2 )";
		String[] srr = str.split(" ");

		char[] stackOp = new char[srr.length];
		int top = -1;
		for (int i = 0; i < srr.length; i++) {
			char c = srr[i].charAt(0);
			switch (c) {
			case '(': // 넣을때는 3 무조건 넣음
				stackOp[++top] = c;
				break;
			case '*': // 2
			case '/': // 2, 스택 맨위의 값이 우선순위가 2라면 빼서 출력
				while (top >= 0 && stackOp[top] == '*' || stackOp[top] == '/') {
					System.out.print(stackOp[top--] + " ");
				}
				stackOp[++top] = c;
				break;
			case '+': // 1
			case '-': // 1, 스택 맨위의 값이 우선순위가 1라면 빼서 출력 0이면 넣기
				while (top >= 0 && stackOp[top] != '(') {
					System.out.print(stackOp[top--] + " ");
				}
				stackOp[++top] = c;
				break;
			case ')': // '('나올때까지 연산자 스택 pop
				while (top >= 0 && stackOp[top] != '(') {
					System.out.print(stackOp[top--] + " ");
				}
				if (stackOp[top] == '(') { // 여는 괄호가 들어있겠지만, 확인차
					top--;
				}
				break;
			default: // 피연산자 (숫자)
				System.out.print(c+" ");
				break;
			}
		}
		// 스택에 남아있는 연산자가 있으면 꺼내서 출력
		while (top > -1) {
			System.out.print(stackOp[top--] + " ");
		}
		System.out.println();
	} // end of main

} // end of class
