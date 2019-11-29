import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 위치 정보를 가지고 있는 배열 혹은 클래스를 가지고 있는다.
// 조합을 이용하여 여러개 치킨집 중 m개의 치킨집을 뽑아 치킨 거리를 계산한후 가장 작은 치킨 거리의 합을 구한다.

public class Main_15686_치킨배달_동명환 {

	static class pos {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int n;
	private static int m;
	private static int[][] arr;
	private static int[] trr;
	private static pos[] prr;
	private static int tsum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // n * n 배열
		m = Integer.parseInt(st.nextToken()); // 이 도시에서 가장 수익을 많이 낼 수 있는 치킨집의 개수, 치킨집 중 m개 빼고 폐업 시키고 그중 가장 작은 치킨거리합 구하기
		// 도시의 치킨 거리 -> 모든 집의 치킨 거리 합
		// |r1-r2| + |c1-c2|
		arr = new int[n][n];
		prr = new pos[14];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0, index = 0; j < n; j++, index += 2) {
				arr[i][j] = str.charAt(index) - '0';
				if (arr[i][j] == 2) { // 치킨집에 대한 위치 정보를 저장할 배열에 넣어주기
					prr[idx] = new pos(i, j);
					idx++;
				}
			}
		} // 입력
		tsum = Integer.MAX_VALUE;
		trr = new int[idx]; // 조합을 돌릴 배열 index C m -> 인덱스 값 저장 
		comb(idx, m);
		System.out.println(tsum);
	} // end of main

	private static void comb(int index, int r) {
		if (r == 0) {
			int sum = 0;
			// 조합된 결과를 통해서 치킨거리 합계를 구한다.
			for (int i = 0; i < m; i++) {
				pos temp = prr[trr[i]];
				int nx = temp.x;
				int ny = temp.y;
				arr[nx][ny] = 3; 
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) { 
						int re = fun2(i, j);
						sum += re;
					}
				}
			}
			for (int i = 0; i < m; i++) {
				pos temp = prr[trr[i]];
				int nx = temp.x;
				int ny = temp.y;
				arr[nx][ny] = 2;
			} // 다시 원복시켜주기
			if (tsum > sum)
				tsum = sum; 
			// System.out.println(sum);
		} else if (index < r) { //. index 가 r 보도 작으면 올바르지 않은 경우
			return;
		} else {
			trr[r - 1] = index - 1;
			comb(index - 1, r - 1);
			comb(index - 1, r);

		}
	}

	// 1 -> 집 2-> 치킨집
	public static int fun2(int x, int y) { // 3인경우 -> 조합 결과로 선택된 치킨 집
		// 치킨집에서 집까지의 거리 계산하여 값 더해주기
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 3) {
					int temp = Math.abs(x - i) + Math.abs(y - j);
					if (result > temp)
						result = temp;
				}
			}
		}
		return result;
	}

}// end of class