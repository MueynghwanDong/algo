package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 공주님의정원_2457_0220 {

	static int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int n;

	// 60 ~ 333
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int count = 0;
		boolean scheck = false;
		boolean echeck = false;
		HashMap<Integer, Integer> flower = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int sday = d;
			for (int j = 0; j < m; j++) {
				sday += month[j];
			}
			if (sday <= 60)
				scheck = true;
			m = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			int eday = d;
			for (int j = 0; j < m; j++) {
				eday += month[j];
			}
			if (eday >= 334)
				echeck = true;
			if (flower.get(sday) == null || flower.get(sday) < eday) {
				flower.put(sday, eday);
			}
		}
		if (!scheck || !echeck)
			System.out.println(0);

		boolean flag = false;
		int current = 60;
		while (current < 335) {
			int max = current;
			for (int key : flower.keySet()) {
				if (key <= current && max < flower.get(key)) {
					max = flower.get(key);
					flag = true;
				}
			}
			if (flag) {
				current = max;
				flag = false;
				count++;
			} else {
				count = 0;
				break;
			}
		}
		System.out.println(count);
	}
}
