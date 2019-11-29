import java.util.Scanner;
import java.util.Stack;

public class sdf {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		sb.append("0 "); // 첫번째 경우
		int num = sc.nextInt(); // 첫 숫자 입력
		stack.push(num); // 첫숫자 스택에 넣기
		stack2.push(1);
		// 첫 인덱스
		for (int i = 2; i <= n; i++) { // 2번부터 시작
			int num2 = sc.nextInt();
			while (!stack.isEmpty()) { // 스택이 빌때까지 반복
				if (num2 < stack.peek()) { // 입력 받은 숫자가 스택에 있는 숫자보다 작을때 스택에 있는 것의 인덱스 출력
					sb.append(stack2.peek() + " ");
					break;
				}
				stack.pop();
				stack2.pop(); // 인덱스,
				// 숫자 스택 모두 빼주기
			}
			if (stack.isEmpty()) {
				// 스택이 비어있다면 0출력
				sb.append("0 ");
			}
			stack.push(num2); // 스택에 값 넣기
			stack2.push(i); // 스택에 인덱스 값 넣기
		}
		System.out.println(sb.toString()); // 출력
	}
}
