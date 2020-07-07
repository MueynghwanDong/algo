package algo06.algo0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 역사 {

	static int n;
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = -1; // a가 b보다 먼저 일어난 사건
			arr[b][a] = 1;
		}
		calc();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(arr[a][b]);
		}
	}

	public static void calc() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (arr[j][k] == 0) {
						if (arr[j][i] == 1 && arr[i][k] == 1)
							arr[j][k] = 1;
						else if (arr[j][i] == -1 && arr[i][k] == -1)
							arr[j][k] = -1;
					}
				}
			}
		}

	}

}
