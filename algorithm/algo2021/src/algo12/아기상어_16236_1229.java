package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236_1229 {

	static class shark implements Comparable<shark> {

		int x;
		int y;
		int size;
		int eat;
		int step;

		shark(int x, int y, int size, int eat, int step) {
			this.x = x;
			this.y = y;
			this.eat = eat;
			this.size = size;
			this.step = step;
		}

		@Override
		public int compareTo(shark o) {
			if (this.x != o.x) {
				return this.x - o.x;
			} else {
				return this.y - o.y;
			}
		}
	}

	static int n;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] arr;
	static boolean[][] brr;
	static int cnt, time = 0;
	static ArrayList<shark> t = new ArrayList<>();
	static Queue<shark> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 9 && arr[i][j] != 0)
					cnt++;
				else if (arr[i][j] == 9) {
					t.add(new shark(i, j, 2, 0, 0));
				}
			}
		}
		if (cnt == 0) {
			System.out.println(0);
			return;
		}
		while (true) {
			init();
			bfs();
			if (t.size() < 1)
				break;
		}
		System.out.println(time);
	}

	public static void init() { // 초기화
		q.clear();
		Collections.sort(t);
		shark s = t.get(0); // 가장 우선순위 높은 위치 선택
		time += s.step; // 이동한 횟수만큼 추가

		if (s.size == s.eat) { // 현재 사이즈와 먹은 수가 같이면 사이즈 UP
			q.add(new shark(s.x, s.y, s.size + 1, 0, 0));
		} else { // 아닌 경우 step만 0으로
			q.add(new shark(s.x, s.y, s.size, s.eat, 0));
		}
		t.clear(); // t 리스트 초기화
		brr = new boolean[n][n];
		// 상어 시작 위치 초기화
		brr[s.x][s.y] = true;
		arr[s.x][s.y] = 0;

	}

	public static void bfs() {
		int l = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			shark cur = q.poll();
			if (cur.step > l)
				return;
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.x + dirs[i][0];
				int ny = cur.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny])
					continue;
				brr[nx][ny] = true;
				// 사이즈가 같거나 빈칸이면 그냥 지나치기, step만 +1
				if (arr[nx][ny] == cur.size || arr[nx][ny] == 0) {
					q.add(new shark(nx, ny, cur.size, cur.eat, cur.step + 1));
				} else if (arr[nx][ny] != 0 && arr[nx][ny] < cur.size) {
					// 빈칸 아니고 사이즈가 상어보다 작으면 먹음
					// 상어 리스트에 추가
					t.add(new shark(nx, ny, cur.size, cur.eat + 1, cur.step + 1));
					l = cur.step;
				}
			}

		}
	}
}
