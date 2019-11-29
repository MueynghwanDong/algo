import java.util.Scanner;

public class Z14_괄호_소루션 {

	static int top = -1;
	static int[] arr;	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		arr = new int[30];
		String str = sc.nextLine();
		for (int i =0; i< str.length(); i++) {
			if(str.charAt(i) == '(') {
				push(1);
			} else {
				pop();
			}
		}
		System.out.println(isRight());
		

	}
	public static void push(int a) {
		arr[++top] = a;
	}
	public static void pop() {
		if(top > -1) top--;
	}
			
	public static boolean isRight() {
		if(top == -1) {
			return true;
		}
		else return false;
	}
}
