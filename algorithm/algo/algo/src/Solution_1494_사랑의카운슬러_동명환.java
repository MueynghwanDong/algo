import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러_동명환 {

	static class data {
		int x;
		int y;

		public data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static data[] arr;
	private static int n;
	private static int[] ttt;
	private static long sumx;
	private static long sumy;
	static long min;

	public static void fun(int k, int r) {
		if (r == 0) {
			long x = 0;
			long y = 0;
			for (int j = 0; j < ttt.length; j++) {
				x += arr[ttt[j]].x;
				y += arr[ttt[j]].y;
			}
			long nx = sumx - x;
			long ny = sumy - y;
			long rx = x - nx;
			long ry = y - ny;
			long result = rx * rx + ry * ry;
			if (result < min) {
				min = result;
			}
		} else if (k < r) {
			return;
		} else {
			ttt[r - 1] = k - 1;
			fun(k - 1, r - 1);
			fun(k - 1, r);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			n = Integer.parseInt(br.readLine());
			arr = new data[n];
			sumx = 0;
			sumy = 0;
			min = Long.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i] = new data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				sumx += arr[i].x;
				sumy += arr[i].y;
			}
			ttt = new int[n / 2];
			fun(n, n / 2);
			System.out.println("#" + testCase + " " + min);
		}

	}

}
