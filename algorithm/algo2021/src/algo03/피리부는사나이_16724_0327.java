package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �Ǹ��δ»糪��_16724_0327 {

	static int n, m, ans = 0, finish;
	static char[][] crr;
	static int[] arr;
	static boolean[] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; // UDRL - ���� �����ֱ�

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		crr = new char[n][m];
		arr = new int[n * m]; // ��ü ��ġ�� �Ϸķ� ��Ÿ���� ����
		brr = new boolean[n * m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				crr[i][j] = str.charAt(j);
				int d = 0;
				if (crr[i][j] == 'U')
					d = 0;
				else if (crr[i][j] == 'D')
					d = 1;
				else if (crr[i][j] == 'R')
					d = 2;
				else if (crr[i][j] == 'L')
					d = 3;
				int nx = i + dirs[d][0];
				int ny = j + dirs[d][1];
				arr[i * m + j] = nx * m + ny; // ������ġ ����
			}
		}
		for (int i = 0; i < n * m; i++) { 
			if (!brr[i]) {
				brr[i] = true;
				finish = i; // ���� ��ġ
				dfs(i);
			}
		}
		System.out.println(ans);
	}

	public static boolean dfs(int v) {
		if (!brr[arr[v]]) { // ������ġ�� �湮 ���� ���� ��� 
			brr[arr[v]] = true;
			boolean c = dfs(arr[v]);
			if (c)
				return true;
			brr[arr[v]] = false;
		}

		if (finish == arr[v]) { // finish�� ���� �湮 ��ġ��� ���� , ����Ŭ�� �� ���
			ans++;
			return true;
		}
		return false;
	}

}
