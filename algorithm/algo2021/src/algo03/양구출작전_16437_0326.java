package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class �籸������_16437_0326 {

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
		// �������� v�� ���� dfs
		for (int i = 0; i < list[v].size(); i++) {
			sum += fun(list[v].get(i));
		}
		// ���ΰ�� �߰�
		if (arr[v] == 'S') {
			return sum + score[v];
		} else {
			// �����ΰ�� sum-score[v]�� 0���� ũ�� 
			if (sum - score[v] >= 0) {
				return sum - score[v];
			} else
				return 0;
		}
	}

}
