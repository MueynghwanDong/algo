import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열돌리기 {

	private static int arr[];
	private static int[][] a;
	private static int[][] acopy;
	private static int[][] cycle;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // a 배열의 행
		int m = Integer.parseInt(st.nextToken()); // a 배열의 열
		int k = Integer.parseInt(st.nextToken()); // 연산 수

		a = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cycle = new int[k][3]; // 회전 연산의 갯수 , r,c,s
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cycle[i][0] = Integer.parseInt(st.nextToken());
			cycle[i][1] = Integer.parseInt(st.nextToken());
			cycle[i][2] = Integer.parseInt(st.nextToken());
		}

		arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = i;
		}
		perm(0, k);
		System.out.println(min);
	}

	public static void cycleA(int[] cycle) {

		for (int s = cycle[2]; s > 0; s--) {
			int size = s * 2 + 1;
			int r = cycle[0] - s;
			int c = cycle[1] - s;

			int temp = acopy[r][c];
			// 하,우 , 상, 좌
			for (int j = 1; j < size; j++) {
				acopy[r][c] = acopy[r + 1][c];
				r++;
			}
			for (int j = 1; j < size; j++) {
				acopy[r][c] = acopy[r][c + 1];
				c++;
			}
			for (int j = 1; j < size; j++) {
				acopy[r][c] = acopy[r - 1][c];
				r--;
			}
			for (int j = 1; j < size; j++) {
				acopy[r][c] = acopy[r][c - 1];
				c--;
			}
			acopy[r][c + 1] = temp;
		}
	}

	public static void perm(int step, int k) {
		if (step == k) {
			for (int i = 1; i < a.length; i++) { // 회전 작업시 원본 이 손상되므로, 배열 복사하기
				acopy[i] = a[i].clone();
			}
			for (int i = 0; i < arr.length; i++) {
				cycleA(cycle[arr[i]]);
			}
			for (int i = 1; i < acopy.length; i++) {
				int sum = 0;
				for (int j = 1; j < acopy[i].length; j++) {
					sum += acopy[i][j];
				}
				if (min > sum)
					min = sum;
			}

		} else {
			for (int i = step; i < arr.length; i++) {
				int temp = arr[step];
				arr[step] = arr[i];
				arr[i] = temp;
				perm(step + 1, k);
				temp = arr[step];
				arr[step] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
