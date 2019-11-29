/**
 * 서로소 집합 = 상호 배타 집합 = Disjoint-Sets 각 원소가 같은 집합 인지, 다른 집합인지 쉽게 구분할 수 있다. 
 * 트리(연결리스트, 배열)
 */
public class Z44_Disjointsets {

	

	public static void main(String[] args) {

		for (int i = 0; i < p.length; i++) {
			make_set(i); // 0~9 정점을 각각 하나씩 원소로 하는 집합 생성
		}
		printset();

		union(0, 1);
		printset();
		union(2, 3);
		printset();
		union(0, 3);
		printset();
		union(4, 5);
		printset();
		union(6, 7);
		printset();
		union(4, 7);
		printset();
		union(3, 5);
		printset();
		union(1, 8);
		printset();
		union(0, 9);
		printset();
	} // end of main

	public static int[] p = new int[10]; // 트리구조를 배열로 저장, 부모의 정보를 저장
	public static int[] rank = new int[10]; // 깊이 정보 rank 저장할 배열
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

	// 정보 출력 메서드
	public static void printset() {
		System.out.print("index  : ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ", i); // 배열의 인덱스 출력
		}
		System.out.println();
		System.out.print("parent : ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ", p[i]); // 부모 정보 출력
		}
		System.out.println();
		System.out.print("rank   : ");
		for (int i = 0; i < rank.length; i++) {
			System.out.printf("%2d ", rank[i]); // 부모 정보 출력
		}
		System.out.println('\n');
	}
} // end of class
