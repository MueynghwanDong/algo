package day10;

public class Z35_진수_연습문제2 {

	public static void main(String[] args) {
		String[] binString = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
				"1011", "1100", "1101", "1110", "1111" };

		String s = "0F97A3";
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('0' <= c && c <= '9') {
				result += binString[c - '0'];
			} else {
				result += binString[c - 'A' + 10];
			}
		}
		System.out.println(result);
		int value = 0;
		for (int i = 0; i < result.length(); i++) {
			// value에 값을 누적 = 이전까지 구한 값 *2 + 새로 가져온 값
			value = value * 2 + (result.charAt(i) - '0');
			// 7비트가 모여진 순간 출력, value 초기화
			if (i % 7 == 6) {
				System.out.print(value + ",");
				value = 0;
			}
		}
		System.out.println(value);

//		String num = "01D06079861D79F99F";
//		String a = " "; 
//		for (int i = 0; i < num.length(); i++) {
//			String hex = Integer.toHexString(num.charAt(i)-'0');
//			if(Character.isDigit(num.charAt(i))) {
//				a = a +" " +Integer.toHexString(num.charAt(i)-'0');
//			}else {
//				a = a + " "+ Integer.toHexString(num.charAt(i)-'1');
//			}
//			Integer.valueOf(a);
//		}
//		System.out.print(a);
	}
}
