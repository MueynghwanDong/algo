import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 트리: 비선형 자료구조 (그래프 일부) 1. 저장 2. 순회 (dfs, bfs, 전,중,후 위) 문제에서 상세히 설명해줘야 하는 사항
 * 이진트리/완전/포화/ 루트노드번호, 트리의 크기(높이, 레벨, 최대 정점 개수, 정점번호) *
 */

// 1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
public class Z33_연습문제2_트리순회 {
	public static int[] tree = new int[32]; // 0번 정점은 안씀

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine()); // 입력될 정점쌍 갯수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(); // 키 - 정점범호 값 - 트리배열에 저장한 index
		hash.put(1, 1); // 루트 정점 위치 저장
		tree[1] = 1; // 루트 정점 지정
		while (st.hasMoreTokens()) { // 정점쌍이 13개,
			int p = Integer.parseInt(st.nextToken()); // 간선의 시작점 부모
			int c = Integer.parseInt(st.nextToken()); // 간선의 끝점 자식
			// int i ;
			// p 부모정점이 tree 배열에 존재하는지 검색 , 정렬이 안된 순차검색
//			for (i = 0; i < tree.length; i++) {
//				if (p == tree[i]) { // 위치 찾기, 순차 검색
//					break;
//				}
//			}
			int i = hash.get(p);// 정점 p의 위치

			// 검색한 index에 c 정점을 자식으로 저장, 왼쪽자식이 없으면 왼쪽자식으로 저장, 왼쪽 자식이 있으면 오른쪽 자식으로 저장
			if (tree[i * 2] == 0) { // 왼쪽 자식이 없으면, 왼쪽 자식으로 등록
				tree[i * 2] = c;
				hash.put(c, i * 2);
			} else {// 왼쪽 자식이 있으면, 오른쪽 자식으로 등록
				tree[i * 2 + 1] = c;
				hash.put(c, i * 2 + 1);
			}
		}
		// System.out.println(Arrays.toString(tree));
		// 순회
		System.out.println("전위");
		preorder(1); // 루트 정점부터 시작
		System.out.println("\n중위");
		inorder(1);
		System.out.println("\n후위");
		postorder(1);

	} // end of main

	public static void preorder(int index) {
		// 부모 -> 왼 -> 오
		System.out.print(tree[index] + " ");
		if (index * 2 < tree.length && tree[index * 2] != 0)
			preorder(2 * index);
		if (index * 2 + 1 < tree.length && tree[index * 2 + 1] != 0)
			preorder(2 * index + 1);
	}

	public static void inorder(int index) {
		// 왼 -> 부모 -> 오
		if (index * 2 < tree.length && tree[index * 2] != 0)
			inorder(2 * index);
		System.out.print(tree[index] + " ");
		if (index * 2 + 1 < tree.length && tree[index * 2 + 1] != 0)
			inorder(2 * index + 1);
	}

	public static void postorder(int index) {
		// 왼-> 오 -> 부모
		if (index * 2 < tree.length && tree[index * 2] != 0)
			postorder(2 * index);
		if (index * 2 + 1 < tree.length && tree[index * 2 + 1] != 0)
			postorder(2 * index + 1);
		System.out.print(tree[index] + " ");
	}
} // end of class
