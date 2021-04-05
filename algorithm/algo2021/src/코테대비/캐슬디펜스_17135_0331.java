package 코테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 캐슬디펜스_17135_0331 {

	static class Node implements Comparable<Node> {
		int x, y, d;

		Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			if (this.d == o.d) {
				return this.y - o.y;
			} else {
				return this.d - o.d;
			}
		}
	}

	static int n, m, d, result = 0, ans = 0, enermy = 0;
	static int[][] arr;
	static int[] trr;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					enermy++; // 적군의 갯수
				}
			}
		}
		for (int i = 0; i < m; i++) {
			arr[n][i] = 2; // 성
		}
		trr = new int[3];
		comb(m, 3, enermy);
		System.out.println(result);

	}

	public static void comb(int num, int gs, int e) {
		if (gs == 0) {
			ans = 0;
			// 복사해주는 이유 - arr로 하면 에러남
			// trr이 변함에 따라 다르게 연산해주어야 하니까..
			map = new int[n + 1][m];
			for (int i = 0; i < arr.length; i++) {
				map[i] = arr[i].clone();
			}
			for (int i = 0; i < trr.length; i++) {
				arr[n][trr[i]] = 3; // 선택된 궁수가 있는 성
			}
			enermy = e;
			// 적군이 남아있을 대 계속 진행...
			while (enermy > 0) {
				attack();
				downe();
			}
			if (result < ans) {
				result = ans;
				return;
			}

		} else if (num < gs) {
			return;
		} else {
			trr[gs - 1] = num - 1;
			comb(num - 1, gs - 1, e);
			comb(num - 1, gs, e);
		}
	}

	public static void downe() {
		// 적군이 한칸 내려오는 경우
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					if (i + 1 == n) { // 성위치에 도달한 경우 제외시킴
						enermy--;
						map[i][j] = 0;
					} else { // 한칸 내려오는 연산 수행
						map[i + 1][j] = 1;
						map[i][j] = 0;
					}
				}

			}
		}
	}

	public static void attack() {
		// 공격할 노드를 담을 변수
		Node[] nodes = new Node[3];
		int idx = 0;
		for (int i = 0; i < trr.length; i++) {
			int num = trr[i];
			// 한 궁수가 쏠 수 있는 적을 담을 리스트
			List<Node> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k] == 1) {
						int dist = Math.abs(n - j) + Math.abs(num - k);
						if (dist <= d) {
							list.add(new Node(j, k, dist));
						}
					}
				}
			}
			// 공격 가능 적군이 여럿일 경우 가장 우선 순위 높은 것 노드배열에 넣어주기
			if (list.size() > 0) {
				Collections.sort(list);
				Node n = list.get(0);
				nodes[idx++] = n;
			}
		}
		// 노드배열 속 적군의 위치 0으로 만들고 적군 수 줄이기
		for (int i = 0; i < idx; i++) {
			Node n = nodes[i];
			if (map[n.x][n.y] == 1) { // 겹칠 수 있는 상황이 있을 수 있음
				ans++;
				enermy--;
				map[n.x][n.y] = 0;
			}
		}
	}

}
