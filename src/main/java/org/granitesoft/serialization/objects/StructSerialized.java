package org.granitesoft.serialization.objects;

import collections.immutable.ImmMap;

/**
 * Defines all of the "struct" or "map" operations for a serialized object.
 */
public interface StructSerialized {
    /**
     * Retrieve the struct as a map of Serialized objects.
     * This operation is *IMMUTABLE*.  The original array is unchanged.
     * @return the struct as a map of Serialized objects.
     * @throws UnsupportedOperationException if the operation is not appropriate for the type.
     * @throws IllegalArgumentException if array is null.
     */
    ImmMap<String, Serialized> asMap();

    Serialized set(String name, Serialized value);
}
