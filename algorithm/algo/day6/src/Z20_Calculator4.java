// 6 5 2 8 - * 2 / + 
public class Z20_Calculator4 {

	static String str = "( 6 + 5 * ( 2 - 8 ) / 2 )";

	public static void main(String[] args) {
		String str2 = calculator1();
		calculator2(str2);
	} // end of main

	public static void calculator2(String str) {
		String srr[] = str.split(" "); // 후위표기식을 공백제거해 배열에 넣기
		int top = -1;
		int[] stacknum = new int[srr.length]; // 피연산자를 담을 스택
		for (int i = 0; i < srr.length; i++) {
			char c = srr[i].charAt(0);
			int num1, num2;
			switch (c) { // 연산자가 나올경우 스택에서 2값을 꺼내주어 연산 수행후 스택에 다시 넣어주기
			case '+':
				num2 = stacknum[top--];
				num1 = stacknum[top--];
				stacknum[++top] = num1 + num2;
				break;
			case '-':
				num2 = stacknum[top--];
				num1 = stacknum[top--];
				stacknum[++top] = num1 - num2;
				break;
			case '*':
				num2 = stacknum[top--];
				num1 = stacknum[top--];
				stacknum[++top] = num1 * num2;
				break;
			case '/':
				num2 = stacknum[top--];
				num1 = stacknum[top--];
				stacknum[++top] = num1 / num2;
				break;
			default:
				stacknum[++top] = Integer.parseInt(srr[i]);
				break;
			}
		}
		System.out.println(stacknum[top--]);
	}

	public static String calculator1() {
		String[] srr = str.split(" ");
		String result = ""; // 후위표기식으로 변환해 저장할 변수
		char[] stackop = new char[srr.length]; // 연산자를 담을 스택
		int top = -1;
		for (int i = 0; i < srr.length; i++) {
			char c = srr[i].charAt(0);
			switch (c) {
			case '(': // 여는 괄호는 무조건 스택에 넣어주기
				stackop[++top] = c;
				break;
			case '*':
			case '/': // 곱, 나누기 연산일 경우 같은 우선순위, top이 0이상일 경우 출력 해주기 -> 맨위 연산자 우선순위가 2일 때 출력(맨위 연산자)
				while (top >= 0 && stackop[top] == '*' || stackop[top] == '/') {
					result = result + stackop[top--] + " ";
				}
				stackop[++top] = c; // 스택에 넣어주기
				break;
			case '+':
			case '-': // 두 연산보다 우선순위 낮은 것이 여는 괄호 밖에 없으므로 여는 괄호 나올 때 까지 맨위 연산자 출력해서 빼내기
				while (top >= 0 && (stackop[top] != '(')) {
					result = result + stackop[top--] + " ";
				}
				stackop[++top] = c; // 스택에 넣어주기
				break;
			case ')': // 여는 괄호 나올 때 까지 맨위 값 출력해주기
				while (top >= 0 && (stackop[top] != '(')) {
					result = result + stackop[top--] + " ";
				}
				if (stackop[top] == '(') { // 여는 괄호는 출력해주지 않기 때문에 top 값만 하나 빼주기
					top--;
				}
				break;
			default:
				result = result + srr[i] + " "; // 숫자(피연산자)는 출력
				break;
			}
		}
		while (top > -1) { // 스택에 남아있는 연산자를 전부 출력해주기
			result = result + stackop[top--] + " ";
		}
		return result;
	}
} // end of class