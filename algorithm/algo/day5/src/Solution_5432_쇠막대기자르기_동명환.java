import java.io.BufferedReader;

import java.io.InputStreamReader;

public class Solution_5432_쇠막대기자르기_동명환 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();
			int top = -1;
			int result = 0;
			char[] s = new char[str.length()];
			char before = '0';
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					s[++top] = '(';
				} else {
					char temp = s[top--];
					if (before == '(')
						result += (top + 1);
					else
						result += 1;
				}
				before = str.charAt(i);
			}

			System.out.println("#" + testCase + " " + result);

		} // end of testCase
	}
}
