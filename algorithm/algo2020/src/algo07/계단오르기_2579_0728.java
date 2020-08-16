package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579_0728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if (n >= 2) {
			f[1] = arr[1]; // 첫번째 계단이 마지막일때 최대값
			f[2] = arr[2] + arr[1]; // 두번째 값이 마지막일 경우 최대값
			for (int i = 3; i <= n; i++) {
				f[i] = Math.max(arr[i - 1] + f[i - 3], f[i - 2]) + arr[i];
				// f[i] = Math.max(f[i - 3] + arr[i] + arr[i - 1], f[i - 2] + arr[i]);
				// 세 칸 이전의 최대값 + 연속된 두칸 // 두 칸 이전의 최대값 + 현재 위치 값 (두계단 점프 시)
			}
			System.out.println(f[n]);
		}else {
			System.out.println(arr[n]);
		}
	}
}
