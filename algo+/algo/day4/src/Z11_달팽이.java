import java.util.Arrays;

public class Z11_달팽이 {

	public static void main(String[] args) {

		int arr[][] = { { 9, 20, 2, 18, 11 }, { 19, 1, 25, 3, 21 }, { 8, 24, 10, 17, 7 }, { 15, 4, 16, 5, 6 },
				{ 12, 13, 22, 23, 14 } };
		int[] temp = new int[25];
		int idx = 0;
		int[][] newarr = new int[5][5];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[idx++] = arr[i][j];
			}
		}
		int x = 0;
		int y = 0;
		final int up = 1;
		final int left = 2;
		final int right = 3;
		final int down = 4;
		int dir = right;
		Arrays.sort(temp);
		while (idx > 0) {

			if (dir != left && dir != up && dir != down) { // 우
				dir = right;
				newarr[x][y] = temp[25 - idx];
				y++;
				idx--;
				if (y == arr.length - 1 || newarr[x][y + 1] != 0) {
					dir = down;
				}
			} else if (dir != left && dir != up && dir != right) { // 하
				dir = down;
				newarr[x][y] = temp[25 - idx];
				x++;
				idx--;
				if (x == arr.length - 1 || newarr[x + 1][y] != 0) {
					dir = left;
				}
			} else if (dir != down && dir != up && dir != right) { // 좌
				dir = left;
				newarr[x][y] = temp[25 - idx];
				y--;
				idx--;
				if (y == 0 || newarr[x][y - 1] != 0) {
					dir = up;
				}
			} else if(dir != down && dir != left && dir != right) { // 상
				dir = up;
				newarr[x][y] = temp[25 - idx];
				x--;
				idx--;
				if (x == 0 || newarr[x -1][y] != 0) {
					dir = right;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(newarr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
