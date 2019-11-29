import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_7584_자가복제문자열_동명환 {

	public static String convert(int num, String pi) {
		String newstr = "";
		while (num > 0) {
			int idx = pi.length() - 1;
			String daching = "";
			for (int i = 0; i < pi.length(); i++) {
				daching += pi.charAt(idx - i);
			}
			// System.out.println(daching);
			String result = "";
			for (int i = 0; i < daching.length(); i++) {
				if (daching.charAt(i) == '1') {
					result = result + "0";
				} else {
					result = result + "1";
				}
			}
			// System.out.println(result);

			newstr = pi + "0" + result;
			pi = newstr;
			// System.out.println(newstr);
			num--;

		}
		return newstr;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String p1 = "001";
			int num =Integer.parseInt(br.readLine());
			if (num > 15) {
				String result = convert(15, p1);
				System.out.println(result.charAt(num - 1));
			}
			String result = convert(num, p1);
			// System.out.println(result.length());
		
			System.out.println(result.charAt(103));
			System.out.println("#" +testCase +" "+ result.charAt(num - 1));

		}
	} // end of main
} // end of class
