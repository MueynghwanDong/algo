import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[][] a;
	private static int[][] cal;
	private static int[] arr;
	private static int n;
	private static int m;
	private static int k;
	private static int[][] acopy;

	public static void perm(int num) {
		if (num == arr.length) { // 종료 파트

			for (int i = 0; i < arr.length; i++) {
				cycle(cal[arr[i]]);
			}

		} else { // 재귀 파트
			for (int i = num; i < arr.length; i++) {
				int temp = arr[num];
				arr[num] = arr[i];
				arr[i] = temp;
				perm(num + 1);
				temp = arr[num];
				arr[num] = arr[i];
				arr[i] = temp;
			}
		}
	}

	public static void cycle(int[] trr) {

		for (int i = trr[2]; i > 0; i--) {

		}
		for (int i = 0; i < trr.length; i++) {

			int rx = trr[0];
			int cx = trr[1];
			int s = trr[2];
			int size = 2 * s + 1;
			int r = rx - s - 1;
			int c = cx - s - 1;

			int temp = acopy[r][c];
			for (int j = 0; j < 2 * s; j++) {
				acopy[r][c] = acopy[r + 1][c];
				r++;
			}
			for (int j = 0; j < acopy.length; j++) {
				System.out.println(Arrays.toString(acopy[j]));
			}
			System.out.println();
			for (int j = 0; j < 2 * s; j++) {
				acopy[r][c] = acopy[r][c + 1];
				c++;
			}
			for (int j = 0; j < 2 * s; j++) {
				acopy[r][c] = acopy[r][c - 1];
				c--;
			}
			for (int j = 0; j < 2 * s; j++) {
				acopy[r][c] = acopy[r - 1][c];
				r--;
			}
			// acopy[r][c] = temp;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		acopy = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String ss[] = s.split(" ");
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(ss[j]);
			}
		}
		arr = new int[k]; // 회전 연산 갯수
		cal = new int[k][3];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cal[i][0] = Integer.parseInt(st.nextToken());
			cal[i][1] = Integer.parseInt(st.nextToken());
			cal[i][2] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < k; i++) {
			arr[i] = i;
		}
		perm(0);

	} // end of main
} // end of class
