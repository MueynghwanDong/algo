package algo0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Easy2048 {

	static int n;
	static int[][] arr;
	static int Max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		Max = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력

		dfs(0);
		System.out.println(Max);
	}

	public static void dfs(int count) {

		int[][] tempMap = new int[n][n];
		copy(tempMap, arr);

		if (count == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > Max)
						Max = arr[i][j];
				}
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			merge2(i);
			dfs(count + 1);
			copy(arr, tempMap);
		}
	}

	public static void copy(int[][] arr, int[][] arr2) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = arr2[i][j];
			}
		}

	}

	public static void merge2(int d) {
		Queue<Integer> q = new LinkedList<>();
		int[][] newMap = new int[n][n];

		if (d == 0) {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (arr[y][x] != 0) {
						q.add(arr[y][x]);
					}
				}
				int idx = 0;
				while (!q.isEmpty()) {
					int value = q.peek();
					if (newMap[idx][x] == 0) {
						newMap[idx][x] = q.poll();
					} else if (newMap[idx][x] == value) {
						newMap[idx][x] += q.poll();
						idx += 1;

					} else { // 0도 아니고 같지도 않을떄
						idx += 1;
						newMap[idx][x] = q.poll();
					}
				}
			}
		}
		if (d == 1) {

			for (int x = 0; x < n; x++) {
				for (int y = n - 1; y >= 0; y--) {
					if (arr[y][x] != 0) {
						q.add(arr[y][x]);
					}
				}
				int idx = n - 1;
				while (!q.isEmpty()) {
					int value = q.peek();
					if (newMap[idx][x] == 0) {
						newMap[idx][x] = q.poll();

					} else if (newMap[idx][x] == value) { // 머징
						newMap[idx][x] += q.poll();
						idx -= 1;

					} else { // 0도 아니고 같지도 않을떄
						idx -= 1;
						newMap[idx][x] = q.poll();
					}
				}
			}
		}
		if (d == 2) {
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (arr[y][x] != 0) {
						q.add(arr[y][x]);
					}
				}
				int idx = 0;
				while (!q.isEmpty()) {
					int value = q.peek();
					if (newMap[y][idx] == 0) {
						newMap[y][idx] = q.poll();

					} else if (newMap[y][idx] == value) { // 머징
						newMap[y][idx] += q.poll();
						idx += 1;

					} else { // 0도 아니고 같지도 않을떄
						idx += 1;
						newMap[y][idx] = q.poll();
					}
				}

			}
		}
		if (d == 3) {
			for (int y = 0; y < n; y++) {
				for (int x = n - 1; x >= 0; x--) {
					if (arr[y][x] != 0) {
						q.add(arr[y][x]);
					}
				}
				int idx = n - 1;
				while (!q.isEmpty()) {
					int value = q.peek();
					if (newMap[y][idx] == 0) {
						newMap[y][idx] = q.poll();

					} else if (newMap[y][idx] == value) {
						newMap[y][idx] += q.poll();
						idx -= 1;

					} else { // 0도 아니고 같지도 않을떄
						idx -= 1;
						newMap[y][idx] = q.poll();
					}
				}
			}
		}
		copy(arr, newMap);
	}

	public static void merge(int direction) {
		int[][] nmap = new int[n][n];
		copy(nmap, arr);

		if (direction == 0) {
			for (int i = 0; i < n; i++) {
				int idx = 0;
				int value = nmap[idx][i];
				for (int j = 1; j < n; j++) {
					if (value == nmap[j][i]) {
						value = value * 2;
						nmap[idx][i] = value;
						nmap[j][i] = 0;
						idx++;
					} else {
						if (nmap[j][i] != 0) {
							idx++;
						}else {
							int k = 0;
							for (k = j; k < n; k++) {
								if (nmap[k][i] != 0) {
									nmap[j][i] = nmap[k][i];
									nmap[k][i] = 0;
									break;
								}
							}
						}
					}
				}
				
			}
		} else if (direction == 1) {
			int idx = 0;
			for (int i = 0; i < n; i++) {
				idx = n - 1;
				int value = nmap[idx][i];
				for (int j = n - 2; j >= 0; j--) {
					if (value == nmap[j][i]) {
						value = value * 2;
						nmap[idx][i] = value;
						nmap[j][i] = 0;
						idx--;
					} else {
						if (nmap[j][i] != 0) {
							idx--;
						}else {
							int k = 0;
							for (k = j; k >= 0; k--) {
								if (nmap[k][i] != 0) {
									nmap[j][i] = nmap[k][i];
									nmap[k][i] = 0;
									break;
								}
							}
						}
					}
				}
				
			}
		} else if (direction == 2) {
			int idx = 0;
			for (int i = 0; i < n; i++) {
				idx = n - 1;
				int value = nmap[i][idx];
				for (int j = n - 2; j >= 0; j--) {
					if (value == nmap[i][j]) {
						value = value * 2;
						nmap[i][idx] = value;
						nmap[i][j] = 0;
						idx--;
					} else {
						if (nmap[i][j] != 0) {
							idx--;
						}else if(nmap[i][j] == 0){
							int k = 0;
							for (k = j; k >= 0; k--) {
								if (nmap[i][k] != 0) {
									nmap[i][j] = nmap[i][k];
									nmap[i][k] = 0;
									break;
								}
							}
						}
					}
				}				
			}

		} else {
			int idx = 0;
			for (int i = 0; i < n; i++) {
				idx = 0;
				int value = nmap[i][idx];
				for (int j = 1; j < n; j++) {
					if (value == nmap[i][j]) {
						value = value * 2;
						nmap[i][idx] = value;
						nmap[i][j] = 0;
						idx++;
					} else {
						if (nmap[i][j] != 0) {
							idx++;
						} else if (nmap[i][j] == 0) {
							int k = 0;
							for (k = j; k < n; k++) {
								if (nmap[i][k] != 0) {
									nmap[i][j] = nmap[i][k];
									nmap[i][k] = 0;
									break;
								}
							}
						}
					}
				}
			}
		}
		copy(arr, nmap);

	}
}
