package BST;

import java.util.Scanner;

public class MainBinarySearchTree {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			BinarySearchTree bst = new BinarySearchTree();
			Boolean isContinue = true;

			while (isContinue) {
				System.out.print("0. exit \n" + "1. insert" + "\n" + "2. search" + "\n" + "3. delete" + "\n"
						+ "4. In-order" + "\n" + "Choose Option : ");

				Integer option = scanner.nextInt();
				Integer key;

				switch (option) {
				case 0:
					System.exit(0);
					break;
				case 1:
					System.out.print("Insert : Enter key : ");
					key = scanner.nextInt();
					bst.insert(key);
					break;
				case 2:
					System.out.print("Search : Enter key : ");
					key = scanner.nextInt();
					System.out.println((bst.search(key)) ? "FOUND" : "NOT-FOUND");
					break;
				case 3:
					System.out.print("Delete : Enter key : ");
					key = scanner.nextInt();
					bst.delete(key);
					break;
				case 4:
					bst.getInorderTraversal();
					break;
				default:
					System.out.println("Enter Correct Option!!!");
				}

				System.out.print("Wanna Continue...(true/false) : ");
				isContinue = scanner.nextBoolean();
			}
		}
	}
}
