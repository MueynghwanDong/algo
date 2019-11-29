
public class Z34_진수 {
	
	public static void main(String[] args) {
		
		int binary = 0b100110111;

		System.out.println(binary);

		// num을 x진법으로 표현하는 방법을 구현해보기
		int num = 311;
		int x = 2;
		String s = ""; // x 진법으로 변환한 문자를 저장

		while (num > 0) {
			s = num % x + s; // 마지막에 구한 문자가 msb 되도록
			num /= x;
		}
		
		System.out.println(s + " (" + x +"진수)");
		
		// num을 x진법으로 표현하는 방법을 구해보기2
		num = 311;
		s = "";
		s = Integer.toString(num, x);
		 
		System.out.println(s + " ("+x+"진수)");

		String str = "0F97A3";
		
		
	}
}
