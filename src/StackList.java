import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StackList {
	private static ArrayList<Integer> stack;
	private static int size;
	private static int top = -1;// 가장 나중에 들어온 위치를 알려주는 int형 변수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		while (true) {
			System.out.println("git 테스트 용도입니다.1");
			System.out.println("git 테스트 용도입니다.2");
			System.out.println("git 테스트 용도입니다.3");
			System.out.println("스택의 크기를 정해주세요.");
			try {
				size = sc.nextInt();
				
			} catch (InputMismatchException e) {// 사용자가 스택의 크기를 숫자가 아닌 다른것을 입력한 것을 잡아주는 trycatch문
				System.out.println("잘못 입력하셨습니다!! 정수만 입력해 주십시오!!");
				sc.nextLine();// 없을경우 무한반복이 되어버리는 현상이 생기기 때문에 넣어준 nextLine
				continue;
			}
			break;
		}
		sc.nextLine();// nextInt에서 enter를 받아주는 nextLine
		stack = new ArrayList<Integer>(size);
		while (true) {
			System.out.println("명령어를 입력해주십시오(push (정수),pop,size,empty,printstack,end,top)");
			str = sc.nextLine();
			switch (str) {// 사용자가 앞에 대문자를 쓸 수도 있기 때문에 대소문자 구분없이 넣어준 스위치문
			case "end":
			case "End":
				return;
			case "pop":
			case "Pop":
				pop();
				break;
			case "size":
			case "Size":
				size();
				break;
			case "Empty":
			case "empty":
				empty();
				break;
			case "printstack":
			case "Printstack":
				printStack();
				break;
			case "top":
			case "Top":
				top();
				break;
			default:
				// push (정수) 이런식으로 쓰기 때문에 split으로 나눠준후 if문으로 확인해주는 코드 push를 적지 않았을 경우 잘못 입력으로
				// 들어감
				String[] strArr = str.split(" ");
				try {
					if (strArr[0].equals("push") || strArr[0].equals("Push"))
						push(Integer.parseInt(strArr[1]));
					else
						System.out.println("잘못 입력하셨습니다.");
				} catch (NumberFormatException e) {// push e 이런식으로 쓰면 에러가 나고 멈추기 때문에 넣어준 try catch문
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		}

	}

	// 사용자의 숫자를 스택리스트에 넣어 주는 메소드
	public static void push(int num) {

		if ((top + 1) >= size) {// ArrayList는 사이즈를 지정해줘도 알아서 칸을 늘리거나 줄이거나 하기때문에 들어간 if문
			System.out.println("Stack is full");
			return;
		}
		// 삽입과정이므로 top의 값을 1더해주고 add 해주는 과정
		top++;
		stack.add(num);
		return;

	}

	// 가장 나중에 들어온 데이터 출력후 삭제
	public static void pop() {
		if (top == -1) {// 스택 리스트가 비었을 경우에 pop을 할 수가 없으므로 사용자에게 비었다는 것을 알려주는 if문
			System.out.println("Stack is empty");
			return;
		}
		// 출력과정이므로 먼저 출력하고 지워준 후 top의 값을 1빼주는 과정
		System.out.println(stack.get(top));
		stack.remove(top);
		top--;
		return;
	}

	public static void size() {// 말 그대로 size를 측정해주는 과정
		System.out.println("Stack Size:" + stack.size());// top+1로 바꿔줄 수 있다.
	}

	// 스택이 비었는지 안비었는지 사용자에게 알려주는 메소드
	public static void empty() {
		if (top == -1)
			System.out.println("Stack is empty");
		else
			System.out.println("Stack is not empty");
		return;
	}

	// 지금 스택이 가지고 있는 모든 값을 출력해주는 메소드
	public static void printStack() {
		for (int i = top; i >= 0; i--)
			System.out.println(stack.get(i));
	}

	public static void top() {
		System.out.println(top);
	}
}
