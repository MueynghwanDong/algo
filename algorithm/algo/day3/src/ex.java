import java.util.Scanner;

public class ex {

	public static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // 하, 상, 우, 좌
	static int laddr[][] = new int[100][100];
	static boolean convert = false; // 방향전환 여부
	static String direct = "Down";

	public static void move(int x, int y) { // 행 열
		int resulty = y;
		while (true) {

			if (!(direct.equals("R") || direct.equals("L"))) {
				direct = leftright(x, y);
			}

			if (direct.equals("R")) {
				int newy = y + dirs[2][1];

				if (newy == laddr.length) {
					x++;
				} else if (laddr[x][newy] == 0 || newy > laddr.length - 1) {
					x++;
					direct = "";
					convert = false;
					continue;
				} else {
					y = y + dirs[2][1];
				}
			} else if (direct.equals("L")) {
				int newy = y + dirs[3][1];
				convert = true;
				if (newy == 0) {
					x++;
				} else if (laddr[x][newy] == 0 || newy < 0) {
					x++;
					direct = "";
					convert = false;
					continue;
				} else {
					y = y + dirs[3][1];
				}
			} else {
				if (x == laddr.length - 1) {
				} else {
					x++;
					convert = false;
				}
			}
			if (x == laddr.length - 1) {

				if (laddr[x][y] == 2) {
					System.out.println("# " + resulty);
					break;
				} else {
					break;
				}

			}

		}
	}

	public static String leftright(int currentx, int currenty) {
		// 오른쪽
		int newRy = currenty + dirs[2][1];
		if ((newRy > 0) && (newRy < laddr.length)) {
			if (laddr[currentx][newRy] == 1) { // 오른쪽 방향 가능

				direct = "R";
			}
		}
		// 왼쪽
		int newLy = currenty + dirs[3][1];
		if ((newLy > 0) && (newLy < laddr.length)) {
			if (laddr[currentx][newLy] == 1) { // 왼쪽 방향 가능

				direct = "L";
			}
		}
		return direct;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 1; testCase++) {
			//int t = sc.nextInt();
			int startarr[] = new int[100]; // 시작가능 위치 같는 배열
			int endx = 0; // 종료 지점 x 좌표
			int idx = 0; // 시작 가능 인덱스
			int endy = 0; // 종료 지점 y 좌표
			laddr = new int[100][100];

			for (int i = 0; i < laddr.length; i++) {
				for (int j = 0; j < laddr.length; j++) {
					laddr[i][j] = sc.nextInt();
					if (laddr[i][j] == 2) {
						endx = i;
						endy = j;
					}
				}
				if (i == 0) {
					for (int j = 0; j < laddr.length; j++) {
						if (laddr[i][j] == 1) {
							startarr[idx++] = j;
						}
					}
				}
			} // 입력 및 시작 가능 위치, 종료 위치 끝

			for (int i = 1; i < idx; i++) {
				//System.out.println(startarr[i]);
				//System.out.print("#"+testCase);
				move(0, startarr[i]);
			}

		}
	}
}
