import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥고 {

	private static int n;
	private static int d;
	private static int k;
	private static String c;
	private static String[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 회전 초밥의 초밥 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		c = st.nextToken(); // 쿠폰 번호
		arr = new String[n]; // 회전 초밥에 있는 초밥을 저장할 배열
		// Set<String> set = new HashSet<>();
		int num = k - 1;
		int result = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
			if (i >= num) {
				boolean ch = true;
				Set<String> s = new HashSet<>();
				String temp = "";
				for (int j = num; j >= 0; j--) {
					s.add(arr[i - j]);
					temp = temp + arr[i - j] + " ";
					if (arr[i - j].equals(c)) {
						ch = false;
					}
				}
				if (ch) {
					if (result < s.size() + 1) {
						// set.add(temp);
						result = s.size() + 1;
					}
				} else {
					if (result < s.size()) {
						// set.add(temp);
						result = s.size();
					}
				}
			}
		}
//		System.out.println(set.toString());
		System.out.println(result);

	} // end of main
} // end of class
