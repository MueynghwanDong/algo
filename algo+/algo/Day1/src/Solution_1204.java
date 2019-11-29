
import java.util.Scanner;

public class Solution_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt(); //테스트 케이스 수
		for (int i = 0; i < testcase; i++) {
			int [] list = new int [1000];
			int [] count = new int [101];
			int casenum = sc.nextInt(); //테스트케이스 번호
			for (int j = 0; j < list.length; j++) {
				list[j] = sc.nextInt(); //점수
				count[list[j]]++;
			}// 빈도수를 구했고
			int max = Integer.MIN_VALUE;
			for (int k = count.length-1; k >= 0; k--) {
				if(count[k]>max) {
					max = count[k];
				}
			}
			for (int k = count.length-1; k >= 0; k--) {
				if(max ==count[k]) {
					System.out.println("#"+casenum+" "+k);
					break;
				}
			}
		}
	}//max값을 찾고 index를 찾아라
}
