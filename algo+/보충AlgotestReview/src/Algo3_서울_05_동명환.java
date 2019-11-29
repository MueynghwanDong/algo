import java.util.Scanner;

/*
5 4
2 1
4 3
5 1
4 2
 */
public class Algo3_서울_05_동명환 {

	static class data {
		int ocnt;
		int ucnt;
		int[] over;
		int[] under;

		public data() {
			ocnt = 0;
			ucnt = 0;
			over = new int[n];
			under = new int[n];
		}
	}

	static int n;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		data[] d = new data[n + 1];
		for (int i = 0; i < d.length; i++) {
			d[i] = new data();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			d[a].under[d[a].ucnt++] = b;
			for (int j = 0; j < d[a].under.length; j++) {
				if (d[a].under[j] == b) {
					for (int k = 0; k < d[b].under.length; k++) {
						if (d[b].under[k] != 0) {
							d[a].under[d[a].ucnt++] = d[b].under[k];
						}
					}
				}
			}
		}
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].under.length; j++) {
				if (d[i].under[j] != 0) {
					d[d[i].under[j]].over[d[d[i].under[j]].ocnt++] = i;
				}
			}
		}
		int cnt = 0;
		int mid = n / 2;
		for (int i = 0; i < d.length; i++) {
			if (d[i].ocnt > mid || d[i].ucnt > mid)
				cnt++;
		}
		System.out.println(cnt);

	} // end of main
} // end of class
