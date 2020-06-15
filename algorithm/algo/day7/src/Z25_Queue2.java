
public class Z25_Queue2 {

	static int n = 5;
	public static int[] q = new int[n];
	static int front = -1;
	static int rear = -1;
	static int count = 20;

	public static boolean isEmpty() {
		return front == rear;
	}

	public static boolean isFull() {
		return ((rear + 1) % n == front);
	}

	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("underflow error");
			return -1;

		} else {
			++front;
			if(front == q.length) {
				front = 0;
			}
			//front = (front + 1) % q.length;
			return q[front];
		}
	}

	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("overflow error");
		} else {
			++rear;
			if(rear == q.length) {
				rear = 0;
			}
			//rear = (rear + 1) % q.length;
			q[rear] = item;
		}
	}

	public static void main(String[] args) {
		enQueue(6);
		enQueue(7);
		enQueue(8);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		enQueue(6);
		enQueue(7);
		enQueue(8);	
		System.out.println(deQueue());

	}

}
