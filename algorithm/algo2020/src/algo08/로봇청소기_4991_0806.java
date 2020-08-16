package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �κ�û�ұ�_4991_0806 {

	static int n;
	static int m;
	static int cnt;
	static int[][] dis;
	static char[][] arr;
	static boolean[] selected;
	static ArrayList<int[]> list;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			arr = new char[n][m];
			list = new ArrayList<>();
			if (m == 0 && n == 0)
				break;
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == 'o') {
						list.add(0, new int[] { i, j }); // ù��°��û�ұ� ��ġ
					} else if (arr[i][j] == '*')
						list.add(new int[] { i, j }); // ����
				}
			}
			int size = list.size();
			dis = new int[size][size]; // û�ұ�� ���� �� / ������ ���� �� �Ÿ�
			selected = new boolean[size]; // �湮�ߴ��� üũ

			for (int i = 0; i < size; i++) {
				if (bfs(i) == -1) { // ���� �� ���� ���� �ִ� ���� ����
					cnt = -1;
					break;
				}
			}
			// for (int i = 0; i < size; i++) {
			// for (int j = 0; j < size; j++) {
			// System.out.print(dis[i][j]);
			// }
			// System.out.println();
			// }
			if (cnt == -1) {
				System.out.println(cnt);
				continue;
			} else {
				cnt = Integer.MAX_VALUE;
				selected[0] = true;
				dfs(0, 0, 0); // û�ұ� ��ġ���� ����
				System.out.println(cnt);
			}

		}
	}

	public static void dfs(int depth, int dist, int from) {
		// System.out.println(depth + " " + dist + " " + from);
		// ��� ���� �湮 ������ �ּҰ� ���� �� ����
		if (depth == selected.length - 1) {
			cnt = cnt > dist ? dist : cnt;
			return;
		}
		for (int i = 1; i < selected.length; i++) {
			if (!selected[i]) {
				selected[i] = true;
				dfs(depth + 1, dist + dis[from][i], i);
				selected[i] = false;
			}
		}
	}

	public static int bfs(int from) { // ������ �Ÿ� �迭�� �� �־��ְ� ���� �Ұ� ���� üũ!!
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		int dust = 0;
		int count = 0;
		int tmp[] = list.get(from);
		visited[tmp[0]][tmp[1]] = true;
		queue.offer(tmp);

		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int k = 0; k < size; k++) {

				int q[] = queue.poll();
				int cx = q[0];
				int cy = q[1];

				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || arr[nx][ny] == 'x')
						continue;
					if (arr[nx][ny] == 'o' || arr[nx][ny] == '*') {
						// ���� ������ �ε��� ���� ã��
						for (int j = 0; j < list.size(); j++) {
							int[] end = list.get(j);
							if (end[0] == nx && end[1] == ny) {
								// �Ÿ� �迭 ����
								dis[from][j] = count;
								dis[j][from] = count;
								dust++;
							}
						}
					}
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
		if (dust != list.size() - 1)
			return -1;
		else
			return 0;

	}

}
