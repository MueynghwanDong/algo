package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 공주님의정원_2457_0221 {

	static int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int sday = d;
			for (int j = 1; j < m; j++) {
				sday += month[j];
			}
			m = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			int eday = d;
			for (int j = 1; j < m; j++) {
				eday += month[j];
			}
			if (map.get(sday) == null || map.get(sday) < eday) {
				map.put(sday, eday);
			}
		}

		boolean flag = false;
		int current = 60;
		while (current < 335) {
			int max = current;
			for (int key : map.keySet()) {
				if (current >= key && map.get(key) > max) {
					max = map.get(key);
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
