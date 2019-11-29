import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	private static int arr[];
	private static boolean brr[];
	private static int n;
	private static int count;
	private static int mcnt;

	public static void perm(int n, int k) {
		if (n == k) {
			//System.out.println(Arrays.toString(arr));
			int leftsum = 0;
			int rightsum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (brr[i]) {
					leftsum += arr[i];
				} else {
					rightsum += arr[i];
				}
			}
			if (leftsum >= rightsum) {
				 //System.out.println(Arrays.toString(arr));
				// System.out.println(leftsum + " " + rightsum);
				count++;
			}
		} else {
			for (int i = k; i < arr.length; i++) {
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				perm(n, k + 1);
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}

	}

	public static void recur(int n) {
		if (n == arr.length) {
			int leftsum = 0;
			int rightsum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (brr[i]) {
					leftsum += arr[i];
				} else {
					rightsum += arr[i];
				}
			}
			if (leftsum >= rightsum) {
				// System.out.println(Arrays.toString(brr));
				perm(arr.length, 0);
			}
		} else {
			brr[n] = true;
			recur(n + 1);
			brr[n] = false;
			recur(n + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			count = 0;
			mcnt = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			brr = new boolean[n];
			String s = br.readLine();
			String[] ss = s.split(" ");
			for (int i = 0; i < ss.length; i++) {
				arr[i] = Integer.parseInt(ss[i]);
			}
			recur(0);
			System.out.println(count);
		}
	}

}
