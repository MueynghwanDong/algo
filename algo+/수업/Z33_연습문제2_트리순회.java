import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;



/**
 * 트리: 비선형자료구조.
 * 1. 저장
 * 2. 순회
 *   - BFS, DFS, 전위, 중위, 후위
 * 문제에서 상세히 설명되는 사항
 *   - 트리의 종류(이진/포화/완전), 루트노드번호, 트리의 크기(높이/레벨/최대정점의 갯수/정점번호)
 *   - 이 문제에서는 레벨 4의 이진트리, 루트노드번호는 1로 취급해서 풀기로 하자.
 *   
 * @author student
 *
 */
public class Z33_연습문제2_트리순회 {
	public static int[] tree = new int[32];
	
	public static void main(String[] args) throws IOException {
		// 저장방법: 배열로 저장. 크기는 부족하지 않도록 지정. 정점 13개. 그러면 간선은 12개.
		// 편향이진트리임을 고려하면 필요한 배열의 크기는 2^13개를 만든다. 
		// 1<<13 1을 쉬프트 연산 13번하면 2^13을 만들수 있다.
		// 그런데 이번에는 그려보니까 레벨 5임을 알 수 있으니 그냥 2^5으로 간다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		HashMap<Integer, Integer> hm = new HashMap<>();// (키 정점번호 : 값 Tree배열에 저장한 index)
		
		tree[1] = 1;	// 루트 정점 지정. 
		// 아래 while문에서는 들어온 문자에서 부모가 배열에 있는지 찾기 때문에, 
		// 최초의 루트 정점이 들어 있어야 한다. 
		
		while(st.hasMoreTokens()) { // 토큰 갯수만큼 돈다. 정점쌍이 13개.
			int p = Integer.parseInt(st.nextToken());	// 간선의 시작점. 부모
			int c = Integer.parseInt(st.nextToken());	// 간선의 끝점. 자식
			
			// 부모정점이 트리 배열에 존재하는지 검색하고, 존재하면 자식이 될 인덱스에 자식을 저장
			// 왼쪽자식이 없으면 왼쪽을 채우고, 왼쪽자식이 있으면 오른쪽 자식으로 저장.
			// 그런데 이 구조에서는 최초의 루트 구조가 이미 있는게 편하다.
			int i = hm.get(p);
			
			
			// 시간 개선을 위한 ! 부분 ! 
			for (i = 0; i < tree.length; i++) {
				if(p == tree[i]) {	// 부모를 i번째에서 찾았다.
					break;
				}
			}
			
			if(tree[i*2] == 0) { 		// 왼쪽자식이 없으면 왼쪽에 등록. i*2의 위차가 왼쪽자식의 위치. 초기값은 0
				tree[i*2] = c;
				hm.put(c, i*2);
			} else {	// 왼쪽자식이 있으면 오른쪽에 등록.
				tree[i*2+1] = c;
				hm.put(c, i*2+1);
			}			
		}
		System.out.println(Arrays.toString(tree));	// 완전 이진 트리에서 순서대로 번호를 매기고 이를 index로 매칭했을 때 그에 따른 노드 위치
		// 여기까지 저장부분.
		
		
		//순회는 재귀로 해보자!
		preorder(1);
		inorder(1);
		postorder(1);
		
	}
	
	public static void preorder(int index) {
		// 부모 -> 왼쪽 -> 오른쪽 순서로 탐색
		System.out.print(tree[index]+ " ");		// 부모노드 출력
		// 왼쪽/오른쪽 자식이 없는경우, 배열의 index를 벗어나는 경우를 체크해야 한다.
		if(index * 2 < tree.length && tree[index*2] != 0) {
			// 왼쪽자식이 범위에서 벗어나는지, 왼쪽자식이 있는지
			preorder(index*2);			// 왼쪽자식
		}
		if(index * 2+1 < tree.length && tree[index*2+1] != 0) {
			// 오른쪽자식이 범위에서 벗어나는지, 오른쪽자식이 있는지
			preorder(index*2+1);		// 오른쪽자식
		}
		
	}
	
	
	public static void inorder(int index) {
		// 부모 -> 왼쪽 -> 오른쪽 순서로 탐색
		System.out.print(tree[index]+ " ");		// 부모노드 출력
		// 왼쪽/오른쪽 자식이 없는경우, 배열의 index를 벗어나는 경우를 체크해야 한다.
		if(index * 2 < tree.length && tree[index*2] != 0) {
			// 왼쪽자식이 범위에서 벗어나는지, 왼쪽자식이 있는지
			inorder(index*2);			// 왼쪽자식
		}
		if(index * 2+1 < tree.length && tree[index*2+1] != 0) {
			// 오른쪽자식이 범위에서 벗어나는지, 오른쪽자식이 있는지
			inorder(index*2+1);		// 오른쪽자식
		}
		
	}
	
	public static void postorder(int index) {
		// 부모 -> 왼쪽 -> 오른쪽 순서로 탐색
		System.out.print(tree[index]+ " ");		// 부모노드 출력
		// 왼쪽/오른쪽 자식이 없는경우, 배열의 index를 벗어나는 경우를 체크해야 한다.
		if(index * 2 < tree.length && tree[index*2] != 0) {
			// 왼쪽자식이 범위에서 벗어나는지, 왼쪽자식이 있는지
			postorder(index*2);			// 왼쪽자식
		}
		if(index * 2+1 < tree.length && tree[index*2+1] != 0) {
			// 오른쪽자식이 범위에서 벗어나는지, 오른쪽자식이 있는지
			postorder(index*2+1);		// 오른쪽자식
		}
		
	}
	
	
}