import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_3501_순환소수_짧게_표현하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // 1 ≤ p, q ≤ 10^5
			int q = Integer.parseInt(st.nextToken());
			sb.append("#").append(testCase).append(' ');

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
			HashMap<Integer, Integer> hm = new HashMap<>(); // 나머지 값 : index 위치

			for (int i = sb.length(); nameji > 0; i++) { // 현재 저장되는 몫의 인덱스
				if (hm.containsKey(nameji)) {
					sb.insert(hm.get(nameji).intValue(), "(");
					sb.append(")");
					break;
				}
				hm.put(nameji, i);
				nameji *= 10;
				mok = nameji / q;
				nameji = nameji % q;
				sb.append(mok);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
