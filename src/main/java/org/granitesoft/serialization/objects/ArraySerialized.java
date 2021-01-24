package org.granitesoft.serialization.objects;

import java.util.function.Function;
import java.util.function.Predicate;

import collections.immutable.ImmList;

/**
 * Defines all of the array-based operations for a serialized object.
 * Some of these operations may return UnsupportedOperationException, if the operation makes no sense
 * for the object.
 */
public interface ArraySerialized extends Serialized, ImmList<Serialized> {
    @Override
    <F> ImmList<F> map(Function<Serialized, F> function);
    @Override
    ArraySerialized filter(Predicate<Serialized> filter);
    @Override
    ArraySerialized retain(Iterable<? extends Serialized> other);
    @Override
    ArraySerialized removeAllIn(Iterable<? extends Serialized> other);
    @Override
    ArraySerialized add(Serialized element);
    @Override
    ArraySerialized setAt(int index, Serialized element);
    @Override
    ArraySerialized insertAt(int index, Serialized element);
    @Override
    ArraySerialized removeAt(int index);
    @Override
    ArraySerialized removeRange(int low, int high);
    @Override
    ArraySerialized replaceRange(int low, int high, ImmList<Serialized> other);
    @Override
    ArraySerialized insertListAt(int index, ImmList<Serialized> other);
    @Override
    ArraySerialized appendList(ImmList<Serialized> other);
    @Override
    ArraySerialized tailAt(int index);
    @Override
    ArraySerialized headAt(int index);
    @Override
    ArraySerialized getRange(int low, int high);
    @Override
    ArraySerialized reversed();
}
