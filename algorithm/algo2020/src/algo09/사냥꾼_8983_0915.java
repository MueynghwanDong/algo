package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//���� üũ�ϱ�!!!
public class ��ɲ�_8983_0915 {

	static class animal implements Comparable<animal> {
		int x;
		int y;

		public animal(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		// ���� ���� ����!!
		@Override
		public int compareTo(animal o) {
			return this.x - o.x;
		}
	}

	static int m;
	static int n;
	static long l;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken()); // ��� ��
		n = Integer.parseInt(st.nextToken()); // ���� ��
		l = Integer.parseInt(st.nextToken()); // ���� �Ÿ�

		long[] gun = new long[m + 1]; // ��� ���� 
		animal[] arr = new animal[n]; // ���� ����

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			gun[i] = num;
		}
		gun[m] = Integer.MAX_VALUE;
		Arrays.sort(gun);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new animal(x, y);
		}
		Arrays.sort(arr);
		
		int cur = 0;
		for (int i = 0; i < n; i++) {
			animal temp = arr[i];
			int cx = temp.x;
			int cy = temp.y;
			// gun[0] - ���� x�� ���� ��ġ 
			if (cy > l || cx < gun[0] - l)
				continue;
			// ����� �ִ� �������� ū ��ġ�� �ִ� ������ Ž�� ���ص���!!
			if (cx > gun[m - 1] + l)
				break;
			for (int j = cur; j < m; j++) {
				long dist = Math.abs(gun[j] - cx) + cy;
				if (dist <= l) {
					cnt++;
					cur = j;
					break;
				}
				if (cx < gun[j]) // ���� ��ġ ���� gun[j]�� ū ��� 
					break;
			}
		}

		System.out.println(cnt);
	}

}
