package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import collections.immutable.ImmCollections;
import collections.immutable.ImmList;
import collections.immutable.ImmMap;

/**
 * Represents a null value.   Nulls can essentially mimic the degenerate form of any
 * value.
 */
final class NullSerializedObject implements Serialized {
	@Override
	public boolean isNumeric() {
		return true;
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public String toString() {
		return "null";
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return (this == obj);
	}

	@Override
	public String asString() {
		return null;
	}

	@Override
	public boolean asBoolean() {
		return false;
	}

	@Override
	public BigDecimal asBigDecimal() {
		return null;
	}

	NullSerializedObject() {
	}

	@Override
	public char asChar() {
		return '\0';
	}

	@Override
	public BigInteger asBigInteger() {
		return null;
	}

	@Override
	public long asLong() {
		return 0;
	}

	@Override
	public int asInt() {
		return 0;
	}

	@Override
	public short asShort() {
		return 0;
	}

	@Override
	public byte asByte() {
		return 0;
	}

	@Override
	public double asDouble() {
		return 0;
	}

	@Override
	public float asFloat() {
		return 0;
	}
	
	@Override
	public Serialized add(Serialized value) {
	    return SerializedFactory.array(ImmCollections.asList(value));
	}
	
	@Override
	public Serialized set(int index, Serialized value) {
	    throw new IndexOutOfBoundsException();
	}
	
	@Override
	public Serialized set(String name, Serialized value) {
	    return SerializedFactory.object(ImmCollections.asMap(name, value));
	}

	@Override
	public ImmList<Serialized> asList() {
	    return ImmCollections.asList();
	}

	@Override
	public ImmMap<String, Serialized> asMap() {
	    return ImmCollections.emptyMap();
	}

}
