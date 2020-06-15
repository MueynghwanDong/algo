/**
 * 문자열 String - 자바는 유니코드 utf-16 체계를 사용함. min - 2byte ~ max - 4byte
 * 
 */
public class Z12_String {
	public static void main(String[] args) {
		String s1 = "hi"; // constant pool에 생성
		String s2 = "hi";
		String s3 = new String("hi");
		String s4 = new String("hi");
		System.out.println(s1.equals(s2)); // 내용물 비교
		System.out.println(s1 == s2); // 주소 비교
		System.out.println(s3 == s4);
		s3 = s3.intern(); // constant pool 영역으로 넣기
		s4 = s4.intern(); // constant pool 영역으로 넣기 -> 재활용 하기에 같은 값이 된다.....
		System.out.println(s1 == s2); // 주소 비교
		System.out.println(s3 == s4);

		String s = "abcDefGHiJ";
		p("문자열 길이: " + s.length());
		p("해당 인덱스 글자: " + s.charAt(3));
		p("해당 문자열의 시작 위치  : " + s.indexOf("efG"));
		p("해당 문자열의 시작 위치(우측 부터 검색)  : " + s.lastIndexOf("efG"));
		p("부분문자열 추출 :" + s.substring(3, 6));
		p("부분문자열 (끝까지):" + s.substring(3));
		// "a".concat("b") // 문자열 연결
		p("소문자로 변환 : " + s.toLowerCase());
		p("대문자로 변환 : " + s.toUpperCase());
		p("내용물 비교 : " + s.equals("abcdefghij"));
		p("내용물 비교 : " + s.equalsIgnoreCase("abcdefghij")); // 대소문자 무시
		p("문자열 앞뒤의 whiteSpace를 제거 : " + s.trim());
		p("문자열 교체 : " + s.replace("Def", "XXXXXXXX")); // 제거시 빈문자를 넣어서 활용하는 방법이 있다.
		p("문자열 출력 : " + s.toString());
		p("문자열 출력 : " + s);

		// String의 메서드는 실행후 저장하지 않는다.
		System.out.println(s);
		s = s.substring(3, 6);
		System.out.println(s);

		// String
		String ss = "abcdefghij";
		System.out.println(ss);
		for (int i = ss.length() - 1; i >= 0; i--) {
			System.out.print(ss.charAt(i));
		}
		System.out.println();
		String str = "";
		for (int i = 0; i < ss.length(); i++) {
			str = ss.charAt(i) + str;
		}
		System.out.println(str);

		// String
		String s5 = "";
		for (int i = 0; i < 10; i++) {
			s5 += "a"; // 배열을 새로 만들어서 저장 때문에 오래걸림
			// s5.concat("a");
		}
		System.out.println(s5);
		// String Builder : 단일 thread 용,
		// Stirng Buffer : 멀티 thread 용, synchronized 처리가 되어있다.
		// -> 동기화 처리 부분만 다르고 나머지는 두 클래스가 유사하다..
		// 덧셈연산에서는 string 보다는 좋은 수행능력을 준다.
		StringBuilder sb = new StringBuilder("abc"); // abc + (여유 공간)16 -> 가득 차면 2배 늘려주는 작업을 수행하지만 스트링보다 빠른 작업이다.
		for (int i = 0; i < 10; i++) {
			sb.append("a"); // 배열을 새로 만드는 횟수가 줄어듦.
		}
		sb.reverse(); // 역순
		System.out.println(sb.toString());

		String s6 = "abcdefghij";
		StringBuilder sb6 = new StringBuilder(s6);// 문자열String -> StringBuilder
		sb6.reverse();
		System.out.println(sb6.toString()); // stringbuilder=> string
		// StringBuilder, StringBuffer는 변경 메서드 실행하면, 직접 원본이 변경되 저장된다.
		sb6.append("a").append("b").append("c"); // 리턴 타입이 StringBuilder
		// StringBuffer sb2;

		StringBuilder sb7 = new StringBuilder();
		int testCase = 1;
		sb7.append('#').append(testCase).append(' ');
		System.out.println(sb7);

		// StringBuilder sb3 = new StringBuilder(100); // capacity 지정

	}// end of main

	public static void p(String str) {
		System.out.println(str);
	}
} // end of class