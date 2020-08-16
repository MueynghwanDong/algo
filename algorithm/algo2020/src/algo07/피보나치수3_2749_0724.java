package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 �ǻ�� �ֱ�
 - �Ǻ���ġ ���� k�� ���� �������� �׻� �ֱ⸦ ������ �Ǵµ� �̸� �ǻ�� �ֱ��� ��
 - ex �Ǻ���ġ ���� 3���� ������ �ֱ� ���̴� 8
 - �ֱⰡ p�̸� n ��° �Ǻ���ġ ���� m���� ���� �������� n%p ���� �Ǻ���ġ ���� m���� ���� �������� ����
 - m = 10^k �̸� �ֱ�� �׻� 15*10^(k-1)
 �������� m-> 1000000 , k =6
 �ֱ�� 15 * 10^5
 
 */
public class �Ǻ���ġ��3_2749_0724 {

	static long n;
	static long fibo[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		int pisano = 1500000; // �ǻ�� �ֱ�
		fibo = new long[pisano];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < pisano && i <= n; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
		}
		// �ǻ�� �ֱ� ������ ���ϱ�
		// �̻��� ���� ������ ������ n �� ã��
		if (n >= pisano) {
			n = n % pisano;
		}
		System.out.println(fibo[(int) n]);
	}

}
