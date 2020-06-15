import java.util.Arrays;

//배열활용
public class Z01_Array {
	public static void main(String[] args) {
		
		int a = 3;
		int b = 5;
		//swap
//		int temp = a;
//		a = b;
//		b = temp;
		
		
		System.out.println(a);
		System.out.println(b);
		
		int[] arr = {3, 7, 5};
//		최대값을출력 : 3개 이상의 데이터의 최대/최소를 구할 경우 변수를 하나 만들자
		int max=0; // 최대값을 저장해 놓을 변수(지역변수 - 초기값이 없음)
		// 1.이 세상에서 존재하는 가장 작은 값으로 초기화, 초기값 중요
		// int max = arr[0];
		// 2.비교하고자하는 원소중의 하나의 값으로 초기화, 초기값 중요
		// int max = Integer.MIN_VALUE;
		
		if(max < arr[0]) max =arr[0];
		if(max < arr[1]) max =arr[1];
		if(max < arr[2]) max =arr[2];
		
		System.out.println(max);
//		int max = Integer.MIN_VALUE;
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i]>max) {
//				max = arr[i];
//			}
//		}
		
		//원소출력
		int[] brr= {1,2,3,4,5};
		for (int i = 0; i < brr.length; i++) {
			System.out.print(brr[i]+", ");
		}
		System.out.println(Arrays.toString(brr));
		
		int [] crr = {1,2,3,4,5,6,7,8,9,10};
		//누적 출력
		int sum = 0; // 초기값, 연산자에 대한 항등원		
		
		for (int i = 0; i < crr.length; i++) {
			sum += crr[i];
		}
		System.out.println("누적합: "+sum);
		
		//존재유무
		int[] drr = {3,2,1,6,5,4,7};
		int key =1; //1:있다 8:없다
		
		for (int i = 0; i < drr.length; i++) {
			if(key ==drr[i]) {
				System.out.println("있따");
				break;
			}
			if(i == drr.length-1) {
				System.out.println("없다");
			}
		}
		//아래것이 더 효율적이다 하지만 관리해야할 변수가 하나더 생긴다.(아래추천)
		
//		boolean check = false; //flag 변수
//		for (int i = 0; i < drr.length; i++) {
//			if(drr[i] == key) {
//				check=true;
//				break;
//			}
//		}
//		if(check) {
//			System.out.println("있다");
//		} else {
//			System.out.println("없다");
//		}
		
		//빈도
		int [] frr = {3,1,1,2,3,1,2,1,3,1,0,0,3}; //0~3
		// 3이 몇회 나왔는가?
//		int count = 0; // 횟수를 누적할 변수
		int [] cnt = new int[4];
		for (int i = 0; i < frr.length; i++) {
			cnt[frr[i]]++;
		}
		Arrays.sort(cnt);
		System.out.println(Arrays.toString(cnt));
//		for (int i = 0; i < cnt.length; i++) {
//			for (int j = 0; j < cnt[i]; j++) {
//				System.out.print(i+" ");
//			}
//		}
		//카운팅 정렬 : 장점:가장빠름, 코드간단
		//   		단점 : 메모리를 낭비, 정렬할 데이터가 0 or 양의정수 이어야함
		System.out.println();
		
		
		int[] grr = {3,5,1,9,7,2,6,4,8}; //이걸로 쓰고 시간이부족하다면 위에껄 활용
		Arrays.sort(grr); //오름차순으로 정렬
		System.out.println(Arrays.toString(grr));
				
		
		
		
		
		
	}
}
