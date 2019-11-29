

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16987_계란으로계란치기 {

	static class Egg {
		int duration;
		int weight;
		boolean check;

		public Egg(int duration, int weight, boolean check) {
			this.duration = duration;
			this.weight = weight;
			this.check = check;
		}
	}

	private static int n;
	private static Egg[] eggs;
	private static int result;

	public static void fight(int cnt, int m) { //인덱스, 깨진 수
		if (cnt == n) {
			if (result < m) {
				result = m;
			}
			return;
		}
		if (eggs[cnt].check) { // 깨졌을 때 다음으로 넘어가기
			fight(cnt + 1, m);
		} else {
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				int temp = 0;
				if (!eggs[i].check) {
					flag = false; // 덜깨진게 있다...
				}

				if (!eggs[i].check && i != cnt) {

					eggs[cnt].duration = eggs[cnt].duration - eggs[i].weight;
					eggs[i].duration = eggs[i].duration - eggs[cnt].weight; // 변화된 내구성
					if (eggs[i].duration <= 0) {
						eggs[i].check = true;
						temp++;
					}
					if (eggs[cnt].duration <= 0) {
						eggs[cnt].check = true;
						temp++;
					}
					fight(cnt + 1, m + temp);
					// 백트래킹 ??????
					if (eggs[i].duration <= 0) {
						eggs[i].check = false;
					}
					if (eggs[cnt].duration <= 0) {
						eggs[cnt].check = false;
					}
					eggs[cnt].duration = eggs[cnt].duration + eggs[i].weight;
					eggs[i].duration = eggs[i].duration + eggs[cnt].weight; // 변화된 내구성

				}
			}
			if(!flag) fight(n,m);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		eggs = new Egg[n];
		result = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int duration = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(duration, weight, false);
		}
		fight(0, 0);
		System.out.println(result);
	}

}
