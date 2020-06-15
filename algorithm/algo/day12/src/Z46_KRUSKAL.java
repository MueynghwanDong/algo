import java.util.Arrays;
import java.util.Scanner;

/* 7 11
 5 3 18
 1 2 21
 2 6 25
 0 2 31
 0 1 32
 3 4 34
 5 4 40
 2 4 46
 0 6 51
 4 6 51
 0 5 60
 */

//* MST 알고리즘 : Prim, Kruskal 간선의 정보를 가중치 기준으로 오름차순 정렬 최소 가중치의 간선을 선택한다 v-1 사이클이  생기는 간선은 선택하지 않는다. -> 서로소 집합으로 사이클하는지 확인

public class Z46_KRUSKAL {
	// 하나의 간선을 추상화 한 클래스
	public static class Edge implements Comparable<Edge> {
		int a; // 정점1
		int b; // 정점2
		int val; // 가중치

		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		@Override
		public String toString() {
			return " [" + a + ", " + b + ", " + val + "]";
		}

		@Override
		public int compareTo(Edge o) {// 가중치를 기준으로 오름 차순 정렬
			return this.val - o.val;
		}

	}

	public static int[] p; // 트리구조를 배열로 저장, 부모의 정보를 저장
	public static int[] rank; // 깊이 정보 rank 저장할 배열
	// 멤버 x, 멤버 y를 포함하는 두 집합을 통합

	public static void union(int x, int y) {
		int px = find_set(x); // 대표자 구해옴
		int py = find_set(y);
		// 서로 다른 집합일 경우만 합쳐야함. 같은 집합인데 합치면 stackoverflow 발생
		if (px != py) {
			Link(px, py);
		}
	}

	public static void Link(int px, int py) {
		if (rank[px] > rank[py])
			p[py] = px; // 작은 쪽을 큰 쪽에 붙인다.
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
			p[x] = find_set(p[x]); // path compression
			return p[x];
		}
	}

	// 멤버 x를 포함하는 새로운 집합을 생성
	public static void make_set(int x) {
		p[x] = x; // 부모가 자기자신이면 대표자 or 부모가 -1이면 대표자
		rank[x] = 0; // 초기값 0임
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		Edge[] G = new Edge[e]; // 간선 저장할 배열
		for (int i = 0; i < e; i++) {
			G[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(G);

		p = new int[v]; // 부모 정점을 저장할 배열
		rank = new int[v];
		for (int i = 0; i < v; i++) {
			make_set(i); // 각 정점을 각각 하나의 집합으로 생성
		}
		int mst = 0; // 가중치 합
		int cnt = 0;
		for (int i = 0; i < e; i++) {
			Edge edge = G[i]; // 작은 가중치 간선부터 꺼낸다.
			int px = find_set(edge.a); // 대표자를 찾음
			int py = find_set(edge.b);
			if (px != py) { // 사이클이 생기지 않을 경우만 합치기
				union(px, py);
				System.out.println(edge.a + "-" + edge.val); // 선택한 간선 출력
				mst += edge.val;
				cnt++;
				if (cnt == v - 1) {
					break;
				}
			}
		}
		System.out.println("KRUSKAL로 구한 MST 전체 가중치 합 : " + mst);
	} // end of main
} // end of class
