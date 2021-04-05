package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커붙이기_18808_0303 {

	static int n, m, k, ans = 0;
	static int[][] arr; // 노트북 배열
	static int[][] temp; // 각 스티커를 저장할 배열
	static int nr, nc; // 스티커 크기를 기억하는 변수 / nr, nc는 회전에 따라 변할 수 있는 변수

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
			temp = new int[r][c]; // 스티커 배열
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
		// nr, nc는 회전에 따라 변할 수 있는 변수
		for (int rotate = 0; rotate < 4; rotate++) { // 회전
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (i + nr > n || j + nc > m)
						continue; // 노트북 크기를 벗어나는 경우
					boolean isput = true;
					out: for (int k = 0; k < nr; k++) {
						for (int l = 0; l < nc; l++) {
							if (arr[i + k][j + l] == 1 && temp[k][l] == 1) { // 다른 스티커와 겹치는 경우
								isput = false;
								break out;
							}
						}
					}
					if (isput) {
						for (int k = 0; k < nr; k++) {
							for (int l = 0; l < nc; l++) {
								if (temp[k][l] == 1) { // 다른 스티커와 겹치는 경우
									arr[i + k][j + l] = 1;
								}
							}
						}
						return true; // 스티커 붙인 경우
					}
				}
			}
			if (rotate == 3) // 횟전해도 스티커를 못붙임ㅠㅠ
				break;
			rotate(rotate, r, c); // 회전
		}
		return false;
	}

	public static void rotate(int rotate, int r, int c) {
		int[][] tms; // 연산할 임시 배열
		int bfr, bfc;
		// nr, nc를 기억하는 변수, nr/nc는 회전에 따라 변화될 수 있기때문
		if (rotate == 1) { // 90도 회전
			bfr = nr;
			bfc = nc;
			nr = r;
			nc = c;
			tms = new int[r][c];

		} else { // 180도 회전
			bfr = nr;
			bfc = nc;
			nr = c;
			nc = r;
			tms = new int[c][r];
		}
		// System.out.println(r + " " + c + " " + tms[0].length);
		for (int i = 0; i < bfr; i++) {
			for (int j = 0; j < bfc; j++) {
				tms[j][nc - 1 - i] = temp[i][j]; // 회전 수행
			}
		}
		// 회전한 스티커 - 돌아가서 재연산 수행
		temp = new int[nr][nc];
		for (int i = 0; i < nr; i++) {
			System.arraycopy(tms[i], 0, temp[i], 0, nc);
		}
	}
}
