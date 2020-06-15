package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z39_배열돌리기 {

	static int[][] a;
	static int[][] acopy;
	public static int[][] cycle; // 회전 연산 정보를 저장할 배열
	public static int[] arr; // 순열 시 사용할 배열
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // a배열의 행, 3<=n, m<= 50
		int m = Integer.parseInt(st.nextToken()); // a배열의 열, 3<=n, m<= 50
		int k = Integer.parseInt(st.nextToken()); // 회전 연산의 갯수 1<= k <=6

		a = new int[n + 1][m + 1];
		acopy = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken()); // 1<= a[i][j] <=100
			}
		}
		cycle = new int[k][3];// r,c,s 값 저장하는 배열
		for (int i = 0; i < k; i++) { // 회전 연산의 개수
			st = new StringTokenizer(br.readLine(), " ");
			cycle[i][0] = Integer.parseInt(st.nextToken()); // 1 ≤ r-s < r < r+s ≤ N
			cycle[i][1] = Integer.parseInt(st.nextToken()); // 1 ≤ c-s < c < c+s ≤ M
			cycle[i][2] = Integer.parseInt(st.nextToken());
		}

		arr = new int[k]; // 명령문의 갯수 만큼 배열 생성
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		perm(0, k);
		System.out.println(min);
	} // end of main

	public static void cycleA(int[] cycle) { // 3 4 2
		for (int s = cycle[2]; s > 0; s--) {
			int size = s * 2 + 1; // 회전할 사각형의 한변의 길이
			int r = cycle[0] - s;
			int c = cycle[1] - s;

			int temp = acopy[r][c]; // 제일 첫번째 값을 임시 저장하는 변수
			for (int i = 1; i < size; i++) { // 하
				acopy[r][c] = acopy[r + 1][c];
				r++;
			}
			for (int i = 1; i < size; i++) { // 우
				acopy[r][c] = acopy[r][c + 1];
				c++;
			}
			for (int i = 1; i < size; i++) { // 상
				acopy[r][c] = acopy[r - 1][c];
				r--;
			}
			for (int i = 1; i < size; i++) { // 좌
				acopy[r][c] = acopy[r][c - 1];
				c--;
			}
			acopy[r][c + 1] = temp;

		}

	}

	public static void perm(int step, int k) {
		if (step == k) { // 종료
			// 순열
			// 회전을 시키기 (원본 배열을 하나 복사해서 사용하기)
			for (int i = 0; i < a.length; i++) {
				acopy[i] = a[i].clone(); // 깊은 복사 - 1차원 배열만 복사 가능
			}
			for (int i = 0; i < arr.length; i++) {
				cycleA(cycle[arr[i]]);
			}
			// 각 행의 합 구하기
			for (int i = 1; i < acopy.length; i++) {
				int sum = 0;
				for (int j = 1; j < acopy[i].length; j++) {
					sum += acopy[i][j];
				}
				// 각 합 중 최소값 구하기
				if (min > sum) {
					min = sum;
				}
			}
		} else { // 재귀
			for (int i = step; i < k; i++) {
				// swap step<-> i
				int temp = arr[step];
				arr[step] = arr[i];
				arr[i] = temp;
				perm(step + 1, k);
				// swap step<-> i
				temp = arr[step];
				arr[step] = arr[i];
				arr[i] = temp;
			}
		}
	}
} // end of class