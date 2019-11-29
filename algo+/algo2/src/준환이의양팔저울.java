import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 준환이의양팔저울 {

	private static int n;
	private static int[] w;
	private static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {

			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = new int[n];
			for (int i = 0; i < w.length; i++) {
				w[i] = Integer.parseInt(st.nextToken()); // 무게가 1<=w <=999
			}
			cnt = 0;
			perm(0, 0, 0);
			System.out.println("#" + testCase + " " + cnt);
		} // end tc
	} // end main

	// 왼쪽 추들의 합과 오른쪽 추들의 합(l,r)
	private static void perm(int step, int l, int r) {
		if (w.length == step) {
			 System.out.println(Arrays.toString(w));
			cnt++;
		} else {
			for (int i = step; i < w.length; i++) {
				int temp = w[step];
				w[step] = w[i];
				w[i] = temp;
				perm(step + 1, l + w[step], r); // 저울의 왼쪽에 w[step]의 추를 올려놓고 재귀 호출
				if (l >= r + w[step]) {
					perm(step + 1, l, r + w[step]); // 저울의 오른쪽에 w[step]의 추를 올려놓고 재귀 호출
				}
				temp = w[step];
				w[step] = w[i];
				w[i] = temp;
			}
		}
	}

} // end class
