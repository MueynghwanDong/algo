package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 나무재테크_16235_1014 {

	static class pair {
		int x;
		int y;
		int v; // 생존 여부
		int age;

		pair(int x, int y, int v, int age) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.age = age;
		}
	}

	static int n;
	static int m;
	static int k;
	static int[][] A;
	static int[][] arr;
	static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static List<ArrayList<ArrayList<pair>>> list = new ArrayList<>(); // 핵심!!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken()); // 년도
		A = new int[n][n];
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
			for (int j = 0; j < n; j++) {
				list.get(i).add(new ArrayList<>());
			}
		}//
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = 5; // 초기 양분 5
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()); // 위치
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()); // 심는 나무 나이
			list.get(r - 1).get(c - 1).add(new pair(r - 1, c - 1, 0, a));
		}
		for (int i = 0; i < k; i++) {
			solveSpring();
			solveSummer();
			solveFall();
			solveWinter();
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result += list.get(i).get(j).size();
			}
		}
		System.out.println(result);
	}

	public static void solveSpring() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if (list.get(i).get(j).get(k).age > arr[i][j]) { // 나무 나이가 양분보다 큰 경우 -> 나무 죽음
						list.get(i).get(j).get(k).v = 1; // 나무 죽음 표시 -> 여름에서 처리
					} else {
						arr[i][j] -= list.get(i).get(j).get(k).age++; // 죽은 경우 아닐 때 나이만큼 빼주기
					}
				}
			}
		}
	}

	public static void solveSummer() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if (list.get(i).get(j).get(k).v == 1) { // 죽은 나무인 경우
						arr[i][j] += (list.get(i).get(j).get(k).age / 2); // 양분에 나이 반값 추가
						list.get(i).get(j).remove(k); // 리스트에서 빼주기
						k--; // 삭제했으므로 -1해주어서 진행!! // 놓치기 쉬운 점.
					}
				}
			}
		}
	}

	public static void solveFall() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if (list.get(i).get(j).get(k).age % 5 == 0) { // 나이가 5의 배수인 경우 번식!! 
						for (int t = 0; t < dirs.length; t++) { // 인접
							int nx = i + dirs[t][0];
							int ny = j + dirs[t][1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= n)
								continue;
							list.get(nx).get(ny).add(0, new pair(nx, ny, 0, 1)); // 나무 1인 것 생성
						}
					}
				}
			}
		}

	}

	public static void solveWinter() {
		// 양분 추가!!
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] += A[i][j];
			}
		}
	}

}
