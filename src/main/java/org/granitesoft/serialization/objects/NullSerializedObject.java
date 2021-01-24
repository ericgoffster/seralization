package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import collections.immutable.ImmCollections;

/**
 * Represents a null value.   Nulls can essentially mimic the degenerate form of any
 * value.
 */
final class NullSerializedObject implements Serialized {
    private static final class NullBasic implements AtomSerialized {
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
    }
    
    @Override
    public StructSerialized asObject() {
        return new StructSerializedObject(ImmCollections.emptyMap());
    }
    
    @Override
    public ArraySerialized asArray() {
        return new ArraySerializedObject(ImmCollections.emptyList());
    }

    @Override
    public AtomSerialized asAtom() {
        return new NullBasic();
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


    NullSerializedObject() {
    }

}
