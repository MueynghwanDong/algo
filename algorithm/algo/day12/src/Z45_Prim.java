import java.util.Scanner;

/**
 * MST 최소 신장트리를 구하는 알고리즘 Prim : 간선의 갯수가 많으면 성능이 좋다, 우선순위 큐를 활용하면 유리
 * KRUSKAL : 간선의 갯수가 적으면 성능이 좋다 
 * 7 11
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
public class Z45_Prim {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[][] G = new int[v][v]; // 인접행렬
		for (int i = 0; i < e; i++) {
			int start = sc.nextInt(); // 시작정점
			int end = sc.nextInt(); // 도착정점
			int val = sc.nextInt(); // 가중치
			G[start][end] = val;
			G[end][start] = val;
		}
		int[] p = new int[G.length]; // 부모의 index를 저장할 배열
		int[] val = new int[G.length]; // 최소 가중치를 저장할 배열
		boolean[] selected = new boolean[v];
		
		int r = sc.nextInt();
		// 시작 정점에서 자신으로 가는 가중치는 0으로 저장, 시작 정점을 기준으로 갈 수 있는 경로의 가중치 최소화
		for (int i = 0; i < selected.length; i++) {
			if (G[r][i] > 0) {// 인접합
				val[i] = G[r][i];
				p[i] = r; // 부모 표시
			} else { // 인접하지 않음, 무한대 표시
				val[i] = Integer.MAX_VALUE; // 무한대 표시
			}
		}
		val[r] = 0; // 자기자신은 가중치 0
		p[r] = r; // 부모저장;
		selected[r] = true; // 시작정점 표시

		for (int i = 1; i < v; i++) { // 정점의 개수 v, mst 간선의 개수 v-1개, 한싸이클마다 1개의 간선을 선택
			// 선택하지 않은 정점중에 가중치의 최소 정점 선택하기
			int minIndex = -1; // 최소값의 방번호
			int min = Integer.MAX_VALUE; // 최소값
			for (int j = 0; j < val.length; j++) {
				if (!selected[j] && min > val[j]) {
					min = val[j];
					minIndex = j;
				}
			}
			r = minIndex;
			selected[r] = true;
			System.out.println(p[r] + "-" + r + " " + val[r]);
			// 선택한 정점을 기준으로 개척된 새로운 간선 가중치를 업데이트(가중치가 작어질 경우만)
			for (int j = 0; j < G[r].length; j++) {
				// 선택안한 정점중, 인접했고, 가중치가 더 작으면 업데이트
				if (!selected[j] && G[r][j] != 0 && val[j] > G[r][j]) {
					val[j] = G[r][j];
					p[j] = r;
				}
			}
		}
		// 최소 신장트리의 목적 : 전체 가중치 합 구하기
		int mst = 0;
		for (int i = 0; i < val.length; i++) {
			mst += val[i];
		}
		System.out.println("prim으로 구한 mst의 전체 가중치 합 : " + mst);

	} // end of main
} // end of class