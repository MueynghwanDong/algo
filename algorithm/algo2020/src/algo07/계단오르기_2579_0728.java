package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ��ܿ�����_2579_0728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if (n >= 2) {
			f[1] = arr[1]; // ù��° ����� �������϶� �ִ밪
			f[2] = arr[2] + arr[1]; // �ι�° ���� �������� ��� �ִ밪
			for (int i = 3; i <= n; i++) {
				f[i] = Math.max(arr[i - 1] + f[i - 3], f[i - 2]) + arr[i];
				// f[i] = Math.max(f[i - 3] + arr[i] + arr[i - 1], f[i - 2] + arr[i]);
				// �� ĭ ������ �ִ밪 + ���ӵ� ��ĭ // �� ĭ ������ �ִ밪 + ���� ��ġ �� (�ΰ�� ���� ��)
			}
			System.out.println(f[n]);
		}else {
			System.out.println(arr[n]);
		}
	}
}
