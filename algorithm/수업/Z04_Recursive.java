
public class Z04_Recursive {

	public static void recursive(int n) {		// static 이 없으면  non-static => 인스턴스
											// static은 static끼리 호출 가능 (미리 메모리에 선언되어있어서)
		if( n == 4 ) {	// finish
			return;
		}
		else {			// basis roll
			System.out.println(n + " ");
			recursive(n+1);
		}
		
	}
	
	public static void main(String[] args) {
		
		recursive(0);
		
		for (int i = 0; i < 4; i++) {
			System.out.print(i + " ");
		}
	}

}
