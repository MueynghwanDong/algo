import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1954_달팽이숫자_동명환 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int num = Integer.parseInt(br.readLine());
			int arr[][] = new int[num][num];
			int idx = 1;
			int[][] newarr = new int[num][num];
			int x = 0;
			int y = 0;
			final int up = 1;
			final int left = 2;
			final int right = 3;
			final int down = 4;
			int dir = right;

			while (idx <= num * num) {

				if (dir != left && dir != up && dir != down) { // 우
					dir = right;
					newarr[x][y] = idx;
					y++;
					idx++;
					if (y == arr.length - 1 || newarr[x][y + 1] != 0) {
						dir = down;
					}
				} else if (dir != left && dir != up && dir != right) { // 하
					dir = down;
					newarr[x][y] = idx;
					x++;
					idx++;
					if (x == arr.length - 1 || newarr[x + 1][y] != 0) {
						dir = left;
					}
				} else if (dir != down && dir != up && dir != right) { // 좌
					dir = left;
					newarr[x][y] = idx;
					y--;
					idx++;
					if (y == 0 || newarr[x][y - 1] != 0) {
						dir = up;
					}
				} else if (dir != down && dir != left && dir != right) { // 상
					dir = up;
					newarr[x][y] = idx;
					x--;
					idx++;
					if (x == 0 || newarr[x - 1][y] != 0) {
						dir = right;
					}
				}
			}
			System.out.println("#" + testCase);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(newarr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
