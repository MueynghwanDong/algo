package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//1 4 1 6 6 10 5 7 3 8 5 9 3 5 8 11 2 13 12 14
public class Z40_Meet {
	// 회의 하나를 추상화한 클래스
	static class meet {
		int stime;
		int etime;

		public meet(int stime, int etime) {
			this.stime = stime;
			this.etime = etime;
		}

		@Override
		public String toString() {
			return "[" + stime + "," + etime + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 회의 개수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		meet[] m = new meet[N];
		for (int i = 0; i < N; i++) {
			m[i] = new meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 정렬, 기준 : 종료시간
		// 빨리 끝나는 회의부터 선택, 선택된 회의와 겹치는 시간 제거
		Arrays.sort(m, new Comparator<meet>() {
			@Override
			public int compare(meet o1, meet o2) {
				return o1.etime - o2.etime; // 종료시간 기준으로 오름차순 정렬
			}
		});
		// 회의가 겹치지 않도록 : 선택된 회의의 가장 마지막 종료시간보다 먼저 시직한 회의는 제거 , 종료시간 이후에 시작한 회의를 선택
		for (int j = 0; j < m.length; j++) {

			int end = m[j].etime;
			System.out.println(m[j]); // 가장 빨리 끝나는 회의 선택
			for (int i = 1; i < m.length; i++) {
				if (end <= m[i].stime) {
					System.out.println(m[i]);
					end = m[i].etime; // 선택한 회의중 가장 마지막 종료시간 업데이트
				}
			}
			System.out.println();
		}

	} // end of main
} // end of class
