import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 계산기 3+4*2+7*2
 */
public class Z17_Calculator {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int top = 0;
		int ptop = 0;
		char[] stack = new char[s.length()];
		int[] pstack = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				pstack[++ptop] = s.charAt(i)-'0';
				if (stack[top] == '*' && ptop >= 2) {
					char af =stack[top--];
					int a = pstack[ptop--];
					int b = pstack[ptop--];
					int sum = a * b;
					pstack[++ptop] = sum;
					if(top>0 && ptop>=2) {
						if(stack[top] == '*') {
							af =stack[top--];
							a = pstack[ptop--];
							b = pstack[ptop--];
							sum = a * b;
							pstack[++ptop] = sum;
						}
						else {
							af =stack[top--];
							a = pstack[ptop--];
							b = pstack[ptop--];
							sum = a + b;
							pstack[++ptop] = sum;
						}
					}
				}
			} else {
				stack[++top] = s.charAt(i);
		
			}
		}
		System.out.println(pstack[ptop]);

	} // end of main
} // end of class
