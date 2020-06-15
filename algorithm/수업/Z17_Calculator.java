import java.io.IOException;
import java.util.Scanner;

/**
 * + * 연산 계산기
 */

public class Z17_Calculator {

	public static void main(String[] args) throws IOException {
		
		// 교수님 코드
		Scanner sc = new Scanner(System.in);
		int[] s = new int[9];
		int top = -1;
		
		String[] str = sc.nextLine().split(" ");
		s[++top] = Integer.parseInt(str[0]);
		for (int i = 0; i < str.length; i+=2) {
			char op = str[i].charAt(0);
			int num = Integer.parseInt(str[i+1]); 
			if(op == '+') {	// 숫자는 스택에 넣기
				s[++top] = num;
			} else {	// '*' 스택에서 숫자 꺼내서 곱셈연산 후 , 숫자를 스택에 넣기
				int pre = s[top--];
				s[++top] = pre * num;
			}
		}
		int result = 0;	//덧셈 연산자에 대한 항등원으로 초기화
		
		for (int i = 0; i<= top; i++) {
			result += s[i];
		}
		
		System.out.println(result);
		
		
		
		/*
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int sum = 0;

		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i].equals("*")) {
				int a = stack.pop();
				a = a * Integer.parseInt(str[i-1]);
				stack.push(a);
				i--;
			} else if (str[i].equals("+")) {
				continue;
			} else {
				stack.push(Integer.parseInt(str[i]));
			}
		}
		int size = 0;
		for (int i = 0; i < size; i++) {
			sum+= stack.pop();
		}
		System.out.println(" = " + sum);
		*/
	}

}
