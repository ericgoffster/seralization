package org.granitesoft.serialization.objects;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import collections.immutable.ImmList;

/**
 * Represents a serialized array of other serialized objects. The class is
 * immutable and cannot be extended.
 */
final class ArraySerializedObject implements ArraySerialized {
	private final ImmList<Serialized> subElements;

	@Override
	public String toString() {
	    return subElements.toString();
	}

	@Override
	public int hashCode() {
	    return subElements.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArraySerializedObject other = (ArraySerializedObject) obj;
		return asCollection().equals(other.asCollection());
	}

	ArraySerializedObject(ImmList<Serialized> subElements) {
		this.subElements = subElements;
	}

	@Override
	public boolean isNull() {
		return false;
	}
	
    @Override
    public AtomSerialized asAtom() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ArraySerialized asArray() {
        return this;
    }

    @Override
    public StructSerialized asObject() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Serialized> asCollection() {
        return subElements.asCollection();
    }

    @Override
    public Serialized getAt(int index) {
        return subElements.getAt(index);
    }

    @Override
    public ListIterator<Serialized> iterator() {
        return subElements.iterator();
    }

    @Override
    public int size() {
        return subElements.size();
    }

    @Override
    public Stream<Serialized> stream() {
        return subElements.stream();
    }

    @Override
    public <F> ImmList<F> map(Function<Serialized, F> function) {
        return subElements.map(function);
    }

    @Override
    public ArraySerialized filter(Predicate<Serialized> filter) {
        return new ArraySerializedObject(subElements.filter(filter));
    }

    @Override
    public ArraySerialized retain(Iterable<? extends Serialized> other) {
        return new ArraySerializedObject(subElements.retain(other));
    }

    @Override
    public ArraySerialized removeAllIn(Iterable<? extends Serialized> other) {
        return new ArraySerializedObject(subElements.removeAllIn(other));
    }

    @Override
    public ArraySerialized add(Serialized element) {
        return new ArraySerializedObject(subElements.add(element));
    }

    @Override
    public ArraySerialized setAt(int index, Serialized element) {
        return new ArraySerializedObject(subElements.setAt(index, element));
    }

    @Override
    public ArraySerialized insertAt(int index, Serialized element) {
        return new ArraySerializedObject(subElements.insertAt(index, element));
    }

    @Override
    public ArraySerialized removeAt(int index) {
        return new ArraySerializedObject(subElements.removeAt(index));
    }

    @Override
    public ArraySerialized removeRange(int low, int high) {
        return new ArraySerializedObject(subElements.removeRange(low, high));
    }

    @Override
    public ArraySerialized replaceRange(int low, int high, ImmList<Serialized> other) {
        return new ArraySerializedObject(subElements.replaceRange(low, high, other));
    }

    @Override
    public ArraySerialized insertListAt(int index, ImmList<Serialized> other) {
        return new ArraySerializedObject(subElements.insertListAt(index, other));
    }

    @Override
    public ArraySerialized appendList(ImmList<Serialized> other) {
        return new ArraySerializedObject(subElements.appendList(other));
    }

    @Override
    public ArraySerialized tailAt(int index) {
        return new ArraySerializedObject(subElements.tailAt(index));
    }

    @Override
    public ArraySerialized headAt(int index) {
        return new ArraySerializedObject(subElements.headAt(index));
    }

    @Override
    public ArraySerialized getRange(int low, int high) {
        return new ArraySerializedObject(subElements.getRange(low, high));
    }

    @Override
    public ArraySerialized reversed() {
        return new ArraySerializedObject(subElements.reversed());
    }
	
}
