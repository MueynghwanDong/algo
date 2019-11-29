
public class Z27_마이쮸 {

	static int n = 20;
	public static int[] q = new int[20];
	static int front = -1;
	static int rear = -1;

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
			if (front == q.length) {
				front = 0;
			}
			// front = (front + 1) % q.length;
			return q[front];
		}
	}

	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("overflow error");
		} else {
			++rear;
			if (rear == q.length) {
				rear = 0;
			}
			// rear = (rear + 1) % q.length;
			q[rear] = item;
		}
	}

	public static void test() {
		int count = 20;
		int arr[] = new int[20];
		int idx = 1;
		while (count >= 0) {

			enQueue(idx);
			int temp = deQueue();
			enQueue(temp);
			arr[temp]++;
			count = count - arr[temp];
			idx++;
			if (count <= 0) {
				System.out.println(temp);
			}
		}

	}

	public static void main(String[] args) {

		test();

		int[] q2 = new int[50];
		int front2 = -1;
		int rear2 = -1;

		int count = 20;
		int arr[] = new int[20];
		int idx = 1;
		while (count >= 0) {
			q2[++rear2] = idx;
			int temp = q2[++front2];
			q2[++rear2] = temp;
			arr[temp]++;
			count = count - arr[temp];
			idx++;
			if (count <= 0) {
				System.out.println(temp);
			}
		}

	}

}
