package Graphs;

import java.util.ArrayList;

public class Queue<T> {
	ArrayList<T> arr = new ArrayList<T>();
	T upNext;
	
	public void append(T data){
		arr.add(data);
		upNext = arr.get(0);
	}
	
	public int getIndexOf(T data){
		int index = -1;
		for(int i = 0; i < arr.size(); i++){
			if(data == arr.get(i)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public T extract(){
		T result = this.getUpNext();
		arr.remove(0);
		return result;
	}
	
	public T getUpNext(){
		return upNext;
	}
	
	public int getSize(){
		return arr.size();
	}
	
	public boolean isEmpty(){
		if(arr.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < arr.size(); i++){
			result += arr.get(i);
			result += "\n";
		}
		return result;
	}

	public static void main(String[] args){
		Queue<Integer> q = new Queue<Integer>();
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		Integer five = new Integer(5);
		
		q.append(one);
		q.append(two);
		q.append(three);
		q.append(four);
		q.append(five);
		
		System.out.println(q);
		System.out.println(q.getUpNext());
		System.out.println();
		
		System.out.println(q);
		
		System.out.println(q.extract());
		
		System.out.println();
		System.out.println(q);
	}
}
