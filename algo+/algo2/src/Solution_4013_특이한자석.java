import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {

	private static int sum;
	private static int k;
	private static int[][] trr;
	private static Deque<String>[] qq;
	private static String[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			sum = 0;
			qq = new Deque[4];
			for (int i = 0; i < qq.length; i++) {
				qq[i] = new ArrayDeque<String>();
			}
			arr = new String[4][8];
			k = Integer.parseInt(br.readLine());
			trr = new int[k][2];
			StringTokenizer st;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					qq[i].add(st.nextToken());
					Object[] obj = qq[i].toArray();
					for (int k = 0; k < obj.length; k++) {
						arr[i][k] = String.valueOf(obj[k]);
					}
				}
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				trr[i][0] = Integer.parseInt(st.nextToken());
				trr[i][1] = Integer.parseInt(st.nextToken());
				rotate(trr[i][0] - 1, trr[i][1]);
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			for (int i = 0; i < 4; i++) {
				int temp = (int) Math.pow(2, i);
				int result = temp * Integer.parseInt(arr[i][0]);
				// System.out.println(result);
				sum = sum + result;
				// System.out.println(sum);
			}
			System.out.println(sum);
		}
	}

	public static boolean[] checkfun() {
		boolean check[] = new boolean[3]; // 회전할 것에 대해 판발하기 위한 배열
		if (arr[0][2].equals(arr[1][6]))
			check[0] = true;
		if (arr[1][2].equals(arr[2][6]))
			check[1] = true;
		if (arr[2][2].equals(arr[3][6]))
			check[2] = true;

		return check;
	}

	public static void setting() {
		for (int j = 0; j < 4; j++) {
			Object[] obj = qq[j].toArray();
			for (int k = 0; k < 8; k++) {
				arr[j][k] = String.valueOf(obj[k]);
			}

		}
	}

	private static void rotate(int mg, int dir) { // 회전할 자석번호, 방향

		switch (mg) {
		case 0:
			// 1번 자석과 자성이 다른 지 체크 -> 앞의 경우 자성이 다른 경우 1번과 2번 체크 -> 2번과 3번 체크 ....
			setting();
			boolean[] check = checkfun();
			if (check[0]) { // 자성이 같은 지 확인 -> dir 값에 따라 회전하기
				if (dir == 1) {
					qq[0].addFirst(qq[0].peekLast()); // 끝에 있는 거를 앞으로 이동 - 시계
					qq[1].addLast(qq[1].peekFirst()); // 반시계
				} else { //
					qq[0].addLast(qq[0].peekFirst()); //
					qq[1].addFirst(qq[1].peekLast());
				}
				dir = -dir;
				if (check[1]) {
					if (dir == 1) {
						// qq[1].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
						qq[2].addLast(qq[2].peekFirst()); //
					} else {
						qq[2].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
						// qq[1].addLast(qq[1].peekFirst()); //
					}
					dir = -dir;
					if (check[2]) {
						if (dir == 1) {
							// qq[2].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
							qq[3].addLast(qq[3].peekFirst()); //
						} else {
							qq[3].addFirst(qq[3].peekLast()); // 끝에 있는 거를 앞으로 이동
							// qq[2].addLast(qq[2].peekFirst()); //
						}
					}

				}
			}
			break;
		case 1:
			setting();
			check = checkfun();
			if (check[0]) { // 자성이 같은 지 확인 -> dir 값에 따라 회전하기
				if (dir == 1) {
					qq[0].addLast(qq[0].peekFirst()); //
					qq[1].addFirst(qq[1].peekLast());
				} else { // 반시계는 하나만 움직인다.
					qq[0].addFirst(qq[0].peekLast()); // 끝에 있는 거를 앞으로 이동
					qq[1].addLast(qq[1].peekFirst()); //
				}
			}
			if (check[1]) {
				if (dir == 1) {
					// qq[1].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
					qq[2].addLast(qq[2].peekFirst()); //
				} else {
					qq[2].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
					// qq[1].addLast(qq[1].peekFirst()); //
				}
				dir = -dir;
				if (check[2]) {
					if (dir == 1) {
						// qq[2].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
						qq[3].addLast(qq[3].peekFirst()); //
					} else { // 반시계는 하나만 움직인다.
						qq[3].addFirst(qq[3].peekLast()); // 끝에 있는 거를 앞으로 이동
						// qq[2].addLast(qq[2].peekFirst()); //
					}
				}
			}
			break;
		case 2:
			setting();
			check = checkfun();
			if (check[2]) { // 자성이 같은 지 확인 -> dir 값에 따라 회전하기
				if (dir == 1) {
					qq[2].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
					qq[3].addLast(qq[3].peekFirst()); //
				} else { // 반시계는 하나만 움직인다.
					qq[3].addFirst(qq[3].peekLast()); // 끝에 있는 거를 앞으로 이동
					qq[2].addLast(qq[2].peekFirst()); //
				}
			}
			if (check[1]) {
				if (dir == 1) {
					qq[1].addLast(qq[1].peekFirst()); //
				} else { // 반시계는 하나만 움직인다.
					qq[1].addFirst(qq[1].peekLast()); // 끝에 있는 거를 앞으로 이동
				}
				dir = -dir;
				if (check[0]) {
					if (dir == 1) {
						qq[0].addLast(qq[0].peekFirst()); //
						// qq[1].addLast(qq[1].peekFirst()); //
					} else { // 반시계는 하나만 움직인다.
						qq[0].addFirst(qq[0].peekLast()); // 끝에 있는 거를 앞으로 이동
						// qq[1].addFirst(qq[1].peekLast());
					}
				}
			}
			break;
		case 3:
			setting();
			check = checkfun();
			if (check[2]) { // 자성이 같은 지 확인 -> dir 값에 따라 회전하기
				if (dir == 1) {
					qq[3].addFirst(qq[3].peekLast()); // 끝에 있는 거를 앞으로 이동
					qq[2].addLast(qq[2].peekFirst()); //
				} else { // 반시계는 하나만 움직인다.
					qq[2].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
					qq[3].addLast(qq[3].peekFirst()); //
				}
				dir = -dir;
				if (check[1]) {
					if (dir == 1) {
						qq[1].addLast(qq[1].peekFirst()); //
						// qq[2].addLast(qq[2].peekFirst()); //
					} else { // 반시계는 하나만 움직인다.
						qq[1].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
						// qq[2].addFirst(qq[2].peekLast()); // 끝에 있는 거를 앞으로 이동
					}
					dir = -dir;
					if (check[0]) {
						if (dir == 1) {
							qq[0].addLast(qq[0].peekFirst()); //
							// qq[1].addLast(qq[1].peekFirst()); //
						} else { // 반시계는 하나만 움직인다.
							qq[0].addFirst(qq[0].peekLast()); // 끝에 있는 거를 앞으로 이동
							// qq[1].addFirst(qq[1].peekLast());
						}
					}

				}
			}
			break;
		}

	}

}
