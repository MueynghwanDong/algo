import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// 20만개  Arraylist mergesort -> 104ms => 배열로 바꾸면 더 줄어든다.
public class Z32_MergeSort {
	public static void main(String[] args) {
		 Integer[] arr = { 6, 4, 8, 5, 7, 2, 9, 3, 0, 1 };
//
//		Integer arr[] = new Integer[200000];
//		Random r = new Random();
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = r.nextInt(arr.length);
//		}

		ArrayList<Integer> ll = new ArrayList<>(Arrays.asList(arr)); // 배열의 원소를 통째로 리스트에 추가하기
		long time = System.currentTimeMillis();
		System.out.println(mergeSort(ll));
		System.out.println(System.currentTimeMillis() - time + "ms");

	} // end of main

	// 두덩어리의 리스트로 쪼개는 메서드 -> 분할
	public static List<Integer> mergeSort(List<Integer> list) {

		if (list.size() <= 1) { // 종료 파트 -> 원소가 한개 이하이면 종료
			return list;
		} else { // 재귀파트
			int m = list.size() / 2;
			List<Integer> left = mergeSort(list.subList(0, m));
			List<Integer> right = mergeSort(list.subList(m, list.size()));
			return merge(left, right);
		}
	} // end of mergeSort

	// 두덩어리의 리스트를 하나로 합치는 메서드 (합치면서 정렬작업 수행) -> 정복
	public static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<Integer>(left.size() + right.size());// 정렬해서 합친 하나의 리스트
		int l = 0; // 왼쪽 리스트 인덱스
		int r = 0; // 오른쪽 리스트 인덱스
		while (l < left.size() && r < right.size()) { // 왼쪽, 오른쪽 모두 원소가 있을 경우

			if (left.get(l) <= right.get(r)) {
				result.add(left.get(l++));
			} else {
				result.add(right.get(r++));
			}
		}
		while (l < left.size()) { // 왼쪽만 원소가 있을 경우
			result.add(left.get(l++));
		}
		while (r < right.size()) { // 오른쪽만 원소가 있을 경우
			result.add(right.get(r++));
		}
		return result;
	} // end of merge
} // end of class
