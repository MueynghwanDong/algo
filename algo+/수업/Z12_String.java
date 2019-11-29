/**
 * 문자열 String java에서는 유니코드 utf-16체계를 사용함. min - 2Byte / max - 4Byte
 * 
 * @author student
 *
 */
public class Z12_String {
	public static void main(String[] args) {
		String s1 = "hi";
		String s2 = "hi";
		String s3 = new String("hi");
		String s4 = new String("hi");
		System.out.println(s1.equals(s2));
		System.out.println(s3.equals(s4));
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		s3 = s3.intern();
		s4 = s4.intern();
		System.out.println(s3==s4);
		
		String s = "abcDefGhiJLLALLDLDLADKS";
		p("문자열 길이 : " + s.length());
		p("해당 인덱스의 글자 : " + s.charAt(3));
		p("해당 문자열의 시작 위치(좌) : " + s.indexOf("D"));
		p("해당 문자열의 시작 위치(우) : " + s.lastIndexOf("D"));
		p(" : " + s.substring(3, 6));// 이상 - 미만
		p(" : " + s.substring(3));// 끝까징
		p(" : " + s3.concat(s4));
		p(" : " + s.toLowerCase());
		p(" : " + s.toUpperCase());
		p(" : " + s.equals("ABCDEF"));
		p("대소문자 무시 : " + s.equalsIgnoreCase("abCdef"));
		p("문자열 앞뒤의 whiteSpace를 제거 : " + s.trim());
		p("문자열 교체 : " + s.replace("Def"," "));
		p("문자열 출력 : " + s);
		
		// String의 메서드는 실행 후 저장하지 않는다. 
		System.out.println(s);
		s.substring(3,6);
		System.out.println(s);
		
		// 버퍼 빌더 안쓰고 리버스 해보기
		String ss = "abcdefghij";
		String tmp = "";
		for (int i = ss.length()-1; i >= 0; i--) {
			tmp = tmp + ss.charAt(i);
		}
		System.out.println(tmp);
		
		// STRING 
//		String s5 = "";
//		for (int i = 0; i < 10; i++) {
//			s5 += "a";
//		}
		
		// String Builder	: 싱글 thread용, 알고리즘에선 빌더만 쓰세요 / 더 빠름 
		StringBuilder sb = new StringBuilder("abc");	// 3 + 16 (여유공간)
		for (int i = 0; i < 10; i++) {
			sb.append("a");	//배열을 새로 만드는 회수가 줄어듦
		}
		sb.reverse();
		System.out.println(sb);
		
		
		// String Buffer	: 멀티 thread용
//		String s6 = "akdifwjieio";
		StringBuilder sb6 = new StringBuilder(100);
		System.out.println(sb6.reverse());
//		StringBuffer sb2 = new StringBuffer();
		// String builder buffer은 변경 메서드 실행하면, 원본이 변경된ㄷ. 
		sb6.append("a").append("n");
		
		StringBuilder sb7 = new StringBuilder();
		int testCase = 1;
		sb7.append('#').append(testCase).append(" ");
		sb7.replace(1, 3, "1234");
		System.out.println(sb7);
		
	}// end of main
	
	public static void p (String str) {
		System.out.println(str);
	}
}// end of class
