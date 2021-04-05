package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑_1202_0213 {

	static class Pos implements Comparable<Pos> {
		int weight;
		int cost;

		Pos(int weight, int cost) {
			this.weight = weight;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.weight - o.weight;
		}
	}

	static int[] bag;
	static Pos[] arr;
	static int n, k;
	static PriorityQueue<Integer> q = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bag = new int[k];
		arr = new Pos[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[i] = new Pos(w, c);

		}

		for (int i = 0; i < k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		Arrays.sort(bag);

		long ans = 0;
		int s = 0;
		for (int i = 0; i < k; i++) {
			int w = bag[i];
			while (s < n) {
				if (w >= arr[s].weight) {
					// 오름차순 정렬이기에 음수로 넣어줌
					q.add(-(arr[s].cost));
					s++;
				} else
					break;
			}
			if (!q.isEmpty()) {
				ans += Math.abs(q.poll());
			}
		}

		System.out.println(ans);
	}
}
