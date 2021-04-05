package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 양구출작전_16437_0213 {

	static int n;
	static char[] arr;
	static int[] score;
	static ArrayList<Integer> list[];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		arr = new char[n + 1];
		score = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 2; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			arr[i] = s.charAt(0);
			score[i] = count;
			list[des].add(i);
		}

		System.out.println(fun(1));
	}

	public static long fun(int node) {
		long sum = 0;

		for (int i = 0; i < list[node].size(); i++) {
			sum += fun(list[node].get(i));
		}

		if (arr[node] == 'S')
			return sum + score[node];
		else {
			if (sum - score[node] >= 0)
				return sum - score[node];
			else
				return 0;
		}
	}
}
