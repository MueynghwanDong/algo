package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 퍼즐_1525_0328 {

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Integer> q;
	static HashMap<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int s = 0;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 0)
					temp = 9;
				s = (s * 10) + temp;
			}
		}
		q = new LinkedList<>();
		map = new HashMap<>();

		q.add(s);
		map.put(s, 0);
		System.out.println(bfs());
	}

	public static int bfs() {
		while (!q.isEmpty()) {
			int cur = q.poll();
			String cstr = String.valueOf(cur);

			if (cstr.equals("123456789")) {
				return map.get(cur);
			}
			int nine = cstr.indexOf('9'); // 9의 현재 좌표
			int r = nine / 3;
			int c = nine % 3;

			for (int i = 0; i < dirs.length; i++) {
				int nx = r + dirs[i][0];
				int ny = c + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3)
					continue;
				StringBuilder next = new StringBuilder(cstr);

				// 이전 9의 위치와 다음 위치 숫자를 바꿈
				char t = next.charAt(nx * 3 + ny);
				next.setCharAt(nx * 3 + ny, '9');
				next.setCharAt(nine, t);

				int nint = Integer.parseInt(next.toString());

				// 맵에 없는 경우 맵에 추가 - 나온적 없는 퍼즐 상태
				if (!map.containsKey(nint)) {
					map.put(nint, map.get(cur) + 1);
					q.add(nint);
				}

			}
		}
		return -1;
	}
}
