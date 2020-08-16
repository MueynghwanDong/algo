package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 피보나치함수_1003_0725 {

	static int n;
	static ArrayList<int[]> fibo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			n = Integer.parseInt(br.readLine());
			fibo = new ArrayList<>();

			fibo.add(0, new int[] { 1, 0 });
			fibo.add(1, new int[] { 0, 1 });

			for (int i = 2; i <= n; i++) {
				fibo.add(i,
						new int[] { fibo.get(i - 2)[0] + fibo.get(i - 1)[0], fibo.get(i - 2)[1] + fibo.get(i - 1)[1] });
			}
			System.out.println(fibo.get(n)[0] + " " + fibo.get(n)[1]);
		}

	}

}
