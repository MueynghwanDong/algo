package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú4_13913_0304 {

	static class Node {
		int loc, cnt;
		List<Integer> list = new ArrayList<>();

		Node(int loc, int cnt, List<Integer> list) {
			this.loc = loc;
			this.cnt = cnt;
			this.list = list;
		}
	}

	static int n, m, min = Integer.MAX_VALUE;
	static int[] arr = new int[100001];
	static List<Integer> rl = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if (n >= m) {
			System.out.println(n - m);
			for (int i = n; i >=m; i--) {
				System.out.print(i+" ");
			}
			return;
		}
		bfs();
		System.out.println(min);
		for (int i = 0; i < rl.size(); i++) {
			System.out.print(rl.get(i)+" ");
		}
	}

	public static void bfs() {

		Queue<Node> q = new LinkedList<>();
		List<Integer> l = new ArrayList<>();
		l.add(n);
		q.add(new Node(n, 0, l));

		arr[n] = 0;
		while (!q.isEmpty()) {
			Node t = q.poll();

			int loc = t.loc;
			int count = t.cnt;
			List<Integer> lt = t.list;
		
			if (min < count)
				return;
			if (loc == m) {
				if (min > count)
					min = count;				
				rl = lt;
			}

			int[] dirs = { loc * 2, loc - 1, loc + 1 };
			
			for (int i = 0; i < dirs.length; i++) {
				int nx = dirs[i];
				if (nx < 0 || nx > 100000)
					continue;

				if (arr[nx] == 0 || arr[nx] == arr[loc] + 1) {
					arr[nx] = arr[loc] + 1;
					List<Integer> nl = new ArrayList<>();
					for (int j = 0; j < lt.size(); j++) {
						nl.add(lt.get(j));						
					}
					nl.add(nx);
					q.add(new Node(nx, count + 1, nl));
				}
			}

		}

	}

}
