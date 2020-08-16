package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 스도쿠_0713_v2 {

	static int n = 9;
	static int[][] arr = new int[n][n];
	static int[][] result = new int[n][n];
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = (str.charAt(j) - '0');
				if (arr[i][j] == 0) {
					list.add(new int[] { i, j }); // 빈칸을 리스트에 넣어주기
				}
			}
		} // 입력
		dfs(0);

	}

	public static void dfs(int idx) {

		if (idx == list.size()) { // 빈칸 다 채운경우
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}

			System.exit(0);
		}
		for (int i = 1; i <= n; i++) {
			// 세가지 상황으로 나눠서 판단하기 가로 세로 박스
			if (checkrow(idx, i) && checkcol(idx, i) && checkbox(idx, i)) { // 현재 list의 idx번째 빈칸과 숫자를 파라미터로 넘김
				arr[list.get(idx)[0]][list.get(idx)[1]] = i; // 숫자 채워주기
				dfs(idx + 1);
			}
			 if(i==9)
				 arr[list.get(idx)[0]][list.get(idx)[1]] = 0;
		}
//		arr[list.get(idx)[0]][list.get(idx)[1]] = 0; // 백트래킹
	}

	public static boolean checkrow(int idx, int val) { // 가로 체크 
		int cx = list.get(idx)[0];
		for (int i = 0; i < n; i++) {
			if (arr[cx][i] == val) // val과 arr배열 값이 일치하면 false // arr[cx][i]가 1~9값이면 false
				return false;
		}
		return true;
	}

	public static boolean checkcol(int idx, int val) { // 세로 체크
		int cy = list.get(idx)[1];
		for (int i = 0; i < n; i++) {
			if (arr[i][cy] == val)
				return false;
		}
		return true;
	}

	public static boolean checkbox(int idx, int val) { // 박스 체크

		// (0,0)이 빈칸인 경우, (0,0) ~ (2,2)를 검사
		// (1,4)가 빈칸인 경우, (0,3) ~ (2,5)를 검사
		// 각 좌표를 3으로 나눠 준 후 *3을 해주면 해당 좌표가 속한 박스의 시작점이 나옴

		int cx = list.get(idx)[0];
		int cy = list.get(idx)[1];
		int boxx = cx / 3;
		boxx *= 3;
		int boxy = cy / 3;
		boxy *= 3;

		for (int i = boxx; i < boxx + 3; i++) {
			for (int j = boxy; j < boxy + 3; j++) {
				if (i == cx && j == cy)
					continue;
				if (arr[i][j] != 0 && arr[i][j] == val)
					return false;
			}
		}
		return true;
	}
}
