package algo06.algo0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알파벳_시간빠른사람것_참고 {
	
    public static void main(String []args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int r = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	char[][] map = new char[r][c];
    	int[][] alphas = new int[r][c];
    	for(int i=0; i<r; i++) 
    		map[i] = br.readLine().toCharArray();
    	
    	int[] dr = {1,0,-1,0};
    	int[] dc = {0,-1,0,1};
    	
    	Queue<Dot> que = new LinkedList<Dot>();
    	
    	que.add(new Dot(0,0,1<<(map[0][0]-'a'),1));
    	int answer=0;
    	
    	while(!que.isEmpty()) {
    		
    		Dot now = que.poll();
    		if(alphas[now.r][now.c]==now.alpha) continue;
    		alphas[now.r][now.c]=now.alpha;
    		answer = now.count;
    		
    		for(int i=0; i<4; i++) {
    			int nextR = now.r+dr[i];
    			int nextC = now.c+dc[i];
				if(0<=nextR&&nextR<r&&0<=nextC&&nextC<c) {
					int nextA = 1<<(map[nextR][nextC]-'a');
	    			
	    			if((now.alpha&nextA)==0) {
	    				que.add(new Dot(nextR, nextC, now.alpha|nextA,now.count+1));
	    			}
				}
    		}
    	}
    	System.out.print(answer);
    }
    static class Dot{
    	
    	int r, c, alpha,count;
    	
    	public Dot(int r, int c, int alpha, int count) {
    		this.r=r;
    		this.c=c;
    		this.alpha=alpha;
    		this.count=count;
    	}
    }
}
