/**
 * 단순 연결 리스트
 */

public class Z29_SinglyLinkedList {

	public static class Node {
		int data;
		Node link;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node head; // 첫번째 노드
	public static int size; // 노드 개수

	public static void main(String[] args) {

		
	} // end of main

	// 해당 inedex 위치의 노드를 삭제
	public static void delete(int index) {

		if (index < 0 || index >= size) {
			System.out.println("범위 벗어남 오류");
			return;

		}
		Node pre = head; // 한칸 전 노드정보를 저장할 변수
		for (int i = 0; i < index - 1; i++) {
			pre = pre.link;
		}
		Node delNode = pre.link; // 삭제할 위치의 노드
		Node next = delNode.link; // 다음 노드
		pre.link = next;
		size--;

	}
	// 첫번째 노드로 삽입하는 메서드

	public static void addtoFirst(int item) {
		Node newNode = new Node(item);
		newNode.link = head;
		head = newNode;
		size++;
	}

	// 인덱스 위치에 노드를 삽입하는 메서드
	public static void add(int index, int item) {
		if (index == 0) {
			addtoFirst(item);
			return;
		}
		Node newNode = new Node(item);
		// 이전칸의 노드 정보
		Node pre = head;
		for (int i = 0; i < index - 1; i++) {
			pre = pre.link;
		}

		// 다음칸의 노드 정보
		Node next = pre.link;
		pre.link = newNode;
		newNode.link = next;
		size++;
	}

	// 마지막 노드로 삽입
	public static void addtoLast(int item) {

		Node newNode = new Node(item);
		if (size == 0) {
			head = newNode;
			size++;
			return;
		}
		Node n = head;
		while (n.link != null) {
			n = n.link;
		}
		n.link = newNode;
		size++;
	}

} // end of class
