import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String str = br.readLine();
			int top = -1;
			int result = 0;
			int[] s = new int[str.length()];
			int[] arr = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {				
				if (str.charAt(i) == '(') {
					s[++top] = i;
				} else if (str.charAt(i) == ')') {					
					int n = s[top--];
					if (n == i - 1) {
						arr[i] = 99;
					} else {
						int cnt = 0;
						for(int j =n;j<=i;j++) {
							if(arr[j]==99)
								cnt++;
						}
						result += (cnt+1);
					}
					
				}
			}

			System.out.println("#" + testCase + " " + result);
		} // end of testCase
	}
}