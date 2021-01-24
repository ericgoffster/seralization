package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map.Entry;

import collections.immutable.ImmList;
import collections.immutable.ImmMap;

/**
 * Represents a serialized struct of other serialized objects. The class is
 * immutable and cannot be extended.
 */
final class StructSerializedObject implements Serialized {
	private final ImmMap<String, Serialized> elements;

	@Override
	public boolean isNumeric() {
		return false;
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("{");
	    String space = "";
	    String delim = " ";
	    for(Entry<String, Serialized> e: elements) {
	        String name = e.getKey();
	        Serialized value = e.getValue();
	        sb.append(delim).append(space).append("\"").append(name.replace("\\", "\\\\").replace("\"", "\\\"")).append("\": ").append(value);
	        delim = ",";
	        space = " ";
	    }
	    return sb.append(space).append("}").toString();
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
		return elements.equals(other.elements);
	}

	StructSerializedObject(ImmMap<String, Serialized> elements) {
		this.elements = elements;
	}
	
	@Override
	public Serialized set(String name, Serialized value) {
	    return new StructSerializedObject(elements.put(name, value));
	}

	@Override
	public boolean isNull() {
		return false;
	}
	
	@Override
	public ImmMap<String, Serialized> asMap() {
	    return elements;
	}
	
	@Override
	public Serialized add(Serialized value) {
        throw new UnsupportedOperationException("add(value) not supported on struct's");
	}
	
	@Override
	public Serialized set(int index, Serialized value) {
        throw new UnsupportedOperationException("set(index, value) not supported on struct's");
	}

	@Override
	public ImmList<Serialized> asList() {
	    throw new UnsupportedOperationException("asList not supported on struct's");
	}

	@Override
	public String asString() {
		throw new UnsupportedOperationException("asString not supported on struct's");
	}

	@Override
	public char asChar() {
		throw new UnsupportedOperationException("asChar not supported on struct's");
	}

	@Override
	public boolean asBoolean() {
		throw new UnsupportedOperationException("asBoolean not supported on struct's");
	}

	@Override
	public BigDecimal asBigDecimal() {
		throw new UnsupportedOperationException("asBigDecimal not supported on struct's");
	}

	@Override
	public BigInteger asBigInteger() {
		throw new UnsupportedOperationException("asBigInteger not supported on struct's");
	}

	@Override
	public long asLong() {
		throw new UnsupportedOperationException("asLong not supported on struct's");
	}

	@Override
	public int asInt() {
		throw new UnsupportedOperationException("asInt not supported on struct's");
	}

	@Override
	public short asShort() {
		throw new UnsupportedOperationException("asShort not supported on struct's");
	}

	@Override
	public byte asByte() {
		throw new UnsupportedOperationException("asByte not supported on struct's");
	}

	@Override
	public double asDouble() {
		throw new UnsupportedOperationException("asDouble not supported on struct's");
	}

	@Override
	public float asFloat() {
		throw new UnsupportedOperationException("asFloat not supported on struct's");
	}
}
