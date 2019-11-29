import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울_동명환 {

	private static int[] arr;
	private static int n;
	private static int cnt;

	public static void perm(int k, int l, int r) {
		if (n == k) {
			cnt++;
		} else {
			for (int i = k; i < arr.length; i++) {
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				perm(k + 1, l + arr[k], r);
				if (l >= r + arr[k]) {
					perm(k + 1, l, r + arr[k]);
				}
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			perm(0, 0, 0);
			System.out.println("#" + testCase + " " + cnt);
		}
	}
}