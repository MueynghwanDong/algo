package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2_���ĺ�_1987 {

	static int n, m, ans = 0;
	static int[][] disr = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] arr;
	static boolean[] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[26];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		} // �Է�
		brr[arr[0][0] - 'A'] = true; // ù ���ĺ�
		dfs(0, 0, 1); // x,y ��ġ / cnt��
		brr[arr[0][0] - 'A'] = false;
		System.out.println(ans);
	}

	public static void dfs(int x, int y, int cnt) {

		if (ans < cnt)
			ans = cnt;

		for (int i = 0; i < disr.length; i++) {
			int nx = x + disr[i][0];
			int ny = y + disr[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[arr[nx][ny] - 'A']) // ������ �Ѿ�ų� �̹� �湮�� ���ĺ��� ���
				continue;
			brr[arr[nx][ny] - 'A'] = true;
			dfs(nx, ny, cnt + 1);
			brr[arr[nx][ny] - 'A'] = false;

		}
	}
}
