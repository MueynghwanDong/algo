
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Solution_4261_빠른휴대전화키패드_동명환22 {
 
    // 값 저장 방식 - map // 배열 //
  private static int temparr[] =
 	 {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9}; 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
//        map.put('a', "2");      map.put('b', "2");      map.put('c', "2");      map.put('d', "3");      map.put('e', "3");      map.put('f', "3");      map.put('g', "4");
//        map.put('h', "4");      map.put('i', "4");      map.put('j', "5");      map.put('k', "5");      map.put('l', "5");      map.put('m', "6");      map.put('n', "6");
//        map.put('o', "6");      map.put('p', "7");      map.put('q', "7");      map.put('r', "7");      map.put('s', "7");      map.put('t', "8");      map.put('u', "8");
//        map.put('v', "8");      map.put('w', "9");      map.put('x', "9");      map.put('y', "9");      map.put('z', "9");
 
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String num = st.nextToken();
            int[] arr = new int[num.length()];
            for (int i = 0; i < arr.length; i++) {
            	arr[i] = num.charAt(i)-'0';
			}
            int n = Integer.parseInt(st.nextToken());
            int count = 0;
            
            st = new StringTokenizer(br.readLine(), " ");
            outer :for (int i = 0; i < n; i++) {
                String str  = st.nextToken();
                if(num.length()== str.length()) {
                	for (int j = 0; j < str.length(); j++) {
                		if(arr[j] != temparr[str.charAt(j)-'a']) {
                			continue outer;
                		}
                	}
                	count++;
                }
            }                     
            System.out.println("#"+testCase + " " +count);
        }
    }

}