/**
 * 비선형 자료구조 (그래프) 에서 모든 정점을 빠짐없이 순회하는 방법 중 하나.!
 * @author student
 *
 */
public class Z28_BFS {
	public static void main(String[] args) {
		int [][] G = {
				{},
				{2, 3},
				{1, 4, 5},
				{1, 7},
				{2, 6},
				{2, 6},
				{4, 5, 7},
				{3, 6}
		};
		
		int [] q = new int[1000];	// 큐 생성
		int front = -1;
		int rear = -1;
		boolean[] visited = new boolean[8];	// 0번 정점은 안씀
		
		int v = 1;
		q[++rear] = v;
		visited[v] = true;
		// 시작정점 지정, 큐에 넣기, 방문 표시
		
		while(front != rear) {	// 큐가 비어있을 때 까지 반복
			// 큐에서 꺼내기, 방문
			// 인접한 정점 중 방문하지 않은 정점을 큐에 넣고, 방문한 것으로 표시
			v = q[++front];
			System.out.println(v + " ");// 방문해서 출력하기
			
			for (int i = 0; i < G[v].length; i++) {	// 인접한 정점에 대해
				
				if (!visited[G[v][i]]) { // 방문하지 않은 정점이면
					q[++rear] = G[v][i];
					visited[G[v][i]] = true;
				}
			}
		}
		
		
		
	}	// end of main
}	// end of class
