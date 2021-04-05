package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuyoPuyo_11559_0317 {

	static class Node {
		int x, y;
		char current;

		Node(int x, int y, char current) {
			this.x = x;
			this.y = y;
			this.current = current;
		}
	}

	static char[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] brr;
	static int ans = 0, cnt = 0;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				arr[i][j] = str.charAt(j);
			}
		} // 입력
		while (true) {
			boolean c = false;

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (arr[i][j] != '.') { // 연쇄하는 것 찾기
						cnt = 0;
						brr = new boolean[12][6];
						list = new ArrayList<>();
						fun(i, j, arr[i][j]);

						if (list.size() >= 4) { // 4개 이상일 경우 연쇄
							c = true;
							for (int k = 0; k < list.size(); k++) {
								int[] t = list.get(k);
								arr[t[0]][t[1]] = '.';
							}
						}
					}
				}
			}
			// 내리기 **
			for (int j = 0; j < 6; j++) {
				for (int i = 10; i >= 0; i--) {
					if (arr[i][j] != '.' && arr[i + 1][j] == '.') {
						int r = i;
						while (r + 1 < 12 && arr[r + 1][j] == '.') {
							arr[r + 1][j] = arr[r][j];
							arr[r][j] = '.';
							r++;
						}
					}
				}
			}
			if (!c)
				break;
			ans++;
		}
		System.out.println(ans);
	}

	public static void fun(int x, int y, char cur) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, cur));
		brr[x][y] = true;
		cnt++;
		list.add(new int[] { x, y });

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = node.x + dirs[i][0];
				int ny = node.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6 || arr[nx][ny] != cur || brr[nx][ny])
					continue;
				list.add(new int[] { nx, ny });
				cnt++;
				brr[nx][ny] = true;
				q.add(new Node(nx, ny, node.current));
			}
		}
	}

}
