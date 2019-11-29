import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_1859 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		for (int testCase = 1; testCase <= T; testCase++) {
			int num = Integer.parseInt(br.readLine());
			int []mama = new int[num];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < mama.length; i++) {
				mama[i] = Integer.parseInt(st.nextToken());
				//System.out.println(mama[i]);
			}
		}
	}
}
