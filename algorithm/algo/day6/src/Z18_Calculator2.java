/**
 * 중위표기식을 후위표기식으로 변환하기 ( 6 + 5 * ( 2 - 8 ) / 2 ) -> -9
 * 토큰 isp icp
 *  )  -   -  안넣음...
 * *,/ 2   2
 * +,- 1   1
 *  (  0   3  무조건 넣음, 스택안에 있으면 무조건 위로 쌓을수 있다.
 *  마지막엔 스택에 남아있는 연산자를 모두 출력해야한다. 
 */
public class Z18_Calculator2 {

	public static void main(String[] args) {

		String str = "( 6 + 5 * ( 2 - 8 ) / 2 )";
		String[] srr = str.split(" ");
		String srr2="";
		char[] stackOp = new char[srr.length];
		int top = -1;
		for (int i = 0; i < srr.length; i++) {
			char c = srr[i].charAt(0);
			switch (c) {
			case '(': // 넣을 때는 3-> 무조건 넣음
				stackOp[++top] = c;
				break;

			case '*': // 2
			case '/': // 2, 스택내에 맨위 연산자의 우선순위가 2라면 빼서 출력
				while (top >= 0 && (stackOp[top] == '*' || stackOp[top] == '/')) {
					//System.out.print(stackOp[top--] + " ");
					srr2 = srr2+stackOp[top--] + " ";
				}
				stackOp[++top] = c;
				break;

			case '+': // 1
			case '-': // 1, 스택내에 맨위 연산자의 우선순위가 0이면 넣기 아니면 빼서 출력
				while (top >= 0 & stackOp[top] != '(') {
					//System.out.print(stackOp[top--] + " ");
					srr2 = srr2+stackOp[top--] + " ";
				}
				stackOp[++top] = c;
				break;

			case ')': // ( 나올때까지 연산자스택에서 모두 빼서 출력
				while (top >= 0 && stackOp[top] != '(') {
					//System.out.print(stackOp[top--] + " ");
					srr2 = srr2+stackOp[top--] + " ";
				}
				if (stackOp[top] == '(') {
					top--;
				}
				break;

			default: // 피연산자(숫자) -> 바로 출력
				//System.out.print(srr[i] + " ");
				srr2 = srr2+srr[i] + " ";
				break;
			} // end of switch
		} // end of for
			// 스택에 남아있는 연산자가 있으면 꺼내서 출력
		while (top > -1) {
			//System.out.print(stackOp[top--] + " ");
			srr2 = srr2+stackOp[top--] + " ";
		}
		//System.out.println();
		System.out.println(srr2);
	}// end of main
} // end of class
