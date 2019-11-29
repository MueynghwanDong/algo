import java.util.Arrays;
import java.util.Scanner;

public class bj_6603 {

	static boolean bit[];
	static int arr[];
	static int n;
	static String[] result;
	static int index = 0;

	public static void dfs(int num) {
		String s = "";
		int temp[] = new int[6];
		if (num == -1) {
			for (int i = 0; i < bit.length; i++) {
				if (bit[i]) {
					s += arr[i] + " ";
				}
			}
			String[] str = s.split(" ");
			if (str.length == 6) {
				for (int i = 0; i < str.length; i++) {
					temp[i] = Integer.valueOf(str[i]);
				}
				System.out.println(Arrays.toString(temp));
				result[index++] = s;
			}
		} else {
			bit[num] = false;
			dfs(num - 1);
			bit[num] = true;
			dfs(num - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			index = 0;
			n = sc.nextInt();
			if (n == 0)
				break;
			arr = new int[n];
			bit = new boolean[arr.length];
			result = new String[50001];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			dfs(n - 1);
			String[] r = new String[index];
			for (int i = 0; i < r.length; i++) {
				r[i] = result[i];
			}

			Arrays.sort(r);
			for (int i = 0; i < index; i++) {
				System.out.println(r[i]);
			}
			System.out.println();
		}
	}
}
