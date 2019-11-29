import java.util.Arrays;

/**
 * 선택정렬 O[n^2] = 정렬 방법으로는 시간이 많이 걸려서 안쓰임.
 * 	k번째로 큰! (작은) 값을 찾을 때, 셀렉션 정렬 활용
 * @author student
 *
 */
public class Z10_SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {6, 4, 1, 9, 2, 8, 5, 7, 3};	// 9개
		int minIndex = Integer.MAX_VALUE;
		int tmp;
		
		for (int i = 0; i < a.length; i++) {
			minIndex = a[i];
			for (int j = i+1; j < a.length; j++) {
				if(a[minIndex] > a[j]) {
					minIndex = j;
				}
			}
			tmp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = tmp;
		}
		System.out.println(Arrays.toString(a));
		
	}

}
