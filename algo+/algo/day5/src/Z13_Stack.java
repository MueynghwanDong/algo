import java.util.Stack;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * Stack : LIFO (후입 선출) 의 선형 자료구조 (1:1 관계) top : 마지막으로 삽입된 데이터의 index를 가리키는 변수
 */
public class Z13_Stack {
	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<>(); // Collection Framwork
//		stack.push(5); // AutoBoxing : 기본형 타입을 자동으로 객체로 바꿔주는 기능
//		stack.push(new Integer(7)); 
//		//stack.push("hi");
//		System.out.println(stack.size());
//		System.out.println(stack.isEmpty());
//		System.out.println(stack);
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		//System.out.println(stack.peek());
//		System.out.println(stack);
		System.out.println("메서드 구현");
		push(5);
		push(9);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());

		// 스택 사용
		// 1. API 사용 : 현업
		// 2. 메서드 구현
		// 3. 직접 작성 : 알고리즘
		System.out.println("/////직접 작성 //////////");
		int[] ss = new int[5];
		int t = -1;
		ss[++t] = 5;
		ss[++t] = 9;
		ss[++t] = 7;
		System.out.println(ss[t--]);
		System.out.println(ss[t--]);
		System.out.println(ss[t--]);
		if (t == -1) {
			System.out.println("비어있음");
		}

	} // end of main


	public static int[] s = new int[5]; // 크기는 부족하지 않게 지정
	public static int top = -1;

	// 스택에 꼭대기에 있는(마지막에 삽입된) 데이터를 반환(삭제하는 메서드)
	public static int pop() {
		if (isEmpty()) {
			System.out.println("스택이 비었어요  stackEmpty Error");
			return -1;
		}
		return s[top--];
	}

	// 스택이 비었는지 여부를 리턴해주는 메서드
	private static boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	// 스택에 값을 삽입 하는 메서드
	public static boolean push(int data) {
		if (isFull()) {
			System.out.println("스택이 꽉찼어요 stackOverflow Error");
			return false;
		}
		s[++top] = data;
		return true;
	}

	// 스택이 꽉찼는지 여부를 리턴 해주는 메서드
	private static boolean isFull() {
		if (top == s.length - 1) {
			return true;
		} else {
			return false;
		}
	}
} // end of class
