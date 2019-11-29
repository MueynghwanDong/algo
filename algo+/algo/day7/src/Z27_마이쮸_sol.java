
public class Z27_마이쮸_sol {

	public static int[] q = new int[100];
	public static int f = -1;
	public static int r = -1;

	public static void main(String[] args) {
		int miZu = 20;
		int num = 1;
		int[] cnt = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, };
		while (true) {
			// 새로운 사람이 줄 선다 (큐에 넣기), num 을 증가해두기
			q[++r] = num++;
			print(num - 1 + "진입 : ");

			// 줄에서 나와서 마이쭈 받기 -> 큐에서 빼기 , 다음 받을 마이쭈 개수 증가시키기
			int temp = q[++f];
			miZu -= cnt[temp];
			print(temp + "나옴: " + cnt[temp] + "개 받음, 남은 마이쭈: " + miZu);

			if (miZu <= 0) {
				System.out.println("20번째꺼는" + temp + "가 받음");
				break;
			}
			cnt[temp]++; // 다음 받을 마이쭈 개수 증가 시킴

			// 마이쭈 받은 사람 다시 줄서기 (큐에 넣기)
			q[++r] = temp;
			print(temp + "진입 : ");

		}
	} // end of main

	public static void print(String str) {
		System.out.print(str + " [");
		for (int i = f + 1; i <= r; i++) {
			System.out.print(q[i] + " ");
		}
		System.out.println("]");
	}
}
