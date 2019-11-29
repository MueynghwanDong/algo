import java.util.Arrays;

/**
 * 다익스트라 Dijkstra
 * 최단 경로 선택 알고리즘
 * 
 * 선택한 특정정점에서 출발해서 각 정점까지 갈 수 있는 최단 경로를 구하는 알고리즘
 */
public class Z47_Dijkstra {
	public static void main(String[] args) {
		final int M = Integer.MAX_VALUE;
		int [][] G = {
				{0, 3, 5, M, M, M},
				{M, 0, 2, 6, M, M},
				{M, 1, 0, 4, 6, M},
				{M, M, M, 0, 2, 3},
				{3, M, M, M, 0, 6},
				{M, M, M, M, M, 0},
				
		};
		
//		int [][] G = {
//				{5,5,4},
//				{3,9,1},
//				{3,2,7},				
//		};

		
		int s = 0; // 시작 정점
		int[] D = G[s].clone();// 가중치 배열 (최종목표), 시작 정점에서 각 정점까지 갈 수 있는 최단 거리를 저장할 배열
							   // 배열을 깊은 복사하는 것이 바람직 하지만, 시작정점의 진출정보는 더 이상 사용 x
		
		boolean[] used = new boolean[G.length]; // 사용한 정점 저장.
		for (int i = 0; i < G.length; i++) { // 한 cycle을 돌면 정점 1개가 선택됩니다.
			// 사용하지 않는 정점 중 가중치가 최소인 정점을 찾아서 추가
			int minIndex = -1;
			int min =M;
			for (int j = 0; j < D.length; j++) {
				if(!used[j] && min > D[j]) {
					minIndex = j;
					min = D[j];
				}
			}
			//System.out.println(minIndex);
			used[minIndex] = true; // 선택한 정점 표시
			
			// 선택한 정점을 통해 갈 수 있는 정점의 가중치를 갱신하기
			for (int j = 0; j < D.length; j++) {
				// 사용하지 않은 정점 중 인접한 정점 중 가중치가 지금보다  D[]보다 더 작으면 업데이트
				if(!used[j] && G[minIndex][j] != M && D[j] > D[minIndex] + G[minIndex][j]) {
					D[j] = D[minIndex] + G[minIndex][j];
				}
			}
			System.out.println(Arrays.toString(D));
		}
	
		
	} // end of main
} // end of class
