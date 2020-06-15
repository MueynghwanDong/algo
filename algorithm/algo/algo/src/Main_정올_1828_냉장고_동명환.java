import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_정올_1828_냉장고_동명환 {

	static class temp {
		int x;
		int y;

		public temp(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		temp[] tt = new temp[t];
		for (int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			tt[i] = new temp(x, y);
		}
		Arrays.sort(tt, new Comparator<temp>() {
			@Override
			public int compare(temp o1, temp o2) {
				return o2.y - o1.y;
			}
		});
		int result = 0;
		int under = Integer.MIN_VALUE;
		int over = Integer.MIN_VALUE;
		int nx = Integer.MIN_VALUE;
		int ny = Integer.MIN_VALUE;

		under = tt[0].y;
		over = tt[0].x;
		for (int i = 0; i < tt.length - 1; i++) {
			nx = tt[i + 1].y;
			ny = tt[i + 1].x;
			if (ny >= over) {
				under = nx;
				over = ny;
			} else if (nx >= over) {
				under = nx;
			} else {
				under = nx;
				over = ny;
				result++;
			}
			
		}
		System.out.println(result + 1);
	}
}
