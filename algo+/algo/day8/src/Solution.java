import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + testCase + " ");
			int a = Integer.valueOf(br.readLine());
			String[] ss = br.readLine().split(" ");
			if (ss.length % 2 == 0) {
				int step = ss.length / 2;
				for (int i = 0; i < step; i++) {
					sb.append( ss[i] + " " + ss[i + step] + " ");
				}
			} else {				
				int step = ss.length / 2 + 1;
				for (int i = 0; i < step; i++) {
					if (i == step - 1) {
						sb.append(ss[i]);
					} else
						sb.append( ss[i] + " " + ss[i + step] + " ");
				}
			}
			System.out.println(sb);
		}
	}
}
