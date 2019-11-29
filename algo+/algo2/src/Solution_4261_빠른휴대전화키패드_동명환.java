

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_4261_빠른휴대전화키패드_동명환 {

	// 값 저장 방식 - map // 배열 //
	static Map<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //'a' 49
		
		map.put('a', 2);		map.put('b', 2);		map.put('c', 2);		map.put('d', 3);		map.put('e', 3);		map.put('f', 3);		map.put('g', 4);
		map.put('h', 4);		map.put('i', 4);		map.put('j', 5);		map.put('k', 5);		map.put('l', 5);		map.put('m', 6);		map.put('n', 6);
		map.put('o', 6);		map.put('p', 7);		map.put('q', 7);		map.put('r', 7);		map.put('s', 7);		map.put('t', 8);		map.put('u', 8);
		map.put('v', 8);		map.put('w', 9);		map.put('x', 9);		map.put('y', 9);		map.put('z', 9);

		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String num = st.nextToken();
			int []srr = new int[num.length()];	
			for (int i = 0; i < srr.length; i++) {
				srr[i] = num.charAt(i)-'0';
			}
			int n = Integer.parseInt(st.nextToken()); // 
			int cnt = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			outer :for (int i = 0; i < n; i++) {
				String str = st.nextToken();
				if(num.length() == str.length()) {
				for (int j = 0; j < str.length(); j++) {
					if(srr[j] != map.get(str.charAt(j))) {
						continue outer;
					}
				}
				cnt++;
			}			
			
		}
			System.out.println("#" + testCase + " " + cnt);
		}
	}
}
