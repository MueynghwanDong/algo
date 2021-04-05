package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 등수찾기_17616_0309 {

	static ArrayList<ArrayList<Integer>> lower;
	static ArrayList<ArrayList<Integer>> higher;
	static int n, m, k;
	static boolean[] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		lower = new ArrayList<>();
		higher = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			lower.add(new ArrayList<>());
			higher.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			higher.get(a).add(b);
			lower.get(b).add(a);
		}
//		System.out.println("high");
		int high = bfs(k, higher);
//		System.out.println("low");
		int low = bfs(k, lower);
		System.out.println((1 + low) + " " + (n - high));
	}

	public static int bfs(int x, ArrayList<ArrayList<Integer>> list) {
		brr = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		brr[x] = true;
		q.add(x);
		int result = 0;
		int nx;
		while (!q.isEmpty()) {
			int c = q.poll();
//			System.out.println("c: " + c);
			for (int i = 0; i < list.get(c).size(); i++) {
				nx = list.get(c).get(i);
				if (!brr[nx]) {
					brr[nx] = true;
					q.add(nx);
					result++;
				}

			}
		}
		return result;
	}

}
