package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759_0216 {

	static int l, c;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken().charAt(0); 
		}
		Arrays.sort(arr);
		fun(0, "");

	}

	public static void fun(int idx, String str) {
		if (str.length() == l) {
			if (check(str)) {
				System.out.println(str);
			}
			return;
		}
		if (idx >= c)
			return;
		fun(idx + 1, str + arr[idx]);
		fun(idx + 1, str);
	}

	public static boolean isM(char cc) {
		if (cc == 'a' || cc == 'e' || cc == 'i' || cc == 'o' || cc == 'u')
			return true;
		else
			return false;
	}

	public static boolean check(String str) {
		int mcnt = 0;
		int jcnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isM(str.charAt(i)))
				mcnt++;
			else
				jcnt++;
		}
		if (mcnt >= 1 && jcnt >= 2)
			return true;
		else
			return false;

	}

}
