//import java.util.Stack;

/**
 * Stack : LIFO (후입선출)의 선형 자료구조 (1:1관계)
 * 
 * @author student top : 마지막으로 삽입된 데이터의 index를 가리키는 변수
 */
public class Z13_Stack {
	public static void main(String[] args) {

//		Stack<Integer> stack = new Stack<Integer>(); // collection Framework
//		stack.push(new Integer(5));	// 기본형 타입이 오브젝트로 변경되는거 => autoBoxing
//		stack.push(7);
//		stack.push(1);

//		System.out.println(stack.size());
//		System.out.println(stack.isEmpty());
//		System.out.println(stack);

		push(5);
		push(6);
		push(8);
		System.out.println(pop());
		System.out.println(pop());
		
		
		// 스택사용
		// 1. API 사용 : 현업에서
		// 2. 메서드 구현
		// 3. 직접 작성 : 알고리즘 할 때;
		
		System.out.println("//////////// 직접 작성//////////");
		
		int[] ss = new int[5];
		int t = -1;
		ss[++t] = 5;
		ss[++t] = 5;
		ss[++t] = 5;
		ss[++t] = 5;
		
		System.out.println(ss[t--]);
		if ( t == -1 )
			System.out.println("비어있음");
		
		
	}// end of main

	public static int[] s = new int[5]; // 크기는 부족하지 않게 지정
	public static int top = -1; // 마지막에 삽입된 데이터의 index를 가리킴

	public static boolean push(int data) {
		if (isFull()) {
			System.out.println("스택이 꽉 찼어요 stackOverFlow Error");
			return false;
		} else {
			s[++top] = data;
			return true;
		}
	}

	public static boolean isFull() {
		if (top == s.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	public static int pop() {
		if (isEmpty()) {
			System.out.println("스택이 비었어요. StackEmpty Error");
			// 새로운 Exception객체를 만들어서 throws 해줘야함 !!
		}
		return s[top--];
	}

	public static boolean isEmpty() {
		return top == -1 ? true : false;
	}

}// end of class
