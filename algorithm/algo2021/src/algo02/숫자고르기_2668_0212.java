package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 숫자고르기_2668_0212 {

	static int n, finish;
	static int[] arr;
	static boolean[] brr;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		brr = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= n; i++) {
			brr[i] = true;
			finish = i;
			dfs(i);
			brr[i] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void dfs(int v) {
		if (!brr[arr[v]]) {
			brr[arr[v]] = true;
			dfs(arr[v]);
			brr[arr[v]] = false;
		}
		if (finish == arr[v])
			list.add(finish);
	}

}
