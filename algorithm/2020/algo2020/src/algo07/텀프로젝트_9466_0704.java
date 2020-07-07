package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트_9466_0704 {

	static int n;
	static int[] arr;
	static boolean[] brr; // 완료된 상태인지 확인하는 배열
	static boolean[] visited; // 방문 배열
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < t; testCase++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			arr = new int[n];
			brr = new boolean[n];
			visited = new boolean[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken()) - 1;
			}
			for (int i = 0; i < n; i++) {
				if (!brr[i]) { // 완료되지 않은 경우에만 dfs 호출
					dfs(i);
				}
			}
			System.out.println(n - cnt);
		}
	}

	public static void dfs(int v) {
		if (visited[v]) { // 방문했으면 완료하고 카운트 늘려주기
			brr[v] = true;
			cnt++;
		} else 
			visited[v] = true;

		if (!brr[arr[v]]) // 다음께 완료되지 않았으면 dfs 
			dfs(arr[v]);
		visited[v] = false; // dfs 마치고 fasle 원복하고 완료 
		brr[v] = true;
	}

}
