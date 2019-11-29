
public class Z27_MyChu {

	public static void main(String[] args) {
		Person[] ps = new Person[20];
		int first = 0;
		int rear = 0;
		int mychu = 20;
		int newIndex = 1;
		int answer = 0;
		Person p = new Person(1, (newIndex++));
		ps[++rear] = p;
		System.out.println("큐에 있는 사람 수 : " + (rear-first) + " 명\t| 현재 일인당 나눠주는 사탕의 수 : "+p.getChu()+"개\t| 현재까지 나눠준 사탕의 수 : " + (20 - mychu) +"개");

		while (mychu >= 0) {
			Person temp = ps[(++first)%ps.length];
			mychu -= temp.getChu();
			System.out.println("큐에 있는 사람 수 : " + (rear-first) + " 명\t| 현재 일인당 나눠주는 사탕의 수 : "+temp.getChu()+"개\t| 현재까지 나눠준 사탕의 수 : " + (20 - mychu) +"개");

			if (mychu <= 0) {
				answer = temp.getIndex();
				break;
			}
			p = new Person(1, (newIndex++));
			temp.setChu(temp.getChu() + 1);
			ps[(++rear)%ps.length] = temp;
			
			ps[(++rear)%ps.length] = p;

		}
		
		System.out.println(answer);
		
		
		
		/**
		 * 
		 */
	}

	public static class Person {
		int chu;
		int index;

		public Person(int chu, int index) {
			super();
			this.chu = chu;
			this.index = index;
		}

		public int getChu() {
			return chu;
		}

		public void setChu(int chu) {
			this.chu = chu;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		@Override
		public String toString() {
			return "Person [chu=" + chu + ", index=" + index + "]";
		}

	}

}
