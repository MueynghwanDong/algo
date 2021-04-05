package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144_1015 {

	static int R;
	static int C;
	static int T;
	static int arr[][];
	static int copy[][];
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			fun();
			gongi();
//			for (int k = 0; k < R; k++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(arr[k][j]+" ");
//				}
//				System.out.println();
//			}
		}
		int tSum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j]!= -1)
					tSum += arr[i][j];
			}
		}
		System.out.println(tSum);
	}

	public static void fun() { // 확산
		copy = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (copy[i][j] != 0) {
					int cnt = 0;
					for (int k = 0; k < dirs.length; k++) {
						int nx = i + dirs[k][0];
						int ny = j + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] == -1)
							continue;
						arr[nx][ny] += (copy[i][j] / 5);
						cnt++;
					}
					arr[i][j] = arr[i][j] - (cnt * (copy[i][j] / 5));
				}
			}
		}

	}

	public static void gongi() { // 공기청정기
		// copy = new int[R][C];
		// for (int i = 0; i < R; i++) {
		// for (int j = 0; j < C; j++) {
		// copy[i][j] = arr[i][j];
		// }
		// }
		boolean f = false;
		for (int k = 0; k < R; k++) {
			
			if(arr[k][0] == -1 && !f) { // 위쪽으로 
				 f= true;
			       //공청기1
			        //위
			        for(int i = k-1; i>0; i--) {
			            arr[i][0] = arr[i-1][0];
			        }
			        //오
			        for(int j = 0; j<C-1; j++) {
			            arr[0][j] = arr[0][j+1];
			        }
			        //아래
			        for(int i = 0; i<k; i++) {
			            arr[i][C-1] = arr[i+1][C-1];
			        }
			        //왼
			        for(int j = C-1; j>0; j--) {
			            arr[k][j] = arr[k][j-1];
			        }
			        arr[k][1] = 0;
			}
			else if(arr[k][0] == -1 && f) {
				 for(int i = k+1; i<R-1; i++) {
			            arr[i][0] = arr[i+1][0];
			        }
			        
			        //왼쪽
			        for(int j = 0; j<C-1; j++) {
			            arr[R-1][j] = arr[R-1][j+1];
			        }
			        //아래
			        for(int i = R-1; i>k; i--) {
			            arr[i][C-1] = arr[i-1][C-1];
			        }
			        //오른쪽
			        for(int j = C-1; j>0; j--) {
			            arr[k][j] = arr[k][j-1];
			        }
			        arr[k][1] = 0;
			}
		}
		
	}
}
