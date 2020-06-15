import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 후위 표기식을 계산하기
 *  * 
 *         토큰 isp icp 
 *         ============
 *           ) | -   - 
 *          *,/| 2   2 
 *          +,-| 1   1 
 *           ( | 0   3    무조건 넣음, 스택안에 있으면 무조건 위로 쌓을 수 있음.
 * 
 *         마지막엔 스택에 남아있는 연산자를 모두 출력해야한다. 
 *         ( 6 + 5 * ( 2 - 8 ) / 2 )
 *          6 5 2 8 - * 2 / + 
 *          -9
 */
public class Z19_Calculator3 {
	public static void main(String[] args) {
		String s = "6 5 2 8 - * 2 / +";
		String[] srr = s.split(" ");
		
		int [] stackNum = new int[srr.length];
		int top = -1;
		
		for (int i = 0; i < srr.length; i++) {
			char c = srr[i].charAt(0);
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
				stackNum[++top] = Integer.parseInt(srr[i]);
				break;
			}	// end of switch
			// 작업 후에 스택에는 숫자가 1개 남아있을거임			
		}	// end of for
		System.out.println(stackNum[top]);
	}	// end of main
}	// end of class
