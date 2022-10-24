package net.aionstudios.hestia.data;

public class ComparablePair<T1 extends Comparable<T1>, T2> extends Pair<T1,T2> implements Comparable<ComparablePair<T1, T2>> {

	public ComparablePair(T1 first, T2 second) {
		super(first, second);
	}
	
	@Override
	public int compareTo(ComparablePair<T1, T2> o) {
		return first.compareTo(o.first);
	}
	
	public static <T1 extends Comparable<T1>, T2> ComparablePair<T1, T2> of(T1 first, T2 second) {
		return new ComparablePair<>(first, second);
	}
	
}
