package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ȸ��̱�_2660_0108 {

	static int n;
	static int[][] arr;
	static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		depth = new int[n + 1];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (s == -1 && e == -1) { // ���� ����
				break;
			}
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {		// 1~n���� �ݺ��ϸ鼭 üũ
			bfs(i);
			if (min > depth[i])
				min = depth[i];
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (depth[i] == min) {
				list.add(i); // min ���� ��ġ�ϴ� �� => ȸ�� �ĺ�
			}
		}
		System.out.println(min + " " + list.size());
		// ȸ�� �ĺ� ����Ʈ ���
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();

	}

	public static void bfs(int s) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { s, 0 });
		boolean[] brr = new boolean[n + 1];
		brr[s] = true;
		int max = 0;

		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int c = q[0];
			int cnt = q[1];
			for (int i = 1; i <= n; i++) {
				if (brr[i] || arr[c][i] == 0) // ģ���� �ƴ� ���, �̹� üũ�� ��� continue
					continue;
				// �������� ���� ���� c�� i �� arr ���� 1�� ��� ť�� �ֱ�
				queue.add(new int[] { i, cnt + 1 });
				brr[i] = true;
				if (max < cnt + 1)
					max = cnt + 1;
			}
			depth[s] = max; // ���� ū ���� depth �迭�� �־��ֱ� - �ε����� s
		}
	}

}
