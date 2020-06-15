/*
 * 비선형 자료구조 (그래프) 모든 정점을 빠짐없이 순회 하는 방법중 하나
 * BFS 너비 우선 탐색
 */
public class Z28_BFS {
	public static void main(String[] args) {
		int[][] G = {
				{}, // 정점 0에 인접한 정점
				{ 2, 3 },
				{ 1, 4, 5 }, 
				{ 1, 7 }, 
				{ 2, 6 },
				{ 2, 6 }, 
				{ 4, 5, 7 }, 
				{ 3, 6 } 
				};
		 
		int[] q = new int[100];
		int front = -1;
		int rear = -1;
		boolean [] visited = new boolean[8]; // 0번은 안씀
		
		// 시작 정점 지정, 큐에 넣기, 방문 표시
		int v= 1; 
		q[++rear] = v;
		visited[v] = true;
		
		while(front!=rear) {// 큐가 비어있을 때 까지 반복
			// 큐에서 꺼내기 , 방문
			v = q[++front];
			System.out.print(v + " "); // 방문해서 출력하기
			//인접 정점중 방문하지 않은 정점을 큐에 넣고, 방문 표시
			for (int i = G[v].length-1; i >=0 ; i--) { // 인접한 정점에 대해
				if(!visited[G[v][i]]) { // 방문하지 않은 정점이라면
					q[++rear] = G[v][i]; // 큐에 넣고 방문한 것으로 표시
					visited[G[v][i]] = true;
				}
			}
		}
	}// end of main
} // end of class
