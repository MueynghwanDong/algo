import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class bj_16236 {

	static class shark {
		int x;
		int y;
		int time;
		int count;
		int size;

		public shark(int x, int y, int time, int count, int size) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.count = count;
			this.size = size;
		}
	}

	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] fish;
	private static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	private static int n;
	static int sx;
	static int sy;
	private static int under; // 상어가 먹을 수 있는 크기 작은 물고기 갯수

	public static void bfs() {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
		Queue<shark> q = new LinkedList<shark>();
		q.add(new shark(sx, sy, 0, 2, 2));
		shark temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			visited[temp.x][temp.y] = true;
			under = fun(temp);
			if (under == 0) {
				System.out.println(temp.time);
				break;
			}
			fun2(temp);
			for (int i = 0; i < dirs.length; i++) {
				int nx = temp.x + dirs[i][0];
				int ny = temp.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || temp.size < arr[nx][ny])
					continue;
				if (arr[nx][ny] == temp.size || arr[nx][ny] == 0) {
					arr[temp.x][temp.y] = 0;
					arr[nx][ny] = 9;
					q.add(new shark(nx, ny, temp.time + 1, temp.count, temp.size));
				} else {
					int tval = arr[temp.x][temp.y];
					arr[temp.x][temp.y] = 0; // 원래 상어 위치 0으로 초기화
					arr[nx][ny] = 9;
					fish[arr[temp.x][temp.y]]--; // 현재 물고기 배열에서 값 하나 제거
					if (temp.count - 1 == 0) {
						q.add(new shark(nx, ny, temp.time + 1, temp.size + 1, temp.size + 1)); // 사이즈가 커지는 경우
					} else {
						q.add(new shark(nx, ny, temp.time + 1, temp.count - 1, temp.size)); // 사이즈가 변하지 않는 경우
					}

				}
			}

		}
		System.out.println(temp.time);
	}

	// 여럿 물고기가 있을 때 선택하는 메서드
	public static void fun2(shark temp) {

		int trr[][] = new int[under][3];// 0 :x 좌표이동할 수 1: y 좌표 이동 할 수 2 : 거리
		int idx = 0;
		int currentx = temp.x;
		int currenty = temp.y;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					trr[idx][0] = i;
					trr[idx][1] = j;
					trr[idx][2] = Math.abs(i - currentx) + Math.abs(j - currenty);
				}
			}
		}
		if (idx > 1) {
			Arrays.sort(trr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[2] == o2[2]) {
						if (o1[1] == o2[1]) {
							return o1[0] - o2[0];
						} else {
							return o1[1] - o2[1];
						}
					}
					return o1[2] - o2[2];
				}
			});
		}
		for (int i = 0; i < idx; i++) {
			System.out.println(trr[i]);
		}

	}

	public static int fun(shark temp) { // 상어의 크기에 따른 물고기 크기 분포

		int over = 0; // 상어보다 큰 물고기
		int under = 0; // 상어보다 작은 물고기
		int mid = 0; // 상어의 크기와 같은 물고기
		for (int i = 0; i < fish.length; i++) {
			if (temp.size < i)
				over += fish[i];
			else if (temp.size > i)
				under += fish[i];
			else
				mid += fish[i];
		}
		return under; // 상어보다 작은 물고기를 리턴 -> 계속 진행할지 여부 체크하기 위해서

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		fish = new int[7]; // 크기별 물고기 수
		int cnt = 0; // 현재 물고기 갯수
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < n; j++, index += 2) {
				arr[i][j] = s.charAt(index) - '0';
				if (arr[i][j] != 9 && arr[i][j] != 0) {
					fish[arr[i][j]]++;
					cnt++;
				} else if (arr[i][j] == 9) {
					visited[i][j] = true;
					sx = i;
					sy = j;
					
				}
			}
		}
		if (cnt == 0) {
			System.out.println(0);
		} else {
			bfs();
		}

	} // end of main
} // end of class
