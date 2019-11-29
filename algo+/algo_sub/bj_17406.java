import java.util.Scanner;

public class bj_17406 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		int k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}		
		for (int i = 0; i <k; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			System.out.println(r + " " + c + " " +s);
			for (int a = 0; a <n; a++) {
				for (int j = r-s; j <= r+s; j++) {
					System.out.print(arr[a][j]);
				}
				System.out.println();
			}
			System.out.println();
			for (int a = 0; a <m; a++) {
				if(a == arr.length-1) {
					
				}
			}
			System.out.println();
			
			
						
		}				
	}

}
