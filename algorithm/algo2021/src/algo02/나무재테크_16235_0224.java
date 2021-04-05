package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ��������ũ_16235_0224 {
	static class Tree {

		int x, y, v, age;

		Tree(int x, int y, int v, int age) {
			this.x = x;
			this.y = y;
			this.v = v; // ���� ����
			this.age = age;
		}

	}

	static int n, m, k;
	static int[][] arr;
	static int[][] A;
	static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static List<ArrayList<ArrayList<Tree>>> list = new ArrayList<>(); // **

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		A = new int[n][n];
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new ArrayList<>());
			for (int j = 0; j < n; j++) {
				arr[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
				list.get(i).add(new ArrayList<>());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a - 1).get(b - 1).add(new Tree(a - 1, b - 1, 0, c));
		}
		for (int i = 0; i < k; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result += list.get(i).get(j).size();
			}
		}
		System.out.println(result);

	}

	public static void spring() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if (list.get(i).get(j).get(k).age > arr[i][j]) { // ��к��� ���̰� ���� ��� 
						list.get(i).get(j).get(k).v = 1;// �������� ǥ��
					} else {
						arr[i][j] -= list.get(i).get(j).get(k).age++; // ��� �԰� ���� ����
					}
				}
			}
		}
	}

	public static void summer() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if (list.get(i).get(j).get(k).v == 1) { // ���� ����
						arr[i][j] += (list.get(i).get(j).get(k).age / 2); // ����߰�(���� ���ݸ�ŭ)
						list.get(i).get(j).remove(k); // ����
						k--;
					}
				}
			}
		}
	}

	public static void fall() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if (list.get(i).get(j).get(k).age % 5 == 0) { // 5�� ����� ������ ���� ���� ��ġ�� ���� �߰�

						for (int t = 0; t < dirs.length; t++) {
							int nx = i + dirs[t][0];
							int ny = j + dirs[t][1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= n)
								continue;
							list.get(nx).get(ny).add(0, new Tree(nx, ny, 0, 1)); // ���� ���ʿ� ��ġ
						}

					}
				}
			}
		}

	}

	public static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] += A[i][j];
			}
		}
	}
}
