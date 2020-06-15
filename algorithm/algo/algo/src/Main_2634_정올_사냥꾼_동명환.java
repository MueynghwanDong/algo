import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2634_정올_사냥꾼_동명환 {
	public static class Animal implements Comparable<Animal> {
		int x;
		int y;

		public Animal(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Animal o) {
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return "Animal [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] tm = new int[m]; // 사대 위치
		List<Animal> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < tm.length; i++) {
			tm[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			if (r > l)
				continue;
			list.add(new Animal(c, r));
		}

		Collections.sort(list);
		Arrays.sort(tm);

		// System.out.println(Arrays.toString(tm));

		int idx = 0;
		int tmp = 0;
		int cnt = 0;

		for (int i = 0; i < list.size(); i++) {
			while (idx != tm.length - 1 && tm[idx] < list.get(i).x) {
				idx++;
			}
			tmp = list.get(i).x - tm[idx];
			tmp = tmp < 0 ? -1 * tmp + list.get(i).y : tmp + list.get(i).y;
			if (tmp <= l) {
				cnt++;
				continue;
			}
			if (idx != 0) {
				tmp = list.get(i).x - tm[idx - 1];
				tmp = tmp < 0 ? -1 * tmp + list.get(i).y : tmp + list.get(i).y;
				if (tmp <= l) {
					cnt++;
					continue;

				}
			}
		}

		System.out.println(cnt);
	}
}