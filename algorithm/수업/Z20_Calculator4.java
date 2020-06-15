
public class Z20_Calculator4 {

	public static void main(String[] args) {
		
		String str = "( 6 + 5 * ( 2 - 8 ) / 2 )";
		String[] srr = str.split(" ");
		
		char[] stackOp = new char[srr.length];
		int top = -1;
		char[] crr = new char[str.length()];	// 후위표기 결과토큰 저장용
		int index = 0;								// 후위표기 length 
		
		
		// 1번 과정 시작
		for (int i = 0; i < srr.length; i++) {
			char c = srr[i].charAt(0);
			switch (c) {
			case '(': // 넣을때는 3 무조건 넣음
				stackOp[++top] = c;
				break;
			case '*': // 2
			case '/': // 2, 스택 맨위의 값이 우선순위가 2라면 빼서 출력
				while (top >= 0 && stackOp[top] == '*' || stackOp[top] == '/') {
					crr[index++] = stackOp[top--];
				}
				stackOp[++top] = c;
				break;
			case '+': // 1
			case '-': // 1, 스택 맨위의 값이 우선순위가 1라면 빼서 출력 0이면 넣기
				while (top >= 0 && stackOp[top] != '(') {
					crr[index++] = stackOp[top--];
				}
				stackOp[++top] = c;
				break;
			case ')': // '('나올때까지 연산자 스택 pop
				while (top >= 0 && stackOp[top] != '(') {
					crr[index++] = stackOp[top--];
				}
				if (stackOp[top] == '(') { // 여는 괄호가 들어있겠지만, 확인차
					top--;
				}
				break;
			default: // 피연산자 (숫자)
				crr[index++] = c;
				break;
			}
		}
		// 스택에 남아있는 연산자가 있으면 꺼내서 출력
		while (top > -1) {
			crr[index++] = stackOp[top--];
		}
		
		// 1번과정 끝
		int [] stackNum = new int[srr.length];
		top = -1;	// top리셋
		
		
		for (int i = 0; i < index; i++) {
			char c = crr[i];
			// 숫자이면 스택에 넣고, 연산자면 숫자2개 꺼내서 연산 후 결과를 스택에 넣는다.
			int num1, num2; 
			switch (c) {
			case '+' :
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 + num2;
				break;
			case '-' :
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 - num2;
				break;
			case '*' :
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 * num2;
				break;
			case '/' :
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 / num2;
				break;
			default:	// 피연산자(숫자)
				stackNum[++top] = crr[i]-'0';
				break;
			}	// end of switch
			// 작업 후에 스택에는 숫자가 1개 남아있을거임			
		}	// end of for
		System.out.println(stackNum[top]);
		
		
		
		
		
		
		
		
		
	} // end of main

}
