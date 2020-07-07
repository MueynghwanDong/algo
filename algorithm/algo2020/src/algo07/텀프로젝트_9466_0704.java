package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��������Ʈ_9466_0704 {

	static int n;
	static int[] arr;
	static boolean[] brr; // �Ϸ�� �������� Ȯ���ϴ� �迭
	static boolean[] visited; // �湮 �迭
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
				if (!brr[i]) { // �Ϸ���� ���� ��쿡�� dfs ȣ��
					dfs(i);
				}
			}
			System.out.println(n - cnt);
		}
	}

	public static void dfs(int v) {
		if (visited[v]) { // �湮������ �Ϸ��ϰ� ī��Ʈ �÷��ֱ�
			brr[v] = true;
			cnt++;
		} else 
			visited[v] = true;

		if (!brr[arr[v]]) // ������ �Ϸ���� �ʾ����� dfs 
			dfs(arr[v]);
		visited[v] = false; // dfs ��ġ�� fasle �����ϰ� �Ϸ� 
		brr[v] = true;
	}

}
