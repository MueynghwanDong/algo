import java.util.Scanner;

public class swea_7854 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {

			int num = sc.nextInt();
			int under10[] = { 1, 2, 5 };
			int arr[] = { 10, 20, 25, 50, 125 };
			int count = 0;
			int cnt = 0;
			int temp = num;
			while (temp >= 10) {
				cnt++;
				temp = temp / 10;
			}
			for (int i = 0; i < under10.length; i++) {
				if (num >= under10[i])
					count++;
			}
			for (int i = 1; i <= cnt; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (i == 1) {
						if (num >= arr[j]) {
							count++;
						}
					}

					else {
						if (num >= Math.pow(10, i-1) * arr[j])
							count++;
					}
				}
			}
			System.out.println("#" + testCase +" "+count);
		}

	}

}
