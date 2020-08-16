package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2_0714 {
	
	
	static int n;
	static int[] arr;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		list.add(Integer.MIN_VALUE);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
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
		System.out.println((list.size() - 1));

//		 for (int i = 1; i < list.size(); i++) {
//		 System.out.print(list.get(i)+" ");
//		 }
	}

}
