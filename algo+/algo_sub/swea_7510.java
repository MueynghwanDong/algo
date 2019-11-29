import java.util.Scanner;

public class swea_7510 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int index = 0;

			int num = sc.nextInt();
			int arr[] = new int[num];

			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					arr[index++] = i;
				}
			}
			int idx = 0; 			int tsum = 0;
			while (true) {
				idx++;
				tsum += idx;
				if (tsum >= num)
					break;
			}
			int cnt = 0;
			if (num == 1) {
				cnt = 1;
			}
			// System.out.println(Arrays.toString(arr));
			for (int i = 1; i <= idx; i++) {
				int sum = 0;
				boolean check = false;
				if (i % 2 == 0) { // i가 짝수
					int temp = num / i;
					for (int j = 0; j < index; j++) {
						if (temp == arr[j]) {
							check = true;
							break;
						}
					}
					if (check) {
						// sum = temp;
						for (int k = 1; k < i / 2; k++) {
							sum = sum + (temp - k) + (temp + k);
						}
					} else {
						int a = temp + 1;
						sum = temp + a;
						for (int k = 1; k < i / 2; k++) {
							sum *= 2;
						}
					}
				} else { // i가 홀수
					int temp = num / i;
					sum = sum + temp;
					for (int j = 0; j < i / 2; j++) {
						sum = sum + (temp - j) + (temp + j);
					}
				}
				if (num == sum) {
					cnt++;
				}
			}

			System.out.println("#" + testCase + " " + cnt);
		}
	}
}
