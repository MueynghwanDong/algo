package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class �̸�Ƽ��_14226_0318 {

	static boolean[][] brr = new boolean[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		brr[1][0] = true;
		q.add(new int[] { 1, 0, 0 }); // ����, Ŭ�����忡 ����� ��

		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cur = t[0];
			int temp = t[1];
			int time = t[2];
			if (cur == s) {
				System.out.println(time);
				return;
			}
			q.add(new int[] { cur, cur, time + 1 });

			if (cur + temp < 1001 && temp != 0 && !brr[cur + temp][temp]) { // �ٿ��ֱ�
				brr[cur + temp][temp] = true;
				q.add(new int[] { cur + temp, temp, time + 1 });
			}
			if (cur > 0 && !brr[cur - 1][temp] && cur - 1 < 1001) {// ����
				brr[cur - 1][temp] = true;
				q.add(new int[] { cur - 1, temp, time + 1 });
			}
		}
	}

}
