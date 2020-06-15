/*
 * 강사님이랑 같이한거
 */
public class Z03_Gravity2 {

	public static void main(String[] args) {
		
		int[] a = { 7, 4, 2, 0, 0, 6, 0, 7, 0 };
		int fall = 0;
		
		for (int i = 0; i< a.length; i++) {
			int cnt = 0;	// 빈공간의 개수 = 나보다 작은 수의 개수
		
			for (int j = i+1; j < a.length; j++) {
				if(a[i] > a[j]) {
					cnt ++;
				}
				
			}
			if (fall < cnt) fall = cnt;
		}
		
		System.out.println(fall);
	}

}
