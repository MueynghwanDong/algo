import java.util.Scanner;

public class Solution_1208_SW문제해결기본1일차_Flatten_문지현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) { // 10번수행
			int dump = sc.nextInt();
			int [] list = new int [100];
			for (int j = 0; j < list.length; j++) { // 하나씩 높이 받기
				list[j] = sc.nextInt();
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int max_num;
			int min_num;
			for (int j = 0; j < dump; j++) { // dump횟수만큼 실행
				max_num = 0;
				min_num = 0;
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for (int k = 0; k < list.length; k++) { // max값 구하기
					if(list[k]>max) {
						max = list[k];
						max_num = k;
					}
					if(list[k]<min) {
						min = list[k];
						min_num = k;
					}
				}
				list[max_num] --;
				list[min_num] ++;
			}
			max_num = 0;
			min_num = 0;
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int k = 0; k < list.length; k++) { // max값 구하기
				if(list[k]>max) {
					max = list[k];
					max_num = k;
				}
				if(list[k]<min) {
					min = list[k];
					min_num = k;
				}
			}
			System.out.println("#"+i+" "+(max-min));
		}
	}
}
