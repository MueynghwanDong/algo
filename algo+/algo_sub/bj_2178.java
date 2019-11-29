import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs로 풀어야함...
public class bj_2178 {

	public static int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
	static boolean[][] visited;
	static int[][] arr;
	static int n, m;
	static Queue<pos> q = new LinkedList<>(); // 큐 생성

	static class pos {
		int x;
		int y;
		int cnt;

		pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static int bfs() {
		pos temp;
		int result = 0;
		while (!q.isEmpty()) {
			temp = q.poll(); // 큐에 들어 있는 값 빼주기
			if (temp.x == n - 1 && temp.y == m - 1) { // 목표 지점에 도달 했을 경우
				result = temp.cnt;
				break;
			}
			for (int i = 0; i < dir.length; i++) {
				int newx = temp.x + dir[i][0];
				int newy = temp.y + dir[i][1];
				if (newx < 0 || newy < 0 || newx >= n || newy >= m)
					continue;
				if (!visited[newx][newy] && arr[newx][newy] == 1) {
					int cnt = temp.cnt + 1; // 방문 횟수 늘려주기
					visited[newx][newy] = true;
					q.offer(new pos(newx, newy, cnt));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		pos p = new pos(0, 0, 1); // 초기값 지정
		visited[0][0] = true; // 초기 방문
		q.offer(p); // 큐에 넣기
		System.out.println(bfs());
		// 구현하기

	}
}
