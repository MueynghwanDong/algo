package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class °øÇ×_10775_0211 {

	static int g;
	static int[] arr;
	static boolean[] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		arr = new int[g + 1];
		// brr = new boolean[g];
		int cnt = 0;
		for (int i = 1; i <= g; i++) {
			arr[i] = i;
		}
		for (int i = 1; i <= p; i++) {
			int gi = Integer.parseInt(br.readLine());
			int dck = find(gi);
			// System.out.println(dck);
			if (dck != 0) {
				merge(dck, dck - 1);
				cnt++;
			} else
				break;
		}
		System.out.println(cnt);

	}

	public static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		if (u != v)
			arr[u] = v;
	}

	public static int find(int gi) {
		if (gi == arr[gi])
			return gi;
		arr[gi] = find(arr[gi]);
		return arr[gi];
	}

}
