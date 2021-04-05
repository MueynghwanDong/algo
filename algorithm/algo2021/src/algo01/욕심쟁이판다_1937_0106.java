package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ��������Ǵ�_1937_0106 {
	
	// Comparable!! 
	static class Node implements Comparable<Node> {
		int x;
		int y;
		long tree;

		Node(int x, int y, long tree) {
			this.x = x;
			this.y = y;
			this.tree = tree;
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.tree - o.tree);
		}
	}

	static int n;
	static int[][] arr;
	static int[][] dp;
	static Node[] nodearr;
	static long max;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		nodearr = new Node[n * n]; // �����Ͽ� ���� ���� �� ���� ����

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				nodearr[n * i + j] = new Node(i, j, arr[i][j]);
			}
		}
		Arrays.sort(nodearr);
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 1);
		}
		max = 1;
		for (int i = 0; i < nodearr.length; i++) {
			Node item = nodearr[i];
			fun(item);
		}
		System.out.println(max);
	}

	public static void fun(Node item) {
		long ctree = item.tree;
		for (int i = 0; i < dirs.length; i++) {
			int nx = item.x + dirs[i][0];
			int ny = item.y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || ctree >=arr[nx][ny])
				continue;
			if (ctree < arr[nx][ny]) { // ���� ���� ū �ͺ��� üũ
				dp[nx][ny] = Math.max(dp[item.x][item.y] + 1, dp[nx][ny]);
				max = Math.max(dp[nx][ny], max);
			}
		}
	}

}
