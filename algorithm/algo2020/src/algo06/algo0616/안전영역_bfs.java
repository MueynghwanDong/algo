package algo06.algo0616;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ��������_bfs {

	static int n;
	static int[][] arr;
	static boolean[][] check;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = 0;
		n = sc.nextInt();
		arr = new int[n][n];
		check =new boolean[n][n];
		int max = 0; // ���� ���̸� ã������ ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				if (max < arr[i][j])
					max = arr[i][j];
			}
		} // �Է�

		for (int i = 0; i < max; i++) {
			flood(i);
			reseting();
		}
		System.out.println(result);
	}

	public static void flood(int height) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]<=height) {
					check[i][j] = true;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] > height && !check[i][j]) {
					bfs(i, j, height);
					count++;
				}
			}
		}
		if (count > result) {
			result = count;
		}

	}

	public static void reseting() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				check[i][j] = false;
			}
		}
	}
	
	public static void bfs(int x, int y, int height) {
		Queue<int[]> queue = new LinkedList<int[]>(); // ť ����
		queue.offer(new int[] { x, y }); // ���� �� �־���
		check[x][y] =true;
		int[] q;
		while(!queue.isEmpty()) {
			q = queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int newx = q[0] + dirs[i][0];
				int newy = q[1] + dirs[i][1];
				if (newx < 0 || newy < 0 || newx >= n || newy >= n)
					continue;
				if (arr[newx][newy] > height && !check[newx][newy]) {
					check[newx][newy] = true;
					queue.offer(new int[] {newx,newy});
				}
			}
		}
		
	}

}
