import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
	// 테스트케이스 개수\
		// 0011 => 문자열 String 으로 취급
		Scanner sc = new Scanner(System.in); //사용자의 키보드 입력을 받아올수 있는 객체 준비
		int TC = sc.nextInt(); //테스트 케이스의 개수
		for (int testCase = 1; testCase <= TC; testCase++) {
			String str = sc.next(); // "0011"
			
			int cnt =0;	// 변경횟수
			char c= '0'; // 초기 비교할 글자
//			System.out.println(str.length()); // 문자열의 전체 글자수
//			System.out.println(str.charAt(2)); // 2번째 인덱스의 문자
			for (int i = 0; i < str.length(); i++) {
				if (c!= str.charAt(i)) {
					cnt++;
					c = str.charAt(i);
				}
			}
			System.out.println("#"+testCase+" "+cnt);
		} // end of for testCase
	}
}
	
		
		
		
//		System.out.println("나이를 입력하세요");
////		int age = sc.nextInt();
//		int age = Integer.valueOf(sc.nextLine());
//		System.out.println(age);
//		System.out.println("당신의 나이는 "+age+"살입니다.");
//		//sc.nextLine() 으로 엔터를 날려버릴수 있음
//		System.out.println("이름을 입력하세요");
//		String name = sc.nextLine(); //엔터가 입력될때까지의 한줄을 받아옴, 엔터는 소비시켜 버림
//		System.out.println("당신의 이름은 " + name);
//		
//		
//		//nextLine() 메서드와 next기본형() 계열의 메서드를 혼용해서 사용하면 문제발생할 수 있다.
//		String ss = "123";
//		int a = Integer.valueOf(ss); // 문자열 String =>정수 int형으로 파싱해주는 메서드 
//		
//		System.out.println("프로그램종료====");
		
		
	//	int TC = 
		

// next, nextInt, nextLong, nextDouble
// white space 공백, 엔터, 탭 날리고 뒤에 값만 받음
// nextLine() : abc 3.14 5 통째로 다받아감 엔터전까지, 받고 엔터 날림