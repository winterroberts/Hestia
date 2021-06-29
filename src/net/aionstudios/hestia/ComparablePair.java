package net.aionstudios.hestia;

public class ComparablePair<K extends Comparable<K>, V> implements Comparable<ComparablePair<K, V>> {
	
	private K key;
	private V value;
	
	public ComparablePair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(ComparablePair<K, V> o) {
		return key.compareTo(o.key);
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
	public void setValue(V newValue) {
		value = newValue;
	}
	
}
