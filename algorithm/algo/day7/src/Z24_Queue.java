import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 선형 자료구조 : 배열, 리스트, 스택, 큐, 덱
 * Queue 큐 : FIFO 선입선출
 * 1. API 사용
 * 2. 메서드 작성
 * 3. 배열 인덱스 관리 - front, rear 변수 두개 필요
 * 
 */
public class Z24_Queue {

	public static void main(String[] args) {
		// 1. API 사용
		Stack s = new Stack(); // 클래스임 , 객체를 만들 수 있음
		Queue<Integer> q = new LinkedList();
		q.offer(6); // 삽입
		q.offer(7); // 삽입
		q.offer(8); // 삽입
		q.poll(); // 삭제
		System.out.println(q.poll());
		System.out.println(q.peek());
		// 2. 메서드 작성
		System.out.println("///////////////////2. 메서드 작성 ///////////////////////////");
		enQueue(6);
		enQueue(7);
		enQueue(8);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());

		// 3. 배열 인덱스 관리
		System.out
				.println("/////////////////////////////////////3. 배열 인덱스 관리 /////////////////////////////////////////");
		int[] queue = new int[5]; // 데이터가 부족하지 않도록 선언..
		int f = -1;
		int r = -1;
		queue[++r] = 6;
		queue[++r] = 7;
		queue[++r] = 8;
		System.out.println(queue[++f]);
		System.out.println(queue[++f]);
		System.out.println(queue[++f]);
	} // end of main

	public static int[] q = new int[5]; // 부족하지 않게 선언
	public static int front = -1;
	public static int rear = -1;

	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("underflow error");
			return -1; // 예외처리하는 것이 바람직
		} else {
			return q[++front];
		}
	}

	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("overflow error");
		} else {
			q[++rear] = item;
		}
	}

	public static boolean isEmpty() {
		return front == rear;
	}

	public static boolean isFull() {
		return (rear == q.length - 1);
	}
} // end of class
