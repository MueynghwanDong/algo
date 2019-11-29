
public class Permutaion { // 순열
	public static void main(String[] args) {
		// 순열 - 재귀함수의 필요성
		int [] b = {2,4,7};
		int num=1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i==j) continue;
				for (int k = 0; k < 3; k++) {
					if(i == k || j == k) continue;
					System.out.println(b[i]+", "+b[j]+", "+b[k]);
				}
			}
		}
	
	}
}
