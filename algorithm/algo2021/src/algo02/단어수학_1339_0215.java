package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어수학_1339_0215 {

	static int n;
	static int[] arr;
	static char[] srr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		srr = new char[10];
		arr = new int[10];
		Arrays.fill(srr, '0');

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			int w = 1;
			for (int j = str.length() - 1; j >= 0; j--) {
				char num = str.charAt(j);
				for (int k = 0; k < 10; k++) {
					if (srr[k] == num) {
						arr[k] += w;
						break;
					} else if (srr[k] == '0') {
						srr[k] = num;
						arr[k] = w;
						break;
					}
				}
				w *= 10;
			}
		}
		Arrays.sort(arr);
		int sum = 0;
		for (int i = 9; i >= 0; i--) {
			sum += i * arr[i];
		}
		System.out.println(sum);
	}
}
