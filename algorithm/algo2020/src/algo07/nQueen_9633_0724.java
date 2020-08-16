package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nQueen_9633_0724 {

	static int n;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		cnt = 0;
		for (int i = 1; i <= n; i++) {
			int[] col = new int[n + 1];
			col[1] = i; // 1�� i���� �� ����
			dfs(col, 1); // col �迭 , �� �ε���

		}
		System.out.println(cnt);
	}

	public static void dfs(int[] col, int row) {
		if (row == n) {
			cnt++;
		} else {
			for (int i = 1; i <= n; i++) {
				col[row + 1] = i;
				if (ispossible(col, row + 1)) {
					dfs(col, row + 1);
				}
			}
		}
	}

	public static boolean ispossible(int col[], int row) {
		
		for (int i = 1; i < row; i++) {
			// i ��� row ����� ���� ��
			if (col[i] == col[row])
				return false;
			// �밢���� ��ġ�ϴ� ��
			if (Math.abs(i - row) == Math.abs(col[i] - col[row]))
				return false;
		}
		return true;
	}

}
