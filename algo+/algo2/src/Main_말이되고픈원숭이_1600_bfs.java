import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_말이되고픈원숭이_1600_bfs {

	private static int k;
	private static int w;
	private static int h;
	private static int[][] m;
	private static int minMoveCnt;
	private static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1, -1, 1, 0, 0 };
	private static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2, 0, 0, -1, 1 };
	private static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		m = new int[h][w];
		for (int i = 0; i < h; i++) {
			String str = br.readLine();
			for (int j = 0, index = 0; j < w; j++, index += 2) {
				m[i][j] = str.charAt(index) - '0';
			}
		}
		minMoveCnt = Integer.MAX_VALUE;
		visited = new boolean[h][w][k + 1]; // 좌표 , 말처럼이동할 수 있는 남은 횟수
		visited[0][0][k] = true;
		Queue<int[]> q = new LinkedList<int[]>(); // {r,c,k,moveCnt} moveCnt -> 현재까지 이동한 횟수
		q.add(new int[] { 0, 0, k, 0 });
		while (!q.isEmpty()) {

			int[] temp = q.poll(); // 큐에서 하나 꺼냄.
			int r = temp[0];
			int c = temp[1];
			int kk = temp[2];
			int moveCnt = temp[3];

			// 목적지에 도착하면 최소값 업데이트
			if (r == h - 1 && c == w - 1) {
				if (minMoveCnt > moveCnt)
					minMoveCnt = moveCnt;
				break; // 가장 적은 이동 횟수인 경우
			}
//			if(minMoveCnt <=moveCnt) continue; // dfs에서만 필요
			// 이동경로들을 큐에 넣기 -> 방문체크

			for (int i = 8; i < 12; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc][kk] && m[nr][nc] == 0) {
					visited[nr][nc][kk] = true;
					q.add(new int[] { nr, nc, kk, moveCnt + 1 });
				}
			}
			if (kk == 0)
				continue;

			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc][kk - 1] && m[nr][nc] == 0) {
					visited[nr][nc][kk - 1] = true;
					q.add(new int[] { nr, nc, kk - 1, moveCnt + 1 });
				}
			}
		}
		System.out.println(minMoveCnt == Integer.MAX_VALUE ? -1 : minMoveCnt);
	}

}
