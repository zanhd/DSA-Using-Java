package LinkedList;

import java.util.Scanner;

public class MainLinkedList {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			LinkedList singlyList = new SinglyLinkedList();
			LinkedList doublyList = new DoublyLinkedList();
			Boolean isContinue = true;

			while (isContinue) {
				System.out.print("0. EXIT " + "1. pushBack \n" + "2. popBack \n" + "3. pushFront \n" + "4. popFront \n"
						+ "5. printList \n" + "Choose Option : ");
				Integer option = scanner.nextInt();

				switch (option) {
				case 0:
					System.exit(0);
					break;
				case 1:
					System.out.print("Enter value for pushBack(?) : ");
					Integer value = scanner.nextInt();
					singlyList.pushBack(value);
					doublyList.pushBack(value);
					break;
				case 2:
					singlyList.popBack();
					doublyList.popBack();
					break;
				case 3:
					System.out.print("Enter value for pushBack(?) : ");
					value = scanner.nextInt();
					singlyList.pushFront(value);
					doublyList.pushFront(value);
					break;
				case 4:
					singlyList.popFront();
					doublyList.popFront();
					break;
				case 5:
					singlyList.print();
					doublyList.print();
					break;
				default:
					System.out.println("Enter Correct Option!!!");
				}

				System.out.print("Wanna Continue...[true/false] : ");
				isContinue = scanner.nextBoolean();
			}

		}
	}
}
