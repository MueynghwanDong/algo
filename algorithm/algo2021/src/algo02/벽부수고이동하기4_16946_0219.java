package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 벽부수고이동하기4_16946_0219 {

	static int n, m;
	static int[][] arr;
	static int[][] groups;
	static int[][] result;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Map<Integer, Integer> gsize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		groups = new int[n][m];
		result = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		} // 입력

		int gcnt = 1;
		gsize = new HashMap<>();
		// map에 gcnt 별로 값넣어주기 , 0 구역별로
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && groups[i][j] == 0) {
					gsize.put(gcnt, fun(i, j, gcnt));
					gcnt++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (groups[i][j] == 0 && arr[i][j] != 0) {
					sb.append(check(i, j) + "");
					continue;
				}
				sb.append(0 + "");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int check(int x, int y) {
		int sum = 1;
		// if (arr[x][y] == 0)
		// return 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || groups[nx][ny] == 0)
				continue;
			set.add(groups[nx][ny]);
		}
		// 인접한 노드가 0이면 groups 값을 넣어줌. set을 통해 중복 제거
		for (int size : set) {
			sum += gsize.get(size);
		}
		return sum % 10;
	}

	public static int fun(int x, int y, int gcnt) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		groups[x][y] = gcnt;
		int cnt = 1;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || groups[nx][ny] != 0 || arr[nx][ny] != 0)
					continue;
				groups[nx][ny] = gcnt;
				cnt++;
				queue.add(new int[] { nx, ny });
			}
		}
		return cnt;
	}
}
