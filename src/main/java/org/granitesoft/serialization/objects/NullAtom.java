package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

final class NullAtom implements AtomSerialized {
    @Override
    public boolean isNumeric() {
        return true;
    }

    @Override
    public boolean isBoolean() {
        return true;
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

    @Override
    public boolean isNull() {
        return false;
    }
    
    @Override
    public String toString() {
        return "null";
    }
}