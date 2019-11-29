
public class Z02_Array {
	public static void main(String[] args) {
		// 배열을 객체로 간주
		// 배열은 생성시 각 타입의 기본값으로 초기화된다
		int[] arr;
		arr = new int [3];
		
		int[] brr =new int[3];
		
		int[] crr = {1,2,3};
		
		int[] drr = new int [] {1,2,3}; // 익명배열 사용할때
		
		int max; // 지역변수에는 초기값이 들어있지 않다.
		
		int[][] err = {{1,2},{3,4},{5,6}}; // 3행 2열
		for (int i = 0; i < err.length; i++) {
			for (int j = 0; j < err[i].length; j++) {
				System.out.print(err[i][j]);
			}
			System.out.println();
		}
		
		
		
		
	}
}
