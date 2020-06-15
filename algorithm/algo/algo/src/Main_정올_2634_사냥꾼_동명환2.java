import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_동명환2 {

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
			int left = 0;
			int right = sade.length;
			if (right == 1) {
				if (L - y >= Math.abs(sade[0] - x)) {
					count++;
				}
			} else {
				if (L - y >= 0) {
					boolean check = false;
					while (left <= right) {
						mid = (left + right) / 2;
						if(mid == sade.length) {
							if (L - y >= Math.abs(sade[sade.length-1] - x)) {
								check = true;
								count++;
								break;
							}
						}
						if (sade[mid] > x) {
							right = mid - 1;
						} else if (sade[mid] < x) {
							left = mid + 1;
						} else {
							if (L - y >= Math.abs(sade[mid] - x)) {
								check = true;
								count++;
								break;
							}
						}
					}
					if (!check) {
						if (L - y >= Math.abs(sade[mid] - x)) {
							count++;
						}
					}
				}
			}

//			int len = L - y;
//			if (len >= 0) {
//				if (sade[mid] == len) {
//					count++;
//				} else if (sade[mid] < x) {
//					for (int j = mid; j < sade.length; j++) {
//						if (len >= Math.abs(sade[j] - x)) {
//							count++;
//							break;
//						}
//					}
//				} else {
//					for (int j = 0; j <= mid; j++) {
//						if (len >= Math.abs(sade[j] - x)) {
//							count++;
//							break;
//						}
//					}
//				}
//			}
		}
		System.out.println(count);

	}

}
