package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 뱀_3190_0225 {

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, k, l;
	static int arr[][];
	static String[][] drr;
	static int d = 0;
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static Deque<Node> dq = new ArrayDeque<>();

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
			arr[a - 1][b - 1] = 2; // 사과 위치
		}
		l = Integer.parseInt(br.readLine());
		drr = new String[l][2];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			drr[i][0] = st.nextToken();
			drr[i][1] = st.nextToken();
		}
		arr[0][0] = 9; // 뱀, 시작
		dq.add(new Node(0, 0));
		fun(0, 0, 0, 1);

	}

	public static void fun(int x, int y, int count, int len) {
		check(count); // 방향 변환 체크
		int nx = x + dirs[d][0];
		int ny = y + dirs[d][1];
		if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
			count = count + 1;
			System.out.println(count);
			return;
		}
		if (arr[nx][ny] == 9) {
			count = count + 1;
			System.out.println(count);
			return;
		}
		// 사과 있는 경우
		else if (arr[nx][ny] == 2) {
			arr[nx][ny] = 9;
			dq.addFirst(new Node(nx, ny));
			fun(nx, ny, count + 1, len + 1);
		}
		// 사과 없는 경우
		else {
			Node tail = dq.removeLast(); // 마지막 거
			arr[tail.x][tail.y] = 0; // 꼬리 부분 비워주기
			arr[nx][ny] = 9;
			dq.addFirst(new Node(nx, ny));
			fun(nx, ny, count + 1, len);
		}

	}

	public static void check(int count) {
		for (int i = 0; i < drr.length; i++) {
			if (count == Integer.parseInt(drr[i][0])) {
				if (drr[i][1].equals("D")) {
					d = ((d + 1) % 4);
				} else {
					d = d - 1;
					if (d < 0) {
						d = 3;
					}
				}
			}
		}
	}

}
