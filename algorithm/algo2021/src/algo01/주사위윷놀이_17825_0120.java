package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위윷놀이_17825_0120 {

	static int[] dice, order;
	static int ans = 0;
	static Node[] horse;
	static Node start; // 시작지점

	static class Node {
		int score;
		boolean isEmpty;
		boolean isFinish;
		Node next;
		Node fastPath;

		public Node(int score) {
			this.score = score;
			this.isEmpty = true;
		}

		public Node addNext(int score) {
			Node nextNode = new Node(score);
			this.next = nextNode;
			return nextNode;
		}

		public static Node getNode(Node start, int target) {
			Node temp = start;
			while (true) {
				if (temp == null)
					return null;
				if (temp.score == target)
					return temp;
				temp = temp.next;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dice = new int[11];
		order = new int[11];
		horse = new Node[5];
		for (int i = 1; i <= 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		init();
		perm(1);
		System.out.println(ans);
	}

	public static void perm(int depth) {
		if (depth >= 11) {
			ans = Math.max(ans, game());
			return;
		}
		for (int i = 1; i <= 4; i++) {
			order[depth] = i;
			perm(depth + 1);
		}
	}

	public static int game() {
		Arrays.fill(horse, start);
		
		int score = 0;
		for (int i = 1; i <= 10; i++) {
			Node cur = horse[order[i]];
			cur.isEmpty = true;
			for (int j = 1; j <= dice[i]; j++) {
				if (j == 1 && cur.fastPath != null) {
					cur = cur.fastPath;
				} else {
					cur = cur.next;
				}
			}
			horse[order[i]] = cur; // 이동후 말 위치
			if (!cur.isEmpty && !cur.isFinish) {
				score = 0;
				break;
			} else {
				cur.isEmpty = false;
				score += cur.score;
			}
		}
		for (int i = 1; i <= 4; i++) {
			horse[i].isEmpty = true;
		}
		return score;
	}

	public static void init() {
		start = new Node(0);
		Node temp = start;
		for (int i = 2; i <= 40; i += 2) {
			temp = temp.addNext(i);
		}
		Node end = temp.addNext(0);
		end.isFinish = true;
		end.next = end;

		Node cross = new Node(25);

		temp = cross.addNext(30);
		temp = temp.addNext(35);
		temp.next = Node.getNode(start, 40);

		temp = Node.getNode(start, 10);
		temp = temp.fastPath = new Node(13);
		temp = temp.addNext(16);
		temp = temp.addNext(19);
		temp.next = cross;

		temp = Node.getNode(start, 20);
		temp = temp.fastPath = new Node(22);
		temp = temp.addNext(24);
		temp.next = cross;

		temp = Node.getNode(start, 30);
		temp = temp.fastPath = new Node(28);
		temp = temp.addNext(27);
		temp = temp.addNext(26);
		temp.next = cross;
	}
}
