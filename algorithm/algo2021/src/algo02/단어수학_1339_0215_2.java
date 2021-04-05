package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 단어수학_1339_0215_2 {

	static int n;
	static int[] data;
	static String[] words;
	static Map<Character, Integer> alphabet;
	static boolean[] brr;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		words = new String[n];
		alphabet = new HashMap<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			for (int j = 0; j < words[i].length(); j++) {
				if (!alphabet.containsKey(words[i].charAt(j))) {
					alphabet.put(words[i].charAt(j), count++);
				}
			}
		}
		data = new int[alphabet.size()];
		brr = new boolean[10];
		solve(0, 0);
		System.out.println(max);

	}

	public static void solve(int index, int depth) {
		if (depth == data.length) {
			check();
//			System.out.println(max);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!brr[i]) {
				brr[i] = true;
				data[depth] = i;
				solve(i, depth + 1);
				brr[i] = false;
			}
		}
	}

	public static void check() {
		int ret = 0;
		for (int i = 0; i < words.length; i++) {
			int tmp = 0;
			for (int j = 0; j < words[i].length(); j++) {
				tmp += data[alphabet.get(words[i].charAt(j))];
				tmp *= 10;
			}
			ret += tmp / 10;
		}
		if (max < ret)
			max = ret;
	}

}