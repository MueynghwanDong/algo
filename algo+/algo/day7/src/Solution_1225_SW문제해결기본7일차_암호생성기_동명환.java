import java.util.Scanner;

public class Solution_1225_SW문제해결기본7일차_암호생성기_동명환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int T = sc.nextInt();
		for (int testCase = 1; testCase <= 10; testCase++) {
			int T = sc.nextInt();
			boolean check = false;
			int[] q = new int[500001];
			int front = -1;
			int rear = -1;
			for (int i = 0; i < 8; i++) {
				q[++rear] = sc.nextInt();
			}
			// 큐 안쓰는 경우 - 배열 시작 or 끝 위치 기억 -> 큐보다 메모리 낭비가 적다.
			//
			outerloop: while (true) {
				for (int i = 1; i <= 5; i++) {
					int temp = q[++front];
					temp = temp - i;
					if (temp <= 0) {
						temp = 0;
						check = true;
					}
					q[++rear] = temp;
					if (check)
						break outerloop;
				}

			}
			System.out.print("#" + testCase + " ");
			for (int i = front + 1; i <= rear; i++) {
				System.out.print(q[i] + " ");
			}
			System.out.println();
		}

	}

}
