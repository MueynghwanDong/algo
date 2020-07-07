package algo0615;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호붙이기_bfs {

	public static PriorityQueue<Integer> pq; // 우선순위큐
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int arr[][];
	static boolean visited[][];
	static int n;

	public static void bfs(int x, int y) {

		Queue<int[]> queue = new LinkedList<int[]>(); // 큐 생성
		queue.offer(new int[] { x, y }); // 시작 값 넣어줌
		int count = 0; // 단지별 갯수를 카운트할 변수
		
		while (!queue.isEmpty()) {
			int cx = queue.peek()[0]; 
			int cy = queue.peek()[1];
			queue.poll();

			if (arr[cx][cy] == 0 || visited[cx][cy])
				continue;
			count += 1;
			visited[cx][cy] = true;
			for (int i = 0; i < dir.length; i++) {
				int newx = cx + dir[i][0];
				int newy = cy + dir[i][1];
				if (newx < 0 || newy < 0 || newx >= n || newy >= n)
					continue;
				queue.offer(new int[] { newx, newy });
				
			}
		}
		pq.offer(count);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); 
		arr = new int[n][n]; // 입력정보를 담을 배열
		visited = new boolean[n][n]; // 이동 했는지 확인하는 boolean 배열
		pq = new PriorityQueue<Integer>(); // 우선순위큐 생성

		// 입력
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		// 시작
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		// 전체 사이즈 출력 - 몇개의 단지가 있는지 
		System.out.println(pq.size());
		// 우선순위는 작은 수 부터 나오게됨..
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	} // end of main
} // end of class