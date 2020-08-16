package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 산업스파이이편지_0716 {

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
				perm(j, arr[j] + ""); // arr 차례대로 넘겨주기

			}
			while(!list.isEmpty()) {        // 탐색시 false가 된 소숫값을 다시 true로 변경
                int num = list.remove();
                isPrime[num] = true;
            }
			System.out.println(result);
		} // t

	}

	private static void prime() { // 에라토스테네스의 체
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

		used[idx] = true; // arr 배열중 사용한 부분 true 하기

		if (isPrime[num]) { // 소수이면 리스트에 넣어주기
			list.add(num); // 중복을 막기위해 list에 넣고 false 해주는 것...
			isPrime[num] = false; // 추가한 것 false 시켜주기 나중에 원복
			result++;
		}
		for (int i = 0; i < arr.length; i++) { // i 번째를 제외하고 next 값을 더해나가면서 재귀 호출
			if (used[i])
				continue;
			String next = current + arr[i];
			perm(i, next);
			used[i] = false;
		}
	}
}