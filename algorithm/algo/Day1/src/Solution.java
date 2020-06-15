import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		
		for(int i=0; i<num; i++) { 
			count = 0;
			String list = sc.next();
			char[] list1 = list.toCharArray();
			if(list1[0] == '1') {
				count++;
			}
			for(int j=0; j<list.length()-1; j++) {
				
				if((list1[j]== '1') && (list1[j+1] == '0')) {
					count++;
				}
				else if((list1[j]== '0') && (list1[j+1] == '1')) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", i+1,count);
		}
		sc.close();
	}
}