import java.util.Arrays;
import java.util.Scanner;

/*
 * 다익스트라
 * 최단 경로 알고리즘
 * 선택한 특정정점에서 출발해 각 정점까지 갈 수 있는 최단 경로를 구하는 알고리즘
 */
/*
6 10
0 1 3
0 2 5
1 2 2
1 3 6
2 1 1
2 3 4
2 4 6
3 4 2
3 5 3
4 5 6

 */
public class Z47_Dijkstra {

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
		}
		for (int i = 0; i < G.length; i++) {
			for (int j = 0; j < G.length; j++) {
				if (i == j)
					G[i][j] = 0;
				else if (G[i][j] == 0)
					G[i][j] = Integer.MAX_VALUE;
			}
		}
		int s = 0; // 시작 정점
		int[] d = new int[v];
		for (int i = 0; i < G.length; i++) {
			d[i] = G[s][i];
		} // 가중치 배열(최종 목표), 시작정점에서 각 정점까지 갈 수 있는 최단 거리를 저장할 배열
			// int[] d = G[s]; // .clone(); 배열을 깊은 복사하는 것이 바람직하지만, 시작정점의 진출정보는 더이상 사용하지 않으므로
			// 깊은 복사하지 않아도 됨

		boolean[] used = new boolean[G.length]; // 사용한 정점 저장
		for (int i = 0; i < G.length; i++) { // 한사이클 돌면 정점 1개가 선택됨
			// 사용하지 않은 정점 중 가중치가 최소인 정점을 찾아 추거ㅏ
			int minIndex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < d.length; j++) {
				if (!used[j] && min > d[j]) {
					minIndex = j;
					min = d[j];
				}
			}
			used[minIndex] = true;

			// 선택한 정점을 통해 갈 수 있는 정점의 가중치 갱신하기
			for (int j = 0; j < d.length; j++) {
				// 사용하지 않은 정점 && 인접한 정점 && 가중치가 d 배열보다 작으면 업데이트
				if (!used[j] && G[minIndex][j] != Integer.MAX_VALUE && d[j] > d[minIndex] + G[minIndex][j]) {
					d[j] = d[minIndex] + G[minIndex][j];
				}
			}

		}
		System.out.println(Arrays.toString(d));
	} // end of main
} // end of class
