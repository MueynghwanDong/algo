package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n°úm_15655_0721 {
	static int n;
	static int m;
	static int arr[];
	static boolean brr[];
	static int trr[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		trr = new int[m];
		arr = new int[n];
		brr = new boolean[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		perm(0, 0);
		System.out.println(sb.toString());
	}

	public static void perm(int c, int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(trr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = c; i < n; i++) {
			if (!brr[i]) {
				brr[i] = true;
				trr[k] = arr[i];
				perm(i,k + 1);
				brr[i] = false;
			}
		}

	}
}
