package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ºø¹°_14719_0301 {

	static int h, w;
	static int[] a;
	static int cnt = 0;
	static int s = 0, e = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		a = new int[w];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < w; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < w - 1; i++) {
			s = e = 0;
			for (int j = 0; j < i; j++) {
				s = Math.max(a[j], s);
			}
			for (int j = i + 1; j < w; j++) {
				e = Math.max(a[j], e);
			}
			// System.out.println(s+" " + e);
			if (a[i] < s && a[i] < e) {
				cnt += Math.min(s, e) - a[i];
			}
		}
		System.out.println(cnt);

	}

}
