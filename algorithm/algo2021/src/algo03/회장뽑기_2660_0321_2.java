package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class »∏¿ÂªÃ±‚_2660_0321_2 {

	static int[][] arr;
	static int n, INF = 10000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (s == -1 && e == -1) {
				break;
			}
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == 0 && i != j)
					arr[i][j] = INF;
			}
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		int[] result = new int[n + 1];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= n; j++) {
				if (max < arr[i][j])
					max = arr[i][j];
			}
			result[i] = max;
		}

		for (int i = 1; i <= n; i++) {
			if (result[i] < min)
				min = result[i];
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (result[i] == min) {
				list.add(i);
			}
		}
		System.out.println(min + " " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
