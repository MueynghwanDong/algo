
public class Z25_Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enQueue(4);
		enQueue(5);
		enQueue(6);
		enQueue(7);
		enQueue(8);
		enQueue(9);
		deQueue();
		deQueue();
		deQueue();
		deQueue();
		
	}
	
	public static int [] queue = new int[5];
	public static int front = 0;
	public static int rear = 0;
	public static void enQueue(int item) {
		if(isFull()) {
			System.out.println("꽉찼습니다");
		} else {
			queue[(rear+1)%queue.length] = item;
		}
	}
	private static boolean isFull() {
		if( (rear+1)%(queue.length) == front) {
			return true;
		}
		return false;
	}
	
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("텅비었습니다");
		}else {
//			++front;
//			if(front == queue.length) {
//				front = 0;
//			}
		}
		
	return queue[front];
	}
	private static boolean isEmpty() {
		if(front == rear) {
			return true;
		}
		return false;
	}

}
