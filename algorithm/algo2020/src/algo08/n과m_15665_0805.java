package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class n°úm_15665_0805 {
	static int n;
	static int m;
	static int arr[];
	static int trr[];
	static StringBuilder sb;
	static LinkedHashSet<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		trr = new int[m];
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		perm(0);
		for(String s : set) {
            sb.append(s.substring(0, s.length()-1)+"\n");
        }
        System.out.print(sb.toString());
	}

	public static void perm(int k) {
		if (k == m) {
			String s = "";
			for (int i = 0; i < trr.length; i++) {
				s += (trr[i] + " ");
			}
			set.add(s);
			return;
		}
		for (int i = 0; i < n; i++) {
				trr[k] = arr[i];
				perm(k + 1);
			
		}

	}
}
