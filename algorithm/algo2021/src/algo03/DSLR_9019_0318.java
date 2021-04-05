package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR_9019_0318 {


	static String[] command;
	static boolean[] brr;
	static int s, e;
	static String ans = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tcase = 0; tcase < t; tcase++) {
			command = new String[10000];
			brr = new boolean[10000];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			Arrays.fill(command,"");
			brr[s] = true;
			bfs();
			System.out.println(command[e]);
		}
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		// q.add(new Node(s, Integer.parseInt(e), "")); // current, target, result =>
		// 추가되는 것

		while (!q.isEmpty()) {
			int cur = q.poll();
			int d = cur * 2 % 10000;
			int s = 0;
			if (cur == 0) {
				s = 9999;
			} else {
				s = cur - 1;
			}
			int l = (cur % 1000) * 10 + cur / 1000;
			int r = (cur % 10) * 1000 + cur / 10;

			if (!brr[d]) {
				q.add(d);
				brr[d] = true;
				command[d] = command[cur] + "D";
			}
			if (!brr[s]) {
				q.add(s);
				brr[s] = true;
				command[s] = command[cur] + "S";
			}
			if (!brr[l]) {
				q.add(l);
				brr[l] = true;
				command[l] = command[cur] + "L";
			}
			if (!brr[r]) {
				q.add(r);
				brr[r] = true;
				command[r] = command[cur] + "R";
			}

		}
	}

}
