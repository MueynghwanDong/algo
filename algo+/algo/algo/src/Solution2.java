import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chem = new int[n][2];
        for (int i = 0; i < chem.length; i++) {
            chem[i][0] = sc.nextInt();
            chem[i][1] = sc.nextInt();
        }
        
        Arrays.sort(chem, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o2[1]-o1[1];
            }
            
        });
        

        int ans = 0;
        int head = -500;
        int tail = -500;
        int nhead = -500;
        int ntail = -500;
        int idx = 0;
        
        head = chem[0][1];
        tail = chem[0][0];
        
        for (int i = 0; i < chem.length-1; i++) {
            nhead = chem[i+1][1];
            ntail = chem[i+1][0];
            if(ntail >= tail) {
                head = nhead;
                tail = ntail;
            } else if (nhead >= tail){
                head = nhead;
                //tail still
            } else {
                head = nhead;
                tail = ntail;
                ans++;
            }
        }
        System.out.println(ans+1);
    }
}