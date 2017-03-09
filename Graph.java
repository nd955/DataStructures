package Graphs;

import java.util.Comparator;
import java.util.Iterator;

import List.BST;
import List.Heap;

public class Graph<T> {
	
	Comparator<Vertex<T>> vertexComp;
	BST<Vertex<T>> bst;
	
	public Graph(Comparator<T> comp){
		this.vertexComp = new VertexComparator<T>(comp);
		this.bst = new BST<Vertex<T>>(this.vertexComp);
	}

	public void dijkstra(Vertex<T> source, Vertex<T> dest){
		Heap<Vertex<T>> q = new Heap<Vertex<T>>();
		
		Heap<Vertex<T>>.HeapData<Vertex<T>> h =q.extractMin();
		
		Vertex<T> u = h.getData();
		
		Iterator<Edge<T>> it = u.getEdgeIterator();
		while(it.hasNext()){
			Edge<T> e = it.next();
			Vertex<T> v = e.getTo();
			if(v.getHeapData().getKey() > h.getKey() + e.getWeight()){
				q.decreaseKey(v.getHeapData(), h.getKey() + e.getWeight());
				v.setParent(u);
			}
		}
	}
	
	public Stack<T> breadthFirstSearch(Vertex<T> source, Vertex<T> dest){
		Stack<T> s = new Stack<T>();
		Queue<T> q = new Queue<T>();
		Vertex<T> v = source;
		
		q.append(source.getData());
		while(source.getEdgeIterator().hasNext()){
			q.append(source.getEdgeIterator().next().getTo().getData());
		}
		
		while(!q.isEmpty()){
			if(q.extract() == dest.getData()){
				while(dest.parent != null){
					s.append(dest.getData());
					dest = dest.parent;
				}
				break;
			}
		}
		
		return s;
	}
	
	public Queue<T> depthFirstSearch(Vertex<T> source, Vertex<T> dest){
		Queue<T> q = new Queue<T>();
		Stack<T> s = new Stack<T>();
		
		while(source.parent != null){
			
		}
		
		return q;
	}
	
	public void updateParent(Queue<T> theQ){
		Queue<T> q = theQ;
		for(int i = 0; i < q.getSize() - 1; i++){
			
		}
	}
	
	public void addVertex(T data){
		Vertex<T> v = new Vertex<T>(data);
	}
	
	public void addEdge(Vertex<T> from, Vertex<T> to, double key){
		Edge<T> e = new Edge<T>(from, to, key);
	}
	
	public static void main(String[] args){
		
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		
	}
}
