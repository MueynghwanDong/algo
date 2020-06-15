import java.util.Scanner;

public class Solution_flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int dump = sc.nextInt();
			int[] list = new int[100];
			int[] count = new int[101];
			for (int j = 0; j < list.length; j++) {
				list[j] = sc.nextInt();
			}
			for (int j = 0; j < dump; j++) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				boolean flag = false;
				for (int k = 0; k <= list.length; k++) {
					count[list[k]]++;
					if(list[k]>max) {
						max = list[k];
						count[k]--;
					}
					if(list[k]<min) {
						min = list[k];
						count[k]++;
					}
					
					
				}
			}
		}
	}
}
