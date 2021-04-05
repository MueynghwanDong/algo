package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브_15685_0224 {

	static int n;
	static int[][] arr = new int[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			moving(x, y, d, g);
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i][j + 1] == 1 && arr[i + 1][j + 1] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void moving(int x, int y, int d, int g) {
		List<Integer> list = new ArrayList<>();
		list.add(d);
		for (int i = g; i > 0; i--) { // 세대 반복
			for (int j = list.size() - 1; j >= 0; j--) { // list에 있는 것 만큼 반복
				int nd = (list.get(j) + 1) % 4; // 90도 회전 -> +1
				list.add(nd);
			}
		}
		arr[x][y] = 1;
		for (int dir : list) {
			if (dir == 0) {
				x++;
			} else if (dir == 1) {
				y--;
			} else if (dir == 2) {
				x--;
			} else if (dir == 3) {
				y++;
			}
			arr[x][y] = 1;
		}
	}
}
