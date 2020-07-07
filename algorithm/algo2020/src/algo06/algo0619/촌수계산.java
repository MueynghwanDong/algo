package algo06.algo0619;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ÃÌ¼ö°è»ê {

	static int n;
	static int[][] arr;
	static boolean[] check;
	static int x;
	static int y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		check = new boolean[n];
		x = sc.nextInt()-1;
		y = sc.nextInt() -1;
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}	

		int result = bfs();
		System.out.println(result);
	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		check[x] = true;
		queue.offer(new int[] { x, 0 });
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int r = q[0];
			if(r==y) return q[1];
			for (int i = 0; i < n; i++) {
				if (arr[r][i] == 1 && !check[i]) {
					queue.offer(new int[] { i, q[1] + 1 });
					check[i] =true;
				}
			}

		}
		return -1;
	}
}
