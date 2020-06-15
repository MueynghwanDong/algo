import java.util.Arrays;

/**
 * 선택정렬 O[N^2] :정렬방법으로는 시간이 많이 걸려서 안쓰임 / K번째로 큰( 작은) 값을 찾을 때, 설렉션 알고리즘이 활용될 수
 * 있다.
 */
public class Z10_SelectionSort {

	public static void main(String[] args) {
		int[] a = { 6, 4, 1, 9, 2, 8, 5, 7, 3 };
		for (int i = 0; i < a.length; i++) { // 검색할 범위의 시작값
			// 최솟값을 찾아 교환
			int minidx = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[minidx]) { // 최소값의 위치를 찾기
					minidx = j;
				}
			}
			int temp = a[i];
			a[i] = a[minidx];
			a[minidx] = temp;
		}
		System.out.println(Arrays.toString(a));
	}// end of main
}// end of class
