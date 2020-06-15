
public class Z02_Array {

	public static void main(String[] args) {
		// 배열을 객체로 간주
		// 배열은 생성시 각 타입의 기본값으로 초기화된다.
		
		int[] arr;
		arr = new int[3];
		
		int[] brr = new int[3];
		
		int[] crr = {1, 2, 3};
		
		int[] drr = new int[] {1, 2, 3};	// 익명배열쓸때 Drr을 사용함
		
		
		int max; // 지역변수는 초기화 X
		
		
		int[][] err = {{1,2}, {3,4}, {5,6}};	// 3행 2열
		for(int[] i: err) {
			for (int j: i) {
				System.out.printf("%d ",j);
			}
			System.out.println();
		}
		// 개선불가한 오류를 error, 개선가능한 에러를 Exception
		
		
	}	// end of main

}	// end of class
