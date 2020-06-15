import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1209_SW문제해결기본2일차_Sum_동명환 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int T = Integer.parseInt(br.readLine());	
			int[][] map = new int[100][100];// 값을 저장해두기 위한 곳 추가
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료 
			int dagak2 = 0;
			int []garo = new int[100];
			int []sero = new int[100];
			int dagak =0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sero[i] += map[j][i]; // 세로 합
					garo[i] += map[i][j]; /// 가로합
					if(j-i == 0) {
						dagak += map[i][j]; // \대각선
					}
					if(i+j == 99) {
						dagak2 += map[i][j];
					}
				}
			}
			
			int max = 0;
			for (int i = 0; i < garo.length; i++) { // 가로합 체크
				if(max<garo[i]) { 
					max = garo[i];
				}
			}
			for (int i = 0; i < sero.length; i++) { // 세로합 체크
				if(max<sero[i]) {
					max = sero[i];
				}
			}
			if(max<dagak)
				max = dagak;
			if(max<dagak2)
				max = dagak;		
			
			System.out.println("#"+testCase + " "+ max);
		}
	}

}
