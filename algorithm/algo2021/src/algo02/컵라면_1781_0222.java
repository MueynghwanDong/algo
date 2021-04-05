package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ÄÅ¶ó¸é_1781_0222 {

	static class Homework implements Comparable<Homework> {
		int day, ramen;

		Homework(int day, int ramen) {
			this.day = day;
			this.ramen = ramen;
		}

		@Override
		public int compareTo(Homework o) {
			if (o.day == this.day) {
				return o.ramen - this.ramen;
			} else
				return this.day - o.day;
		}

	}

	static int n;
	static List<Homework> list = new ArrayList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			list.add(new Homework(d, r));
		}
		Collections.sort(list);
		// for (int i = 0; i < list.size(); i++) {
		// Homework h = list.get(i);
		// System.out.println(h.day +" " + h.ramen);
		// }
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int d = list.get(i).day;
			int r = list.get(i).ramen;

			if (pq.size() < d)
				pq.add(r);
			else {
				if (pq.peek() < r) {
					pq.poll();
					pq.add(r);
				}
			}

			// System.out.println(r);
			// while (pq.size() > d) {
			// pq.poll();
			// }
		}
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
	}

}
