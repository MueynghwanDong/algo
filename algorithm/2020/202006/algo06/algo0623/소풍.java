package algo0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��ǳ {

	static int k;
	static int n;
	static int f;
	static int[] student;
	static boolean[] brr;
	static int[][] arr;
	static boolean done = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		student = new int[n + 1];
		brr = new boolean[n + 1];
		for (int i = 0; i < f; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
			student[x]++;
			student[y]++;
		}
		for (int i = 1; i <= n; i++) {
			if (student[i] < k - 1)
				continue;
			if (done)
				break;

			brr[i] = true;
			dfs(i, 1);
			brr[i] = false;
		}
		if (!done)
			System.out.println(-1);
	}

	public static void dfs(int now, int d) {
		if (done)
			return;
		if (d == k) { // k�� �����Ǿ��� ��
			for (int i = 1; i <= n; i++) {
				if (brr[i])
					System.out.println(i);
			}
			done = true;
			return;
		}
		for (int i = now + 1; i <= n; i++) {
			if (arr[now][i] == 1 && isfriends(i)) { // ���� now�� ģ���� ���
				brr[i] = true;
				dfs(i, d + 1);
				brr[i] = false;
			}
		}
	}

	public static boolean isfriends(int t) { // ģ�� ���� Ȯ��
		for (int i = 1; i <= n; i++) {
			if (brr[i] && arr[t][i] != 1) // ģ�� �ƴ� ���
				return false;
		}
		return true;
	}
}
