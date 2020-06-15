import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시뮬레이션 문제 : 1을 커버할 수 있도록 가능한 색종이를 붙여본다..
 * 
 * @author student
 *
 */
public class 색종이붙이기 {

	private static int[][] m;
	private static int min;
	private static int[] p = { 0, 5, 5, 5, 5, 5 }; // 색종이의 남은 장수, 0번은 안씀

	/* 색종이를 붙이고 남은 숫자 배열 m[][] */
	public static void dfs(int cnt, int sum) { // cnt => 사용한 색종이의 갯수 / sum > 남은 1의 갯수
		if (min < cnt) { // 이미 최소값 보다 커졌다면 nono
			return;
		} else if (sum == 0) { // m 배열에 더이상 1이 없음
			if (min > cnt)
				min = cnt;
			return;
		} else {
			int r = -1;
			int c = -1;
			ex: for (r = 0; r < 10; r++) { // 맵에서 1의 위치를 체크
				for (c = 0; c < 10; c++) {
					if (m[r][c] == 1) {
						break ex;
					}
				}
			}
			int maxsize = 5;
			for (; maxsize >= 1; maxsize--) { // 큰 종이를 붙일 수 있다면 그 보다 작은 종이는 당연히 붙일 수 있음.
				if (check(r, c, maxsize)) { // r,c를 좌상단 사각형으로 maxsize 크기 영역안에 모두 1인지 체크
					break;
				}
			}
			for (int size = maxsize; size >= 1; size--) { // maxsize ~1 까지의 크기 색종이를 붙여보자.
				if (p[size] > 0) { // 사이즈의 색종이가 남아있으면
					paint(r, c, size, 0);// size 만큼의 사각영역을 0으로 덮자 // 사용한 색종이 감소
					p[size]--;
					dfs(cnt + 1, sum - size * size);
					// 다음 칸으로 재귀 호출
					paint(r, c, size, 1);
					p[size]++;
					// 사이즈만큼의 사각영역을 1으로 덮자 - 원복 / 사용한 색종이 원복

				}
			}
		}

	}

	/** (r,c) 좌표에서 시작하는 size 크기의 정사각형 val로 채우는 메서드 **/
	public static void paint(int r, int c, int size, int val) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				m[i][j] = val;
			}
		}
	}

	public static boolean check(int r, int c, int size) { // r,c 좌표에서 시작하는 size 크기의 정사각형 영역이 모두 1인지 검사하는 메서드
		if (r + size > 10 || c + size > 10) {// 색종이가 영역에서 벗어남
			return false;
		}
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (r + size <= 10 && c + size <= 10 && m[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = new int[10][10];
		int sum = 0; // 1의 개수를 누적할 변수
		for (int i = 0; i < 10; i++) {
			String str = br.readLine();
			for (int j = 0, index = 0; j < 10; j++, index += 2) {
				m[i][j] = str.charAt(index) - '0';
				sum += m[i][j];
			}
		}
		min = Integer.MAX_VALUE;
		if (sum == 0) {
			min = 0;
		} else if (sum == 100) {
			min = 4;
		} else {
			dfs(0, sum);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	} // end of main
} // end of class
