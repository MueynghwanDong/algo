import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			int idx = i;
			while (idx >= 0) {
				if (arr[i] < arr[idx]) {
					arr2[i] = (idx+1);
					break;
				}
				idx--;
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
}
