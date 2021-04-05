package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class °úÁ¦_13904_0211 {

	static class Task implements Comparable<Task> {
		int day;
		int point;

		Task(int day, int point) {
			this.day = day;
			this.point = point;
		}

		@Override
		public int compareTo(Task o) {
			return o.point - this.point;
		}

	}

	static int n, ans = 0;
	static int[] result;
	static ArrayList<Task> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		result = new int[1001];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list.add(new Task(d, p));
		}
		Collections.sort(list);
		// for (int i = 0; i < n; i++) {
		// System.out.println(list.get(i).day + " " + list.get(i).point);
		// }
		for (Task t : list) {
			int d = t.day;
			for (int i = d; i > 0; i--) {
				int v = t.point;
				if (result[i] == 0) {
					result[i] = v;
					break;
				}
			}
		}

		int sum = 0;
		 for(int temp : result) {
		 sum+= temp;
		}

		System.out.println(sum);

	}
}
