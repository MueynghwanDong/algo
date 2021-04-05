package algo09;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ДЎБо_2636_0906_dfs {

	private static int[][] arr;
	private static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static int R;
	private static int C;
    static int count = 0;
	private static boolean[][] brr;

	public static void fun(int x, int y) {
		for (int k = 0; k < dirs.length; k++) {
			int nx = x + dirs[k][0];
			int ny = y + dirs[k][1];
			if (nx >= R || ny >= C || nx < 0 || ny < 0)
				continue;
			if (arr[nx][ny] == 1) {
				arr[nx][ny] = 9;                
			}
			if (!brr[nx][ny] && arr[nx][ny] == 0) {
				brr[nx][ny] = true;
				fun(nx, ny);
			}
		}
	}

	public static void fun2() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] == 9) {
					arr[i][j] =0;
					count--;
				}					
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		brr = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < C; j++, index += 2) {
				arr[i][j] = s.charAt(index) - '0';
                if(arr[i][j] == 1) count++;
			}
		}
		int time = 0;
		int pre = 0;	
		while (true) {
            brr = new boolean[R][C];
        	if(count==0) {
				break;
			}
        	pre = count;
			fun(0,0);
			fun2();
			time++;		
            
		}
		System.out.println(time);
		System.out.println(pre);
	}

}
