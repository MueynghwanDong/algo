import java.util.Arrays;

public class Z38_재귀조합 {

	public static int[] arr = {6,7,8,9};
	public static int[] trr;
	
	public static void main(String[] args) {
		int r = 3;	//    nCr    n: 전체 개수, r:뽑을 개수
		trr = new int[r];
		comb(arr.length, r);
	}

	public static void comb(int n, int r) {
		if (r == 0) {
			System.out.println(Arrays.toString(trr));
		} else if ( n < r ) {	// 잘못된 경우는 제거
			return;
		} else {
			trr[r-1] = arr[n-1];
			comb(n-1, r-1);	// n-1번째 숫자를 사용한 경우
			comb(n-1, r);	// n-1번째를 사용안 한 경우
			
		}
	}

}
