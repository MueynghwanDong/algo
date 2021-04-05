package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class easy_2048_12100_0323 {

	static int n, max = 0;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		fun(0);
		System.out.println(max);
	}

	public static void fun(int cnt) {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		}
		if (cnt == 5) { // 5번 수행시 가장 큰 값 찾기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > max)
						max = arr[i][j];
				}
			}
			return;
		}
		for (int i = 0; i < 4; i++) { // 방향별로 연산 수행
			merge(i);
			fun(cnt + 1);
			for (int j = 0; j < n; j++) {
				arr[j] = temp[j].clone();
			}
		}
	}

	public static void merge(int d) {
		Queue<Integer> q = new LinkedList<>();
		int[][] map = new int[n][n];
		if (d == 0) { // 상
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[j][i] != 0) {
						q.add(arr[j][i]);
					}
				}
				int idx = 0;
				while (!q.isEmpty()) {
					int val = q.peek();
					if (map[idx][i] == 0) { 
						map[idx][i] = q.poll();
					} else if (map[idx][i] == val) { // 같은 값
						map[idx][i] += q.poll();
						idx++;
					} else { //2 다음 4일 경우
						idx++;
						map[idx][i] = q.poll();
					}
				}
			}

		} else if (d == 1) { // 하
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (arr[j][i] != 0) {
						q.add(arr[j][i]);
					}
				}
				int idx = n - 1;
				while (!q.isEmpty()) {
					int val = q.peek();
					if (map[idx][i] == 0) {
						map[idx][i] = q.poll();
					} else if (map[idx][i] == val) {
						map[idx][i] += q.poll();
						idx--;
					} else {
						idx--;
						map[idx][i] = q.poll();
					}
				}
			}

		} else if (d == 2) { // 좌
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0) {
						q.add(arr[i][j]);
					}
				}
				int idx = 0;
				while (!q.isEmpty()) {
					int val = q.peek();
					if (map[i][idx] == 0) {
						map[i][idx] = q.poll();
					} else if (map[i][idx] == val) {
						map[i][idx] += q.poll();
						idx++;
					} else {
						idx++;
						map[i][idx] = q.poll();
					}
				}
			}

		} else if (d == 3) {// 우
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (arr[i][j] != 0) {
						q.add(arr[i][j]);
					}
				}
				int idx = n - 1;
				while (!q.isEmpty()) {
					int val = q.peek();
					if (map[i][idx] == 0) {
						map[i][idx] = q.poll();
					} else if (map[i][idx] == val) {
						map[i][idx] += q.poll();
						idx--;
					} else {
						idx--;
						map[i][idx] = q.poll();
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			arr[i] = map[i].clone();
		}

	}
}
