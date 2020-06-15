import java.util.Scanner;

public class Solution_4408_자기방으로돌아가기_동명환 {

	private static int[] start;
	private static int[] end;
	private static int n;
	private static int[] arr;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			n = sc.nextInt();
			start = new int[n];
			end = new int[n];
			arr = new int[401];
			for (int j = 0; j < end.length; j++) {
				start[j] = sc.nextInt();
				end[j] = sc.nextInt();
				System.out.println();
				if(start[j] < end[j]) {
					if (start[j] % 2 == 0)
						start[j] = start[j] - 1;
					if (end[j] % 2 == 1)
						end[j] = end[j] + 1;
				for (int k = start[j]; k <= end[j]; k++) {
					arr[k] = arr[k]+1;
				}
				}else {
					if (end[j] % 2 == 0)
						end[j] = end[j] - 1;
					if (start[j] % 2 == 1)
						start[j] = start[j] + 1;

					for (int k = end[j]; k <= start[j]; k++) {
						arr[k] = arr[k]+1;
					}
				}
			} // 입력
			int max = 0;
			for (int j = 0; j <arr.length; j++) {
				max = Math.max(max, arr[j]);
			}
			System.out.println("#" + i + " " + max);
		}
	}
}