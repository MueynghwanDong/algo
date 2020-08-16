package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 로고 {
	static Queue<Integer> q = new LinkedList<>();
	static boolean visited[];
	static rec store[];
	static int n;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		store = new rec[n + 1]; // n개의 직사각형을 갖는 배열
		visited = new boolean[n + 1];

		store[0] = new rec(0, 0, 0, 0);
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			store[i] = new rec(x1, y1, x2, y2);
		}

		for (int i = 0; i <= n; i++) {
			if (visited[i])
				continue;
			
			visited[i] = true;
			q.add(i);
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int j = 0; j <= n; j++) {
					if (cur == j || !check(cur, j) || visited[j])
						continue;

					visited[j] = true;
					q.add(j);
				}
			}
			cnt++;
		}
		System.out.println(cnt - 1);
	}

	
	static boolean check(int cur, int next) {
		rec c = store[cur];
		rec n = store[next];

		// 겹치지 않는 경우 
		if ((c.x1 < n.x1 && n.x2 < c.x2 && c.y1 < n.y1 && n.y2 < c.y2)
				|| (c.x1 > n.x1 && n.x2 > c.x2 && c.y1 > n.y1 && n.y2 > c.y2) || c.x2 < n.x1 || c.x1 > n.x2
				|| c.y2 < n.y1 || c.y1 > n.y2)
			return false;

		return true;

	}

}

class rec {
	int x1, y1, x2, y2;

	rec(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}