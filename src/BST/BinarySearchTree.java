package BST;

class Node {
	private Integer data;
	private Node left;
	private Node right;

	public Node() {
		this.data = 0;
		left = right = null;
	}

	public Node(Integer data) {
		this();
		this.data = data;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}

public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	private Boolean search(Node root, Integer key) {
		if (root == null) {
			return false;
		}

		if (key == root.getData()) {
			return true;
		}

		if (key < root.getData()) {
			return search(root.getLeft(), key);
		} else {
			return search(root.getRight(), key);
		}
	}

	public Boolean search(Integer key) {
		return search(root, key);
	}

	private Node insert(Node root, Integer key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.getData()) {
			root.setLeft(insert(root.getLeft(), key));
		} else {
			root.setRight(insert(root.getRight(), key));
		}

		return root;
	}

	public void insert(Integer key) {
		if (search(key)) {
			return;
		}
		root = insert(root, key);
	}

	private Node delete(Node root, Integer key) {
		if (root == null) {
			return root;
		}

		if (key == root.getData()) {

			// case 1 : Leaf
			if (root.getLeft() == null && root.getRight() == null) {
				return null;
			}

			// case 2(a) : left-child is null
			if (root.getLeft() == null) {
				return root.getRight();
			}

			// case 2(b) : right-child is null
			if (root.getRight() == null) {
				return root.getLeft();
			}

			// case 3[V.IMP]: both-child is non-null
			Integer minNode = findMin(root.getRight()); // Note : there will be no-left child of this node
			root.setData(minNode);
			root.setRight(delete(root.getRight(), minNode));
			return root;

		} else {

			if (key < root.getData()) {
				root.setLeft(delete(root.getLeft(), key));
			} else {
				root.setRight(delete(root.getRight(), key));
			}

		}

		return root;

	}

	private Integer findMin(Node root) {

		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root.getData();
	}

	public void delete(Integer key) {
		root = delete(root, key);
	}

	private void inorder(Node root) {
		if (root == null) {
			return;
		}

		inorder(root.getLeft());
		System.out.print(root.getData() + " ");
		inorder(root.getRight());
	}

	public void getInorderTraversal() {
		System.out.print("In-order : ");
		inorder(root);
		System.out.println();
	}

}
