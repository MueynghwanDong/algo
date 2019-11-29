import java.util.Scanner;

public class bj_1697 {

	static class data {
		int x;
		int cnt;

		public data(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		data[] q = new data[100001];
		boolean visited[] = new boolean[100001];
		int front = -1;
		int rear = -1;
		int count = 0;
		q[++rear] = new data(n, 0);
		visited[n] = true;
		outerloop: while (front != rear) {
			data d;
			d = q[++front];
			if (d.x == k) {
				count = d.cnt;
				break outerloop;
			}
			int arr[] = { d.x + 1, d.x - 1, 2 * d.x };
			for (int i = 0; i < 3; i++) {
				int newn = arr[i];
				if (newn < 0 || newn > 100000)
					continue;
				if (!visited[newn]) {
					d.x = newn;
					q[++rear] = new data(d.x, d.cnt + 1);
					visited[d.x] = true;
				}

			}
		}
		System.out.println(count);
	}

}