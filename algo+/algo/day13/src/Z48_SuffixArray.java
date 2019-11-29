import java.util.Arrays;

/*
 * 특정 문자열읠 모든 부분 문자열을 알고 싶을 때
 * 
 * 트라이 Trie : 문자열의 집합을 표현하는 트리
 * Compressed Trie : 문자열의 접미사 트라이의 압축된 표현
 * 접미어 트리(Suffix Tree_) : Compress trie의 개선된 표현, 문자열 끝에 $ 표시함.
 * 		생성 시간 복잡도 O[n^2] => o[N long n] => O[n]
 * 접미어 배열 (Suffix Array) : 접미어들을 사전식으로 나열한 배열
 * 		메모리 절약 1/4 (접미어 트리에 비해서), 속도가 느리다. 접미어 트리보다 간단하다
 * 		생성시간 복잡도  O[n log n] (정렬을 해야하기 때문에)
 * LCP 배열 : 최장공통접두어 (Longest Common Prefix), 접미어 배열 사용시 보조적으로 사용
 * 		두 문자열 사이 공통 접두어 길이 
 */
/*
 * 1. 모든 접미사를 만들자! -> 2. 접미사를 정렬 -> LCP를 구해놓기 -> 각 접미사의 모든 접두사를 구하기 -> 유효한 문자열의 갯수  
 * -- 각 문자를 저장하지 말고 시작 인덱스를 sa 배열에 저장하기..
 * -- 정렬된 상태의 인덱스 값을 저장..
 * -- LCP -> 이전값과 비교해 같은 값을 저장..
 * -- 접두사의 갯수는 접두사의 글자 길이, 중복 제거로 제거된 갯수는 lcp
 */
/*
 ex) banana
 모든 접미사  	정렬			lcp 	유효한 부분 문자열 		모든 접두사를 구하기.. -> 모든 접두사 값도 정렬된 형태가 됨..  
 6 a		6 a			0		1 (1-0)				-> 중복된은 값은 제거해주기 
 5 na		4 ana		1		2 (3-1)				접두사의 갯수는 접두사의 글자 길이
 4 ana		2 anana		3		2 (5-2) 			중복 제거로 제거된 갯수는 lcp
 3 nana		1 banana	0		6 (6-0)
 2 anana	5 na		0		2 (2-0)
 1 banana	3 nana		2		2 (4-2)
 */
public class Z48_SuffixArray {
	public static void main(String[] args) {
		String s = "banana";

		// s 문자열의 모든 접미사를 생성
		int[] as = new int[s.length()]; // Suffix Array : 접미사의 시작하0는 index를 저장
		for (int i = 0; i < as.length; i++) {
			as[i] = i;
		}
		// 모든 접미사의 정렬 => 선택정렬 ( O[n^2]) => 퀵정렬 등 성능 좋은 정렬으로 개선 가능
		for (int i = 0; i < as.length; i++) { // 선택 정렬
			int minindex = i;
			for (int j = i + 1; j < as.length; j++) {
				if (s.substring(as[minindex]).compareTo(s.substring(as[j])) > 0) {
					minindex = j;
				}
			}
			// i<->minindex swap
			int temp = as[minindex];
			as[minindex] = as[i];
			as[i] = temp;
		}
		// 정렬된 접미사의 lcp를 구함.
		int[] lcp = new int[s.length()]; // 최정 공통 접두어
		for (int i = 1; i < lcp.length; i++) {
			//String s1 = s.substring(as[i - 1]);
			//String s2 = s.substring(as[i]);
			int len1 = s.length() - as[i-1];
			int len2 = s.length() - as[i];
			while (len1 > lcp[i] && len2 > lcp[i] && s.substring(as[i-1]).charAt(lcp[i]) == s.substring(as[i]).charAt(lcp[i])) {
				lcp[i]++;
			}
		}
		System.out.println(Arrays.toString(lcp) + " : LCP");
		// 모든 접미사의 접두사를 생성
		for (int i = 0; i < as.length; i++) {
			// String str = s.substring(as[i]);
			// System.out.println("<<" + str + ">>");
			int len = s.length() - as[i];
			// 각 접미사로 만들 수 있는 모든 접두사
			for (int j = 0; j <= len; j++) {
				System.out.println(s.substring(as[i], as[i] + j));
				// System.out.println(str.substring(0, j));
			}
			System.out.println(len + " : 접두사의 갯수");
			System.out.println(lcp[i] + " : 최장공통접두사의 개수");
			System.out.println((len - lcp[i]) + " : 유효한 부분문자열의 갯수");
		}
		// s 문자열에서 만들수 있는 모든 부분문자열에서 사전식으로 정렬한 상태의 k 번째 문자열

		int k = 13;
		for (int i = 0; i < as.length; i++) {
			// String str = s.substring(as[i]); // 접미사 임시저장 < - 저장하지 않도록 수정하기
			// int len = s.substring(as[i]).length();
			int len = s.length() - as[i];
			if (k - (len - lcp[i]) > 0) {
				k = k - (len - lcp[i]);
			} else {
				System.out.println(s.substring(as[i], as[i] + lcp[i] + k));
				// System.out.println(s.substring(as[i]).substring(0, lcp[i] + k));
				break;
			}

		}

	} // end of main
} // end of class
