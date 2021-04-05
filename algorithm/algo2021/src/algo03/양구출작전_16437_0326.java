package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 양구출작전_16437_0326 {

	static int n;
	static int[] score;
	static char[] arr;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n + 1];
		score = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 2; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			arr[i] = s.charAt(0);
			score[i] = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			list[des].add(i);
		}
		System.out.println(fun(1));
	}

	public static long fun(int v) {
		long sum = 0;
		// 목적지가 v인 곳을 dfs
		for (int i = 0; i < list[v].size(); i++) {
			sum += fun(list[v].get(i));
		}
		// 양인경우 추가
		if (arr[v] == 'S') {
			return sum + score[v];
		} else {
			// 늑대인경우 sum-score[v]가 0보다 크면 
			if (sum - score[v] >= 0) {
				return sum - score[v];
			} else
				return 0;
		}
	}

}
