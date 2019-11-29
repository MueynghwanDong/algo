import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_정올_1863_종교_동명환 {

	public static class Edge {
		int a;
		int b;

		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
		}

	}

	static int prr[];
	static int rank[];
	private static int n;
	private static int[] arr;
	private static Set<Integer> set;

	public static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		if (px != py) {
			Link(px, py);
		}
	}

	public static void Link(int px, int py) {
		if (rank[px] > rank[py])
			prr[py] = px;
		else {
			prr[px] = py;
			if (rank[px] == rank[py])
				rank[py]++;
		}
	}

	public static int find_set(int x) {
		if (prr[x] == x) {
			return x;
		} else {
			prr[x] = find_set(prr[x]); // path compression
			return prr[x];
		}
	}

	public static void make_set(int x) {
		prr[x] = x;
		rank[x] = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		prr = new int[n + 1];
		rank = new int[n + 1];
		arr = new int[n + 1];

		Edge[] g = new Edge[m];
		for (int i = 0; i < arr.length; i++) {
			make_set(i);
		}
		for (int i = 0; i < m; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			g[i] = new Edge(p, c);
		}

		for (int i = 0; i < m; i++) {
			int px = find_set(g[i].a);
			int py = find_set(g[i].b);
			if (px != py) {
				union(px, py);
			}

		}
		for (int i = 0; i < n + 1; i++) {
			find_set(i);
		}

		set = new HashSet<>();
		for (int i = 0; i < prr.length; i++) {
			set.add(prr[i]);
		}
		if (m == 0) {
			System.out.println(n);
		} else {
			System.out.println(set.size() - 1);
		}
	}

}
