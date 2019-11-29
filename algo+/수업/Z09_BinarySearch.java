import java.util.Arrays;

/**
 * 이진 검색 : 정렬이 된 데이터 군에서 검색하는 방법
 * @author student
 * 반복문
 * 메서드 사용
 * 재귀함수
 */
public class Z09_BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int start = 0;
		int end = a.length-1;
		int key = 8;

		int index = Arrays.binarySearch(a, key);
		System.out.println(index);
//		while (start <= end) {	// 검색할 범위가 남아있으면 반복
//			int mid = (start+end)/2;	// 중간위치의 값
//			if (a[mid] == key) {
//				System.out.println("찾았따");
//				break;
//			} else if (key < a[mid]) {
//				end = mid-1;
//			} else {
//				start = mid+1;
//			}
//		}
//		if (start > end) {
//			System.out.println("못찾음");
//		}
		
		
		
		System.out.println(bs(0, b.length-1));
	}
	public static int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static int key = 8;
	
	public static int bs(int start, int end) {
		
		// 조건절이 많을 땐 스위치가 빠름 => 해싱기법으로 키를 구분해놓기 때문에
		// if문은 우선순위 배열을 해놓으면 좋음
		if(start > end) {	// 종료파트
			return -1;
		} else { // 재귀파트
			int mid = (start+end)/2;
			if( key < b[mid]) {
				return bs(start, mid-1);
			} else if ( b[mid] < key ) {
				return bs(mid+1, end);
			} else { // 
				return mid;
			}
		}
	}

}
