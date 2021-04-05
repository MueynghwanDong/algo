package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회장뽑기_2660_0108 {

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
			if (s == -1 && e == -1) { // 종료 조건
				break;
			}
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {		// 1~n까지 반복하면서 체크
			bfs(i);
			if (min > depth[i])
				min = depth[i];
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (depth[i] == min) {
				list.add(i); // min 값과 일치하는 값 => 회장 후보
			}
		}
		System.out.println(min + " " + list.size());
		// 회장 후보 리스트 출력
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
				if (brr[i] || arr[c][i] == 0) // 친구가 아닌 경우, 이미 체크한 경우 continue
					continue;
				// 지나가지 않은 경우와 c와 i 의 arr 값이 1인 경우 큐에 넣기
				queue.add(new int[] { i, cnt + 1 });
				brr[i] = true;
				if (max < cnt + 1)
					max = cnt + 1;
			}
			depth[s] = max; // 가장 큰 값을 depth 배열에 넣어주기 - 인덱스는 s
		}
	}

}
