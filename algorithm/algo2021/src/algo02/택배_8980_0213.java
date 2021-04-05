package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ец╧Х_8980_0213 {

	static class Pos implements Comparable<Pos> {
		int s;
		int e;
		int cnt;

		Pos(int s, int e, int cnt) {
			this.s = s;
			this.e = e;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pos o) {
			return this.e - o.e;

		}
	}

	static int n, c, m, result = 0;
	static List<Pos> l;
	static int[] truck;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		truck = new int[n + 1];
		l = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			l.add(new Pos(a, b, c));
		}
		Collections.sort(l);

		for (int i = 0; i < l.size(); i++) {

			Pos p = l.get(i);
			int s = p.s;
			int e = p.e;
			int cnt = p.cnt;
			int max = 0;
			boolean load = true;
			for (int j = s; j < e; j++) {
				if (truck[j] >= c) {
					load = false;
					break;
				}
				max = Math.max(max, truck[j]);
			}

			if (load) {
				int unload = c - max;
				if (unload > cnt)
					unload = cnt;
				result += unload;
				for (int j = s; j < e; j++) {
					truck[j] += unload;
				}
			}

		}

		System.out.println(result);
	}

}
