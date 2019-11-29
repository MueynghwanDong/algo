import java.util.Scanner;

public class Solution_1208_SW문제해결기본1일차_Flatten_동명환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxidx = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int minidx = 0;
		for (int i = 1; i <= 10; i++) {
			int dump = sc.nextInt();
			int[] arr = new int[100]; // 값 배열
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			for (int j2 = 0; j2 < arr.length; j2++) {
				if (arr[j2] > max) {
					max = arr[j2];
					maxidx = j2;
				}
				if (arr[j2] < min) {
					min = arr[j2];
					minidx = j2;
				}
			}
			for (int j = 1; j <= dump; j++) { // 덤프횟수 만큼 
				arr[maxidx]--;
				arr[minidx]++;
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				maxidx = 0;
				minidx = 0;
				for (int j2 = 0; j2 < arr.length; j2++) {
					if (arr[j2] > max) {
						max = arr[j2];
						maxidx = j2;
					}
					if (arr[j2] < min) {
						min = arr[j2];
						minidx = j2;
					}
				}
			}
			System.out.println("#" + i + " " + (arr[maxidx] - arr[minidx]));
		}
	}
}