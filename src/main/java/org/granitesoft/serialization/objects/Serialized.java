package org.granitesoft.serialization.objects;

/**
 * The generic serialized object, capable of representing string, numeric, array, or struct based objects.
 * This class contains everything needed to create and query serialized object.
 * All sub-classes of Serialized are *IMMUTABLE*.   You can't change them in any way.
 */
public interface Serialized {
    AtomSerialized asAtom();
    ArraySerialized asArray();
    StructSerialized asObject();

    /**
     * Returns true is it is null.
     * @return true is it is null
     */
    boolean isNull() ;
}
