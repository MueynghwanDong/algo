package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú2_12851_0910 {

	static int n;
	static int m;
	static int[] arr = new int[100001];
	static int min = Integer.MAX_VALUE;
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		if(n>=m) {
			System.out.println((n-m));
			System.out.println(1);
			return;
		}
		
		bfs();
		
		System.out.println(min);
		System.out.println(time);

	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		arr[n] = 1;
		while (!queue.isEmpty()) {
			int loc = queue.poll();
			if (min < arr[loc])
				return;
			
			int dir[] = { loc - 1, loc + 1, loc * 2 };
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i];
				if (nx == m) {
					min = arr[loc];
					time++;
				}
				if (nx < 0 || nx > 100000)
					continue;
				if (arr[nx] == 0 || arr[nx] == arr[loc] + 1) {
					queue.add(nx);
					arr[nx] = arr[loc] + 1;
				}

			}
		}

	}

}
