import java.util.*;
public class Linkedlist {

		// don't mess with head. This is the reference that will direct to all other nodes
		Node head = new Node();
		static int counter = 0;
		 static double start, end, diff;
		// Constructor. Initialize Head
		public Linkedlist () {
			head.setPointer(null);
			head.setData(0);
		}
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		/*
		 * We create a new node for each item that we want to Insert
		 * Each node that will be inserted will have
		 * 			1. Pointer/reference --> points to the newly created node
		 * 			2. Data value --> stores data
		 * 			3. PointerToNextNode --> Default set to null and this holds the reference/pointer to next node that will be created
		 * Get the data, from the user, that we want to save. And save the data in the newly created node
		 * If PointerTONextNode of head node is not null, means that there is already existing reference.
		 * Copy the reference that was stored in head Node into new temporary node
		 * Then, add the reference of newly created node inside the Head node.
		 * Then, add the reference of the previous saved node inside the newly created node
		 */
	public static void insertFront(int data, Node headPointer) {
		//New node is created and value is stored
		start = System.nanoTime();
		Node newCurrentNode = new Node();
		//set the value of the node
		newCurrentNode.setData(data);
		//if the head does not point to null then there is already element in the linked list
		if(headPointer.getPointer() != null) {
			Node savePreviousNode = new Node();
			/* what ever was stored inside headPointer (address/pointer to previous node.
			 * Get that value and temporarily save inside "savePreviousPointer"
			 */	
			savePreviousNode.setPointer(headPointer.getPointer());
			
			// Update what HEADPointer was pointing at --> Newly inserted Node
			headPointer.setPointer(newCurrentNode);
			
			//To get an access to previous Node. Save its Pointer to newly created Node
			newCurrentNode.setPointer(savePreviousNode.getPointer());
			// update counter
			end = System.nanoTime();
			diff = end - start;
			System.out.println("It took " + diff + " nanoseconds to insert " + data + " at front of the linkedlist.");
			counter++;
		}
		else { // if the new Node is the first node to be inserted in the linked list.
				headPointer.setPointer(newCurrentNode);	
				end = System.nanoTime();
				diff = end - start;
				System.out.println("It took " + diff + " nanoseconds to insert " + "first node in the linkedlist.");
				counter++;
		}
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/*
	 * To delete node:
	 * 		ask for value/data that the user wants to delete
	 * 	Starting from head, check the value of every node, if matches:
	 * 		save the pointer of the previous node
	 * 		copy the nextNodePointer from current node and save in the previous node's nextNodePointer
	 */
	public static void delete(int value, Node head) {
		Node previous;
		Node current;
		int dataValue;
		start = System.nanoTime();
		current = head.getPointer();
		dataValue = current.getData();
		previous = head;
		while(value != dataValue) {
			previous = current;
			dataValue = current.getData();
			current = current.getPointer();
			dataValue = current.getData();
			if(current.getPointer()== null) {
				System.out.println("Item you want to delete could not be found");
				break;
			}
			
		}
		
		if(dataValue == value) {
			//update node
		previous.setPointer(current.getPointer());
		end = System.nanoTime();
		diff = end - start;
		System.out.print("It took " + diff + " nanoseconds to delete the node.");
		}
		
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/*
	 * Search the data item in the node
	 * 		get the value from user that needs to be searched
	 * starting from head, check the value at each node
	 */
	public static void search(int value, Node head) {
		Node current;
		int dataValue;
		int count = 0;
		start = System.nanoTime();
		current = head.getPointer();
		dataValue = current.getData();
		count ++;
		while(dataValue != value) {
			current = current.getPointer();
			dataValue = current.getData();
			count++;
			
		}
		
		if(dataValue == value) {
			end = System.nanoTime();
			diff = end - start;
			System.out.print("It took " + diff + " nanoseconds to find the element.");
			System.out.println("The value you you were searching was found at " + count + "th node.");
		}
		else {
			System.out.println("Sorry couldn't find the item that you were looking for");
		}
	}
	/*
	 * In order to insert at any given position:
	 * 		We first get the position.
	 * 		Then, starting from pointer that head has stored (count = 1), we search the node that is at position - 1
	 * After we find the node that is at the position -1:
	 * 		we, create new node
	 * 		we, copy the pointer that is saved in Node at position -1 to the newly created node
	 * 		then, we change/update the pointer that is saved at position -1 to the pointer that is pointing to newly created node
	 */
	
	public static void insertAtAnyPosition(int position, int data, Node headPointer) {
		int count = 0;
		start = System.nanoTime();
		Node newCurrentNode = new Node();
		newCurrentNode.setData(data);
		Node temp;
		// search the node by position. Insert the new node at the position so stop before that position
		temp = headPointer.getPointer();
		count++;
		while(count!= position-1) {
			
			temp = temp.getPointer();
			count++;
		}
		
		// Set the value of Pointer of newly created node to the pointer that was saved in node before this
		
		newCurrentNode.setPointer(temp.getPointer());
		temp.setPointer(newCurrentNode);
		end = System.nanoTime();
		diff = end - start;
		System.out.println("It took " + diff + " nanoseconds to insert " + data + " at " + position + "th position of the linkedlist.");
		
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	/*
	 * To insert at the end:
	 * Start from the head node,
	 * Get pointer that is saved in the head node and follow the pointer until you reach null
	 * If node stores null in the nextNodePointer variable then this indicates that we have reached the end of the linkedlist
	 * So, create a new node.
	 * Save the nextNodepointer of that last node to the pointer that is pointing at newly created node
	 */
	public static void insertAtEnd(int data, Node head) {
		start = System.nanoTime();
		
		Node newCurrentNode = new Node();
		newCurrentNode.setData(data);
		
		Node temp;
		temp = head.getPointer();
		// when this search reach the end of the node, it will exit the loop 
		while(temp != null) {
			if(temp.getPointer() == null) {
				break;
			}
			temp = temp.getPointer();
			
		}
		
		temp.setPointer(newCurrentNode);
		end = System.nanoTime();
		diff = end - start;
		System.out.println("It took " + diff + " nanoseconds to insert " + data + " at the end of linkedlist.");
		
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/*
	 * To traverse through each node:
	 * Start from the head. 
	 * Get the nextNodePointer and save it to the temporary saver
	 * then access the data of that node
	 * Update temporary saver to nextNodePointer
	 */
	public static void traverse(Node head) {
		Node temp;
		int dataValue;
		
		start = System.nanoTime();
		temp = head.getPointer(); 
		dataValue = temp.getData();
		System.out.println(dataValue);
		do {
			//Once you get the next Node, get the data of that node
			temp = temp.getPointer();
			dataValue = temp.getData();
			System.out.println(dataValue);
			// get the pointer that was saved int that Node
			end = System.nanoTime();
			diff = end - start;
			System.out.println("It took " + diff + " nanoseconds to walk through each node of the linkedlist");
		}while(temp.getPointer() !=null);
		
		end = System.nanoTime();
		diff = end - start;
		System.out.println("It took " + diff + " nanoseconds to walk through all the node of the Linkedlist");
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	/*
	 * In the main method, I created an object of LinkedList class:
	 * 		Linkedlist class consists of all the methods
	 * 		Creating object of Linkedlist class, will initialize head Node's dataValue to 0 and pointerNextNode to null
	 */
	
	public static void main(String[] args) {
		Linkedlist implement = new Linkedlist();
		Scanner scan = new Scanner(System.in);
		String input;
		do {
			System.out.println("Enter if to insert at front");
			System.out.println("Enter t to traverse");
			System.out.println("Enter ip to insert at any position");
			System.out.println("Enter ie to inset at the end");
			System.out.println("Enter d to delete the element.");
			System.out.println("Enter s to search the element");
			 input = scan.nextLine();
			// call insert method
					if(input.equals("if")) {
						System.out.println("Enter number you want to insert");
						int data = scan.nextInt();
						scan.nextLine();
						implement.insertFront(data, implement.head);
					}
					else if (input.equals("t"))
						implement.traverse(implement.head);
					else if (input.equals("ip")) {
						int position, dataField;
						System.out.println("Please enter the position you want to insert");
						position = scan.nextInt();
						scan.nextLine();
						System.out.println("Please enter the data that you want to insert");
						dataField = scan.nextInt();
						scan.nextLine();
						insertAtAnyPosition(position, dataField, implement.head);
					}
					else if( input.equals("ie")) {
						System.out.println("Please enter the data that you want to insert at the end");
						int value = scan.nextInt();
						scan.nextLine();
						insertAtEnd(value, implement.head);
					}
					else if(input.equals("d")) {
						System.out.println("Please enter the element you want to delete");
						int data = scan.nextInt();
						scan.nextLine();
						delete(data, implement.head);
					}
					else if (input.equals("s")) {
						System.out.println("Enter the number that you would like to search");
						int dataValue = scan.nextInt();
						scan.nextLine();
						search(dataValue, implement.head);
					}
					
			}while(!input.equals("quit"));

		System.out.println("There are " + counter + " nodes in the linked list");
	}
}
