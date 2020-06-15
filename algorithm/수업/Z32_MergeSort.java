import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Z32_MergeSort {

	public static void main(String[] args) {
		Integer[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		long time = System.currentTimeMillis();
		
		ArrayList<Integer> ll = new ArrayList<>(Arrays.asList(arr));
		System.out.println(mergeSort(ll));
		System.out.println(System.currentTimeMillis() - time + "ms");
		//System.out.println(ll);
	}
	
	/* 두 덩어리의 리스트로 쪼개는 메서드 */
	public static List<Integer> mergeSort(List<Integer> ll) {
		if (ll.size() <= 1) {
			return ll;
		} else {
			int m = ll.size()/2;
			List<Integer> left = mergeSort(ll.subList(0, m));// 이렇게 쓰면 원본도 같이 수정 됌.
			List<Integer> right = mergeSort(ll.subList(m, ll.size()));
			
			return merge(left, right);
		}
	}
	
	/* 두 덩어리의 리스트를 하나로 합치는 메서드 (합치면서 정렬작업함) */
	public static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<>(left.size()+right.size());// 정렬해서 합친 하나의 리스트
		int l = 0;	// 왼쪽 리스트 인덱스
		int r = 0; 	// 오른쪽 리스트 인덱스
		
		while (l<left.size() && r<right.size()) {	// 왼쪽, 오른쪽 모두 원소가 있을 경우
			if (left.get(l) < right.get(r)) {
				result.add(left.get(l++));
			} else {
				result.add(right.get(r++));
			}
		} 
		while (l<left.size()) {
			result.add(left.get(l++));
		}
		while (r<right.size()) {
			result.add(right.get(r++));
		}
		return result;
	}

}
