// 함수 : class 밖에 위치, c언어
// 메서드 : class 안에 위치, java언어
public class Z04_재귀함수 {
	public static void fun(int x) {
		if(x>=4) { // 종료파트
			System.out.println();
		} else { // 재귀파트
			System.out.print(x+" ");
			fun(x+1);
			
			
		}
	}
	
	public static void main(String[] args) {
		fun(0);
//		0 1 2 3
//		for (int i = 0; i < 4; i++) {
//			System.out.println(i+" ");
//		}
//		System.out.println();
//		
		
		
		
		
	}
}
