package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 등수찾기_17616_0309_2 {

	static class Node {
		ArrayList<Integer> lower;
		ArrayList<Integer> higher;

		Node(ArrayList<Integer> lower, ArrayList<Integer> higher) {
			this.lower = lower;
			this.higher = higher;
		}
	}

	static int n, m, k;
	static Node[] nodes;
	static boolean[] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nodes = new Node[n + 1];

		for (int i = 1; i < n + 1; i++) {
			ArrayList<Integer> lower = new ArrayList<>();
			ArrayList<Integer> higher = new ArrayList<>();
			nodes[i] = new Node(lower, higher);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].lower.add(b);
			nodes[b].higher.add(a);
		}
		brr = new boolean[n + 1];
		int h = fun(k, 0);
		brr = new boolean[n + 1];
		int l = fun(k, 1);
		System.out.println((h+1)+" " +(n-l));
	}

	public static int fun(int x, int d) {
		brr = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		brr[x] = true;
		q.add(x);
		int result = 0;
		int nx;
		if (d == 0) {
			while (!q.isEmpty()) {
				int c = q.poll();
				for (int i = 0; i < nodes[c].higher.size(); i++) {
					nx = nodes[c].higher.get(i);
					if (!brr[nx]) {
						brr[nx] = true;
						q.add(nx);
						result++;
					}

				}
			}
		} else {
			while (!q.isEmpty()) {
				int c = q.poll();
				for (int i = 0; i < nodes[c].lower.size(); i++) {
					nx = nodes[c].lower.get(i);
					if (!brr[nx]) {
						brr[nx] = true;
						q.add(nx);
						result++;
					}

				}
			}
		}
		return result;
	}
}
