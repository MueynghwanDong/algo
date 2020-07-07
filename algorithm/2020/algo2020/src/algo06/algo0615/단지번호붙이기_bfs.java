package algo06.algo0615;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ������ȣ���̱�_bfs {

	public static PriorityQueue<Integer> pq; // �켱����ť
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int arr[][];
	static boolean visited[][];
	static int n;

	public static void bfs(int x, int y) {

		Queue<int[]> queue = new LinkedList<int[]>(); // ť ����
		queue.offer(new int[] { x, y }); // ���� �� �־���
		int count = 0; // ������ ������ ī��Ʈ�� ����
		
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
		arr = new int[n][n]; // �Է������� ���� �迭
		visited = new boolean[n][n]; // �̵� �ߴ��� Ȯ���ϴ� boolean �迭
		pq = new PriorityQueue<Integer>(); // �켱����ť ����

		// �Է�
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		// ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		// ��ü ������ ��� - ��� ������ �ִ��� 
		System.out.println(pq.size());
		// �켱������ ���� �� ���� �����Ե�..
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	} // end of main
} // end of class