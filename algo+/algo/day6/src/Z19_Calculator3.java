/**
 * 후위 표기식 계산하기 
 * 6 5 2 8 - * 2 / + 
 * -9
 */
public class Z19_Calculator3 {

	public static void main(String[] args) {
		String s = "6 5 2 8 - * 2 / +";
		String[] srr = s.split(" ");

		int[] stackNum = new int[srr.length];
		int top = -1;
		for (int i = 0; i < srr.length; i++) {
			char c = srr[i].charAt(0);
			// 숫자라면 스택에 넣고 연산자면 숫자 2개 꺼내 연산 결과를 스택에 넣어줌...
			int num1, num2;
			switch (c) {
			case '+':
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 + num2;
				break;
			case '-':
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 - num2;
				break;
			case '*':
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 * num2;
				break;
			case '/':
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 / num2;
				break;
			default: // 피연산자
				stackNum[++top] = Integer.parseInt(srr[i]);
				break;
			} // end of switch
		} // end of for
		System.out.println(stackNum[top--]); // 작업 후에 스택 1개 남아 있는 것이 답...
	}// endof main
} // end of class
