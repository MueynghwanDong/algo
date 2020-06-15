import java.util.Arrays;

/*
 * 연습문제 1
 */
public class Z03_Gravity {

	public static void main(String[] args) {

		int[] a = { 7, 4, 2, 0, 0, 6, 0, 7, 0 };
		int[][] room = new int[9][8];
		int maxFall = 0;
		int fall = 0;
		
		// 회전 후 박스 위치 저장
		for (int i = 0; i < room.length; i++) {

			for (int j = 0; j < a[i]; j++) { 
				room[i][j] = 1;
			} // end of for

		} // end of for
		
		// 출력문
		for (int i = 0; i< room.length; i++)
			System.out.println(Arrays.toString(room[i]));
		
	
		for (int k = room.length - 1; k >= 0; k--) {				// 낙하 시작, 맨 아랫줄 부터
			
			for (int l = 0; l < room[k].length; l++) {				// k번째줄 크기만큼
			
				// 만약 k, l칸에 상자가 있다면
				if (room[k][l] == 1) {							
					
					for (int m = k+1; m < room.length; m++) {		// 낙하 시작, 아래칸부터 탐색
						
						// 아래칸에 1이 있다면 반복문 아웃
						if (room[m][l] == 1) {						
							break;
						}
						
						// 원래 상자가 있던곳에서 낙하함을 표시
						room [k][l] = 0;
						room [m][l] = 1;
						
						// 낙하 거리 계산
						fall++;
					}	
				}
				
				// 최대 낙하거리 찾기
				maxFall = Math.max(maxFall, fall);
				fall = 0;
			}

		}
		
		/*
		 * 다른 아이디어 1)
		 * 자신의 아래에 있는 0의 갯수를 카운트해서 리턴하는 방법으로 maxFall계산하면 됌 => for문이 하나 줄음
		 * 배열을 Boolean으로 채움
		 */

		System.out.println(maxFall);
	} // end of main

} // end of class
