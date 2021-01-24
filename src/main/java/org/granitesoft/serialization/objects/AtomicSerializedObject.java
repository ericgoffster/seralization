package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import org.granitesoft.requirement.Requirements;

/**
 * Represents a serialized atomic value.   The atomic value can represent null, string, boolean, and numeric values.
 * arbitrary precision is allowed (via BigDecimal)
 */
final class AtomicSerializedObject implements AtomSerialized {
	private final String value;
	private final AtomType type;

	@Override
	public boolean isNumeric() {
		return type == AtomType.numeric;
	}

	@Override
	public boolean isBoolean() {
		return type == AtomType.bool;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public String toString() {
		return (type == AtomType.string) ? ("\"" + value.replace("\\", "\\\\").replace("\"", "\\\"") + "\"") : value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtomicSerializedObject other = (AtomicSerializedObject) obj;
		return Objects.equals(value, other.value) && type == other.type;
	}

	@Override
	public String asString() {
		return value;
	}

	@Override
	public boolean asBoolean() {
		switch(type) {
		case numeric: throw new UnsupportedOperationException("numeric values don't have a boolean value");
		case bool: return Boolean.parseBoolean(value);
		case string: throw new UnsupportedOperationException("string values don't have a boolean value");
		default: throw new IllegalStateException();
		}
	}

	@Override
	public BigDecimal asBigDecimal() {
		switch(type) {
		case numeric: return new BigDecimal(value);
		case bool: throw new UnsupportedOperationException("boolean values don't have a numeric value");
		case string: throw new UnsupportedOperationException("string values don't have a numeric value");
		default: throw new IllegalStateException();
		}
	}

	AtomicSerializedObject(String value, AtomType type) {
		this.value = Requirements.require(value, Requirements.notNull());
		this.type = Requirements.require(type, Requirements.notNull());
	}

	@Override
	public char asChar() {
		return value.length() == 0 ? '\0' : value.charAt(0);
	}

	@Override
	public BigInteger asBigInteger() {
		return asBigDecimal().toBigInteger();
	}

	@Override
	public long asLong() {
		return asBigDecimal().longValue();
	}

	@Override
	public int asInt() {
		return asBigDecimal().intValue();
	}

	@Override
	public short asShort() {
		return asBigDecimal().shortValue();
	}

	@Override
	public byte asByte() {
		return asBigDecimal().byteValue();
	}

	@Override
	public double asDouble() {
		return asBigDecimal().doubleValue();
	}

	@Override
	public float asFloat() {
		return asBigDecimal().floatValue();
	}

    @Override
    public AtomSerialized asAtom() {
        return this;
    }

    @Override
    public ArraySerialized asArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public StructSerialized asObject() {
        throw new UnsupportedOperationException();
    }
}
