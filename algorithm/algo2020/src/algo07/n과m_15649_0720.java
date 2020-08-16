package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n°úm_15649_0720 {

	static int m;
	static int n;
	static int[] arr;
	static boolean[] brr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		brr = new boolean[n];
		perm(0);

	}

	public static void perm(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			if (!brr[i]) {
				brr[i] = true;
				arr[k] = i + 1;
				perm(k + 1);
				brr[i] = false;
			}
		}
        return;
	}
}