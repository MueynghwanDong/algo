import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol_bj_17144 {

	private static int R;
	private static int C;
	private static int airY;
	private static int airX;
	private static int[][] m1;
	private static int[][] m2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		m1 = new int[R][C]; // 원본
		m2 = new int[R][C]; // 작업 공간
		airY = -1; // 공기청정기 행 첫번째 좌표
		airX = -1; // 공기 청정기 열
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				m1[i][j] = Integer.parseInt(st.nextToken()); // -1<= 먼지 <= 1000
				if (airY == -1 && m1[i][j] == -1) {
					airY = i;
					airX = j;
				}
			}
		}
		for (int i = 0; i < T; i++) { // 타임만큼 반복, m1이 원본, m2 작업공간
			// 초기화
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					m2[r][c] = 0;
				}
			}
			m2[airY][airX] = -1;
			m2[airY + 1][airX] = -1;
			// 1 단계 확산
			spread();
			// 2 단계 순환 - 상단, 하단
			circleup();
			circledown();

			int[][] temp = m1;
			m1 = m2;
			m2 = temp;
		}
		// 먼지 합 출력
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += m1[i][j];
			}
		}
		System.out.println(sum + 2);
	} // end of main

	public static void spread() { // m1 원본 배열을 읽어 m2에 작업하기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (m1[r][c] == 0 || m1[r][c] == -1)
					continue;
				int v = m1[r][c] / 5; // 인접칸에 퍼트릴 값
				int cnt = 0; // 퍼트린 횟수
				if (0 <= r - 1 && m2[r - 1][c] != -1) { // 상
					m2[r - 1][c] += v;
					cnt++;
				}
				if (r + 1 < R && m2[r + 1][c] != -1) { // 하
					m2[r + 1][c] += v;
					cnt++;
				}
				if (0 <= c - 1 && m2[r][c - 1] != -1) { // 좌
					m2[r][c - 1] += v;
					cnt++;
				}
				if (c + 1 < C && m2[r][c + 1] != -1) { // 우
					m2[r][c + 1] += v;
					cnt++;
				}
				m2[r][c] += m1[r][c] - cnt * v;
			}
		}
	}

	public static void circleup() {
		int r = airY - 1;
		; // 공기청정기 -위 , 초기 시작위치를 공기청정기 -1
		int c = airX;
		for (; r - 1 >= 0; r--) { // 상
			m2[r][c] = m2[r - 1][c];
		}
		for (; c + 1 < C; c++) { // 우
			m2[r][c] = m2[r][c + 1];
		}
		for (; r + 1 <= airY; r++) { // 하
			m2[r][c] = m2[r + 1][c];
		}
		for (; c - 1 >= 1; c--) { // 좌
			m2[r][c] = m2[r][c - 1];
		}
		m2[r][c] = 0;
	}

	public static void circledown() {
		int r = airY + 2; // 공기청정기 시작위치, 공기청정기 변하지 않기위한 +1/+1
		; // 공기청정기 -위 , 초기 시작위치를 공기청정기 -1
		int c = airX;
		for (; r + 1 < R; r++) { // 하
			m2[r][c] = m2[r + 1][c];
		}
		for (; c + 1 < C; c++) { // 우
			m2[r][c] = m2[r][c + 1];
		}

		for (; r - 1 >= airY + 1; r--) { // 상
			m2[r][c] = m2[r - 1][c];
		}
		for (; c - 1 >= 1; c--) { // 좌
			m2[r][c] = m2[r][c - 1];
		}
		m2[r][c] = 0;
	}
} // end of class