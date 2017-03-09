package List;

public class DListNode<T> {
	T data;
	DListNode<T> next = null;
	DListNode<T> prev = null;
	
	public DListNode(T data, DListNode<T> prev, DListNode<T> next) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DListNode<T> getNext() {
		return next;
	}

	public void setNext(DListNode<T> next) {
		this.next = next;
	}

	public DListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DListNode<T> prev) {
		this.prev = prev;
	}
	
}
