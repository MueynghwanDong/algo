

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_동명환2 {

	private static String result;
	private static int[] p;
	private static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			result = "";
			p = new int[n+1];
			rank = new int[n+1];
			for (int i = 1; i <= n; i++) {
				makeset(i);
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				calc(op, a, b);
			}
			System.out.println("#" + testCase +" " +result);
		}
	}

	private static void calc(int op, int a, int b) {
		switch(op) {
		case 0:
			int px = findset(a);
			int py = findset(b);
			if(px!=py) {
				link(px,py);
			}
			break;
		case 1:
			if(p[a] == p[b])
				result += "1";
			else 
				result += "0";
			break;
		}
		
	}

	private static void link(int px, int py) {
		if(rank[px] < rank[py]) {
			p[px] = py;
		}else {
			p[px] = py;
			if(rank[px]== rank[py]) {
				rank[py]++;
			}
		}
		
	}

	private static int findset(int x) {
		if(p[x]==x) {
			return x;
		}else {
			p[x] = findset(p[x]);
			return p[x];
		}
	}

	private static void makeset(int x) {
		p[x] = x;
		rank[x] = 0;
		
	}

}
