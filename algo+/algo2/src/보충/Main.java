package 보충;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static int[][] arr;
	private static int n;
	private static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	private static int[][] temp;
	private static Queue<int[]> q;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int problem = 1;
		while (true) {
			q = new LinkedList<int[]>();
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			temp = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < n; j++, index += 2) {
					arr[i][j] = str.charAt(index) - '0';
					temp[i][j] = Integer.MAX_VALUE;
				}
			} // �Է�
			if (n == 0)
				break;

			temp[0][0] = arr[0][0];
			q.add(new int[] { 0, 0 });
			int[] t;
			while (!q.isEmpty()) {
				t = q.poll();

				for (int i = 0; i < dirs.length; i++) {
					int nx = t[0] + dirs[i][0];
					int ny = t[1] + dirs[i][1];
					if (nx >= n || ny >= n || nx < 0 || ny < 0 || arr[nx][ny] + temp[t[0]][t[1]] >= temp[nx][ny])
						continue;
					if (arr[nx][ny] + temp[t[0]][t[1]] < temp[nx][ny]) {
						temp[nx][ny] = arr[nx][ny] + temp[t[0]][t[1]];
						q.add(new int[] { nx, ny });
					}

				}
			}
//			for (int i = 0; i < temp.length; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
			System.out.println("Problem " + problem++ + ": " + temp[n - 1][n - 1]);
		}
	}

}
