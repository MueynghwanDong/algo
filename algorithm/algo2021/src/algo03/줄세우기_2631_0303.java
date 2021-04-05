package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 줄세우기_2631_0303 {

	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int len = getLIS();
		System.out.println(n - len);

	}

	public static int getLIS() {
		int[] tp = new int[n];
		int lislen = 0;
		tp[lislen++] = arr[0];
		for (int i = 1; i < n; i++) {
//			System.out.println(arr[i] +" " + tp[0] + " " + tp[lislen-1]);
			if (arr[i] < tp[0]) {
				tp[0] = arr[i];
			} else if (arr[i] > tp[lislen - 1]) {
				tp[lislen++] = arr[i];
			} else {
				int idx = Arrays.binarySearch(tp, 0, lislen, arr[i]);
				if (idx < 0) {
					idx = -idx-1;
				}
				tp[idx] = arr[i];
			
			}
		}
		
		return lislen;
	}
}
