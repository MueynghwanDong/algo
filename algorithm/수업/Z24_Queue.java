import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 선형 자료구조 : 배열, 리스트, 스택, 큐, 덱 Queue 큐 : FIFO 선입선출 front, rear 변수 두개로 관리한다. 1.
 * API 사용 2. 메서드 작성 3. 배열 인덱스 관리
 */
public class Z24_Queue {

	public static void main(String[] args) {
		// 1. AP사용
		System.out.println("////////////////////1. API 작성///////////////////");
		Stack s = new Stack(); // 클래스임. 객체를 만들 수 있음 !
		Queue q = new LinkedList<>(); // Interface임. 객체생성불가.

		q.offer(6);
		q.offer(7);
		q.offer(8);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());

		// 2. 메서드 작성
		System.out.println("////////////////////2. 메서드 작성///////////////////");
		enQueue(6);
		enQueue(7);
		enQueue(8);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		
		// 3. 배열 인덱스 관리
		System.out.println("////////////////////3. 배열 인덱스 관리//////////////");
		int [] queue = new int[5];
		int f = -1;
		int r = -1;
		queue[++r] = 6;
		queue[++r] = 7;
		queue[++r] = 8;
		System.out.println(queue[++f]);
		System.out.println(queue[++f]);
		System.out.println(queue[++f]);

	} // end of Main

	public static int[] q = new int[5]; // 부족하지 않게 선언
	public static int front = -1;
	public static int rear = -1;

	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("overflow error");
		}
		q[++rear] = item; 
	}
	
	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("underflow error");
			return -1; //예외처리를 하는 것이 바람직 !
		}
		return q[++front];
	}

	private static boolean isEmpty() {

		return front == rear;
	}

	private static boolean isFull() {
		return rear == q.length-1;
	}

} // end of Class
