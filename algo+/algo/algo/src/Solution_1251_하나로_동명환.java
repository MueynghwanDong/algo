import java.util.Arrays;
import java.util.Scanner;

public class Solution_1251_하나로_동명환 {
	public static class Edge implements Comparable<Edge> {
		int a; 
		int b; 
		long val; 
		public Edge(int a, int b, long val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.val, o.val);
		}
	}

	public static int[] p; 
	public static int[] rank; 
	private static int[] dx;
	private static int[] dy;
	private static int n;
	private static double e;
	private static Edge[] G;

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

	public static void fun() {
		int index = 0;
		for (int i = 0; i < n-1; i++) {
			int x = dx[i];
			int y = dy[i];
			for (int j = i+1; j < n; j++) {
				int nx = dx[j];
				int ny = dy[j];
				long t1 = Math.abs(x-nx);
				long t2 = Math.abs(y-ny);
				long data = (t1*t1 + t2*t2);
				
				G[index++] = new Edge(i, j, data);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testCase = 1; testCase <= t; testCase++) {
			n = sc.nextInt();
			dx= new int[n];
			dy= new int[n];
			for (int i = 0; i < dx.length; i++) {
				dx[i] = sc.nextInt();
			}
			for (int i = 0; i < dy.length; i++) {
				dy[i] = sc.nextInt();
			}
			e = sc.nextDouble();
			G = new Edge[n*(n-1)/2]; 
			fun();
			Arrays.sort(G);

			p = new int[n]; 
			rank = new int[n];
			for (int i = 0; i < n; i++) {
				make_set(i); 
			}
			long mst = 0; 
			int cnt = 0;
			for (int i = 0; i < G.length; i++) {
				Edge edge = G[i]; 
				int px = find_set(edge.a); 
				int py = find_set(edge.b);
				if (px != py) { 
					union(px, py);
					mst += edge.val;
					cnt++;
					if (cnt == n - 1) {
						break;
					}
				}
			}
			System.out.println("#" + testCase + " " + Math.round(e * mst));
		}
	}
}