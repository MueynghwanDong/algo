/**
 * 비선형 자료구조의 그래프문제에서 모든 정점을 빠짐없이 순회하는 방법
 * DFS 깊이 우선 탐색 : Stack 필요
 * BFS 넓이 우선 탐색 : Queue 필요
 * input 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
 * output DFS로 순회하면서 정점을 출력 ! ( 1번부터 시작이다. )
 * 1 2 4 6 5 7 3
 */
public class Z16_DFS {

	static int[][] G = {
			{},	// 0번 정점은 안씀
			{2, 3},
			{1, 4, 5},
			{1, 7},
			{2, 6},
			{2, 6},
			{4, 5, 7},
			{3, 6}
	};
	static boolean[] visited = new boolean[8];	// 0번 정점은 안씀
	public static void main(String[] args) {
		
		int[] stack = new int[8];
		int top = -1;
		
		// 시작 정점 지정, 시작 정점 방문, 스택에 시작정점을 넣고, 반복 시작
		int v = 1;	// 시작정점을 지정, 1 A를 의미
		visited[v] = true; // 방문 체크
		// 마지막 갈림길을 스택에 저장
		System.out.print(v + " ");
		stack[++top] = v;
		
		// 반복 시작 : 스택이 비워질 때 까지 반복, 스택에서 정점을 꺼내, 인접한 && 방문하지 않은 정점을 방문하는 작업을 반복.
		while(top > -1) {
			int w = -1; // 다음 정점을 저장할 변수 선언, 플래그 변수 역할도 겸함
			for (int i = G[v].length-1; i >= 0; i--) {	// v정점에 인접한 정점만큼 반복
				if(!visited[G[v][i]]) {// 방문하지 않은 정점이면, 방문하기
					w = G[v][i];	// 다음 갈 정점을 w에 저장
					stack[++top] = w;
					visited[w] = true;	// 방문 여부 체크
					System.out.print(w + " ");
					v = w;
					break;			// DFS 하려구
				}
			}
			if(w == -1) {	// 인접한 정점 중 방문하지 않은 정점이 없는 것 (막다른 골목)
				v= stack[top--];
			}
		}
		
	}

}
