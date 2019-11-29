
public class Solution_마이쮸_동명환 {

	public static void main(String[] args) {

		int[] q = new int[100];
		int front = -1;
		int rear = -1;
		int count = 20;
		int arr[] = new int[20];
		int idx = 1;
		while (count >= 0) {
			q[++rear] = idx++;
			int temp = q[++front];
			q[++rear] = temp;
			arr[temp]++;
			count = count - arr[temp];
			if (count <= 0) {
				System.out.println("20번째는 " + temp + "가 받음");
			}
		}

	}

}
