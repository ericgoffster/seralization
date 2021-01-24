package org.granitesoft.serialization.objects;

import collections.immutable.ImmCollections;

/**
 * Represents a null value.   Nulls can essentially mimic the degenerate form of any
 * value.
 */
final class NullSerializedObject implements Serialized {
    private static final ArraySerializedObject NULL_ARRAY = new ArraySerializedObject(ImmCollections.emptyList());
    private static final StructSerializedObject NULL_STRUCT = new StructSerializedObject(ImmCollections.emptyMap());
    private static final NullAtom NULL_ATOM = new NullAtom();
    @Override
    public StructSerialized asObject() {
        return NULL_STRUCT;
    }
    
    @Override
    public ArraySerialized asArray() {
        return NULL_ARRAY;
    }

    @Override
    public AtomSerialized asAtom() {
        return NULL_ATOM;
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
