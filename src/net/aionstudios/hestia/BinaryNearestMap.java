package net.aionstudios.hestia;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryNearestMap<K extends Comparable<K>, V> {
    private List<ComparablePair<K, V>> terms;

    public BinaryNearestMap() {
        this.terms = new LinkedList<>();
    }
    
    public boolean containsKey(K key) {
    	int idxNearest = nearestMatch(key);
    	ComparablePair<K, V> nearest = idxNearest > -1 ? terms.get(idxNearest) : null;
    	if (nearest != null && nearest.getKey().compareTo(key) == 0) {
    		return true;
    	}
    	return false;
    }
    
    public ComparablePair<K, V> get(int idx) {
    	return terms.get(idx);
    }

    public void put(K key, V value) {
    	int idxNearest = nearestMatch(key);
    	ComparablePair<K, V> nearest = idxNearest > -1 ? terms.get(idxNearest) : null;
    	if (nearest != null && nearest.getKey().compareTo(key) == 0) {
    		nearest.setValue(value);
    	} else {
    		terms.add(idxNearest+1, new ComparablePair<K, V>(key ,value));
    	}
    }
    
    public ComparablePair<K, V> remove(K key) {
    	int idxNearest = nearestMatch(key);
    	ComparablePair<K, V> nearest = idxNearest > -1 ? terms.get(idxNearest) : null;
    	if (nearest != null && nearest.getKey().compareTo(key) == 0) {
    		terms.remove(nearest);
    	}
    	return nearest;
    }

    public int nearestMatch(K key) {
    	ComparablePair<K, V> dummy = new ComparablePair<>(key, null);
        int index = Collections.binarySearch(terms, dummy);
        if (index < 0) index = -(index+1)-1;
        if (index < terms.size()) return index;
        return -1;
    }
}