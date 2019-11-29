package 보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 나무재테크이거보고공부하기 {

	static int N, M ,K, answer;
	static Tree[][] tree;
	static int[][] nut;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,-1,1};
	private static int[][] D;
	// Tree 배열을 만들고 그 안에 List 형식으로 만들어 저장시켜주는 방식 
	
	public static void main(String[] args) throws IOException {
		// 1. 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 땅 크기 (NxN)
		M = Integer.parseInt(st.nextToken()); // 나무 개수
		K = Integer.parseInt(st.nextToken()); // 연도
		tree = new Tree[N+1][N+1];            // 땅마다 나무 영양정보+나무갯수 확인할 클래스 이중배열
		nut = new int[N+1][N+1];              // 영양분 배열(겨울용)
		for(int i=1; i<=N; i++) {     // 양분 입력
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=1; j<=N; j++) {
				nut[i][j] = Integer.parseInt(st.nextToken());
				tree[i][j] = new Tree(5, new ArrayList<Integer>()); // 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
			}
		} 
		
		for(int i=1; i<=M; i++) {     // 나무 정보 입력
			st = new StringTokenizer(in.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int old = Integer.parseInt(st.nextToken());
			tree[row][col].years.add(old); // 입력으로 주어지는 나무의 위치는 모두 서로 다름 (== 정렬할 필요가 없다)
		}
		
		// 굳이 봄 -> 여름 -> 가을 -> 겨울  시뮬순서대로 할 필요가 없다.
		// 2. simulation
		while(K-->0) {
			// 나무 생존 + 죽은 나무 영양분화 + 땅에 영양분 주기
			spring_summer_winter(); // 봄+여름+겨울  시뮬레이션
			// 5배수나무들 8방향으로 번식 
			fall();                 // 가을 시뮬레이션
		}
		
		// 3. 정답 출력
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				answer += tree[i][j].years.size(); // 살아있는 나무들을 더해준다.
			}
		}
		System.out.println(answer);
	}
	
	public static void spring_summer_winter() {
		D = new int[N+1][N+1];     // 번식할 나무 갯수를 저장
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int deathNut = 0;
				for(int k=0; k<tree[i][j].years.size(); k++) { // 나무가 있는 위치만 봄
					if(tree[i][j].nut < tree[i][j].years.get(k)) { // 죽을 나무
						deathNut += tree[i][j].years.get(k)/2; // 해당 나무의 나이절반을 영양분으로 저장 (여름)
						tree[i][j].years.remove(k);			   // 나무 제거
						k--; // 이부분 주의하기 
					} else {
						tree[i][j].nut -= tree[i][j].years.get(k); // 영양분 섭취
						tree[i][j].years.set(k, tree[i][j].years.get(k)+1); // 나이 1 증가
						if(tree[i][j].years.get(k) % 5 == 0) { // 5의 배수 나이 나무들만 확인 (가을 대비)
							D[i][j]++; // 번식할 나무 개수 저장
						}
					}
				}
				// 맵 i,j 순서대로 진행되게 때문에 그 이후에 여름과 겨울에 따로 영양분 추가 작업을 할필요 없이 바로 더해준다. 
				tree[i][j].nut += deathNut + nut[i][j]; // 여름(죽은나무 영양분) + 겨울(추가 영양분)
			}
		}
	}
	
	public static void fall() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(D[i][j] > 0) { // 번식할 나무 위치라면
					int nr,nc;
					for(int k=0; k<8; k++) { // 8방에 대해서
						nr = i + dr[k];
						nc = j + dc[k];
						if(nr > 0 && nr <= N && nc > 0 && nc <= N) {
							for(int l=0; l<D[i][j]; l++) {
								tree[nr][nc].years.add(0, 1); // (정렬을 하지 않기 위해 첫번째 인덱스로)나무 번식을 한다.
							}
						}
					}
				}
			}
		}
	} 
	
	// 해당 위치의 영양분 정보와 추가나무의 위치가 저장할 수 있는 리스트형태로 클래스 선언 
	private static class Tree{
		int nut; // 영양정보
		ArrayList<Integer> years = new ArrayList<Integer>(); // 해당 위치의 중복 나무들 나이 저장하기 위해
		public Tree(int nut, ArrayList<Integer> years) {
			super();
			this.nut = nut;
			this.years = years;
		}
	}
}
