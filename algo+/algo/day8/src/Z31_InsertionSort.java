import java.util.Random;

/**
 * 삽입정렬 : O[n^2] but, 하나만 정렬하면 될 때 유용한 알고리즘 -> 이진검색 사용하면 유용
 * 
 */
public class Z31_InsertionSort {

	public static void main(String[] args) {

		// int arr[] = { 1, 4, 7, 0, 5, 6, 8, 2, 9, 3 };
		int arr[] = new int[200000];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(arr.length);
		}
		long time = System.currentTimeMillis();
		// 배열, swap , 코드 간단, 20만개 12866ms
//		for (int i = 1; i < arr.length; i++) {
//			for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) { // 삽입할 대상 전부터 감소하면서 검색
//				int temp = arr[j];
//				arr[j] = arr[j + 1];
//				arr[j + 1] = temp;
//			}
//		}

		// 배열, swap 안함. 8918ms
//		for (int i = 1; i < arr.length; i++) {
//			int data = arr[i]; // 삽입할 대상
//			int j;
//			for (j = i - 1; j >= 0 && data < arr[j]; j--) {
//				arr[j + 1] = arr[j]; // 뒤로 한칸 이동
//			}
//			arr[j + 1] = data; // 백업해놨던 삽입할 대상 숫자를 저장 ,1개를 보정해야함.
//		}

		// 배열, swap 안함, arraycopy() 5395ms
		for (int i = 1; i < arr.length; i++) {
			int data = arr[i]; // 삽입할 대상
			int j;
			for (j = i - 1; j >= 0 && data < arr[j]; j--) { // 삽입할 대상 전부터 감소하면서 검색 -> tnsck rjator
			}
			System.arraycopy(arr, j + 1, arr, j + 2, i - 1 - j); // 통째로 옮기기
			arr[j + 1] = data;
		}

		System.out.println(System.currentTimeMillis() - time + "ms");
		// System.out.println(Arrays.toString(arr));

	} // end of main
} // end of class
