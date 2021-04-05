package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class øÂΩ…¿Ô¿Ã∆«¥Ÿ_1937_0312 {

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

	static int n, ans = 1;
	static Node[] nodes;
	static int arr[][], dp[][];
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		nodes = new Node[n * n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 1;
				nodes[i * n + j] = new Node(i, j, arr[i][j]);
			}
		}
		Arrays.sort(nodes);
		for (int i = 0; i < nodes.length; i++) {
			Node node = nodes[i];
			dfs(node);
		}
		System.out.println(ans);

	}

	public static void dfs(Node node) {
		long cur = node.tree;
		for (int i = 0; i < dirs.length; i++) {
			int nx = node.x + dirs[i][0];
			int ny = node.y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] <= cur)
				continue;
			dp[nx][ny] = Math.max(dp[nx][ny], dp[node.x][node.y] + 1);
			ans = Math.max(dp[nx][ny], ans);
		}
	}
}
