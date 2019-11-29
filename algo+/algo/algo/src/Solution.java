

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//1 4 1 6 6 10 5 7 3 8 5 9 3 5 8 11 2 13 12 14
public class Solution {
	// 회의 하나를 추상화한 클래스
	static class temper {
		int under;
		int over;

		public temper(int under, int over) {
			this.under = under;
			this.over = over;
		}

		@Override
		public String toString() {
			return "[" + under + "," + over + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 회의 개수


		temper[] m = new temper[N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String ss[] = s.split(" ");
			m[i] = new temper(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
		}

		// 정렬, 기준 : 종료시간
		// 빨리 끝나는 회의부터 선택, 선택된 회의와 겹치는 시간 제거
		Arrays.sort(m, new Comparator<temper>() {
			@Override
			public int compare(temper o1, temper o2) {
				return o1.over - o2.over; // 종료시간 기준으로 오름차순 정렬
			}
		});
		// 회의가 겹치지 않도록 : 선택된 회의의 가장 마지막 종료시간보다 먼저 시직한 회의는 제거 , 종료시간 이후에 시작한 회의를 선택
		for (int j = 0; j < m.length; j++) {
			int cnt =1;
			int end = m[j].over;
			System.out.println(m[j]); // 가장 빨리 끝나는 회의 선택
			for (int i = 1; i < m.length; i++) {
				if (end <= m[i].under) {
					cnt++;
					System.out.println(m[i]);
					end = m[i].over; // 선택한 회의중 가장 마지막 종료시간 업데이트
				}
			}
			System.out.println(cnt);
		}

	} // end of main
} // end of class
