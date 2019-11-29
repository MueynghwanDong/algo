import java.util.Arrays;

public class Gravity {
	public static void main(String[] args) {
		int[] a = {7,4,2,0,0,6,0,7,0}; //9개
		int[][] box =new int [9][8]; 
		int[] gra = new int [8];
		
		for (int i = 0; i < a.length; i++) { //2차원 배열만들기
			for (int j = 0; j < a[i]; j++) {
				box[i][j] = 1;  
			}
		}					
		for (int i = 0; i < gra.length; i++) { //열마다 더하고 9에서 뺀다
			for (int j = 0; j < box.length; j++) { //2차원배열을 열끼리 더하기
				gra[i] = gra[i] + box[j][i];
			}
			if(gra[i]!=0) {
				gra[i] = 9 - gra[i];
			}
		}
		System.out.println(Arrays.toString(gra));
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < gra.length; i++) {
			if(gra[i]>max) {
				max = gra[i];
			}
		}
		System.out.println(max);
	}
}

// 1차원 > 2차원배열 > 중력 > 최대값







