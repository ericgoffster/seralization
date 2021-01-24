package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;

import org.granitesoft.requirement.Requirements;

import collections.immutable.ImmCollections;
import collections.immutable.ImmList;
import collections.immutable.ImmMap;

/**
 * Starting point for creating serialized objects.
 */
public final class SerializedFactory {
	private static final Set<Class<?>> VALID_CLASSES = new HashSet<Class<?>>();
	static {
		VALID_CLASSES.add(ArraySerializedObject.class);
		VALID_CLASSES.add(AtomicSerializedObject.class);
		VALID_CLASSES.add(NullSerializedObject.class);
		VALID_CLASSES.add(StructSerializedObject.class);
        VALID_CLASSES.add(NullAtom.class);
	}

	/**
	 * Represents the "true" boolean serialized object.
	 */
	public static final Serialized TRUE = new AtomicSerializedObject("true", AtomType.bool);
	
	/**
	 * Represents the "false" boolean serialized object.
	 */
	public static final Serialized FALSE = new AtomicSerializedObject("false", AtomType.bool);
	
	/**
	 * Represents the null serialized object.
	 */
	public static final Serialized NULL = new NullSerializedObject();
	
	static final Predicate<Serialized> IS_VALID_SERIAL =
			Requirements.and(Requirements.notNull(), Requirements.chain(Requirements.nameF(Serialized::getClass, () -> "class"), Requirements.memberOf(VALID_CLASSES)));
	private static final Predicate<Entry<String, Serialized>> ENTRY_VALIDATOR = Requirements.and(
			Requirements.chain(Requirements.nameF(Entry<String, Serialized>::getKey, () -> "key"), Requirements.notNull()),
			Requirements.chain(Requirements.nameF(Entry<String, Serialized>::getValue, () -> "value"), IS_VALID_SERIAL));
	
	private SerializedFactory() {
	}

	/**
	 * Creates a serialized object representing a boolean.
	 * @param value The boolean value
	 * @return a serialized object representing a boolean.
	 */
	public static Serialized of(boolean value) {
		return value ? SerializedFactory.TRUE : SerializedFactory.FALSE;
	}

	/**
	 * Creates a serialized object representing a BigDecimal.
	 * If <code>value</code> is null then {@link #NULL} is returned.
	 * @param value The BigDecimal value - Can be null
	 * @return a serialized object representing a BigDecimal.
	 */
	public static Serialized of(BigDecimal value) {
		return value == null ? SerializedFactory.NULL : new AtomicSerializedObject(value.toString(), AtomType.numeric);
	}

	/**
	 * Creates a serialized object representing a BigInteger.
	 * If <code>value</code> is null then {@link #NULL} is returned.
	 * @param value The BigInteger value - Can be null
	 * @return a serialized object representing a BigInteger.
	 */
	public static Serialized of(BigInteger value) {
		return value == null ? SerializedFactory.NULL : new AtomicSerializedObject(value.toString(), AtomType.numeric);
	}

	/**
	 * Creates a serialized object representing a double.
	 * @param value The double value
	 * @return a serialized object representing a double.
	 */
	public static Serialized of(double value) {
		return new AtomicSerializedObject(String.valueOf(value), AtomType.numeric);
	}

	/**
	 * Creates a serialized object representing a long.
	 * @param value The long value
	 * @return a serialized object representing a long.
	 */
	public static Serialized of(long value) {
		return new AtomicSerializedObject(String.valueOf(value), AtomType.numeric);
	}

	/**
	 * Creates a serialized object representing a string.
	 * If <code>value</code> is null then {@link #NULL} is returned.
	 * @param value The string value - Can be null
	 * @return a serialized object representing a string.
	 */
	public static Serialized of(String value) {
		return value == null ? NULL : new AtomicSerializedObject(value, AtomType.string);
	}

	/**
	 * Creates a serialized object representing a char.
	 * @param value The char value
	 * @return a serialized object representing a char.
	 */
	public static Serialized of(char value) {
		return new AtomicSerializedObject(String.valueOf(value), AtomType.string);
	}

	/**
	 * Creates an empty serialized object representing a struct.
	 * @return a serialized object representing an empty struct.
	 */
	public static Serialized object() {
		return new StructSerializedObject(ImmCollections.emptyMap());
	}
	
	/**
	 * Creates a pre-populated serialized object representing a struct.
	 * @param fields The initial map of fields - Can't be null
	 * @return a serialized object representing a struct.
	 */
	public static Serialized object(ImmMap<String, Serialized> fields) {
		return new StructSerializedObject(
		        Requirements.require(fields, Requirements.allMembers(ENTRY_VALIDATOR)));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * Use {@link ArraySerialized#add(Serialized)} to add more.
	 * @param elements The initial list of non-null elements - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(ImmList<Serialized> elements) {
		Requirements.require(elements, Requirements.allMembers(IS_VALID_SERIAL));
        return new ArraySerializedObject(elements);
	}

	/**
	 * Creates a pre-populated serialized object representing an array
	 * beginning from an array of bytes.
	 * @param elements The initial array of bytes - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(byte[] elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array
	 * beginning from an array of shorts.
	 * @param elements The initial array of bytes - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(short[] elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array
	 * beginning from an array of longs.
	 * @param elements The initial array of longs - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(long ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * beginning from an array of ints.
	 * @param elements The initial array of int's - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(int ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * beginning from an array of chars.
	 * @param elements The initial array of chars - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(char ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * beginning from an array of booleans.
	 * @param elements The initial array of booleans - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(boolean ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * beginning from an array of floats.
	 * @param elements The initial array of floats - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(float ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * beginning from an array of BigDecimals.
	 * @param elements The initial array of BigDecimals - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(BigDecimal ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * beginning from an array of BigIntegers.
	 * @param elements The initial array of BigIntegers - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(BigInteger ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * beginning from an array of doubles.
	 * @param elements The initial array of doubles - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(double ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array,
	 * beginning from an array of Strings.
	 * @param elements The initial array of Strings - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(String ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())).map(SerializedFactory::of));
	}

	/**
	 * Creates a pre-populated serialized object representing an array.
	 * Use {@link ArraySerialized#add(Serialized)} to add more.
	 * @param elements The initial list of elements - Can't be null
	 * @return a serialized object representing an array.
	 */
	public static Serialized array(Serialized ... elements) {
        return new ArraySerializedObject(ImmCollections.asList(Requirements.require(elements, Requirements.notNull())));
	}

	/**
	 * Creates a pre-populated serialized object representing an empty array.
	 * Use {@link ArraySerialized#add(Serialized)} (or its variants) to add more.
	 * @return a serialized object representing an array.
	 */
	public static Serialized array() {
		return new ArraySerializedObject(ImmCollections.emptyList());
	}
}
