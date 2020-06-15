import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_동명환3 {

	private static int M;
	private static int N;
	private static int L;
	private static int count;
	private static int[] sade;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 사대 수
		N = Integer.parseInt(st.nextToken()); // 동물 수
		L = Integer.parseInt(st.nextToken()); // 사정거리
		sade = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			sade[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		Arrays.sort(sade);
		int mid = M / 2;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int len = L - y;
			if (len >= 0) {
				if (sade[mid] == len) {
					count++;
				} else if (sade[mid] < x) {
					for (int j = mid; j < sade.length; j++) {
						if (len >= Math.abs(sade[j] - x)) {
							count++;
							break;
						}
					}
				} else {
					for (int j = 0; j <= mid; j++) {
						if (len >= Math.abs(sade[j] - x)) {
							count++;
							break;
						}
					}
				}
			}
		}
		System.out.println(count);

	}

}
