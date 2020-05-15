import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StackList {
	private static ArrayList<Integer> stack;
	private static int size;
	private static int top = -1;// ���� ���߿� ���� ��ġ�� �˷��ִ� int�� ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		while (true) {
			System.out.println("git �׽�Ʈ �뵵�Դϴ�.1");
			System.out.println("git �׽�Ʈ �뵵�Դϴ�.2");
			System.out.println("git �׽�Ʈ �뵵�Դϴ�.3");
			System.out.println("������ ũ�⸦ �����ּ���.");
			try {
				size = sc.nextInt();
				
			} catch (InputMismatchException e) {// ����ڰ� ������ ũ�⸦ ���ڰ� �ƴ� �ٸ����� �Է��� ���� ����ִ� trycatch��
				System.out.println("�߸� �Է��ϼ̽��ϴ�!! ������ �Է��� �ֽʽÿ�!!");
				sc.nextLine();// ������� ���ѹݺ��� �Ǿ������ ������ ����� ������ �־��� nextLine
				continue;
			}
			break;
		}
		sc.nextLine();// nextInt���� enter�� �޾��ִ� nextLine
		stack = new ArrayList<Integer>(size);
		while (true) {
			System.out.println("��ɾ �Է����ֽʽÿ�(push (����),pop,size,empty,printstack,end,top)");
			str = sc.nextLine();
			switch (str) {// ����ڰ� �տ� �빮�ڸ� �� ���� �ֱ� ������ ��ҹ��� ���о��� �־��� ����ġ��
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
				// push (����) �̷������� ���� ������ split���� �������� if������ Ȯ�����ִ� �ڵ� push�� ���� �ʾ��� ��� �߸� �Է�����
				// ��
				String[] strArr = str.split(" ");
				try {
					if (strArr[0].equals("push") || strArr[0].equals("Push"))
						push(Integer.parseInt(strArr[1]));
					else
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				} catch (NumberFormatException e) {// push e �̷������� ���� ������ ���� ���߱� ������ �־��� try catch��
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}
		}

	}

	// ������� ���ڸ� ���ø���Ʈ�� �־� �ִ� �޼ҵ�
	public static void push(int num) {

		if ((top + 1) >= size) {// ArrayList�� ����� �������൵ �˾Ƽ� ĭ�� �ø��ų� ���̰ų� �ϱ⶧���� �� if��
			System.out.println("Stack is full");
			return;
		}
		// ���԰����̹Ƿ� top�� ���� 1�����ְ� add ���ִ� ����
		top++;
		stack.add(num);
		return;

	}

	// ���� ���߿� ���� ������ ����� ����
	public static void pop() {
		if (top == -1) {// ���� ����Ʈ�� ����� ��쿡 pop�� �� ���� �����Ƿ� ����ڿ��� ����ٴ� ���� �˷��ִ� if��
			System.out.println("Stack is empty");
			return;
		}
		// ��°����̹Ƿ� ���� ����ϰ� ������ �� top�� ���� 1���ִ� ����
		System.out.println(stack.get(top));
		stack.remove(top);
		top--;
		return;
	}

	public static void size() {// �� �״�� size�� �������ִ� ����
		System.out.println("Stack Size:" + stack.size());// top+1�� �ٲ��� �� �ִ�.
	}

	// ������ ������� �Ⱥ������ ����ڿ��� �˷��ִ� �޼ҵ�
	public static void empty() {
		if (top == -1)
			System.out.println("Stack is empty");
		else
			System.out.println("Stack is not empty");
		return;
	}

	// ���� ������ ������ �ִ� ��� ���� ������ִ� �޼ҵ�
	public static void printStack() {
		for (int i = top; i >= 0; i--)
			System.out.println(stack.get(i));
	}

	public static void top() {
		System.out.println(top);
	}
}
