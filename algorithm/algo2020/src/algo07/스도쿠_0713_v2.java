package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ������_0713_v2 {

	static int n = 9;
	static int[][] arr = new int[n][n];
	static int[][] result = new int[n][n];
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = (str.charAt(j) - '0');
				if (arr[i][j] == 0) {
					list.add(new int[] { i, j }); // ��ĭ�� ����Ʈ�� �־��ֱ�
				}
			}
		} // �Է�
		dfs(0);

	}

	public static void dfs(int idx) {

		if (idx == list.size()) { // ��ĭ �� ä����
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}

			System.exit(0);
		}
		for (int i = 1; i <= n; i++) {
			// ������ ��Ȳ���� ������ �Ǵ��ϱ� ���� ���� �ڽ�
			if (checkrow(idx, i) && checkcol(idx, i) && checkbox(idx, i)) { // ���� list�� idx��° ��ĭ�� ���ڸ� �Ķ���ͷ� �ѱ�
				arr[list.get(idx)[0]][list.get(idx)[1]] = i; // ���� ä���ֱ�
				dfs(idx + 1);
			}
			 if(i==9)
				 arr[list.get(idx)[0]][list.get(idx)[1]] = 0;
		}
//		arr[list.get(idx)[0]][list.get(idx)[1]] = 0; // ��Ʈ��ŷ
	}

	public static boolean checkrow(int idx, int val) { // ���� üũ 
		int cx = list.get(idx)[0];
		for (int i = 0; i < n; i++) {
			if (arr[cx][i] == val) // val�� arr�迭 ���� ��ġ�ϸ� false // arr[cx][i]�� 1~9���̸� false
				return false;
		}
		return true;
	}

	public static boolean checkcol(int idx, int val) { // ���� üũ
		int cy = list.get(idx)[1];
		for (int i = 0; i < n; i++) {
			if (arr[i][cy] == val)
				return false;
		}
		return true;
	}

	public static boolean checkbox(int idx, int val) { // �ڽ� üũ

		// (0,0)�� ��ĭ�� ���, (0,0) ~ (2,2)�� �˻�
		// (1,4)�� ��ĭ�� ���, (0,3) ~ (2,5)�� �˻�
		// �� ��ǥ�� 3���� ���� �� �� *3�� ���ָ� �ش� ��ǥ�� ���� �ڽ��� �������� ����

		int cx = list.get(idx)[0];
		int cy = list.get(idx)[1];
		int boxx = cx / 3;
		boxx *= 3;
		int boxy = cy / 3;
		boxy *= 3;

		for (int i = boxx; i < boxx + 3; i++) {
			for (int j = boxy; j < boxy + 3; j++) {
				if (i == cx && j == cy)
					continue;
				if (arr[i][j] != 0 && arr[i][j] == val)
					return false;
			}
		}
		return true;
	}
}
