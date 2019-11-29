import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석_동명환 {

	private static int sum;
	private static int k;
	private static int[][] trr;
	private static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			sum = 0;
			arr = new int[4][8];
			k = Integer.parseInt(br.readLine());
			trr = new int[k][2];
			StringTokenizer st;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				trr[i][0] = Integer.parseInt(st.nextToken());
				trr[i][1] = Integer.parseInt(st.nextToken());
				rotate(trr[i][0] - 1, trr[i][1]);
			}
//			for (int i = 0; i < arr.length; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			for (int i = 0; i < 4; i++) {
				int temp = (int) Math.pow(2, i);
				int result = temp * arr[i][0];
				// System.out.println(result);
				sum = sum + result;
				// System.out.println(sum);
			}
			System.out.println("#" + testCase + " " +sum);
		}
	}

	public static boolean[] checkfun() {
		boolean check[] = new boolean[3]; // 회전할 것에 대해 판발하기 위한 배열
		if (arr[0][2] != arr[1][6])
			check[0] = true;
		if (arr[1][2] != arr[2][6])
			check[1] = true;
		if (arr[2][2] != arr[3][6])
			check[2] = true;

		return check;
	}

	public static void move(int dir, int idx) {
		if (dir == 1) { // 시계
			int temp = arr[idx][7];
			for (int i = 7; i > 0; i--) {
				arr[idx][i] = arr[idx][i - 1];
			}
			arr[idx][0] = temp;
		} else { // 반시계
			int temp = arr[idx][0];
			for (int i = 0; i < 7; i++) {
				arr[idx][i] = arr[idx][i + 1];
			}
			arr[idx][7] = temp;
		}
	}

	private static void rotate(int mg, int dir) { // 회전할 자석번호, 방향

		boolean check[] = checkfun();
		if (mg == 0) {
			move(dir, 0);
			if (check[0]) {
				move(-dir, 1);
				if (check[1]) {
					move(dir, 2);
					if (check[2]) {
						move(-dir, 3);
					}
				}
			}
		} else if (mg == 1) {
			move(dir, 1);
			if (check[0]) {
				move(-dir, 0);
			}
			if (check[1]) {
				move(-dir, 2);
				if (check[2]) {
					move(dir, 3);
				}
			}
		} else if (mg == 2) {
			move(dir, 2);
			if (check[1]) {
				move(-dir, 1);
				if (check[0]) {
					move(dir, 0);
				}
			}
			if (check[2]) {
				move(-dir, 3);
			}
		} else if (mg == 3) {
			move(dir, 3);
			if (check[2]) {
				move(-dir, 2);
				if (check[1]) {
					move(dir, 1);
					if (check[0]) {
						move(-dir, 0);
					}
				}
			}
		}
	}
}
