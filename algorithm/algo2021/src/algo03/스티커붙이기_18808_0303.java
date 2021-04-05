package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��ƼĿ���̱�_18808_0303 {

	static int n, m, k, ans = 0;
	static int[][] arr; // ��Ʈ�� �迭
	static int[][] temp; // �� ��ƼĿ�� ������ �迭
	static int nr, nc; // ��ƼĿ ũ�⸦ ����ϴ� ���� / nr, nc�� ȸ���� ���� ���� �� �ִ� ����

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		int r = 0, c = 0;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int cnt = 0;
			temp = new int[r][c]; // ��ƼĿ �迭
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < c; k++) {
					temp[j][k] = Integer.parseInt(st.nextToken());
					if (temp[j][k] == 1)
						cnt++;
				}
			}
			nr = r;
			nc = c;
			boolean check = fun(r, c);
			if (check)
				ans += cnt;
		}
		System.out.println(ans);
	}

	public static boolean fun(int r, int c) {
		// nr, nc�� ȸ���� ���� ���� �� �ִ� ����
		for (int rotate = 0; rotate < 4; rotate++) { // ȸ��
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (i + nr > n || j + nc > m)
						continue; // ��Ʈ�� ũ�⸦ ����� ���
					boolean isput = true;
					out: for (int k = 0; k < nr; k++) {
						for (int l = 0; l < nc; l++) {
							if (arr[i + k][j + l] == 1 && temp[k][l] == 1) { // �ٸ� ��ƼĿ�� ��ġ�� ���
								isput = false;
								break out;
							}
						}
					}
					if (isput) {
						for (int k = 0; k < nr; k++) {
							for (int l = 0; l < nc; l++) {
								if (temp[k][l] == 1) { // �ٸ� ��ƼĿ�� ��ġ�� ���
									arr[i + k][j + l] = 1;
								}
							}
						}
						return true; // ��ƼĿ ���� ���
					}
				}
			}
			if (rotate == 3) // Ƚ���ص� ��ƼĿ�� �����ӤФ�
				break;
			rotate(rotate, r, c); // ȸ��
		}
		return false;
	}

	public static void rotate(int rotate, int r, int c) {
		int[][] tms; // ������ �ӽ� �迭
		int bfr, bfc;
		// nr, nc�� ����ϴ� ����, nr/nc�� ȸ���� ���� ��ȭ�� �� �ֱ⶧��
		if (rotate == 1) { // 90�� ȸ��
			bfr = nr;
			bfc = nc;
			nr = r;
			nc = c;
			tms = new int[r][c];

		} else { // 180�� ȸ��
			bfr = nr;
			bfc = nc;
			nr = c;
			nc = r;
			tms = new int[c][r];
		}
		// System.out.println(r + " " + c + " " + tms[0].length);
		for (int i = 0; i < bfr; i++) {
			for (int j = 0; j < bfc; j++) {
				tms[j][nc - 1 - i] = temp[i][j]; // ȸ�� ����
			}
		}
		// ȸ���� ��ƼĿ - ���ư��� �翬�� ����
		temp = new int[nr][nc];
		for (int i = 0; i < nr; i++) {
			System.arraycopy(tms[i], 0, temp[i], 0, nc);
		}
	}
}
