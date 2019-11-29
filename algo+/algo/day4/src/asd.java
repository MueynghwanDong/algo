import java.io.BufferedReader;
import java.io.InputStreamReader;

public class asd {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int num = Integer.parseInt(br.readLine());
			int arr[][] = new int[num][num];
			int index = 1;
			// 달팽이 경로에 순서대로 넣기
			int r = 0;
			int c = -1;
			int step = arr.length; // 몇칸 직진할지
			index = 1; // 정렬된 data 배열에서 꺼낼 순서를 관리할 인덱스
			while (step > 0) {
				for (int i = 0; i < step; i++) { // 우
					c++;
					arr[r][c] = index++;
				}
				step--;
				for (int i = 0; i < step; i++) { // 하
					r++;
					arr[r][c] = index++;
				}
				for (int i = 0; i < step; i++) { // 좌
					c--;
					arr[r][c] = index++;
				}
				step--;
				for (int i = 0; i < step; i++) { // 상
					r--;
					arr[r][c] = index++;
				}
			}
			// System.out.println(Arrays.toString(data));
			System.out.println("#"+testCase);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.printf("%d ", arr[i][j]);
				}
				System.out.println();
			}
		}
	}// end of main
} // end of class