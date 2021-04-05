package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//정렬 체크하기!!!
public class 사냥꾼_8983_0915 {

	static class animal implements Comparable<animal> {
		int x;
		int y;

		public animal(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		// 오름 차순 정렬!!
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
		m = Integer.parseInt(st.nextToken()); // 사대 수
		n = Integer.parseInt(st.nextToken()); // 동물 수
		l = Integer.parseInt(st.nextToken()); // 사정 거리

		long[] gun = new long[m + 1]; // 사대 저장 
		animal[] arr = new animal[n]; // 동물 저장

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
			// gun[0] - 가장 x가 작은 위치 
			if (cy > l || cx < gun[0] - l)
				continue;
			// 사대의 최대 범위보다 큰 위치에 있는 동물은 탐색 안해도됨!!
			if (cx > gun[m - 1] + l)
				break;
			for (int j = cur; j < m; j++) {
				long dist = Math.abs(gun[j] - cx) + cy;
				if (dist <= l) {
					cnt++;
					cur = j;
					break;
				}
				if (cx < gun[j]) // 현재 위치 보다 gun[j]가 큰 경우 
					break;
			}
		}

		System.out.println(cnt);
	}

}
