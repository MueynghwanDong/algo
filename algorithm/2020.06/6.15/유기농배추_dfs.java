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
			for(int i = 0; i<r; i++) {
				for(int j =0; j<c; j++) {
					
				}
			}

		} // end of testcase
	}// end of main
	
	public static void dfs() {
		
	}

}
