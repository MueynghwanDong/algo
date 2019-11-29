/*
 * 선형큐 : 메모리가 재활용할 수 없다. -> 낭비
 * => 삭제 연산시마다 쉬프트 -> 성능이 떨어짐..
 * 	  원형 큐 -> 나머지 연산 성능 떨어짐
 * 	 연결큐 -> 안쓰는 메모리는 없지만, 다음 링크를 위한 메모리가 낭비, 삽입시마다 노드 객체를 생성하는 시간이 걸린다.
 * 
 */
public class Z26_연결큐 {
	public static class Node { // 더이터, 링크
		int data;
		Node link; // 다음 노드

		public Node(int data) {
			this.data = data;
		}

	}

	public static Node front;
	public static Node rear;

	public static void main(String[] args) {

		enQueue(6);
		enQueue(7);
		enQueue(8);
		System.out.println(deQueue());
	} // end of main

	private static int deQueue() {

		if (isEmpty()) {
			System.out.println("undoerflow  error");
			return -1;
		} else {
			int data = front.data;
			front = front.link;
			if (isEmpty()) {
				rear = null;
			}
			return data;
		}
	}

	private static void enQueue(int item) {
		Node newNode = new Node(item);	
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.link = newNode;
			rear = newNode;
		}
	}

	private static boolean isEmpty() {
		return front == null;
	}

} // end of class
