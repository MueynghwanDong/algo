import java.io.BufferedReader;
import java.io.InputStreamReader;

public class aaaa {

	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int num =Integer.parseInt(br.readLine());
			
			if(num%4!=0) {
				int n = num%8;
				switch(n) {
				case 1:
					System.out.println("#" +testCase +" "+ "0");
				case 2:
					System.out.println("#" +testCase +" "+ "0");
				case 3:
					System.out.println("#" +testCase +" "+ "1");
				case 5:
					System.out.println("#" +testCase +" "+ "1");
				case 6:
					System.out.println("#" +testCase +" "+ "1");
				case 7:
					System.out.println("#" +testCase +" "+ "0");
				}
			}else {
				
			}

			 
			//System.out.println("#" +testCase +" "+ result.charAt(num - 1));
			
		}
	} // end of main
} // end of class
