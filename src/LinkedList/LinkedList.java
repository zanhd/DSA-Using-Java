package LinkedList;

/*
 * Yes, Interfaces CAN contain member variables. But these variables have to be implicitly (without any keyword definition) final, public and static. 
 * This means that within interfaces, one can only declare constants. 
 * You cannot declare instance variables using interfaces.
*/

public interface LinkedList {
	public void pushBack(Integer data);

	public void popBack();

	public void pushFront(Integer data);

	public void popFront();

	public void print();
}
