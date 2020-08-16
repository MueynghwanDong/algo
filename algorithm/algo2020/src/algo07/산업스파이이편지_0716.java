package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class ���������������_0716 {

	static char[] arr;
	static LinkedList<Integer> list = new LinkedList<>();
	static boolean[] isPrime = new boolean[10_000_000];
	static boolean[] used;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		prime();

		for (int i = 0; i < t; i++) {
			result = 0;
			String str = br.readLine();
			arr = new char[str.length()];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = str.charAt(j);
			}

			for (int j = 0; j < arr.length; j++) {
				used = new boolean[arr.length];
				perm(j, arr[j] + ""); // arr ���ʴ�� �Ѱ��ֱ�

			}
			while(!list.isEmpty()) {        // Ž���� false�� �� �Ҽ����� �ٽ� true�� ����
                int num = list.remove();
                isPrime[num] = true;
            }
			System.out.println(result);
		} // t

	}

	private static void prime() { // �����佺�׳׽��� ü
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < isPrime.length; i++) {
			if (!isPrime[i])
				continue;

			for (int j = i + i; j < isPrime.length; j += i) {
				isPrime[j] = false;
			}
		}
	}

	public static void perm(int idx, String current) {
		if (current.length() > arr.length)
			return;
		int num = Integer.parseInt(current);

		used[idx] = true; // arr �迭�� ����� �κ� true �ϱ�

		if (isPrime[num]) { // �Ҽ��̸� ����Ʈ�� �־��ֱ�
			list.add(num); // �ߺ��� �������� list�� �ְ� false ���ִ� ��...
			isPrime[num] = false; // �߰��� �� false �����ֱ� ���߿� ����
			result++;
		}
		for (int i = 0; i < arr.length; i++) { // i ��°�� �����ϰ� next ���� ���س����鼭 ��� ȣ��
			if (used[i])
				continue;
			String next = current + arr[i];
			perm(i, next);
			used[i] = false;
		}
	}
}