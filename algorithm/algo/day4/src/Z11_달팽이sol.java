import java.util.Arrays;

public class Z11_달팽이sol {

	public static void main(String[] args) {
		int arr[][] = { { 9, 20, 2, 18, 11 }, { 19, 1, 25, 3, 21 }, { 8, 24, 10, 17, 7 }, { 15, 4, 16, 5, 6 },
				{ 12, 13, 22, 23, 14 } };

		int[] data = new int[arr.length * arr.length];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				data[index++] = arr[i][j];
			}
		}
		Arrays.sort(data);
		// 달팽이 경로에 순서대로 넣기
		int r = 0;
		int c = -1;
		int step = arr.length; // 몇칸 직진할지
		index = 0; // 정렬된 data 배열에서 꺼낼 순서를 관리할 인덱스
		while (step > 0) {
			for (int i = 0; i < step; i++) { // 우
				c++;
				arr[r][c] = data[index++];
			}
			step--;
			for (int i = 0; i < step; i++) { // 하
				r++;
				arr[r][c] = data[index++];
			}
			for (int i = 0; i < step; i++) { // 좌
				c--;
				arr[r][c] = data[index++];
			}
			step--;
			for (int i = 0; i < step; i++) { // 상
				r--;
				arr[r][c] = data[index++];
			}
		}
		// System.out.println(Arrays.toString(data));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}

	}// end of main
} // end of class