import java.util.Arrays;
import java.util.Scanner;

/*
10 8
3
0 3
1 4
0 2

50 50
4
0 45
0 30
0 29
0 48
 */
public class Algo2_서울_05_동명환 {

	static int garo[];
	static int sero[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int num = sc.nextInt();
		int garocnt = 0;
		int serocnt = 0;
		garo = new int[num];
		sero = new int[num];
		for (int i = 0; i < num; i++) {
			int cut = sc.nextInt();
			if (cut == 0) {
				garo[garocnt++] = sc.nextInt();
			} else
				sero[serocnt++] = sc.nextInt();
		} // 입력
		Arrays.sort(garo);
		Arrays.sort(sero);
		int[] newgaro = new int[garocnt + 1];
		int index = 0;
		int idx = 0;
		int[] newsero = new int[serocnt + 1];
		int current = 0;
		for (int i = 0; i < garo.length; i++) {
			if (garo[i] != 0) {
				newgaro[index++] = garo[i] - current;
				current = garo[i];
			}
			if (i == garo.length - 1) {
				newgaro[index++] = C - current;
			}
		}
		current = 0;
		for (int i = 0; i < sero.length; i++) {
			if (sero[i] != 0) {
				newsero[idx++] = sero[i] - current;
				current = sero[i];
			}
			if (i == sero.length - 1) {
				newsero[idx++] = R - current;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < newgaro.length; i++) {
			for (int j = 0; j < newsero.length; j++) {
				int result = newgaro[i] * newsero[j];
				if (result > max)
					max = result;
			}
		}
		System.out.println(max);
	} // end of main
} // end of class
