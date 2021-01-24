package org.granitesoft.serialization.objects;

import collections.immutable.ImmList;

/**
 * Defines all of the array-based operations for a serialized object.
 * Some of these operations may return UnsupportedOperationException, if the operation makes no sense
 * for the object.
 */
public interface ArraySerialized {
    /**
     * Retrieve the array as a list of Serialized objects.
     * This operation is *IMMUTABLE*.  The original array is unchanged.
     * @return The array as a list of Serialized objects.
     * @throws UnsupportedOperationException if the operation is not appropriate for the type.
     * @throws IllegalArgumentException if array is null.
     */
    ImmList<Serialized> asList();

    Serialized add(Serialized value);
    
    Serialized set(int index, Serialized value);
}
