import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_7272 {

	static char[] one = { 'A', 'D', 'O', 'P', 'Q', 'R' };
	static char[] two = { 'B' };
	static char[] no = { 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			String s = br.readLine();
			String str[] = s.split(" ");
			int check = 0;
			int check2 = 0;
			boolean is = false;
			if (str[0].length() != str[1].length()) {
				is =true;
				//System.out.println("DIFF");
			} else {
				for (int i = 0; i < str[0].length(); i++) {
					for (int j = 0; j < one.length; j++) {
						if (str[0].charAt(i) == one[j])
							check = 1;
						if (str[1].charAt(i) == one[j])
							check2 = 1;
					}
					for (int j = 0; j < two.length; j++) {
						if (str[0].charAt(i) == two[j])
							check = 2;
						if (str[1].charAt(i) == two[j])
							check2 = 2;
					}
					for (int j = 0; j < no.length; j++) {
						if (str[0].charAt(i) == no[j])
							check = 3;
						if (str[1].charAt(i) == no[j])
							check2 = 3;
					}
					if (check != check2) {
						is = true;
						break;
					}
				}
			}
			if (is)
				System.out.println("#" + testCase + " " + "DIFF");
			else
				System.out.println("#" + testCase + " " + "SAME");

		}

	}

}
