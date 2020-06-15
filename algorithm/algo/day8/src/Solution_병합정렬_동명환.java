import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution_병합정렬_동명환 {
	public static void main(String[] args) {
		Integer[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
		System.out.println(mergeSort(list));
	} // end of main

	public static List<Integer> mergeSort(List<Integer> list) {
		if (list.size() <= 1) {
			return list;
		} else {
			int m = list.size() / 2;
			List<Integer> left = mergeSort(list.subList(0, m));
			List<Integer> right = mergeSort(list.subList(m, list.size()));
			return merge(left, right);
		}

	} // end of mergeSort

	public static List<Integer> merge(List<Integer> left, List<Integer> right) {

		List<Integer> result = new ArrayList<>(left.size() + right.size());
		int lindex = 0;
		int rindex = 0;
		while (lindex < left.size() && rindex < right.size()) {

			if (left.get(lindex) < right.get(rindex))
				result.add(left.get(lindex++));
			else
				result.add(right.get(rindex++));

		}
		while (lindex < left.size()) {
			result.add(left.get(lindex++));
		}
		while (rindex < right.size()) {
			result.add(right.get(rindex++));
		}
		return result;
	} // end of merge
} // end of class
