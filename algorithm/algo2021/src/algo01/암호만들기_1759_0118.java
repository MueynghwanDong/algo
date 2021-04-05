package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759_0118 {

	static int l, c;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new String[c];
		arr = br.readLine().split(" ");
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

	public static boolean isM(char ch) {
		return ch == 'a' | ch == 'e' | ch == 'i' | ch == 'o' | ch == 'u';
	}

	public static boolean check(String str) {
		int mcnt = 0, jcnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isM(str.charAt(i))) {
				mcnt++;
			} else {
				jcnt++;
			}
		}
		if (mcnt >= 1 && jcnt >= 2)
			return true;
		else
			return false;
	}

}
