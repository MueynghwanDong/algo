import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리 문제 
 * Scanner 사용 
 * BufferedReader
 * 
 * @author student
 * 
 */
public class Z08_ladder01 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int [][] m = new int[100][102];	// 인덱스 넘어가지 않도록 옆에 한 열씩 추가
			for (int i = 0; i < m.length; i++) {	//행
				st = new StringTokenizer(br.readLine(), " ");	//구분자 입력 !! 
				for (int j = 1; j <= 100; j++) {	//열
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int r = 99;
			int c = 100;

			// 마지막줄 돌기
			for (int i = 1; i <= 100; i++) { // 마지막 행을 검사해서 2를 찾는다.
				if (m[99][i] == 2) {
					c = i;
				}
			}

			final int 상 = 1;
			final int 좌 = 2;
			final int 우 = 3;
			int dir = 상;

			while (r > 0) {
				if (dir != 우 && m[r][c - 1] == 1) { // 좌
					dir = 좌;
					c--;
				} else if (dir != 좌 && m[r][c + 1] == 1) { // 우
					dir = 우;
					c++;
				} else { // 상
					dir = 상;
					r--;
				}
			}

			System.out.println("#" + testCase + " " + (c - 1));

		}

	} // end of main
} // end of class
