import java.util.Arrays;
import java.util.Scanner;

public class Solution_1210_SW문제해결기본2일차_Ladder1_동명환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] laddr = new int[100][100];

		for (int t = 0; t < 10; t++) {
			int tNum = sc.nextInt();
			for (int i = 0; i < laddr.length; i++)
				for (int j = 0; j < laddr[0].length; j++)
					laddr[i][j] = sc.nextInt();
			System.out.println("#" + tNum + " " + ladder(laddr));
		}
	}

	public static int ladder(int[][] laddr) {
		int[][] visit = new int[100][100];

		for (int k = 0; k < laddr.length; k++) {
			int i = 0;
			int j = k;
			if (laddr[0][k] == 1) {
				for (int a = 0; a < visit.length; a++)
					Arrays.fill(visit[a], 0);
				visit[0][k] = 1;

				while (i < laddr.length - 1) { // 맨 왼쪽 (오른쪽 체크)
					if (j == 0) {
						if (laddr[i][j + 1] == 1 && visit[i][j + 1] == 0) {
							j++;
							visit[i][j] = 1;
							continue;
						}
					}// 맨 오른쪽(왼쪽 체크)
					else if (j == laddr.length - 1) {
						if (laddr[i][j - 1] == 1 && visit[i][j - 1] == 0) {
							j--;
							visit[i][j] = 1;
							continue;
						}
					} else { // 오른쪽, 왼쪽 체크
						if (laddr[i][j + 1] == 1 && visit[i][j + 1] == 0) {
							j++;
							visit[i][j] = 1;
							continue;
						} else if (laddr[i][j - 1] == 1 && visit[i][j - 1] == 0) {
							j--;
							visit[i][j] = 1;
							continue;
						}
					}
					// 아래로
					i++;
					visit[i][j] = 1;

				}

			}
			if (laddr[i][j] == 2)
				return k;
		}

		return 0;
	}
}