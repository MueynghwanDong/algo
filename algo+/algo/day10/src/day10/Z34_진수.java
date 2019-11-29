package day10;

public class Z34_진수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int binary = 0b100110111; 
		System.out.println(binary);		
		// 저장한 2진수의 값을 10진수로 출력		
		
		int num = 311;
		int x = 2;
		String s = ""; // x 진법으로 변환한 문자를 저장
	
		while(num>0) {
			s = num%x + s;
			num  = num/x;
		}
		System.out.println(s);
		
		num =311;
		s = Integer.toBinaryString(num);
		System.out.println(s);
	}

}
