package 보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class sol {

	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1;; testCase++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int[][] m = new int[N][N];
			int[][] memo = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					m[i][j] = str.charAt(index) - '0';
					memo[i][j] = Integer.MAX_VALUE; // 최소값 초기화
				}
			}
			memo[0][0] = m[0][0];
			// Queue<int[]> q = new LinkedList<int[]>(); // r,c, r,c까지 최소 비용
			// 우선 순위 큐, 비용이 최소인 정점부터 넣자
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			q.add(new int[] { 0, 0, m[0][0] });

			while (!q.isEmpty()) {
				// 큐에서 값 꺼내기
				int[] data = q.poll();
				int r = data[0];
				int c = data[1];
				int cost = data[2];
				if (memo[r][c] < cost)
					continue;

				for (int i = 0; i < dx.length; i++) {
					int nx = r + dx[i];
					int ny = c + dy[i];
					if (nx < N && ny < N && nx >= 0 && ny >= 0 && m[nx][ny] + memo[r][c] < memo[nx][ny]) {
						memo[nx][ny] = m[nx][ny] + memo[r][c];
						q.add(new int[] { nx, ny, memo[nx][ny] });
					}

				}
			}
			System.out.println("Problem " + testCase + ": " + memo[N - 1][N - 1]);

		}
	}

}
