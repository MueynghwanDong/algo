package algo09;

import java.util.Scanner;
import java.util.Stack;
 
class 히스토그램_1725_0916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
 
        int n = sc.nextInt();
        int height[] = new int[n + 2];
        for (int i = 1; i <= n; i++)
            height[i] = sc.nextInt();
        int result = 0;
        stack.push(0);
 
        for (int i = 1; i <= n + 1; i++) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int idx = stack.pop();
                result = Math.max(result, height[idx] * (i - stack.peek() - 1));
//                System.out.println(i+" " +idx+" " + height[idx] +" "+stack.peek()+" "+result);
            }
            stack.push(i);
        }
        sc.close();
        System.out.println(result);
    }
}
