import java.util.Arrays;
import java.util.Scanner;

public class Solution_5431_민석이의과제체크하기_문지현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 수
		for (int i = 0; i < T; i++) { // 테스트 케이스 반복
			int num = sc.nextInt(); // 총인원
			int num_o = sc.nextInt(); // 제출인원
			int [] list_o = new int [num_o]; // 낸사람 리스트
			int [] list = new int [num];
			
			for (int j = 0; j <num ; j++) { // 낸사람 번호받기
				list[j] = j+1;
			}
			for (int j = 0; j <num_o ; j++) { // 낸사람 번호받기
				list_o[j] = sc.nextInt();
			}
			for (int j = 0; j < num; j++) {
				for (int k = 0; k < list_o.length; k++) {
					if(list[j] == list_o[k]) {
						list[j] = 0;
					}
				}
			}
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < list.length; j++) {
				if(list[j] != 0) System.out.print(list[j]+" ");
			} System.out.println();
		}
	}
}