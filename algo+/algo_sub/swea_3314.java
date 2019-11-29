import java.util.Scanner;

public class swea_3314 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int[] arr= new int[5];
			int sum =0;
			for (int i = 0; i < 5; i++) {
				arr[i] =sc.nextInt();
				if(arr[i]<40)
					arr[i] = 40;
				sum +=arr[i];
			}
			int average = sum/5;
			System.out.println("#" +testCase + " " + average);
		}

	}

}
