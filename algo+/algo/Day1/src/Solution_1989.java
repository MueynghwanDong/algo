import java.util.Scanner;

public class Solution_1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); //테스트케이스
		for(int i=1; i<=num; i++) {
			String str = sc.next();
			int len = str.length();
			char[] list = str.toCharArray();
			for (int j = 0; j < len/2; j++) {
				if(list[j] != list[len-1-j]) { //if한번만 하기 True false사용
					System.out.printf("#%d 0\n", i);
				}
				else {
					System.out.printf("#%d 1\n", i);
				}
			}	
		}
	}
}