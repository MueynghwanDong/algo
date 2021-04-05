package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기_17136_0904 {

	static int[] papers = { 0, 5, 5, 5, 5, 5 };
	static int[][] arr = new int[10][10];
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

	}

	public static void dfs(int idx, int cnt) {
		if (idx == 100) { // 종료 조건
			answer = Math.min(answer, cnt);
			return;
		}
		if (answer <= cnt) // cnt가 answer 값보다 커지면 안됨
			return;
		int r = idx / 10;
		int c = idx % 10;
		
		if (arr[r][c] == 1) { 
			for (int i = 5; i >= 1; i--) { // 큰거 부터 진행하는 게 핵심!
				if (papers[i] > 0) { // 개수가 남을 때 진행 
					if (check(r, c, i)) { // 채울 수 있는지 여부 체크
						papers[i]--;
						// 0으로 채우기
						for (int a = 0; a < i; a++) {
							for (int b = 0; b < i; b++) {
								arr[r + a][c + b] = 0;
							}
						}
						dfs(idx + 1, cnt + 1); 
						// 다시 복귀
						for (int a = 0; a < i; a++) {
							for (int b = 0; b < i; b++) {
								arr[r + a][c + b] = 1;
							}
						}
						papers[i]++;
					}
				}
			}
		} else { // 1이 아닌 경우 다음으로 이동
			dfs(idx + 1, cnt);
		}
	}

	public static boolean check(int r, int c, int size) {
		if (r + size > 10 || c + size >10)
			return false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[r + i][c + j] != 1)
					return false;
			}
		}
		return true;
	}

}
