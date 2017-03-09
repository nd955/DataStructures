package Graphs;

import java.util.Iterator;

import List.DoublyLinkedList;
import List.Heap;

public class Vertex<T> {
	T data;
	Vertex<T> parent = null;
	Heap<Vertex<T>>.HeapData<Vertex<T>> heapData = null;
	DoublyLinkedList<Edge<T>> adjList = new DoublyLinkedList<Edge<T>>();
	
	public Vertex(T data) {
		this.data = data;
	}
	
	public Iterator<Edge<T>> getEdgeIterator(){
		return this.adjList.iterator();
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Vertex<T> getParent() {
		return parent;
	}

	public void setParent(Vertex<T> parent) {
		this.parent = parent;
	}
	
	public Heap<Vertex<T>>.HeapData<Vertex<T>> getHeapData() {
		return heapData;
	}

	public void setHeapData(Heap<Vertex<T>>.HeapData<Vertex<T>> heapData) {
		this.heapData = heapData;
	}

	public void addEdgeTo(Vertex<T> to, double weight){
		Edge<T> e = new Edge<T>(this, to, weight);
		this.adjList.append(e);
	}

	@Override
	public String toString() {
		String result = data + ": ";
		
		Iterator<Edge<T>> it = this.adjList.iterator();
		
		while(it.hasNext()){
			Edge<T> e = it.next();
			result += e + " ";
		}
		
		return result;
	}
	
	public static void main(String[] args){
		Vertex<String> v = new Vertex<String>("Boston");
		Vertex<String> w = new Vertex<String>("StLouis");
		Vertex<String> x = new Vertex<String>("Detroit");
		Vertex<String> y = new Vertex<String>("LA");
		
		System.out.println(v);
		System.out.println(w);
		
		v.addEdgeTo(w, 8);
		v.addEdgeTo(x, 10);
		x.addEdgeTo(y, 20);
		w.addEdgeTo(v, 30);
		x.addEdgeTo(v, 40);
		
		System.out.println(v);
		System.out.println(w);
		System.out.println(x);
		System.out.println(y);
	}
	
}
