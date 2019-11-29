import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥_동명환 {

	private static int n;
	private static int d;
	private static int k;
	private static int c;
	private static int[] arr;
	private static int[] cntrr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 회전 초밥의 초밥 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		arr = new int[n]; // 회전 초밥에 있는 초밥을 저장할 배열
		cntrr = new int[d + 1];
		cntrr[c]++; // 카운팅 배열의 쿠폰 번호에 대한 값 늘려주기

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int result = 1; //
		for (int i = 0; i < k; i++) {
			if (cntrr[arr[i]] == 0) {
				result++;
				cntrr[arr[i]]++;
			}
		}
		int ans = result;

		for (int i = k; i < k + n; i++) {

			if (cntrr[arr[i - k]] == 0)
				result--; //
			if (cntrr[arr[i % n]] == 0) { // 배열 인덱스가 넘어가기에 % 연산으로 주행 cntrr 값 증가는 앞과 동일하게 진행
				result++;
				cntrr[arr[i % n]]++;
			}
			// result 값이 크면 ans값 업데이트
			if (result > ans)
				ans = result;
		}
		System.out.println(ans);

	} // end of main
} // end of class
