package List;

import java.util.Iterator;

public class DoublyLinkedList<T> {
	DListNode<T> head;
	DListNode<T> tail;
	
	public void append(T data){
		DListNode<T> newNode = new DListNode<T>(data, this.tail, null);
		
		if(this.head == null){
			this.head = newNode;
			this.tail = newNode;
		}
		else{
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	
	@Override
	public String toString(){
		String result = "";
		for(DListNode<T> curr = head; curr != null; curr = curr.next){
			result += curr.data + "\n";
		}
		return result;
	}
	
	public Iterator<T> iterator(){
		Iterator<T> result = new DListIterator();
		return result;
	}
	
	private class DListIterator implements Iterator<T>{

		DListNode<T> node = head;
		
		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			T result = node.getData();
			node = node.next;
			return result;
		}

		@Override
		public void remove() {
			//Empty Method
		}
		
	}
	
	public static void main(String[] args){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		
		list.append("a");
		list.append("b");
		list.append("c");
		list.append("d");
		
		System.out.println(list);
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println("Iterator returned: " + s);
		}
	}
} 
