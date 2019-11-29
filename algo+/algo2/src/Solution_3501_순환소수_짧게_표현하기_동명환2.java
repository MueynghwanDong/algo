import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3501_순환소수_짧게_표현하기_동명환2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // 1 ≤ p, q ≤ 10^5
			int q = Integer.parseInt(st.nextToken());
			int arr[] = new int[q];

			int mok = p / q;
			int nameji = p % q;
			// 나누어 떨어지면 소수가 아니니깐, 출력하고 다음 케이스로 넘어가기
			if (nameji == 0) {
				sb.append(mok).append("\n");
				continue;
			}
			// 나누어 떨어지지않으면 소수가 있는 거니까 , 출력후 다음 케이스로 넘어가기
			sb.append(mok).append('.');
			// 순환하는 소수 찾기
			// 순환하는지 찾기위해 나머지 값과 위치 저장
			int idx = 0;
			while (true) {
				//if(nameji == 0) break;
				if(arr[nameji]!=0) {
					sb.insert(arr[nameji], "(");
					sb.append(")");
					break;
				}
				arr[nameji] = idx;
				nameji *= 10;
				mok = nameji / q;
				nameji = nameji % q;
				sb.append(mok);
				idx++;
			}
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}

	// 값 저장하기..
	// 몫 저장 ? 나머지 저장 ?
	// 어느 값이 순환마디의 마지막인지 확인하는 것>

}
