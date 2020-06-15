import java.util.Arrays;

/*
 * 배열활용 ETC
 */

public class Z01_Array {

	public static void main(String[] args) {
		
		int a =3;
		int b =5;
		

		// swap

//		변수를 안 선언하는 방식 
		a = a + b ;	//8
		b = a - b ;	//3
		a = a - b ;	//5
		// or XOR
		
//		변수를 선언하는 방식
//		int tmp = b;
//		b = a;
//		a = tmp;

		System.out.println(a);
		System.out.println(b);
		
		// 모듈별로 기억. 알고리즘은 수식임
		
		
		
		
		
		
		int[] arr = {3, 7, 5};
		
		// arr 최댓값 출력 (1)
		
		Arrays.sort(arr);
		System.out.println(arr[arr.length-1]);
		
		
		
		// 3개 이상의 데이터에서 최대/최소를 구하기 위해서 변수 하나 만들기 (2)
		
		int max  = Integer.MIN_VALUE;	/*
		 								 * 최대값을 저장해 놓을 변수 (지역변수는 초기값이 없음)
										 * 초기값이 중요 ! 
										 * 1. 이 세상에서 존재하는 가장 작은 값으로 초기화
										 * 2. 비교하고자 하는 원소 중의 하나의 값으로 초기화
										 */
		if ( max < arr[0]) {
			max = arr[0];
		} if ( max < arr[1]) {
			max = arr[1];
		} if ( max < arr[2]) {
			max = arr[2];
		} 
		
		for (int i = 0; i < arr.length ; i++) {
			if ( max < arr[i]) {
				max = arr[i];
			}
		}
			
		System.out.println(max);
		

		
		
		
		// 원소출력
		
		int[] brr = {1, 2, 3, 4, 5};
		
		for(int j : brr) {
			System.out.print(j+", ");
		}
		for (int i = 0; i < brr.length; i++) {
			System.out.print(brr[i]+", ");
		}
		
		System.out.println(Arrays.toString(brr));
		
		
		
		
		
		// 누적
		
		int [] crr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = 0;	// 연산자에 대한 항등원으로 넣는 것.
		for(int i = 0; i<10 ; i++)
			sum += crr[i];
		System.out.println("누적 합 : " + sum);
		
		
		
		
		
		
		
		// 존재 유무
		int [] drr = {3, 2, 1, 6, 5, 4, 7};
		int key = 7; // 1: 있다. 8: 없다.
	
		// 이 방법의 장점은 변수 하나를 덜 관리해도 됌.
		for (int i = 0; i< drr.length; i++) {
			if (drr[i] == key) {
				System.out.println("있다");
				break;
			}
			
			if (i == drr.length-1) System.out.println("없다");	// 이 코드 때문에 좀 불편해짐. for 문 들어올때마다 물어보기 때문에.
		}
			
		// 강사님 방법
		// 알고리즘 측면에서 좋음. (장점 : 빠름, 상태값을 보존해줌)
		boolean flag = false;	// 존재 유무 확인을 위한 flag 변수
		
		for (int i = 0; i< drr.length; i++) {
			if (drr[i] == key) {
				flag = true;
				break;
			}
		}
		if (flag)	{	// boolean 비교하는거 하지말기
			System.out.println("있다");
		} else {
			System.out.println("없다");
		}
		
		
		
		
		// 빈도
		int [] frr = {3, 1, 1, 2, 3, 1, 2, 1, 3, 1, 0, 0, 3 };
		// 3이 몇번 사용됐느냐 
		// ***** 가장 깔끔한 숫자정렬 방법(카운팅 정렬 알고리즘) *****
		// 우리가 알고있는 것 중에 가장 빠름!
		// 장점 : 가장 빠름, 코드 간단 
		// 단점 : 배열 필요 => 엄청 큰 숫자가 나온다면 메모리를 낭비하게 됌 => 이걸 보완한게 기수정렬
		// 		제약 조건 = 정렬할 데이터가 0이상의 정수여야함. 음수 X 
		// 상용 프로그램의 정렬은 카운팅정렬을 사용을 안함.
		
		int [] count = new int[4];
		
		for (int i = 0; i< frr.length; i++) {
				count[frr[i]]++;	// 대박 깔끔한것
		}
		
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				System.out.print(i+" ");
			}
		}
			
		int [] grr = {3, 5, 1, 9, 7, 2, 6, 4, 8};
		Arrays.sort(grr);	// 오름차순으로 정렬
		System.out.println(Arrays.toString(grr));
		
		
		
		
		
		
		
		

	} // end of main

} // end of class
