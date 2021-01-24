package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import collections.immutable.ImmList;
import collections.immutable.ImmMap;

/**
 * Represents a serialized array of other serialized objects. The class is
 * immutable and cannot be extended.
 */
final class ArraySerializedObject implements Serialized {
	private final ImmList<Serialized> subElements;

	@Override
	public boolean isNumeric() {
		return false;
	}

	@Override
	public boolean isBoolean() {
		return false;
	}
	
	@Override
	public ImmList<Serialized> asList() {
	    return subElements;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		String space = "";
		String delim = " ";
		for(Serialized e: subElements) {
			sb.append(delim).append(space).append(e);
			delim = ",";
			space = " ";
		}
		return sb.append(space).append("]").toString();
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
		return subElements.equals(other.subElements);
	}

	ArraySerializedObject(ImmList<Serialized> subElements) {
		this.subElements = subElements;
	}

	@Override
	public boolean isNull() {
		return false;
	}
	
	@Override
	public Serialized add(Serialized value) {
	    return SerializedFactory.array(subElements.add(value));
	}
	
	@Override
	public Serialized set(int index, Serialized value) {
        return SerializedFactory.array(subElements.setAt(index, value));
	}
	
	@Override
	public Serialized set(String name, Serialized value) {
        throw new UnsupportedOperationException("add(name,value) not supported on arrays");
	}
	
	@Override
	public ImmMap<String, Serialized> asMap() {
	    throw new UnsupportedOperationException("asMap not supported on arrays");
	}

	@Override
	public String asString() {
		throw new UnsupportedOperationException("asString not supported on arrays");
	}

	@Override
	public char asChar() {
		throw new UnsupportedOperationException("asChar not supported on arrays");
	}

	@Override
	public boolean asBoolean() {
		throw new UnsupportedOperationException("asBoolean not supported on arrays");
	}

	@Override
	public BigDecimal asBigDecimal() {
		throw new UnsupportedOperationException("asBigDecimal not supported on arrays");
	}

	@Override
	public BigInteger asBigInteger() {
		throw new UnsupportedOperationException("asBigInteger not supported on arrays");
	}

	@Override
	public long asLong() {
		throw new UnsupportedOperationException("asLong not supported on arrays");
	}

	@Override
	public int asInt() {
		throw new UnsupportedOperationException("asInt not supported on arrays");
	}

	@Override
	public short asShort() {
		throw new UnsupportedOperationException("asShort not supported on arrays");
	}

	@Override
	public byte asByte() {
		throw new UnsupportedOperationException("asByte not supported on arrays");
	}

	@Override
	public double asDouble() {
		throw new UnsupportedOperationException("asDouble not supported on arrays");
	}

	@Override
	public float asFloat() {
		throw new UnsupportedOperationException("asFloat not supported on arrays");
	}
}
