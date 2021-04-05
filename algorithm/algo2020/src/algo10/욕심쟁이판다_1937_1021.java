package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class øÂΩ…¿Ô¿Ã∆«¥Ÿ_1937_1021 {

	static class Node implements Comparable<Node> {
		int x, y;
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
	static long[][] arr;
	static long[][] dp;
	static Node[] nodeArr;
	static long max = 0;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n][n];
		dp = new long[n][n];
		nodeArr = new Node[n * n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
				nodeArr[n * i + j] = new Node(i, j, arr[i][j]);
			}
		}
		Arrays.sort(nodeArr);
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 1);
		}
		max = 1;
		for (int i = 0; i < nodeArr.length; i++) {
			Node item = nodeArr[i];
			fun(item, n);
		}
		System.out.println(max);

	}

	public static void fun(Node item, int n) {
		long tree = item.tree;
		for (int i = 0; i < dirs.length; i++) {
			int x = item.x + dirs[i][0];
			int y = item.y + dirs[i][1];
			if (x >= 0 && x < n && y >= 0 && y < n) {
				if (arr[x][y] > tree) {
					dp[x][y] = Math.max(dp[x][y], dp[item.x][item.y] + 1);
					max = Math.max(max, dp[x][y]);
				}
			}

		}
	}
}
