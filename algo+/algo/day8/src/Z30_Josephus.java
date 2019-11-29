import java.util.LinkedList;

public class Z30_Josephus {

	public static class Node {
		int data;
		Node link;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node head;
	public static int size = 0;

	public static void main(String[] args) {

		LinkedList<Node> n = new LinkedList<>();
		LinkedList<Integer> s = new LinkedList<>();
		for (int i = 0; i < 24; i++) {
//			if (i == 0) {
//				Node nnew = new Node(i+1);
//				nnew.link = head;
//				head = nnew;
//				n.addFirst(nnew);
//				size++;
//			} else {
//				Node newnode = new Node(i+1);
//				Node pre = n.get(i - 1);
//				pre.link = newnode;
//				n.add(newnode);
//				size++;
//			}
			s.add(i + 1);
		}
		int idx = 0;
		while (s.size() > 2) {

			s.remove(idx);
			idx += 3;
			if (idx > size) {
				break;
			}
		}
		System.out.print(s.get(0) + " " + s.get(1));

	}

}
