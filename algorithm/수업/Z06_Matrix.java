import java.util.Arrays;
import java.util.Random;

public class Z06_Matrix {

	public static void main(String[] args) {
		
		int[][] arr = new int [7][7];
		Random rd = new Random();
		int abs = 0;
		
		for (int i = 1; i<arr.length-1; i++) {
			for (int j = 1; j < arr[i].length-1; j++) {
				arr[i][j] = rd.nextInt(25)+1;
			}
			System.out.println(Arrays.toString(arr[i]));
		}
		
		// 외곽에 한줄씩 만든것 때문에 절대값 구하기가 어려움 => 외각복사.
		for (int i = 0; i < arr.length; i++) {
			arr[0][i] = arr[1][i];
			arr[6][i] = arr[5][i];
			arr[i][0] = arr[i][1];
			arr[i][6] = arr[i][5];
		}
		
		System.out.println();
		int[][] absArr = new int[5][5];
		
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < arr.length-1; j++) {
				abs += Math.abs(arr[i][j]-arr[i+1][j]);
				abs += Math.abs(arr[i][j]-arr[i][j+1]);
				abs += Math.abs(arr[i][j]-arr[i-1][j]);
				abs += Math.abs(arr[i][j]-arr[i][j-1]);
				absArr[i-1][j-1] = abs;
				abs = 0;
			}
		}
		/*
		 *
		 */
		
		for (int[] a : absArr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
