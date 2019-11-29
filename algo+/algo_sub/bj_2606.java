import java.util.Scanner;

public class bj_2606 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		int M = sc.nextInt();
		int arr[][] = new int[G + 1][G + 1];
		boolean visited[] = new boolean[G + 1];
		int q[] = new int[(G + 1) * (G + 1)];
		int front = -1;
		int rear = -1;
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
		}
		int cnt = 0;
		int v = 1; // 시작 정점
		visited[v] = true; // 방문 표시
		q[++rear] = v; // 큐에 넣기

		while (rear != front) {
			v = q[++front]; // 큐에서 빼기
			for (int i = 0; i < arr[v].length; i++) {
				if (!visited[i] && arr[v][i] == 1) { // 인접 정점이 방문하지 않고 연결되어 있는 경우
					q[++rear] = i; // 큐에 넣고
					visited[i] = true; // 방문 표시
					cnt++; // 연결된 정점 갯수 카운트
				}
			}
		}
		System.out.println(cnt);

	} // end of main
}
