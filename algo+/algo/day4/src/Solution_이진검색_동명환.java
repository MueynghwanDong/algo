public class Solution_이진검색_동명환 {

	static int key = 8;
	static int key2 = 20;
	static int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void binarysearch(int start, int end, int n) {
		int left = start;
		int mid = (start + end) / 2;
		int right = end;
		if (left > right) {
			System.out.println("존재하지 않음");
		} else {
			if (a[mid] == n) {
				System.out.println("존재");
			} else {
				if (a[mid] < n) {
					left = mid + 1;
					binarysearch(left, right, n);
				} else if (a[mid] > n) {
					right = mid - 1;
					binarysearch(left, right, n);
				}
			}
		}
	}

	public static void whilebinary(int num) {
		// 반복문
		int first = 0;
		int last = a.length - 1;
		int check = 0;

		while (first <= last) {
			int mid = (first + last) / 2;
			if (a[mid] == num) {
				System.out.println("존재");
				check = 1;
				break;
			} else {
				if (a[mid] > num) {
					last = mid - 1;
				} else if (a[mid] < num) {
					first = mid + 1;
				}
			}
		}
		if (check == 0) {
			System.out.println("존재 하지 않음");
		}
	}

	public static void main(String[] args) {

		binarysearch(0, a.length - 1, key);
		binarysearch(0, a.length - 1, key2);

		whilebinary(key);
		whilebinary(key2);
	}
}