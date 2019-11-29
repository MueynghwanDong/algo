import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.FontUIResource;

public class 홈방범서비스 {

	private static int n;
	private static int m;
	private static int[][] arr;
	private static boolean[][] brr;
	private static int max;
	private static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken()); // 집 하나당 비용
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			max = 0;
			int k = 0;
			if (n % 2 == 1) {
				k = (n + 1) / 2;
			} else {
				k = n / 2;
			}
			// int mcost = k * k + (k - 1) * (k - 1);
			int temp = k;
			result = 0;
			while (temp > 0) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							fun(i, j, temp);

						}
					}
				temp--;
			}
			System.out.println(max);
		}

	}

	private static void fun(int x, int y, int temp) { // temp = k
		brr = new boolean[n][n]; // 초기화
		System.out.println(x + " " + y + " " + temp);

		int idx = -1;
		for (int i = x; i >= 0; i--) {
			for (int j = y - (temp + idx); j <= y + (temp + idx); j++) {
				// System.out.println(i + " " + j);
				if (i < 0 || j < 0 || i >= n || j >= n)
					continue;
				if (!brr[i][j])
					brr[i][j] = true;
			}
			idx--;
			if (y + temp - idx == 0)
				break;
		}
		idx = -1;
		for (int i = x; i <= x + (temp - 1); i++) {
			for (int j = y - (temp + idx); j <= y + (temp + idx); j++) {
				// System.out.println(i + " " + j);
				if (i < 0 || j < 0 || i >= n || j >= n)
					continue;
				if (!brr[i][j])
					brr[i][j] = true;
			}
			// ty--;
			idx--;
			if (y + temp - idx == 0)
				break;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (brr[i][j] && arr[i][j]==1) {
					count++;
				}
			}
		}
//		if(temp>=5) {
//		for (int i = 0; i < brr.length; i++) {
//			System.out.println(Arrays.toString(brr[i]));
//		}}
		int sum = 0;
		int mcost = (temp * temp) + ((temp - 1) * (temp - 1));
		if (temp == 1) {
			sum = m * count - 1;
		} else {
			sum = m * count - mcost;
		}
//		if(max <count && sum>=0) {
//			max = count;
//			//result = count;
//		}
//		if(count == 24) {
//			System.out.println(sum+" "+count);
//		}
//		System.out.println(sum);
//		System.out.println(max);
	//	System.out.println(count);
	}

}
