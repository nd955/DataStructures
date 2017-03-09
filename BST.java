package List;

import java.util.Comparator;
import java.util.Iterator;

public class BST<T>{
	BSTNode<T> root;
	Comparator<T> c;
	
	public BST(Comparator<T> comp){
		c = comp;
	}
	
	private BSTNode<T> searchNode(T key, BSTNode<T> subTreeRoot){
		if(subTreeRoot == null || subTreeRoot.getData() == key){
			return subTreeRoot;
		}
		else if(c.compare(key, subTreeRoot.getData()) < 0){
			return searchNode(key, subTreeRoot.getLeft());
		}
		else{
			return searchNode(key, subTreeRoot.getRight());
		}
	}
	
	public T search(T key){
		BSTNode<T> node = searchNode(key, root);
		if(node != null){
			return node.getData();
		}
		else{
			return null;
		}
	}
	
	private void insertNode(BSTNode<T> node, BSTNode<T> subTreeRoot){
		if(c.compare(node.getData(), subTreeRoot.getData()) <= 0){
			if(subTreeRoot.getLeft() == null){
				subTreeRoot.setLeft(node);
				node.setParent(subTreeRoot);
			}
			else{
				insertNode(node, subTreeRoot.getLeft());
			}
		}
		else{
			if(subTreeRoot.getRight() == null){
				subTreeRoot.setRight(node);
				node.setParent(subTreeRoot);
			}
			else{
				insertNode(node, subTreeRoot.getRight());
			}
		}
	}
	
	public void insert(T data){
		BSTNode<T> newNode = new BSTNode<T>(data);
		if(root != null){
			insertNode(newNode, root);
		}
		else{
			root = newNode;
		}
	}
	
	private BSTNode<T> deleteNode(BSTNode<T> node){
		BSTNode<T> nodeToDelete = node;
		BSTNode<T> s = this.successor(node);
		BSTNode<T> p = this.predecessor(node);
		boolean deleted = false;
		if(node.getLeft() == null && node.getRight() == null){
			if(node.getParent() != null){
				if(node.getParent().getLeft() == node){
					node.getParent().setLeft(null);
				}
				else if(node.getParent().getRight() == node){
					node.getParent().setRight(null);
				}
				deleted = true;
			}
			else{
				node = null;
			}
		}
		else if(node.getLeft() != null  && node.getRight() != null){
			if(s != null && !deleted){
				node.setData(s.getData());
				this.deleteNode(s);
			}
			else if(p != null && !deleted){
				node.setData(p.getData());
				this.deleteNode(p);
			}
		}
		else if(node.getLeft() != null){
			if(node.getParent() != null){
				if(node.getParent().getRight() == node){
					node.getParent().setRight(node.getLeft());
					node.getLeft().setParent(node.getParent());
					node = null;
					deleted = true;
				}
				else if(node.getParent().getLeft() == node){
					node.getParent().setLeft(node.getLeft());
					node.getLeft().setParent(node.getParent());
					node = null;
					deleted = true;
				}
			}
			else{
				node.getLeft().setParent(null);
				node = null;
				deleted = true;
			}
		}
		else if(node.getRight() != null){
			if(node.getParent() != null){
				if(node.getParent().getRight() == node){
					node.getParent().setRight(node.getRight());
					node.getRight().setParent(node.getParent());
					node = null;
					deleted = true;
				}
				else if(node.getParent().getLeft() == node){
					node.getParent().setLeft(node.getRight());
					node.getRight().setParent(node.getParent());
					node = null;
					deleted = true;
				}
			}
			else{
				node.getRight().setParent(null);
				node = null;
				deleted = true;
			}
		}
		
		return nodeToDelete;
	}
	
	public T delete(T data){
		T dataToDelete = data;
		BSTNode<T> node = this.searchNode(data, root);
		this.deleteNode(node);
		return dataToDelete;
	}
	
	private BSTNode<T> successor(BSTNode<T> node){
		if(node.getRight() != null){
			return findMinNode(node.getRight());
		}
		else{
			BSTNode<T> curr = node;
			while(curr.getParent() != null && curr.getParent().getLeft() != curr){
				curr = curr.getParent();
			}
			return curr;
		}
	}
	
	private BSTNode<T> predecessor(BSTNode<T> node){
		if(node.getLeft() != null){
			return findMinNode(node.getLeft());
		}
		else{
			BSTNode<T> curr = node;
			while(curr.getParent() != null && curr.getParent().getRight() != curr){
				curr = curr.getParent();
			}
			return curr;
		}
	}
	
	private BSTNode<T> findMinNode(BSTNode<T> subRoot){
		if(subRoot != null){
			if(subRoot.getLeft() != null){
				return findMinNode(subRoot.getLeft());
			}
			else{
				return subRoot;
			}
		}
		else{
			return null;
		}
	}
	
	public T minimum(BSTNode<T> subRoot){
		BSTNode<T> node = this.findMinNode(subRoot);
		return node.getData();
	}
	
	public String inOrderWalk(BSTNode<T> subTreeRoot){
		String result = "";
		if(subTreeRoot != null){
			result += inOrderWalk(subTreeRoot.getLeft());
			result += subTreeRoot.getData() + "\n";
			result += inOrderWalk(subTreeRoot.getRight());
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return inOrderWalk(root);
	}
	
	public Iterator<T> iterator(){
		Iterator<T> result = new BSTIterator();
		return result;
	}
	
	private class BSTIterator implements Iterator<T>{

		BSTNode<T> node = new BSTNode<T>(minimum(root));
		
		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			T result = node.getData();
			node = successor(node);
			return result;
		}

		@Override
		public void remove() {
			//Empty Method
		}
		
	}

	public static void main(String[] args){
		BST<Integer> ints = new BST<Integer>(new CompareByPrice());
		Integer three = new Integer(3);
		Integer two = new Integer(2);
		Integer one = new Integer(1);
		Integer five = new Integer(5);
		Integer four = new Integer(4);
		Integer six = new Integer(6);
		
		ints.insert(two);
		ints.insert(three);
		ints.insert(one);
		ints.insert(five);
		ints.insert(four);
		ints.insert(six);
		
		System.out.println(ints);
		
		Integer searchResult = ints.search(three);
		System.out.println(searchResult);
		ints.delete(two);
		System.out.println();
		System.out.println(ints);
	}

}
