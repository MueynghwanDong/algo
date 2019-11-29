import java.util.Scanner;

public class bj_2667 {

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int arr[][];
	static boolean visited[][];
	static int cnt = 0;
	static int[] count;

	public static void dfs(int x, int y) {

		visited[x][y] = true;
		count[cnt]++;
		for (int i = 0; i < dir.length; i++) {
			int newx = x + dir[i][0];
			int newy = y + dir[i][1];
			if (newx < 0 || newy < 0 || newx >= arr.length || newy >= arr.length)
				continue;
			if (!visited[newx][newy] && arr[newx][newy] == 1) {
				dfs(newx, newy);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		visited = new boolean[n][n];
		count = new int[n];

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.println(count[i]);
		}
	} // end of main
} // end of class
