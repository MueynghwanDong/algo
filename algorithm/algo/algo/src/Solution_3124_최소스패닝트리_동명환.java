import java.util.Arrays;
import java.util.Scanner;

public class Solution_3124_최소스패닝트리_동명환 {
	public static class Edge implements Comparable<Edge> {
		int a; 
		int b; 
		int val; 

		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) {
			return this.val - o.val;
		}
	}

	public static int[] p; 
	public static int[] rank; 

	public static void union(int x, int y) {
		int px = find_set(x); 
		int py = find_set(y);
		if (px != py) {
			Link(px, py);
		}
	}

	public static void Link(int px, int py) {
		if (rank[px] > rank[py])
			p[py] = px; 
		else {
			p[px] = py;
			if (rank[px] == rank[py])
				rank[py]++;
		}
	}

	public static int find_set(int x) {
		if (p[x] == x) {
			return x;
		} else {
			p[x] = find_set(p[x]); 
			return p[x];
		}
	}

	public static void make_set(int x) {
		p[x] = x; 
		rank[x] = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testCase = 1; testCase <= t; testCase++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			Edge[] G = new Edge[e]; 
			for (int i = 0; i < e; i++) {
				G[i] = new Edge(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt());
			}
			Arrays.sort(G);
			p = new int[v];
			rank = new int[v];
			for (int i = 0; i < v; i++) {
				make_set(i); 
			}
			long mst = 0; 
			int cnt = 0;
			for (int i = 0; i < e; i++) {
				Edge edge = G[i]; 
				int px = find_set(edge.a); 
				int py = find_set(edge.b);
				if (px != py) { 
					union(px, py);
					mst += edge.val;
					cnt++;
					if (cnt == v - 1) {
						break;
					}
				}
			}
			System.out.println("#" + testCase + " " + mst);
		}
	}
}