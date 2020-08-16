package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n°úm_15652_0720 {

	static int m;
	static int n;
	static int[] arr;
	static boolean[] brr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		brr = new boolean[n + 1];
		sb = new StringBuilder();
		perm(1, 0);
		System.out.println(sb.toString());

	}

	public static void perm(int a, int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = a; i <= n; i++) {
			arr[k] = i;
			perm(i, k + 1);
		}
	}

}
