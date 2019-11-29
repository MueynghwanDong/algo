import java.util.Arrays;
import java.util.Scanner;

public class Solution_2063 { //중간값찾기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] list = new int [N];
		for (int i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		System.out.println(list[N/2]);
	}
}

//public class Solution_2063 { //중간값찾기
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);  // jdk 1.5 추가됨
//		// 나중에 BufferedReader 로 입력받아 다시 풀어보기(시간 비교해볼것)
//		int N = sc.nextInt();
//		int [] arr = new int [N];
//		for (int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//		}
//		Arrays.sort(arr); //오름차순
//		System.out.println(arr[N/2]);
//	}
//}