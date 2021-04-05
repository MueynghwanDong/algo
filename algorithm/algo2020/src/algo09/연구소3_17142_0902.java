package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3_17142_0902 {

	static int arr[][];
	static boolean[] check;
	static int n;
	static int m;
	static ArrayList<int[]> list = new ArrayList<>();
	static int count = 0, answer = Integer.MAX_VALUE;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		// 0 빈칸, 1 벽, 2 바이러스
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					list.add(new int[] { i, j });
				if (arr[i][j] == 0)
					count++;
			}
		} // 입력
		check = new boolean[list.size()]; // 초기 바이러스 수 만큼 할당
		// 바이러스 선택 확인 변수
		if (count != 0) // 빈칸이 있는 경우
			comb(0, 0);
		else
			answer = 0;
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	public static void comb(int depth, int start) { // 조합
		if (depth == m) { // 종료 조건
			int[][] copyarr = copy(); // 원 배열은 나두고 배열 복사
			bfs(copyarr, count);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			check[i] = true; // 바이러스 선택
			comb(depth + 1, i + 1);
			check[i] = false;
		}
	}

	public static int[][] copy() {
		int result[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = arr[i][j];
			}
		} // 배열 복사
		for (int i = 0; i < list.size(); i++) {
			if (!check[i]) {
				int[] idx = list.get(i);
				result[idx[0]][idx[1]] = 3; // 선택되지 않은 바이러스 3으로 처리
			}
		}
		return result;
	}

	public static void bfs(int[][] arr, int count) {
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			// 현재 선택된 바이러스 위치 큐에 추가
			if (check[i])
				queue.add(list.get(i));
		}
		int time = 0;
		while (!queue.isEmpty()) {
			if (answer <= time)
				break;
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int[] temp = queue.poll();
				int cx = temp[0];
				int cy = temp[1];
				for (int j = 0; j < dirs.length; j++) {
					int nx = cx + dirs[j][0];
					int ny = cy + dirs[j][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 1 || arr[nx][ny] == 2)
						continue;
					if (arr[nx][ny] == 0) // 빈칸인 경우
						count--;
					arr[nx][ny] = 2;
					queue.add(new int[] { nx, ny });
				}
			}
			time++;
			if (count == 0) {
				answer = time;
				return;
			}
		}

	}

}
