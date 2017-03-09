package Graphs;

import java.util.Comparator;

public class VertexComparator<T> implements Comparator<Vertex<T>> {
	
	Comparator<T> c;
	
	public VertexComparator(Comparator<T> comp){
		this.c = comp;
	}

	@Override
	public int compare(Vertex<T> o1, Vertex<T> o2) {
		return this.c.compare(o1.getData(), o2.getData());
	}
}
