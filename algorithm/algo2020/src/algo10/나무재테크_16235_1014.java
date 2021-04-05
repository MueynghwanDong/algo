package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ��������ũ_16235_1014 {

	static class pair {
		int x;
		int y;
		int v; // ���� ����
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
	static List<ArrayList<ArrayList<pair>>> list = new ArrayList<>(); // �ٽ�!!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken()); // �⵵
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
				arr[i][j] = 5; // �ʱ� ��� 5
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()); // ��ġ
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()); // �ɴ� ���� ����
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
					if (list.get(i).get(j).get(k).age > arr[i][j]) { // ���� ���̰� ��к��� ū ��� -> ���� ����
						list.get(i).get(j).get(k).v = 1; // ���� ���� ǥ�� -> �������� ó��
					} else {
						arr[i][j] -= list.get(i).get(j).get(k).age++; // ���� ��� �ƴ� �� ���̸�ŭ ���ֱ�
					}
				}
			}
		}
	}

	public static void solveSummer() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if (list.get(i).get(j).get(k).v == 1) { // ���� ������ ���
						arr[i][j] += (list.get(i).get(j).get(k).age / 2); // ��п� ���� �ݰ� �߰�
						list.get(i).get(j).remove(k); // ����Ʈ���� ���ֱ�
						k--; // ���������Ƿ� -1���־ ����!! // ��ġ�� ���� ��.
					}
				}
			}
		}
	}

	public static void solveFall() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if (list.get(i).get(j).get(k).age % 5 == 0) { // ���̰� 5�� ����� ��� ����!! 
						for (int t = 0; t < dirs.length; t++) { // ����
							int nx = i + dirs[t][0];
							int ny = j + dirs[t][1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= n)
								continue;
							list.get(nx).get(ny).add(0, new pair(nx, ny, 0, 1)); // ���� 1�� �� ����
						}
					}
				}
			}
		}

	}

	public static void solveWinter() {
		// ��� �߰�!!
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] += A[i][j];
			}
		}
	}

}
