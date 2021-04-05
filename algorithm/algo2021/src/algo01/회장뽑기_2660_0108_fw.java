package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 회장뽑기_2660_0108_fw {

	static int n;
	static int[][] arr;
	static int INF = 10000;
	// 주의. Inter.MAXVALUE 하면 범위 값이 초과되어 다른 값이 나옴

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (s == -1 && e == -1) { // 종료 조건
				break;
			}
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		for (int i = 1; i <= n; i++) { // 1~n까지 반복하면서 체크
			for (int j = 1; j <= n; j++) {
				// i!=j 이고 arr 값이 0이면 큰 값을 넣어 주기
				if (arr[i][j] == 0 && i != j)
					arr[i][j] = INF;
			}
		}
		// 폴로이드-와샬
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		int[] result = new int[n + 1];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= n; j++) {
				if (max < arr[i][j])
					max = arr[i][j];
			}
			// 반복하면서 max 값 찾아주기 !! - result 배열에 인덱스별 가장 큰 값 넣어주기
			result[i] = max;
		}
//		for (int i = 1; i < result.length; i++) {			
//			System.out.print(result[i] +" ");
//		}
//		System.out.println();
		for (int i = 1; i <= n; i++) {
			if (min > result[i])
				min = result[i];
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (result[i] == min) // 회장 후보 추가
				list.add(i);
		}
		System.out.println(min + " " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}