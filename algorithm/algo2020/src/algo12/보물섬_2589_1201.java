package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class º¸¹°¼¶_2589_1201 {

	static int r, c;
	static char[][] crr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		crr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				crr[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(crr[i][j]=='L')
					bfs(i,j);
			}
		}
		System.out.println(ans);

	}
	public static void bfs(int x, int y) {
		
		brr = new boolean[r][c];
		Queue<int[]> queue = new LinkedList<int[]>();
		brr[x][y] = true;
		queue.add(new int[] {x,y, 0});
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int cnt = q[2];
			if(cnt>ans) ans = cnt;
			
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if(nx <0 || ny<0 ||nx>=r || ny>=c || brr[nx][ny] || crr[nx][ny]=='W')continue;
				brr[nx][ny] = true;
				queue.add(new int[] {nx,ny,cnt+1});
						
			}
		}
	}

}
