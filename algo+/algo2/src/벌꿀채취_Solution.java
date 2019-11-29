import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 벌꿀채취_Solution {

	private static int[][] arr;
	private static int c;
	private static int m;
	private static int n;
	private static boolean[] brr;
	private static int[] result;
	private static pos[] prr;
	private static int index;
	private static int[] trr;
	private static int tidx;
	private static int resum;

	static class pos {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			result = new int[n * n]; // 채취한 값을 저장할 배열
			prr = new pos[n * n];
			brr = new boolean[m];
			index = 0;
			resum = 0;
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < n; j++, index += 2) {
					arr[i][j] = str.charAt(index) - '0';
				}
			} // 입력

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					prr[index++] = new pos(i, j);
				}
			}
			trr = new int[2];
			tidx = 0;
			comb(index, 2);

//			System.out.println(resum);
		}
	}

	private static boolean check(pos temp, pos temp2) {
		int ty = temp.y;
		int ty2 = temp2.y;
		for (int i = 0; i < m; i++) {
			if (ty + i == ty2)
				return false;
		}
		return true;
	}

	private static int powerset(int[] t, int tdx, int x) {
		int re = 0;
		if (tdx == m) {
			// 종료
			int sum = 0;
			for (int i = 0; i < t.length; i++) {
				if (brr[i]) {
					sum += arr[x][t[i]];
				}
			}
			System.out.println(sum);
			if (sum > c) {
				System.out.println("no");
				re = 0;
			} else {
				for (int i = 0; i < t.length; i++) {
					if (brr[i]) {
						re += (arr[x][t[i]] * arr[x][t[i]]);
					}
				}
			}
			System.out.println(re);
			return re;

		} else {
			brr[tdx] = false; // n 번째를 false..
			powerset(t, tdx + 1, x);
			brr[tdx] = true;
			powerset(t, tdx + 1, x);
		}
		return re;
	}

	private static void comb(int index, int r) {
		if (r == 0) {
			// System.out.println(Arrays.toString(trr));
			pos temp = prr[trr[0]];
			pos temp2 = prr[trr[1]];
			if (check(temp, temp2)) {
				// 계산 하기
				resum = 0;
				int t1[] = new int[m];
				for (int i = 0, tdx = 0; i < t1.length; i++, tdx++) {
					t1[tdx] = temp.y + i;
				}
				brr = new boolean[m];
				int max = 0;
				int m1 = 0;
				m1 = powerset(t1, 0, temp.x);
				if (m1 > max)
					max = m1;

				int t2[] = new int[m];
				for (int i = 0, tdx = 0; i < t1.length; i++, tdx++) {
					t2[tdx] = temp2.y + i;
				}
				max = 0;
				int m2 = 0;
				m2 = powerset(t2, 0, temp2.x);
				if (m2 > max)
					max = m2;
				resum = m1 + m2;
				System.out.println(resum);
			}
		} else if (index < r) {
			return;
		} else {
			trr[r - 1] = index - 1;
			comb(index - 1, r - 1);
			comb(index - 1, r);
		}
	}

}
