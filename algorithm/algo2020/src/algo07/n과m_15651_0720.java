package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 초과 때문에 System.out.println() 대신 StringBuilder 사용!!
public class n과m_15651_0720 {

	static int n;
	static int m;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		sb = new StringBuilder();
		perm(0);
		System.out.println(sb.toString());
	}

	public static void perm(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			arr[k] = i;
			perm(k + 1);
		}
	}

}
