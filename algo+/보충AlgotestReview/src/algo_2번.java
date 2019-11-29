import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 영역 자르기 - Greedy
 */

public class algo_2번 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> cutR = new ArrayList<Integer>();
		ArrayList<Integer> cutC = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int type = Integer.parseInt(st.nextToken()); // 행/얄 그븐
			int num = Integer.parseInt(st.nextToken()); // 자를 우치
			if (type == 0) {
				cutR.add(num);
			} else {
				cutC.add(num);
			}
		}

		cutR.add(0); // 영역의 시작점 추가, 자를때 기준이 될 수 있도록 해줌
		cutR.add(r); // 영역의 끝 점 추가
		cutC.add(0);
		cutC.add(c);

		Collections.sort(cutR);
		Collections.sort(cutC);

		int maxR = 0;
		for (int i = 1; i < cutR.size(); i++) {
			if (maxR < cutR.get(i) - cutR.get(i - 1)) {
				maxR = cutR.get(i) - cutR.get(i - 1);
			}
		}
		int maxC = 0;
		for (int i = 1; i < cutC.size(); i++) {
			if (maxC < cutC.get(i) - cutC.get(i - 1)) {
				maxC = cutC.get(i) - cutC.get(i - 1);
			}
		}
		System.out.println(maxR * maxC);

	} // end of main
} // end of class
