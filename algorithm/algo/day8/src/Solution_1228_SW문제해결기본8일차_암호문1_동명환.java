import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1228_SW문제해결기본8일차_암호문1_동명환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 2; testCase++) {
			LinkedList<Integer> ll = new LinkedList<>();
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				ll.add(sc.nextInt());
			}
			int num2 = sc.nextInt();
			for (int i = 0; i < num2; i++) {
				String temp = sc.next();
				int index = sc.nextInt();
				int cnt = sc.nextInt();
				for (int j = index; j < index + cnt; j++) {
					int data = sc.nextInt();
					ll.add(j, data);
				}
			}
			System.out.print("#" + testCase + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(ll.get(i) + " ");
			}
			System.out.println();
		}
	}
}
