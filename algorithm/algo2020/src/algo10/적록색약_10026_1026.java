package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026_1026 {

	static int n;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		brr = new boolean[n][n];
		System.out.print(bfs()+" ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]=='G')
					arr[i][j]='R';
			}
		}
		brr= new boolean[n][n];
		System.out.print(bfs()+" ");

	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (brr[i][j])
					continue;
				brr[i][j] = true;
				queue.offer(new int[] { i, j });
				while (!queue.isEmpty()) {
					int[] temp = queue.poll();
					int cx = temp[0];
					int cy = temp[1];
					for (int k = 0; k < dirs.length; k++) {
						int nx = cx + dirs[k][0];
						int ny = cy + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] != arr[cx][cy])
							continue;
						brr[nx][ny] = true;
						queue.offer(new int[] { nx, ny });
					}
				}
				cnt++;
			}
		}
		return cnt;
	}

}
