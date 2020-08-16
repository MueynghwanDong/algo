package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¿­¼è_9328_0726 {

	static int w;
	static int h;
	static char[][] arr;
	static boolean[][] brr;
	static int result;
	static boolean[] key;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new char[w+2][h+2];
			brr = new boolean[w+2][h+2];
			result = 0;
			queue = new LinkedList<>();
			key = new boolean[26];
			for (int i = 1; i <= w; i++) {
				String str = br.readLine();
				for (int j = 1; j <= h; j++) {
					arr[i][j] = str.charAt(j-1);
				}
			}
			
			for(int j = 0 ; j < h+2 ; j++ ){
		        arr[0][j] = '.';
		        arr[w+1][j] = '.';
		      }
		      for(int i = 0 ; i < w+2 ; i++ ){
		        arr[i][0] = '.';
		        arr[i][h+1] = '.';
		      }
			
			// Å° °ª
			String k = br.readLine();
			if (!k.equals("0")) {
				for (int i = 0; i < k.length(); i++) {
					key[k.charAt(i) - 'a'] = true;
				}
			}

			boolean check = true;
			while (check) {
				brr = new boolean[w+2][h+2];
//				search();
				check = bfs();
				// System.out.println(check);
			}
			System.out.println(result);
		}

	}

	public static boolean bfs() {

		brr[0][0] = true;
		queue.offer(new int[] {0,0});
		boolean c = false;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			// System.out.println(cx +" " + cy);
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= w+2 || ny >= h+2 || brr[nx][ny] || arr[nx][ny] == '*')
					continue;
				if (!brr[nx][ny] && arr[nx][ny] == '.') { // ºóÄ­ ÀÎ °æ¿ì
					brr[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				} else if (arr[nx][ny] >= 'A' && arr[nx][ny] <= 'Z') { // ´ë¹®ÀÚ
					for (int j = 0; j < key.length; j++) {
						if (key[(arr[nx][ny] - 'A')]) {
							queue.offer(new int[] { nx, ny });
							brr[nx][ny] = true;
						}
					}

				} else if (arr[nx][ny] >= 'a' && arr[nx][ny] <= 'z') { // ¼Ò¹®ÀÚ
					// System.out.println(nx + " " + ny + " " + arr[nx][ny]);
					if (!key[arr[nx][ny] - 'a']) {
						key[arr[nx][ny] - 'a'] = true;
						arr[nx][ny] = '.';
						c = true;
					}
					brr[nx][ny] = true;
					queue.offer(new int[] { nx, ny });

				} else if (arr[nx][ny] == '$') {
					result++;
					brr[nx][ny] = true;
					arr[nx][ny] = '.';
					queue.offer(new int[] { nx, ny });
				}
			}

		}
		return c;
	}

	public static void search() {
		for (int i = 0; i < w; i++) {
			if (arr[i][0] == '.') {
				queue.offer(new int[] { i, 0 });
				brr[i][0] = true;
			} else if (arr[i][0] >= 'A' && arr[i][0] <= 'Z') {
				if (key[arr[i][0] - 'A']) {
					queue.offer(new int[] { i, 0 });
					brr[i][0] = true;
				}
			} else if (arr[i][h - 1] == '.') {
				queue.offer(new int[] { i, h - 1 });
				brr[i][h - 1] = true;
			} else if (arr[i][h - 1] >= 'A' && arr[i][h - 1] <= 'Z') {
				if (key[arr[i][h - 1] - 'A']) {
					queue.offer(new int[] { i, h - 1 });
					brr[i][h - 1] = true;
				}

			} else if (arr[i][0] == '$') {
				result++;
				arr[i][0] = '.';
				queue.offer(new int[] { i, 0 });
				brr[i][0] = true;
			} else if (arr[i][h - 1] == '$') {
				result++;
				arr[i][0] = '.';
				queue.offer(new int[] { i, 0 });
				brr[i][0] = true;
			}
		}
		for (int i = 0; i < h; i++) {
			if (arr[0][i] == '.') {
				queue.offer(new int[] { 0, 1 });
				brr[0][i] = true;
			} else if (arr[0][i] >= 'A' && arr[0][i] <= 'Z') {

				if (key[arr[0][i] - 'A']) {
					queue.offer(new int[] { 0, i });
					brr[0][i] = true;
				}

			} else if (arr[w - 1][i] == '.') {
				queue.offer(new int[] { w - 1, 1 });
				brr[w - 1][i] = true;
			} else if (arr[w - 1][i] >= 'A' && arr[w - 1][i] <= 'Z') {
				if (key[arr[w - 1][i] - 'A']) {
					queue.offer(new int[] { w - 1, i });
					brr[w - 1][i] = true;
				}
			} else if (arr[0][i] == '$') {
				result++;
				arr[0][i] = '.';
				queue.offer(new int[] { 0, i });
				brr[0][i] = true;
			} else if (arr[w - 1][i] == '$') {
				result++;
				arr[w - 1][i] = '.';
				queue.offer(new int[] { 0, w - 1 });
				brr[w - 1][i] = true;
			}

		}
	}
}
