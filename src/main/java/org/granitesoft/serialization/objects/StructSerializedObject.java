package org.granitesoft.serialization.objects;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import collections.immutable.ImmCollection;
import collections.immutable.ImmMap;
import collections.immutable.ImmSet;

/**
 * Represents a serialized struct of other serialized objects. The class is
 * immutable and cannot be extended.
 */
final class StructSerializedObject implements Serialized, StructSerialized {
	private final ImmMap<String, Serialized> elements;

	@Override
	public String toString() {
	    return elements.toString();
	}

	@Override
	public int hashCode() {
	    return elements.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StructSerializedObject other = (StructSerializedObject) obj;
		return asMap().equals(other.asMap());
	}

	StructSerializedObject(ImmMap<String, Serialized> elements) {
		this.elements = elements;
	}
	
	@Override
	public boolean isNull() {
		return false;
	}
	
    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean containsKey(String key) {
        return elements.containsKey(key);
    }

    @Override
    public Serialized get(String key) {
        return elements.get(key);
    }

    @Override
    public Serialized getOrDefault(String key, Supplier<Serialized> defaultSupplier) {
        return elements.getOrDefault(key, defaultSupplier);
    }

    @Override
    public Map<String, Serialized> asMap() {
        return elements.asMap();
    }

    @Override
    public ImmSet<String> keys() {
        return elements.keys();
    }

    @Override
    public ImmCollection<Serialized> values() {
        return elements.values();
    }

    @Override
    public Stream<Entry<String, Serialized>> stream() {
        return elements.stream();
    }

    @Override
    public void forEach(BiConsumer<String, Serialized> consumer) {
        elements.forEach(consumer);
        
    }

    @Override
    public Iterator<Entry<String, Serialized>> iterator() {
        return elements.iterator();
    }

    @Override
    public StructSerialized asObject() {
        return this;
    }

    @Override
    public ArraySerialized asArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public AtomSerialized asAtom() {
        throw new UnsupportedOperationException();
    }

    @Override
    public StructSerialized addAll(Iterable<? extends Entry<String, Serialized>> entries) {
        return new StructSerializedObject(elements.addAll(entries));
    }

    @Override
    public StructSerialized addAll(Map<String, Serialized> map) {
        return new StructSerializedObject(elements.addAll(map));
    }

    @Override
    public StructSerialized put(String key, Serialized value) {
        return new StructSerializedObject(elements.put(key, value));
    }

    @Override
    public StructSerialized removeKey(String key) {
        return new StructSerializedObject(elements.removeKey(key));
    }

    @Override
    public StructSerialized retainAllKeys(Iterable<? extends String> keys) {
        return new StructSerializedObject(elements.retainAllKeys(keys));
    }

    @Override
    public StructSerialized removeAllKeysIn(Iterable<? extends String> keys) {
        return new StructSerializedObject(elements.removeAllKeysIn(keys));
    }

    @Override
    public StructSerialized filterKeys(Predicate<String> keyFilter) {
        return new StructSerializedObject(elements.filterKeys(keyFilter));
    }

    @Override
    public StructSerialized filter(BiPredicate<String, Serialized> filter) {
        return new StructSerializedObject(elements.filter(filter));
    }
}
