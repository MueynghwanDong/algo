package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ´©ÀûÇÕ!! ºÎºÐÇÕ!!
public class °³¶Ë¹ú·¹_3020_0915 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] top= new int[m+1];
		int[] bot = new int[m+ 1];
		
		for (int i = 0; i < n/2; i++) {
			bot[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;			
		}
		
		int [] t_sum = new int[m+1];
		int [] b_sum = new int[m+1];
		for (int i = 1; i <= m; i++) {
			t_sum[i] = t_sum[i-1] + top[i];
			b_sum[i] = b_sum[i-1] + bot[i];
		}
		
		int min = n;
		int cnt = 0;
		for (int i = 1; i <= m; i++) {
			int total = 0; 
			total += b_sum[m] - b_sum[i-1];
			total += t_sum[m] - t_sum[m-i];
			
			if(min > total) {
				min = total;
				cnt = 1;
			}
			else if(total == min) {
				cnt++;
			}
//			System.out.print(arr[i]+" ");
		}
		System.out.print(min + " " + cnt);
	}

}
