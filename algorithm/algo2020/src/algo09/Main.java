package algo09;
import java.io.*;
import java.util.*;
public class Main {
    static int dx[] = {100,-1,-1,0,1,1,1,0,-1};
    static int dy[] = {100,0,-1,-1,-1,0,1,1,1};
    static int map[][];
    static Fish[] fish;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        fish = new Fish[17];
        for(int i=1; i<5; i++) {

            int map_input_cnt =0;
            String [] t = br.readLine().split(" ");
            for(int j=1; j<5; j++) {
                int a = Integer.parseInt(t[map_input_cnt]);
                int b = Integer.parseInt(t[map_input_cnt+1]);
                map_input_cnt+=2;
                map[i][j] =  a;
                fish[a] = new Fish(i,j,b,true);
            }
        }
        
        fish[map[1][1]].alive = false;
        int tmp_dir = fish[map[1][1]].dir;
        int tmp_fishNum = map[1][1];
        map[1][1] = -1;
        dfs(1,1,tmp_dir,tmp_fishNum);
        System.out.println(max);
    }
    public static void dfs(int sx, int sy, int sdir ,int sum) {
        max = Math.max(max, sum);
        
        int copy_map[][] = new int[5][5];
        Fish copy_fish[] = new Fish[17];
        for(int i=1; i<=16; i++) {
            copy_fish[i] = new Fish(0,0,0,true);
        }
        copy(copy_map,copy_fish);
        
        move_fish();
        
        for(int i=1; i<=3; i++) {
            int nx = sx+dx[sdir]*i;
            int ny = sy+dy[sdir]*i;
            if(!isRange(nx,ny) || map[nx][ny]==0) {
                continue;
            }
            int fish_num = map[nx][ny];
            int ndir = fish[fish_num].dir; // 이동할 위치에 있는 물고기 방향
    
            map[sx][sy] = 0;    // 원래 상어가 있던 위치 0으로 바꿔줌
            map[nx][ny] = -1;   // 상어가 이동할 위치에 -1로 해줌
            fish[fish_num].alive = false;   // 물고기 죽음 처리
            dfs(nx,ny,ndir,sum+fish_num);
            fish[fish_num].alive = true;    // 물고기 살음 처리
            map[nx][ny] = fish_num;
            map[sx][sy] = -1;
        }
        rollback(copy_map,copy_fish);
}
    public static void move_fish() {
        for(int i=1; i<=16; i++) {
            if(fish[i].alive == false) {
                continue;
            }
            boolean flag = false;
            int x = fish[i].x;
            int y = fish[i].y;
            int dir = fish[i].dir;
            
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(isRange(nx,ny)  && map[nx][ny]!=-1) {
                flag = true;
                if(map[nx][ny]==0) {
                    dead_fish_change(i,x,y,nx,ny,dir);
                }
                else {
                    alive_fish_change(i,x,y,nx,ny,dir);
                }
            }   // isRange
            
            if(!flag) {
                int ndir = dir+1;
                if(ndir==9) {
                    ndir=1;
                }
                
                while(ndir!=dir) {
                    int tx = x+dx[ndir];
                    int ty = y+dy[ndir];
                    if(!isRange(tx,ty) || map[tx][ty]==-1) {
                        ndir++;
                        if(ndir==9) {
                            ndir=1;
                        }
                        continue;
                    }
                    else {
                        if(map[tx][ty]==0) {
                            dead_fish_change(i,x,y,tx,ty,ndir);
                            break;
                        }
                        else {
                            alive_fish_change(i,x,y,tx,ty,ndir);
                            break;
                        }
                    }
                }
            }   // !flag
        }   //for 
    }//move fish
    public static void dead_fish_change(int num,int x, int y, int nx, int ny, int dir) {
        // x,y는 원래위치 nx,ny는 움직이고 바뀐 위치
        fish[num].x = nx;
        fish[num].y = ny;
        fish[num].dir = dir;
        map[nx][ny] = num;
        map[x][y]=0;
    }
    public static void alive_fish_change(int num, int x, int y, int nx, int ny, int dir) {
        // x,y는 원래위치 nx,ny는 바뀐위치
        int other_fish = map[nx][ny];
        
        fish[num].x =nx;
        fish[num].y = ny;
        fish[num].dir = dir;
        
        fish[other_fish].x = x;
        fish[other_fish].y=y;
        
        map[x][y] = other_fish;
        map[nx][ny] = num;
    }
    public static void rollback(int copy_map[][], Fish copy_fish[]) {
        for(int i=1; i<=16; i++) {
            fish[i].x = copy_fish[i].x;
            fish[i].y = copy_fish[i].y;
            fish[i].dir = copy_fish[i].dir;
            fish[i].alive = copy_fish[i].alive;
        }
        for(int i=1; i<=4; i++) {
            for(int j=1; j<=4; j++) {
                map[i][j] = copy_map[i][j];
            }
        }
    }
    public static void copy(int copy_map[][], Fish copy_fish[]) {
        for(int i=1; i<=16; i++) {
            copy_fish[i].x = fish[i].x;
            copy_fish[i].y = fish[i].y;
            copy_fish[i].dir = fish[i].dir;
            copy_fish[i].alive = fish[i].alive;
        }
        for(int i=1; i<=4; i++) {
            for(int j=1; j<=4; j++) {
                copy_map[i][j] = map[i][j];
            }
        }
    }
    public static boolean isRange(int x, int y) {
        if(x>=1 && y>=1 && x<=4 && y<=4) {
            return true;
        }
        return false;
    }
}
class Fish{
    int x,y,dir;
    boolean alive;
    Fish(int x, int y, int dir,boolean alive){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.alive = alive;
    }
}