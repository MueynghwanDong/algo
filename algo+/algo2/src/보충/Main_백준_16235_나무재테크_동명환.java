package 보충;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.Collections;

import java.util.LinkedList;

import java.util.List;

import java.util.StringTokenizer;

public class Main_백준_16235_나무재테크_동명환 {
	private static int n;
	private static int m;
	private static int k;
	private static int[][] arr;
	private static List<Integer>[][] listarr;
	private static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } }; // 인접
	private static List<int[]> list;
	private static int[][] initrr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 배열 크기
		m = Integer.parseInt(st.nextToken()); // 초기 나무 갯수
		k = Integer.parseInt(st.nextToken()); // k년
		listarr = new List[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				listarr[i][j] = new LinkedList<>();
			}
		}
		arr = new int[n][n];
		initrr = new int[n][n]; // 현재 양분의 양을 저장하고 있는 배열
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				initrr[i][j] = 5;
			}
		}
		list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0, index = 0; j < n; j++, index += 2) {
				arr[i][j] = str.charAt(index) - '0'; // 겨울에 추가되는 양분의 양을 저장하는 배열
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			listarr[x][y].add(age);
			list.add(new int[] { x, y, 1 }); // 나무 정보 리스트에 추가하기 , 위치 x, y, 나무 갯수
		}
		for (int i = 0; i < k; i++) {
			// k번 반복 -> k년의 시간을 흐르게 함....
			fun();
		}
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			cnt += list.get(i)[2];
		}
		System.out.println(cnt);
	}

	public static void fun() {
		List<int[]> death = new LinkedList<int[]>(); // 죽은 나무의 값을 기억하기 위한 배열
		// 봄
		for (int i = 0; i < list.size(); i++) {
			int nx = list.get(i)[0];
			int ny = list.get(i)[1];
			if (listarr[nx][ny].size() > 1) { // 여러개 나무가 있을 때 // 여러 나무일 경우 가장 나이 어린 나무 부터 양분 추가하기
				Collections.sort(listarr[nx][ny]);
				for (int j = 0; j < listarr[nx][ny].size(); j++) {
					if (initrr[nx][ny] >= listarr[nx][ny].get(j)) {
						initrr[nx][ny] -= listarr[nx][ny].get(j); // 제거해주기
					}
					if (initrr[nx][ny] < listarr[nx][ny].get(j)) {
						death.add(new int[] { nx, ny, listarr[nx][ny].get(j) }); // 제거할 나무 위치
						listarr[nx][ny].remove(j);
					}
				}
			} else if (listarr[nx][ny].size() == 1) { // 하나만 있는 경우
				if (initrr[nx][ny] >= listarr[nx][ny].get(0)) {
					initrr[nx][ny] -= listarr[nx][ny].get(0); // 제거해주기
				}
				if (initrr[nx][ny] < listarr[nx][ny].get(0)) {
					death.add(new int[] { nx, ny, listarr[nx][ny].get(0) }); // 제거할 나무 위치
					listarr[nx][ny].remove(0);
					list.remove(i);
				}
			}
		}
		// 여름
		for (int i = 0; i < death.size(); i++) {
			int nx = death.get(i)[0];
			int ny = death.get(i)[1];
			int nage = death.get(i)[2] / 2;
			initrr[nx][ny] += nage;
		}
		death.clear();
		// 가을
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < listarr[list.get(i)[0]][list.get(i)[1]].size(); j++) {
				if (listarr[list.get(i)[0]][list.get(i)[1]].get(j) % 5 == 0) { // 5의 배수 인 경우

					for (int k = 0; k < dirs.length; k++) {
						int nr = list.get(i)[0] + dirs[k][0]; // 인접 행의 x좌표
						int nc = list.get(i)[1] + dirs[k][1]; // 인접 행의 y좌표
						if (nr < 0 || nc < 0 || nr >= n || nc >= n)
							continue;
						if (listarr[nr][nc].size() == 0) { // 전에 있던 것이 없을 경우
							listarr[nr][nc].add(1);

						} else { // 기존에 값이 있는 경우
							listarr[nr][nc].add(1);
							for (int l = 0; l < list.size(); l++) {
								if (list.get(l)[0] == nr && list.get(l)[1] == nc) {
									int tempnum = list.get(l)[2];
									list.remove(l);
									list.add(new int[] { nr, nc, tempnum + 1 });
									break;
								}
							}
						}
					}
				}
			}
		}
		// 겨울
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				initrr[i][j] += arr[i][j];
			}
		}
	}

}
