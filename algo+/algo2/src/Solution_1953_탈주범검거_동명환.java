import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거_동명환 {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };// 상, 우, 좌, 하
	static int r, c, firstx, firsty, hour;
	static int arr[][];
	static boolean visited[][];
	static Queue<Pos> q = new LinkedList<>();

	public static class Pos {
		int x;
		int y;
		int count;

		public Pos(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void bfs() {
		Pos temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int num = arr[temp.x][temp.y];// 현재 구조물의 타입
			switch (num) {
			case 1:
				duple(0, 1, temp);
				duple(2, 3, temp);
				break;
			case 2:
				duple(0, 3, temp); // 상,하
				break;
			case 3:
				duple(2, 1, temp); // 좌,우
				break;
			case 4:
				duple(0, 1, temp); // 상, 우
				break;
			case 5:
				duple(3, 1, temp); // 하,우
				break;
			case 6:
				duple(3, 2, temp); // 하,좌
				break;
			case 7:
				duple(0, 2, temp); // 상,좌
				break;
			}// 상, 우, 좌, 하
		}
	}

	public static void duple(int idx1, int idx2, Pos temp) { // 위치 정보에 따라 이동할 수 있는 경우 와 다음 이동경로가 맞는 경우에 대해 큐에 넣기
		for (int i = 0; i < dir.length; i++) {
			if (i == idx1 || i == idx2) {
				int newx = temp.x + dir[i][0];
				int newy = temp.y + dir[i][1];
				if (newx < 0 || newy < 0 || newx >= r || newy >= c)
					continue;
				if (arr[newx][newy] != 0 && !visited[newx][newy] && temp.count < hour) {
					int nn = arr[newx][newy]; // 다음 이동 경로의 타입 확인
					switch (i) { // i의 방향과 현재 nn 의 방향을 확인
					case 0:
						if (nn == 1 || nn == 2 || nn == 5 || nn == 6) // 다음 경로가 상일 경우 이동할 수 있는 타입 경우
							break;
						else
							continue;
					case 1:
						if (nn == 1 || nn == 3 || nn == 7 || nn == 6)
							break;
						else
							continue;
					case 2:
						if (nn == 1 || nn == 3 || nn == 5 || nn == 4)
							break;
						else
							continue;
					case 3:
						if (nn == 1 || nn == 2 || nn == 4 || nn == 7)
							break;
						else
							continue;
					}// 상, 우, 좌, 하
					visited[newx][newy] = true;
					q.offer(new Pos(newx, newy, temp.count + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken()); // 지도 세로크기
			c = Integer.parseInt(st.nextToken()); // 지도 가로크기
			firstx = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 세로위치
			firsty = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 가로 위치
			hour = Integer.parseInt(st.nextToken());
			arr = new int[r][c];
			visited = new boolean[r][c];
			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < c; j++, index += 2) {
					arr[i][j] = str.charAt(index) - '0';
				}
			} // 입력
			visited[firstx][firsty] = true;
			q.offer(new Pos(firstx, firsty, 1)); // 맨홀 뚜겅 위치 넣어주기
			bfs();
			int cnt = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (visited[i][j])
						cnt++;
				}
			}
			System.out.println("#" + testCase + " " + cnt);
		}
	}
}