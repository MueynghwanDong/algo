import java.util.Arrays;
import java.util.Scanner;
/**
 * MST 최소 신장트리를 구하는 알고리즘 Prim : 간선의 갯수가 많으면 성능이 좋다, 우선순위 큐를 활용하면 유리
 * KRUSKAL : 간선의 갯수가 적으면 성능이 좋다 
 * 7 11
 5 3 18
 1 2 21
 2 6 25
 0 2 31
 0 1 32
 3 4 34
 5 4 40
 2 4 46
 0 6 51
 4 6 51
 0 5 60
 */
public class Z45_Prim_동명환 {

	static int[][] arr;

	static int[] st;
	static int[] val;
	static boolean[] visited = new boolean[7];
	static int minidx = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		arr = new int[v][v]; // 인접행렬
		for (int i = 0; i < e; i++) {
			int start = sc.nextInt(); // 시작정점
			int end = sc.nextInt(); // 도착정점
			int val = sc.nextInt(); // 가중치
			arr[start][end] = val;
			arr[end][start] = val;
		}
		st = new int[v];
		val = new int[v];
		int startidx = sc.nextInt();
		prim(startidx, 0);
	}

	public static void prim(int n, int cnt) {
		if (cnt == arr.length) {
			int sum = 0;
			for (int i = 0; i < val.length; i++) {
				sum += val[i];
			}
			System.out.println(sum);
			return;
		}
		int temp = n;
		visited[n] = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[temp][i] != 0 && !visited[i]) {
				if ((arr[temp][i] < val[i]) || (val[i] == 0)) {
					st[i] = temp;
					val[i] = arr[temp][i];
				}
			}
			System.out.println(Arrays.toString(st));
			System.out.println(Arrays.toString(val));
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < val.length; i++) {
			if (val[i] != 0 && min > val[i] && !visited[i]) {
				min = val[i];
				minidx = i;
			}
		}
		// st[minidx] =n;
		prim(minidx, cnt + 1);
	}
}
