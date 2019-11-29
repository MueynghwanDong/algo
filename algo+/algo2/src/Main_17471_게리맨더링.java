import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	private static int n;
	private static int[] arr;
	private static int[][] map;
	private static boolean[] brr;
	private static int min; // 인구수 차이 

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1]; // 구역 별 인구수
		map = new int[n + 1][n + 1];
		brr = new boolean[n + 1]; //연결 가능한 지 확인하기
		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= num; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][temp] = 1;
				map[temp][i] = 1;
			}
		}
		brr[1] = true;
		fun(1, 1, 1); // 연결된 구역 수 , 시작 값 , 현재 연결된 위치
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);

	}

	private static boolean check(int cnt) {
		System.out.println(Arrays.toString(brr));
		Set<Integer> s = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			if (!brr[i]) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == 1 && !brr[j]) {
						System.out.println("서로 연결됨" + i + " " + j);
						s.add(i);
						s.add(j);
					}
				}
			}
		}
		Object[] temp = s.toArray();
		int[] temp2 = new int[s.size()];
		for (int i = 0; i < temp.length; i++) {
			temp2[i] = Integer.parseInt(String.valueOf(temp[i]));
		}
		boolean [] visited = new boolean[s.size()];
		for (int i = 0; i < temp2.length; i++) {
		int t = temp2[i];
			for (int j = 0; j < temp2.length; j++) {
				if (i!=j && map[t][temp2[j]] == 1 && visited[j]) {
					visited[i] = true;
				}
			}
		}
		for (int i = 0; i < visited.length; i++) {
			System.out.println(Arrays.toString(visited));
		}
		
		System.out.println(s.size() + " " + (n - cnt));
		if (s.size() == n - cnt) {
			return true;
		} else {
			return false;
		}

	}

	private static void fun(int cnt, int s, int current) {
		if (cnt >= 1 && cnt <= n - 2) {
			// 계산 하기 - 나머지들 모두 연결되어있는지 / 모두 연결되어있으면 인구수 계산하기
			boolean c = check(cnt); // 남은것들끼리 연결한 것의 개수
			if (c) { // 연결된 남은 것들의 수 = 전체 - 연결된 것
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 1; i <= n; i++) {
					if (brr[i]) {
						sum1 += arr[i];
					} else {
						sum2 += arr[i];
					}
				}
				int result = Math.abs(sum1 - sum2);
				if (min > result) {
					min = result;
				}
			}
			// 추가 연결
			for (int i = 1; i <= n; i++) {
				if (map[current][i] == 1 && !brr[i]) {
					System.out.println("추가2. " + current + " " + i + " 연결됨" + cnt);
					brr[i] = true;
					fun(cnt + 1, s, i);
					brr[i] = false;
				}
			}
		} else if (cnt > n - 2) {
			System.out.println("아웃됨");
			return; // 너무 많이 들어옴
		}
	}
}