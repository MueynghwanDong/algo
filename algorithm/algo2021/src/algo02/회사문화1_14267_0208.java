package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 회사문화1_14267_0208 {

	static int n, m;
	static List<Integer> list[];
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num != -1)
				list[num].add(i);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 칭찬 받은 직원
			int b = Integer.parseInt(st.nextToken()); // 칭찬 수치
			result[a] += b;
		}
		dfs(1);
		for (int i = 1; i <= n; i++) {
			System.out.print(result[i] + " ");
		}

	}

	public static void dfs(int me) {
		for (int i = 0; i < list[me].size(); i++) {
			int num = list[me].get(i);
			result[num] += result[me];
			dfs(num);
		}

	}
}
