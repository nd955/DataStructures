package Graphs;

import java.util.ArrayList;

public class Stack<T> {
	ArrayList<T> arr = new ArrayList<T>();
	T upNext;
	
	public void append(T data){
		arr.add(data);
		upNext = arr.get(arr.size() - 1);
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
		arr.remove(arr.size() - 1);
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
		Stack<Integer> s = new Stack<Integer>();
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		Integer five = new Integer(5);
		
		s.append(one);
		s.append(two);
		s.append(three);
		s.append(four);
		s.append(five);
		
		System.out.println(s);
		System.out.println(s.getUpNext());
		System.out.println();
		
		System.out.println(s);
		
		System.out.println(s.extract());
		
		System.out.println();
		System.out.println(s);
	}
}
