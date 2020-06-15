import java.util.Scanner;

public class Main_1809_동명환 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					arr2[i] = j + 1;
					break;
				}
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

}
