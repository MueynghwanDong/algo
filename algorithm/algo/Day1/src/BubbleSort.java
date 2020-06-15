import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		System.out.println("버블정렬");
		int[] x= {55,7,78,12,42};
		for (int i = x.length-1; i >= 0; i--) { // 검색영역의 끝 숫자를 표시
			for (int j = 0; j < i; j++) { //0~i 검색범위
				if(x[j]>x[j+1]) {
					int temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(x));
	}
}
