import java.util.Arrays;
import java.util.Scanner;

/**
 * Flatten 문제
 * @author student
 *
 */
public class Z05_Flatten {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 0; testCase < 10; testCase++) {
			int dump_cnt = sc.nextInt();	// 덤프의 합
			int[] arr = new int[100];	// 상자
			
			int sum = 0;	// 전체 상자들의 개수의 합
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			int target = 1; // 평탄화 작업 후 최대~최소의 차이
			if(sum % 100 == 0) {
				target = 0;
			}
			
			Arrays.sort(arr);
			for (int i = 0; i < dump_cnt && arr[99] - arr[0] > target ; i++) {
				arr[99]--;	// 가장 높은 박스를 하나 제거
				arr[0]++;	// 가장 낮은 박스에 하나 추가
				Arrays.sort(arr);
			}
			
			System.out.println("#"+(testCase+1)+" "+(arr[99]-arr[0]));
		}
		
	}
}
