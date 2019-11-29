import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥고_count배열 {

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
		} // 첫 k개에 대한 카운트 배열 늘려주고, 쿠폰 번호에 대한 값 늘려주기
			// result 값은 중복되지 않은 값에 대해서 ++해주기
		int ans = result;
//		System.out.println(Arrays.toString(cntrr));
//		System.out.println(result);
		for (int i = k; i < k + n; i++) {
//			System.out.println(Arrays.toString(cntrr));
//			System.out.println(i - k + " " + i % n);
//			System.out.println(result);
			// 0번째 인덱스 값에 대해 변경해주면서 k번째 값이 증가되면서 값을 변경해줌...
			// 가장 처음의 경우 k번째 부터 시작이기에 첫 k개에 대해 값 -- 해주는 부분 0이되는 경우 result값 --
			cntrr[arr[i - k]]--;
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
