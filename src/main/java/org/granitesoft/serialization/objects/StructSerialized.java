package org.granitesoft.serialization.objects;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import collections.immutable.ImmMap;

/**
 * Defines all of the "struct" or "map" operations for a serialized object.
 */
public interface StructSerialized extends ImmMap<String, Serialized> {
    @Override
    StructSerialized addAll(Iterable<? extends Entry<String, Serialized>> entries);
    @Override
    StructSerialized addAll(Map<String, Serialized> map);
    @Override
    StructSerialized put(String key, Serialized value);   
    @Override
    StructSerialized removeKey(String key); 
    @Override
    StructSerialized retainAllKeys(Iterable<? extends String> keys);
    @Override
    StructSerialized removeAllKeysIn(Iterable<? extends String> keys);    
    @Override
    StructSerialized filterKeys(Predicate<String> keyFilter);
    @Override
    StructSerialized filter(BiPredicate<String, Serialized> filter);
}
