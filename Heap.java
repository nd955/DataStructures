package List;

import java.util.ArrayList;

public class Heap<T> {
	ArrayList<HeapData<T>> theArray = new ArrayList<HeapData<T>>();
	
	public HeapData<T> extractMin(){
		HeapData<T> result = theArray.get(0);
		this.swap(theArray, theArray.get(0), theArray.get(theArray.size() - 1));
		theArray.remove(theArray.size() - 1);
		this.heapify(0);
		
		return result;
	}
	
	public void decreaseKey(HeapData<T> hd, double newKey){
		hd.setKey(newKey);
		
		int index = theArray.size() - 1;
		while(index > 0 && theArray.get(this.parent(index)).getKey() > newKey){
			this.swap(theArray, theArray.get(index), theArray.get(this.parent(index)));
			index = this.parent(index);
		}
	}
	
	public void heapify(int index){
		if(index < theArray.size() - 1){
			int smallestIndex = this.findSmallestIndex(index);
			if(smallestIndex != index){
				this.swap(theArray, theArray.get(index), theArray.get(smallestIndex));
				this.heapify(smallestIndex);
			}
		}
	}
	
	public HeapData<T> insert(HeapData<T> hd){
		theArray.add(hd);
		hd.setIndex(theArray.indexOf(hd));
		
		int index = theArray.size() - 1;
		while(index > 0 && theArray.get(this.parent(index)).getKey() > hd.getKey()){
			this.swap(theArray, theArray.get(index), theArray.get(this.parent(index)));
			index = this.parent(index);
		}
		
		return hd;
	}
	
	public void buildHeap(){
		for(int i = parent(theArray.size() - 1); i > 0; i--){
			this.heapify(i);
		}
	}
	
	public int findSmallestIndex(int index){
		int smallestIndex = index;
		if(this.left(index) < theArray.size() - 1 && theArray.get(index).getKey() > theArray.get(this.left(index)).getKey()){
			smallestIndex = this.left(index);
		}
		if(this.right(index) < theArray.size() - 1 && theArray.get(smallestIndex).getKey() > theArray.get(this.right(index)).getKey()){
			smallestIndex = this.right(index);
		}
		return smallestIndex;
	}
	
	public int left(int i){
		return (2 * i + 1);
	}
	
	public int right(int i){
		return (2 * i + 2);
	}
	
	public int parent(int i){
		return (i - 1) / 2;
	}
	
	public void swap(ArrayList<HeapData<T>> arr, HeapData<T> one, HeapData<T> two){
		int tempIndex = one.getIndex();
		
		one.setIndex(two.getIndex());
		two.setIndex(tempIndex);
		
		arr.set(one.getIndex(), one);
		arr.set(two.getIndex(), two);
	}
	
	@Override
	public String toString(){
		String result = "";
		for(int i = 0; i < theArray.size(); i++){
			result += theArray.get(i).getData();
			result += " ";
			result += theArray.get(i).getKey();
			result += "\n";
		}
		return result;
	}
	
	public class HeapData<T>{
		private T data;
		private double key;
		private int index;
		
		public HeapData(T data, double key) {
			this.data = data;
			this.key = key;
		}

		public T getData() {
			return data;
		}

		public double getKey() {
			return key;
		}
		
		public void setKey(double key) {
			this.key = key;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

	}
	
	public static void main(String[] args){
		Heap<Integer> ints = new Heap<Integer>();
		
		Heap<Integer>.HeapData<Integer> one = ints.new HeapData<Integer>(1, 1);
		Heap<Integer>.HeapData<Integer> two = ints.new HeapData<Integer>(2, 2);
		Heap<Integer>.HeapData<Integer> three = ints.new HeapData<Integer>(3, 3);
		Heap<Integer>.HeapData<Integer> four = ints.new HeapData<Integer>(4, 4);
		Heap<Integer>.HeapData<Integer> five = ints.new HeapData<Integer>(5, 5);
		Heap<Integer>.HeapData<Integer> six = ints.new HeapData<Integer>(6, 6);
		Heap<Integer>.HeapData<Integer> eight = ints.new HeapData<Integer>(8, 8);
		Heap<Integer>.HeapData<Integer> sevenButOne = ints.new HeapData<Integer>(7, 1);
		
		ints.insert(three);
		ints.insert(six);
		ints.insert(one);
		ints.insert(four);
		ints.insert(two);
		ints.insert(five);
		
		ints.buildHeap();
		System.out.println(ints);
		
		ints.insert(eight);
		System.out.println(ints);
		
		ints.insert(sevenButOne);
		System.out.println(ints);
		
		ints.decreaseKey(six, 1);
		System.out.println(ints);
	}
	
}
