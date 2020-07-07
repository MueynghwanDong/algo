package algo0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PuyoPuyo_0706 {

	static char[][] arr;
	static char[][] copy; 
	static boolean[][] brr;
	static ArrayList<int[]> list;
	static int count;
	static int answer = 0;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		arr = new char[12][6];
		copy = new char[12][6];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				arr[i][j] = s.charAt(j);
			}
		} // 입력
		while (true) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					copy[i][j] = arr[i][j];
				}
			} // 배열 복사

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (arr[i][j] != '.') {
						count = 0;
						brr = new boolean[12][6];
						list = new ArrayList<>();

						dfs(i, j, arr[i][j]); 

						if (count >= 4) { // 4개이상이면 .로 바꾸기
							for (int k = 0; k < list.size(); k++) {
								arr[list.get(k)[0]][list.get(k)[1]] = '.';
							}
						}
					}
				}
			}
			for (int i = 0; i < 6; i++) {
				for (int j = 10; j >= 0; j--) {
					if (arr[j][i] != '.' && arr[j + 1][i] == '.') {
						int r = j;
						while (r + 1 < 12 && arr[r + 1][i] == '.') {
							arr[r + 1][i] = arr[r][i];
							arr[r][i] = '.';
							r++;
						}
					}

				}
			}
			boolean check = false;
			Outer: for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (copy[i][j] != arr[i][j]) {
						check = true;
						break Outer;
					}
				}
			}

			if (!check)
				break;
			answer++;
		}
		System.out.println(answer);
	}

	public static void dfs(int x, int y, char current) {
		count++;
		list.add(new int[] { x, y });
		brr[x][y] = true;

		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && !brr[nx][ny] && arr[nx][ny] == current) {
				dfs(nx, ny, arr[nx][ny]);
			}
		}
	}
}