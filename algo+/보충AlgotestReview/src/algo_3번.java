import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 *  DFS 응용 
 *  완전탐색으로 하면 시간초과
 *  백트래킹 으로 풀어야함... 가지치기가 핵심... 
 */
public class algo_3번 {

	private static int n;
	private static int[][] map;
	private static HashSet<Integer>[] hsw;
	private static HashSet<Integer>[] hsl;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 1<= n <= 99
		int m = Integer.parseInt(st.nextToken()); // 1<= m <= n*(n-1)/2

		map = new int[n + 1][n + 1]; // 0번 정점 안씀
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = 1;
		}
		int cnt = 0; // 절대 중간이 될 수 없는 구슬의 수
		int mid = (n + 1) / 2; // 중간점 . 탈락기준
		hsl = new HashSet[n + 1];
		hsw = new HashSet[n + 1];
		for (int i = 1; i < n; i++) { // 전체 정점을 순회
			// i정점보다 큰 정점을 탐색
			// 각 정점에 큰 정점의 갯수을 가져올 것인지, 큰 정점의 목록을 가져오는지..-> 재활용 가능. 중복 정점 체크 하기 위해 좋음.
			int x = dfsLight(i).size();
			// i정점보다 작은 정점을 탐색
			int y = dfsWeight(i).size();
			if(x>=mid || y>=mid) {
				cnt++;
			}
		}
		System.out.println(cnt);

	} // end of main

	public static HashSet<Integer> dfsLight(int v) { // 가벼운 구슬을 순회하며 목록을 만들어 리턴
		if (hsl[v] == null) { // 저장한 적이 없을 때만 구해라
			hsl[v] = new HashSet<Integer>(); // 객체 생성
			for (int i = 1; i <= n; i++) {
				if (map[v][i] == 1) {
					hsl[v].add(i); // 현재 맵에 있는 직접 관계가 있는 정점 담기
					hsl[v].addAll(dfsLight(i)); // i 정점보다 더 가벼운 정점 목록을 받아 추가
				}
			}
		}
		return hsl[v];
	}

	public static HashSet<Integer> dfsWeight(int v) { // 무거운 구슬을 순회하며 목록을 만들어 리턴
		if (hsw[v] == null) { // 저장한 적이 없을 때만 구해라
			hsw[v] = new HashSet<Integer>();
			for (int i = 1; i <= n; i++) {
				if (map[i][v] == 1) {
					hsw[v].add(i); // 현재 맵에 있는 직접 관계가 있는 정점 담기
					hsw[v].addAll(dfsWeight(i)); // i 정점보다 더 무거운 정점 목록을 받아 추가
				}
			}
		}
		return hsw[v];

	}
}