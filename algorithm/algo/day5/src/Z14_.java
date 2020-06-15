
public class Z14_ {

	public static void main(String[] args) {
		String str = "()()((()))";
		char[] s = new char[20];
		int t = -1;
		int tt = -1;
		boolean check = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				s[++t] = c;
				tt--;
			} else {
				tt++;
				if (t == -1 || s[t--] != '(') {
					check = false;
					break;
				}
			}
		}
		if (t != -1)
			check = false;
		System.out.println(t);
		System.out.println(tt);
	}
}
