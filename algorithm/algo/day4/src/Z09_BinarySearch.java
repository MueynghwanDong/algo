import java.util.Arrays;

/**
 * 정렬이 된 데이터 군에서 검색하는 방법 1. 반복문 2. Arrays.binarySearch 3.재귀함수
 */
public class Z09_BinarySearch {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // 정렬된 데이터
		int key = 8;
		int idx = Arrays.binarySearch(a, key);
		//System.out.println(idx);
		/*
		 * int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // 정렬된 데이터 int key = 8; int start =
		 * 0; // 검색의 첫번째 값 int end = a.length - 1; while (start <= end) { // 검색할 범위가
		 * 남아있으면 반복 int mid = (start + end) / 2; if (a[mid] == key) { // 찾은 경우
		 * System.out.println("찾음"); break; } else if (a[mid] > key) { // 키가 작은 쪽으로 재조정
		 * end = mid - 1; } else { start = mid + 1; } } if(start>end) {
		 * System.out.println("못찾음"); }
		 */

		
		System.out.println(bs( 0, b.length - 1));
	}
	static int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int key = 8;
	// if , switch 중 항목이 많으면 switch 가 더 좋다. switch는 int 형 정수, string, 가능 / 일치하는 값만 사용 가능
	// 구분해서 break를 잘이용해 사용할 수 있다.
	public static int bs(int start,int end) {
		if(start> end) { // 종료 파트
			return -1;
		}else { // 재귀 파트
			int mid = (start+end)/2;
			if(b[mid]>key) {
				return bs(start, mid-1);
			}else if(key>b[mid]) {
				return bs(mid + 1, end);
			}else {
				return mid;
			}
		}
	}
}
