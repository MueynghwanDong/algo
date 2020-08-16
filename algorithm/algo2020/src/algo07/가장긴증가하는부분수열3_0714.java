package algo07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열3_0714 { // String Builder로 바꿔야 함...

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		arr = new int[n];

		list.add(Integer.MIN_VALUE);

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			int value = arr[i];
			if (list.get(list.size() - 1) < value)
				list.add(value);
			else {
				int left = 0;
				int right = list.size() - 1;
				while (left < right) {
					int mid = (left + right) / 2;
					if (list.get(mid) < value)
						left = mid + 1;
					else
						right = mid;
				}
				list.set(right, value);
			}
		}
		sb.append(list.size() - 1 + "\n");

		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}
