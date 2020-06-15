import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 17135 캐슬 디펜스
 * 삼성 SW 역량테스트 A형 2번 기출문제
 * 복잡한 시뮬레이션 문제 = 효율성 생각하지말고 일단 작성
 * 
 * 아이디어 - 적군을 한줄씩 아래로 이동시켜도 되지만, 
 * 			반대로 궁수가 있는 성의 위치를 한줄 씩 위로 올려도 된다.
 */
public class Main_17135_t {
	public static int N, M, D;
	public static int [][] map;
	public static int [][] mapCopy;
	private static int max;
	private static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		mapCopy = new int [N][M];
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//System.out.print(map[i][j] +" ");
			}
			//System.out.println();
		}
		max = 0;
		// M개의 열 중에서 3명의 궁수자리 배치 - 조합
		for (int x = 0; x < M-2; x++) {
			for (int y = x+1; y < M-1; y++) {
				for (int z = y+1 ; z < M; z++) {
					// 원본 맵을 보존하고, 사본을 복사해서 진행
					for (int i = 0; i < map.length; i++) {
						mapCopy[i] = map[i].clone();
					}
					
					// 궁수배치 후 시뮬레이션 해서 죽인 적군의 개수 누적
					
					cnt = 0; 
					
					// 궁수가 공격거리 안에 있는 적군을 한번씩 쏜다
					
					for (int i = 0; i < map.length; i++) {
						Attack(x,y,z); // 죽으면 cnt++;
						Shift();
					}
					// 최대값을 출력
					if( max < cnt ) max = cnt;
				}
			}
		}
		System.out.println(max);
	}// main
	
	// 격자판을 한행씩 아래로 내리기 
	
	public static void Shift() {
		for (int r = N-2; r >= 0 ; r--) {
			// 마지막 행부터 시작	
			for (int c = 0; c < M; c++) {
				mapCopy[r+1][c] = mapCopy[r][c];
			}
		}
		for (int c = 0; c < M; c++) {
			mapCopy[0][c] = 0;
		}
		
	}
	
	public static Set<String> set = new HashSet<>(); // 죽일 적군의 위치 " 행 열" 문자열로 저장 
	// 궁수의 공격 -적군 제거  = 거리 (dx+dy)가 가까운순, 거리가 동일하면 왼쪽부터
	public static void Attack(int ... trr) { // int[] trr
		set.clear();
		for (int i = 0; i < trr.length; i++) {
			// 궁수 차례로 (N행, trr[i])
		next : 	for (int j = 1; j <= D; j++) {
				int r = N;
				int c = trr[i] - j;
				for ( ; c <= trr[i]+ j ; c++) {
					// c는 계속 증가, r은 감소 후 증가
					if(r >= 0 && r < N && c >= 0 && c < M && mapCopy[r][c]==1) {
						// 제거할 적군을 기록해 놓는다 
						set.add(r+" "+c);
						break next;
					}
					r = c < trr[i] ? r-1 : r+1;
				}
			}
		
			
			for (String e : set) {
				StringTokenizer st = new StringTokenizer(e, " ");
				mapCopy[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 0; // 적군 제거
			}
		
		}
		cnt += set.size();
	}
	public static String src = "5 5 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 1 1 1 1\r\n" + 
			"";
}//class