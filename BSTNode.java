package List;

public class BSTNode<T> {
	T data;
	BSTNode<T> left;
	BSTNode<T> right;
	BSTNode<T> parent;
	
	public BSTNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public BSTNode<T> getLeft() {
		return left;
	}
	
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
	public BSTNode<T> getRight() {
		return right;
	}
	
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	
	public BSTNode<T> getParent() {
		return parent;
	}
	
	public void setParent(BSTNode<T> parent) {
		this.parent = parent;
	}
	
	public boolean isLeftChild(){
		if(this.equals(this.getParent().getLeft())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isRightChild(){
		if(this.equals(this.getParent().getRight())){
			return true;
		}
		else{
			return false;
		}
	}
	
}
