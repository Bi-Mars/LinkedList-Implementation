/*
 * This class is a block that stores data (integer).
 * Every element is created using Instance of this class
 */


public class Node {
	private int data;
	private Node pointerToNextNode;
	
	//****************************constructors**************************************
	Node(){
		this.data = 0;
		this.pointerToNextNode = null;
	}
	Node(int data1, Node pointer){
		this.data = data1;
		this.pointerToNextNode = pointer;
	}
	Node(int data1){
		this.data = data1;
		this.pointerToNextNode = null;
	}
	//******************************************************************************
	
	//************************GETTERS**********************************************
	public int getData() {
		return this.data;
	}
	
	public Node getPointer(){
		return this.pointerToNextNode;
	}
	//*****************************************************************************
	
	//**********************SETTERS***********************************************
	public void setData(int value) {
		this.data = value;
	}
	public void setPointer(Node pointer) {
		this.pointerToNextNode = pointer;
	}
	//***************************************************************************
	
}
