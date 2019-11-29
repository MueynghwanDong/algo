import java.util.Arrays;
import java.util.Random;

public class Z30_InsertSort {

	public static void main(String[] args) {
//		int [] arr = {1, 4, 7, 0, 5, 6, 8, 2, 9, 3};
		int[] arr = new int[200000];
		
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
		
		long time = System.currentTimeMillis();
		
		
		// 배열, Swap 안함 System.arrayCopy, 20만개 5424
		for (int i = 1; i < arr.length; i++) {
			int data = arr[i];	// 삽입할 대상
			int j;
			for (j = i-1; j >= 0 && data < arr[j]; j--) {
				
			}
			System.arraycopy(arr, j+1, arr, j+2, i-1-j);// 통째로 옮기기
			arr[j+1] = data;
		}
		
		
		// 배열, Swap 안함,
		for (int i = 0; i < arr.length; i++) {
			int data = arr[i]; 	// 삽입할 대상
			int j;
			for (j = i-1; j >= 0 && data < arr[j]; j--) {	//삽입할 대상 전부터 감소하면서 검색
				arr[j+1] = arr[j];	 // 뒤로한칸 옮기기
			}
			arr[j+1] = data;	// 백업해놨던 삽입할 대상 숫자를 저장, 1개 보정해야함
		}
		
		
		// 배열, Swap, 코드 간단, 
		// 0 ~ 0 1 ~ 끝
		// 0 ~ 1 2 ~ 끝
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i-1; j >= 0 && arr[j+1] > arr[j]; j--) {	//삽입할 대상 전부터 감소하면서 검색
//				int temp = arr[j];
//				arr[j] = arr[j+1];
//				arr[j+1] = temp;
//			}
//		}
		
		System.out.println(System.currentTimeMillis() - time + "ms");
	}

}
