import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 아기상어_sol {
	private static int[] cnt;
	private static int[][] m;
	private static int size;
	private static int num;
	private static int time;
	private static int r;
	private static int c;
	private static int[][] visited;
	private static int[] dr = {-1, 0, 0, 1};  //상좌우하
	private static int[] dc = { 0,-1, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());  //공간의 크기, 2 = N = 20
		m = new int[N+2][N+2];  //공간상태 0123456 9, 외곽 한줄씩 안씀
//		0 빈 칸
//		1, 2, 3, 4, 5, 6 칸에 있는 물고기의 크기
//		9 아기 상어의 위치 - 1마리 뿐
//		
		for (int i = 0; i < m.length; i++) {  //공간의 외곽 한줄은 안씀, 넘어가지 못하게 큰 숫자로 경계 표시함
			m[i][N+1] = Integer.MAX_VALUE;
			m[i][0] = Integer.MAX_VALUE;
			m[N+1][i] = Integer.MAX_VALUE;
			m[0][i] = Integer.MAX_VALUE;
		}
		
		cnt = new int[10]; // 물고기 개수
		r = 0; // 상어의 좌표
		c = 0;
		for (int i = 1; i<= N; i++) {
			String s = br.readLine();
			for (int j = 1; j<= N; j++) {
				m[i][j] = s.charAt((j-1)*2)-'0'; ///sa/d/
				cnt[m[i][j]]++;
				if (m[i][j] == 9) {
					r = i;
					c = j;
					m[i][j] = 0;
				}
			}
		}
		visited = new int[N+2][N+2]; // 방문 여부 체크 
		size = 2;  //아기상어의 초기 크기
		num = 0;  //아기상어가 먹은개수
		time = 0;  //지나간 시간
		
		while(true) {
			boolean check = false;
			for (int i = 1; i < size; i++) {
				if (cnt[i] > 0) {
					check = true;
					break;
				}
			}
			if (!check) {  //먹을 수 있는 물고기가 없으면 그만
				break;
			}
			if (!bfs()) {  //먹을 물고기는 있지만 갈수 없으면 그만
				break;
			}
		}
		
		System.out.println(time);
	}  //end of main
	// 큐에서 꺼내기 전에 정렬할 비교기준 
	private static Comparator<int[]> comparator = new Comparator<int[]>() {
		public int compare(int[] a, int[] b) {
			if (visited[a[0]][a[1]] != visited[b[0]][b[1]]) {
				return visited[a[0]][a[1]] - visited[b[0]][b[1]];
			}
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		}
	};
	public static boolean bfs() {
		for (int i = 0; i < visited.length; i++) {  //방문여부를 기록할 배열을 초기화
			Arrays.fill(visited[i], 0);
		}
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(comparator);
//		 아기상어의 위치(r,c)에서 bfs 상좌에서 하우 방향의 우선순위로 탐색, 자신 크기보다 작거나 같으면 이동가능
//		 상어가 먹으면 그 물고기 칸은 0이된다
//		 자신크기보다 작은 가까운 물고기 먹고, cnt 하나 감소 후 리턴
		visited[r][c] = 1;  //방문 표시하고 큐에 넣음
		q.offer(new int[] {r, c});
		while(q.size() > 0) {
			int[] t = q.poll(); 
			r = t[0];
			c = t[1];
			
			 //방문하고
			if (0 < m[r][c] && m[r][c] < size) {  //자신의 크기보다 작으면 먹기
				cnt[m[r][c]]--;  //물고기 개수 감소
				num++;  //먹은 물고기 개수
				time += visited[r][c]-1;
				if (num == size) { // 자신의 크기만큼 먹으면, 아기상어 크기 증가
					size++; // 아기상어 크기 증가
					num = 0;  //먹은 물고기 개수 다시 초기화
				}
				m[r][c] = 0; // 아기상어가 먹음
				return true; // 먹음
			}
			for (int i = 0; i < dr.length; i++) { // 인접칸 
				 //방문안했으면, 방문체크하고, 큐에 넣고
				if (visited[r+dr[i]][c+dc[i]] == 0 && m[r+dr[i]][c+dc[i]] <= size) {
					visited[r+dr[i]][c+dc[i]] = visited[r][c] + 1;
					q.offer(new int[] {r+dr[i], c+dc[i]});
				}
			}
		}
		return false;  //못먹음
	}
} // end of class