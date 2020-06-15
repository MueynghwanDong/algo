///*
// * t선형큐ㅣ 메모리 재활용 별가(장비()
// * ㅅ삭제연산시마다 시프트 9(성능이 떵어짐 
// * 원형큐(나머지 연산 성능떨어짐)
// * 연결큐 (안쓰는 메모른 ㅡㄴ 없지만, 다ㅇ음 링크르르 ㅟㅐ한 삽입시 마다 노드 개게를생성하ㅡ는 식나이 주어든다.*/
//public class z06_연결큐 {
//	public static class Node {
//		int data;
//		Node link;
//
//		public Node(int data) {
//			this.data = data;
//		}
//	}
//
//	public static Node front;
//	public static Node rear;
//	public static void main(String[] args){
//		Node newNode = new Node(item);
//		enQueue(6);
//		enQueue(7);
//		enQueue(6);
//		
//	}
//	public static int dequeue() {
//		int data= front.data;
//		front = front.link;
//		
//		if(isEmpty()) {
//			rear = null;
//			System.out.println("예외 처리 하는게 바람직");
//		}
//		return data;
//	}
//	public static boolean isEmpty() {
//		return front == null;
//	}
//
//
//	public static void enQueue(int itme) {
//		Node newNode = new Node(item());
//				
//	};
//
//}
