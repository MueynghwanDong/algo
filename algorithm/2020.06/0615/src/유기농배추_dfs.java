import java.util.Scanner;

public class ¿Ø±‚≥ÛπË√ﬂ_dfs {

	static int r;
	static int c;
	static int k;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			r = sc.nextInt();
			c = sc.nextInt();
			k = sc.nextInt();
			arr = new int[r][c];
			visited = new boolean[r][c];
			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 1;
			}
			int count = 0;
			for(int i = 0; i<r; i++) {
				for(int j =0; j<c; j++) {
					if(arr[i][j]==1 && !visited[i][j]) {
						dfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);

		} // end of testcase
	}// end of main
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i<dirs.length; i++) {
			int newx = x +dirs[i][0];
			int newy = y + dirs[i][1];
			
			if(newx < 0 || newy <0 || newx >=r || newy >=c) continue;
			if(!visited[newx][newy] && arr[newx][newy]==1) {
				dfs(newx, newy);
			}
		}
	}

}
