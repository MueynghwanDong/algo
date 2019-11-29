import java.util.Random;

public class Z05_Abs {

	public static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int[][] arr = new int[7][7];
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				arr[i][j] = r.nextInt(25)+1 ;
			}
		}
		// 출력용
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf("%2d  ", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		/*
		// 외곽에 한줄씩 만든 것 때문에 절대값 구하기 어려움 -> 외곽 복사 
		for(int i =1 ; i<=5; i++) {
			arr[0][i] = arr[1][i];
			arr[6][i] = arr[5][i];
			arr[i][0] = arr[i][1];
			arr[i][6] = arr[i][5];
		}*/
		
		// 출력용
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf("%2d  ", arr[i][j]);
			}
			System.out.println();
		}
		
		int sum = 0;
		int newR = 0;
		int newC = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				if (arr[i][j] != 0) {
					for (int k = 0; k < dirs.length; k++) {
						newR = i + dirs[k][0];
						newC = j + dirs[k][1];
						if(newR!=0|| newC!=0 || newR !=6 || newC!=6) {
						sum += Math.abs((arr[i][j] - arr[newR][newC]));
						//System.out.println(sum);
						}
					}
				}
			}
		}
		System.out.println("총합 : " + sum);
	}
}
