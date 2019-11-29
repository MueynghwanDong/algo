import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_동명환 {

	private static int[][] arr;
	private static int x;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < n; j++, index += 2) {
					arr[i][j] = str.charAt(index) - '0';
				}
			}
			int result = fun();
			System.out.println("#" + testCase + " " + result);
		}
	}

	private static int fun() {
		int cnt = 0;
		// 가로 체크
		for (int i = 0; i < n; i++) {
			if (check(arr[i]))
				cnt++;
		}
		// 세로 체크
		for (int i = 0; i < arr.length; i++) {
			int[] sero = new int[n];
			for (int j = 0; j < arr.length; j++) {
				sero[j] = arr[j][i];
			}
			if (check(sero))
				cnt++;
		}
		return cnt;
	}

	public static boolean check(int[] temp) {
		int pre = temp[0];
		int count = 1;
		boolean c = false;
		boolean cc = false;
		for (int i = 1; i < temp.length; i++) {
			if (pre != temp[i]) {
				if (count > 0 && c)
					return false;
				if (pre < temp[i]) {
					if (c) {
						if (count > 0 || pre != temp[i] - 1)
							return false;
						if(count <=0) {
							if(Math.abs(count)<=x-1) return false; 
						}
					} else {
						if (count < x || pre != temp[i] - 1)
							return false;
					}
					c = false;
					pre = temp[i];
					if (i != n - 1) {
						count = 1;
					}
				} else if (pre > temp[i]) {
					if (pre - 1 != temp[i])
						return false;
					c = true;
					count = x - 1;
					pre = temp[i];
				}
			} else {
				if (c) {
					count--;
				} else {
					count++;
					cc = true;
				}
			}
		}
		if (c) {
			if (count > 0)
				return false;
			else
				return true;
		} else {
			if (count == n || count >= x || (cc)) {
				return true;
			} else {
				return false;
			}
		}
	}
}