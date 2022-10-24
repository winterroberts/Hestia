package net.aionstudios.hestia.data;

public class Pair<T1,T2> {
	
	protected T1 first;
	protected T2 second;
	
	public Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	
	public T1 getFirst() {
		return first;
	}
	
	public T2 getSecond() {
		return second;
	}
	
	public static <T1, T2> Pair<T1, T2> of(T1 first, T2 second) {
		return new Pair<>(first, second);
	}

}
