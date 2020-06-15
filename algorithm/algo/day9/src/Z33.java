import java.util.Scanner;

public class Z33 {

	static int arr[] = new int[14];
	static boolean brr[] = new boolean[14];

	public static void dd(int data) {
		System.out.print(data+" ");
		brr[data] = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == data && !brr[i]) {
				dd(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		arr = new int[v + 1];
		brr = new boolean[v + 1];

		for (int i = 1; i < v; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[b] = a;
		}
		// brr[1] = true;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i] == j && !brr[i]) {
					dd(i);
				}
			}
		}
	}// end of main
} // end of class
