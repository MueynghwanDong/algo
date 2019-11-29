import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥고_deque_slidingwindow {

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
		Deque<Integer> d = new LinkedList<>();
		int ans = 0;
		int result = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 첫 k개에대한 연산
		for (int i = 0; i < k; i++) {
			d.add(arr[i]);
			if (cntrr[arr[i]] == 0) {
				result++;
				cntrr[arr[i]]++;
			}
			if (ans < result)
				ans = result;
		}
		if (cntrr[c] == 0) {
			result++;
			if (ans < result)
				ans = result;
		} else {
			if (ans < result)
				ans = result;
		}

		for (int i = 0; i < n - 1; i++) {
			d.pollFirst();// 맨앞의 값 제거
			// k번을 넣기위해 0번째 값에 대해 연산
			cntrr[arr[i]]--;
			if (cntrr[arr[i]] == 0) {
				result--;
			}
			// k 번째 에 대한 연산
			d.addLast(arr[(i + k) % n]); // k번째값 deque에 넣기
			if (arr[(i + k) % n] == 0) {
				result++;
			}
			cntrr[arr[(i + k) % n]]++;

			// 쿠폰 연산
			if (cntrr[c] == 0) {
				result++;
				if (ans < result)
					ans = result;
			} else {
				if (ans < result)
					ans = result;
			}

		}

		System.out.println(ans);

	} // end of main
} // end of class
