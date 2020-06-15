import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리 문제 - Scanner 사용 367ms Buffredreader -> 문자를 숫자로, 각 값을 쪼개는 방법을 알고 있어야 함.
 * 쪼개는 방법 -> string split 158ms, string tokenizer 빠른 이유 -> buffredreader는 exception handling을 처리하지 않음. 
 * scanner는 처리해서 나오기에 사용시마다 exception handling 수행
 * String으로 안쪼개기 
 */
public class Solution_ladder {
	public static void main(String[] args) throws Exception { // 2로부터 올라가는 방식

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1; testCase <= 10; testCase++) {
			// int T = sc.nextInt();
			int T = Integer.parseInt(br.readLine()); // 엔터입력까지의 한줄 받아옴, 언터는 버림
			int[][] map = new int[100][102]; // 왼쪽, 오른쪽 한줄씩 추가해줌 -> 인덱스 넘어가지 않도록 옆에 한열씩 추가
			for (int i = 0; i < map.length; i++) {
				
				String s = br.readLine(); // 전체 데이터가 다들어감 100*100 만큼 -> 짝수번 인덱스만 활용
				//StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 생성자 3가지중 직접 구분자를 지정해주는 것이 더 빠르따.
				// String s = br.readLine();
				// String[] srr = s.split(" "); // 구분자 입력
				for (int j = 1; j <= 100; j++) {
					// map[i][j] = sc.nextInt();
					// map[i][j] = Integer.parseInt(srr[j-1]); // string split
					//map[i][j] = Integer.parseInt(st.nextToken()); // springtokenizer
					map[i][j] = s.charAt(j*2-2) - '0'; 
				}
			}
			int r = 99;
			int c = 100;
			for (int i = 1; i <= 100; i++) { // 마지막행 검사해서 2를 찾음
				if (map[99][i] == 2) {
					c = i;
				}
			}

			final int up = 1;
			final int left = 2;
			final int right = 3;
			int dir = up; // 1= 상, 2 = 좌, 3 = 우
			while (r > 0) {
				if (dir != right && map[r][c - 1] == 1) { // 좌
					dir = left;
					c--;

				} else if (dir != left && map[r][c + 1] == 1) { // 우
					dir = right;
					c++;
				} else { // 상
					dir = up;
					r--;
				}
			}
			System.out.println("#" + testCase + " " + (c - 1)); // 한열을 더만들어 주었기에 -1을 해주어야함.
		}
	} // end of main
} // end of class
