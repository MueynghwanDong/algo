import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 총잡이 문제 
 * - 완전탐색 (방향 탐색) 시뮬레이션
 * - BruteForce
 * 
 #1 6
#2 2
#3 12
#4 13
#5 11
#6 24
#7 27
#8 0
#9 7
#10 5
#11 45
#12 3
 */
public class algo_1번 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.valueOf(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()); // 1<= r,c <= 20
			int c = Integer.parseInt(st.nextToken());
			// 쪼개서 사용 String charAt(0) => 가장 느리다 . 쪼개서 사용 StringTokenizer -> 빠르다. String 한줄을
			// 통째로 받아 쓴다.
			char[][] map = new char[r][c];
			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < c; j++, index += 2) {
					map[i][j] = str.charAt(index);
				}
			}
			// map 전체를 순회하면서 G 총잡이가 나오면 상하좌우 탐색
			// 총잡이나 벽이 나오면 탐색 종료 , 목표물이 나오면 목표물 카운팅, T를 다른 값으로 변경하기 W로 바꾸기...
			int cnt = 0; // 잡힌 목표물의 개수
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					// 총잡이 G일 경우
					if (map[i][j] == 'G') { // 상,하,좌,우 탐색
						// 상
						for (int k = 1; 0 <= i - k; k++) {
							if (map[i - k][j] == 'G' || map[i - k][j] == 'W') // 총잡이, 벽이면 그만
								break;
							else if (map[i - k][j] == 'T') { // T 목표물이면 카운팅, 다음으로 넘어가지 못하도록 w로 바꾸고 빠져나가기
								cnt++;
								map[i - k][j] = 'W'; // 중복카운팅 되지 않도록
								break;
							}
						}
						// 하
						for (int k = 1; i + k < r; k++) {
							if (map[i + k][j] == 'G' || map[i + k][j] == 'W') // 총잡이, 벽이면 그만
								break;
							else if (map[i + k][j] == 'T') { // T 목표물이면 카운팅, 다음으로 넘어가지 못하도록 w로 바꾸고 빠져나가기
								cnt++;
								map[i + k][j] = 'W'; // 중복카운팅 되지 않도록
								break;
							}
						}
						// 좌
						for (int k = 1; 0 <= j - k; k++) {
							if (map[i][j - k] == 'G' || map[i][j - k] == 'W') // 총잡이, 벽이면 그만
								break;
							else if (map[i][j - k] == 'T') { // T 목표물이면 카운팅, 다음으로 넘어가지 못하도록 w로 바꾸고 빠져나가기
								cnt++;
								map[i][j - k] = 'W'; // 중복카운팅 되지 않도록
								break;
							}
						}
						// 우
						for (int k = 1; j + k < c; k++) {
							if (map[i][j + k] == 'G' || map[i][j + k] == 'W') // 총잡이, 벽이면 그만
								break;
							else if (map[i][j + k] == 'T') { // T 목표물이면 카운팅, 다음으로 넘어가지 못하도록 w로 바꾸고 빠져나가기
								cnt++;
								map[i][j + k] = 'W'; // 중복카운팅 되지 않도록
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + testCase + " " + cnt);
		} // end of testCase

	} // end of main
} // end of class
