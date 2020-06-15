
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 복잡한 시뮬레이션 문제 - 효율성 생각하지 말고 일단 작성
 * 
 * 아이디어 -> 적군을 한줄 씩 아래로 이동시켜도 되지만, 반대로 궁수가 있는 궁수가 있는 성의 위치를 한줄씩 위로 올려도 된다. (시간 빠름)
 */
public class 캐슬_sol {

	private static int N;
	private static int M;
	private static int D;
	private static int[][] a;
	private static int[][] acopy;
	private static int max;
	private static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		a = new int[N][M];
		acopy = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				a[i][j] = str.charAt(index) - '0';

			}
		}

		// 궁수 자리 배치 (조합)
		max = 0; // 최대값
		for (int x = 0; x < M - 2; x++) {
			for (int y = x + 1; y < M - 1; y++) {
				for (int z = y + 1; z < M; z++) {

					for (int i = 0; i < a.length; i++) {
						acopy[i] = a[i].clone();
					}
					cnt = 0;
					for (int i = 0; i < a.length; i++) {
						attack(x, y, z);
						move();
					}

					if (max < cnt)
						max = cnt;

				}
			}
		}
		//
		System.out.println(max);
	} // end of main

	public static HashSet<String> hs = new HashSet<>(); // 죽일 적군의 위치 "행 열" 문자열로 저장

	public static void attack(int... trr) { // int[] trr
		hs.clear();
		for (int i = 0; i < trr.length; i++) {
			next: for (int j = 1; j <= D; j++) {
				int r = N; // 왼쪽 끝은 격자판 밖이라 적군이 없음
				int c = trr[i] - j; //
				for (; c <= trr[i] + j; c++) { // 오르막 내리막
					if (0 <= r && r < N && 0 <= c && c < M && acopy[r][c] == 1) {
						// 제거할 적군을 기록해 놓는다
						hs.add(r + " " + c);
						// System.out.println(hs.toString());
						break next;
					}
					r = c < trr[i] ? r - 1 : r + 1; // 높이 조정
				}
			}
			// System.out.println(hs.toString());

			for (String e : hs) {
				StringTokenizer st = new StringTokenizer(e, " ");
				acopy[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 0;

			}

		}
		cnt += hs.size();
		// System.out.println(cnt);
	}

	// 격자판을 한행씩 아래로 내리기
	public static void move() {
		for (int r = N - 2; r >= 0; r--) { // 마지막행부터 올리기
			for (int c = 0; c < M; c++) {
				acopy[r + 1][c] = acopy[r][c];
			}
		}
		for (int c = 0; c < M; c++) {
			acopy[0][c] = 0; // 윗줄은 0으로 초기화
		}
	}
} // end of class
