package 코테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 뱀_3190_0401 {

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, k, l, d = 0;
	static String[][] drr;
	static int[][] arr;
	static Deque<Node> dq = new ArrayDeque<>();
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a - 1][b - 1] = 2;
		}
		l = Integer.parseInt(br.readLine());
		drr = new String[l][2];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			drr[i][0] = st.nextToken();
			drr[i][1] = st.nextToken();
		}
		dq.add(new Node(0, 0));
		arr[0][0] = 9; // 뱀의 초기위치
		fun(0, 0, 0, 1);

	}

	public static void fun(int x, int y, int cnt, int len) {
		check(cnt);
		int nx = x + dirs[d][0];
		int ny = y + dirs[d][1];
		if (nx < 0 || ny < 0 || nx >= n || ny >= n) { // 범위 밖인 경우
			System.out.println(cnt + 1);
			return;
		} else if (arr[nx][ny] == 9) { // 뱀을 만난 경우
			System.out.println(cnt + 1);
			return;
		} else if (arr[nx][ny] == 2) { // 사과일 경우
			dq.addFirst(new Node(nx, ny));
			arr[nx][ny] = 9;
			fun(nx, ny, cnt + 1, len + 1);
		} else { // 사과 아닌 경우
			Node n =dq.removeLast();
			dq.addFirst(new Node(nx, ny));
			arr[nx][ny] = 9;
			arr[n.x][n.y] = 0;
			fun(nx, ny, cnt + 1, len);
		}
	}

	public static void check(int count) { //방향 변환 체크
		for (int i = 0; i < drr.length; i++) {
			if (count == Integer.parseInt(drr[i][0])) {
				if (drr[i][1].equals("D")) { // 시계방향
					d = ((d + 1) % 4);
				} else { // 반시계방향
					d = d - 1;
					if (d < 0)
						d = 3;
				}
			}
		}
	}
}
