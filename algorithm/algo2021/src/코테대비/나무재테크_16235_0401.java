package ���״��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ��������ũ_16235_0401 {

	static class Tree {
		int x, y, v, age;

		Tree(int x, int y, int v, int age) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.age = age;
		}
	}

	static int n, m, k;
	static int[][] arr;
	static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int[][] A; // ���
	static List<ArrayList<ArrayList<Tree>>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		A = new int[n][n];
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

	public static void spring() { // �� - ����� �԰� ���� �ѻ� ����, ����� ������ ��� ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					Tree cur = list.get(i).get(j).get(k);
					if (cur.age > arr[i][j]) {
						cur.v = 1; // ����
					} else {
						arr[i][j] -= cur.age++;
					}
				}
			}
		}
	}

	public static void summer() { // ���� - ���� ���� �������� ����� ����� ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					Tree cur = list.get(i).get(j).get(k);
					if (cur.v == 1) {
						arr[i][j] += cur.age / 2;
						list.get(i).get(j).remove(cur);
						k--;
					}
				}
			}
		}
	}

	public static void fall() { // ���� - ���� ��忡 ���ο� ���� �ɱ� (��, ���̰� 5�� ����� ���)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					Tree cur = list.get(i).get(j).get(k);
					if (cur.age % 5 == 0) {
						for (int l = 0; l < dirs.length; l++) {
							int nx = i + dirs[l][0];
							int ny = j + dirs[l][1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= n)
								continue;
							list.get(nx).get(ny).add(0,new Tree(nx, ny, 0, 1)); // ���� ���� � �������� ����� ����ϱ� ������ ���� �տ� �߰�
						}
					}

				}
			}
		}
	}

	public static void winter() { // �ܿ� - ��� �߰�
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] += A[i][j];
			}
		}
	}

}
