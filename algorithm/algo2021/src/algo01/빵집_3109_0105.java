package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_3109_0105 {

	static int n, m;
	static int ans = 0;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		} // �Է�
		for (int i = 0; i < n; i++) {
			if (dfs(i, 0)) { // ���� �����ϴ� ��� ans++
				ans++;
			}
		}
		System.out.println(ans);
	}

	public static boolean dfs(int x, int y) {
		brr[x][y] = true; // �湮 ǥ��
		if (y == m - 1) { // ������ ����
			return true;
		}
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 'x')
				continue;
			boolean c = dfs(nx, ny); // ������ ���� ���������� true ��ȯ
			if (c) {
				return true;
			}
		}
		// �������� ���ϰ� ���� ��� false ��ȯ
		return false;
	}

}
