package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미네랄_2933_1203 {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int r, c;
	static char[][] crr;
	static boolean[][] brr;
	static ArrayList<Node> cluster;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		crr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				crr[i][j] = str.charAt(j);
			}
		}
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			int h = r - arr[i];
			if (i % 2 == 0) { // 왼쪽에서 오른쪽으로
				for (int j = 0; j < c; j++) {
					if (crr[h][j] == 'x') {
						crr[h][j] = '.';
						break;
					}
				}
			} else { // 오른쪽에서 왼쪽으로 이동
				for (int j = c - 1; j >= 0; j--) {
					if (crr[h][j] == 'x') {
						crr[h][j] = '.';
						break;
					}
				}
			}
			find();
			// cluster 사이즈가 0이 아니면 떨어뜨려야할 것이 존재한다는 의미
			if (cluster.size() != 0) {
				downcluster();
			}
			cluster.clear();
			
		}
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				System.out.print(crr[j][k]);
			}
			System.out.println();
		}

	}

	public static void downcluster() {
		int cnt = 0;
		for (Node n : cluster) {
			crr[n.r][n.c] = '.'; // 현재 위치 빈칸 만들기
		}
		outer: for (int i = 1; i < r; i++) {
			for (Node n : cluster) {
				if (n.r + i >= r || crr[n.r + i][n.c] == 'x') {
					break outer;
				}
			}
			// 현재 위치에서 빈칸.인 곳 찾아서 cnt값에 차이값 넣어주기
			cnt = i;
		}
		for (Node n : cluster) {
			crr[n.r + cnt][n.c] = 'x'; // 떨어지는 값 만큼 더해서 x 만들기
		}
	}

	public static void find() {
		cluster = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		brr = new boolean[r][c];
		
		// 밑단의 x에서 이동할수 있으면 cluster 떨어지지 않아도 된다는 의미
		for (int i = 0; i < c; i++) {
			if (crr[r - 1][i] == 'x') { // 제일 밑단
				q.offer(new Node(r - 1, i));
				brr[r - 1][i] = true;
			}
		}
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.r + dirs[i][0];
				int ny = cur.c + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || crr[nx][ny] == '.' || brr[nx][ny])
					continue;
				brr[nx][ny] = true;
				q.offer(new Node(nx, ny));
			}
		}
		// brr이 true 된 것은 공중에 떠있지 않은 것
		// x이지만 brr이 false인 것은 공중에 떠있는 것이므로 떨어지는 연산 수행해야함.
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!brr[i][j] && crr[i][j] == 'x') {
					cluster.add(new Node(i, j));
				}
			}
		}
	}

}
