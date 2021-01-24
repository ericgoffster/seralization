package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Defines all of the generic serialized object.
 * Some of these operations may return UnsupportedOperationException, if the operation makes no sense
 * for the object.
 */
public interface AtomSerialized extends Serialized {
	/**
	 * Returns the string value of this SerializedObject.
	 * The {@link SerializedFactory#NULL} object will return null.
	 * @return the string value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	String asString() ;
	
	/**
	 * Returns the char value of this SerializedObject.
	 * The {@link SerializedFactory#NULL} object will return '\0'.
	 * @return the char value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	char asChar() ;
	
	/**
	 * Returns the boolean value of this SerializedObject.
	 * The {@link SerializedFactory#NULL} object will return false.
	 * @return the boolean value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	boolean asBoolean() ;

	/**
	 * Returns the BigDecimal value of this SerializedObject.
	 * The {@link SerializedFactory#NULL} object will return null.
	 * @return the BigDecimal value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	BigDecimal asBigDecimal() ;

	/**
	 * Returns the BigInteger value of this SerializedObject.
	 * The result maybe "thunk'ed" or less have precision than the original number.
	 * The {@link SerializedFactory#NULL} object will return null.
	 * @return the BigInteger value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	BigInteger asBigInteger() ;

	/**
	 * Returns the long value of this SerializedObject.
	 * The result maybe "thunk'ed" or less have precision than the original number.
	 * The {@link SerializedFactory#NULL} object will return 0.
	 * @return the long value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	long asLong() ;

	/**
	 * Returns the int value of this SerializedObject.
	 * The result maybe "thunk'ed" or less have precision than the original number.
	 * The {@link SerializedFactory#NULL} object will return 0.
	 * @return the int value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	int asInt() ;

	/**
	 * Returns the short value of this SerializedObject.
	 * The result maybe "thunk'ed" or less have precision than the original number.
	 * The {@link SerializedFactory#NULL} object will return 0.
	 * @return the short value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	short asShort() ;

	/**
	 * Returns the byte value of this SerializedObject.
	 * The result maybe "thunk'ed" or less have precision than the original number.
	 * The {@link SerializedFactory#NULL} object will return 0.
	 * @return the byte value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	byte asByte() ;

	/**
	 * Returns the double value of this SerializedObject.
	 * The result maybe "thunk'ed" or less have precision than the original number.
	 * The {@link SerializedFactory#NULL} object will return 0.
	 * @return the double value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	double asDouble() ;

	/**
	 * Returns the float value of this SerializedObject.
	 * The result maybe "thunk'ed" or less have precision than the original number.
	 * The {@link SerializedFactory#NULL} object will return 0.
	 * @return the float value of this SerializedObject
	 * @throws UnsupportedOperationException if the operation is not appropriate for the type.
	 */
	float asFloat() ;

    /**
     * Returns true is it is numeric.
     * @return true is it is numeric
     */
    boolean isNumeric() ;

    /**
     * Returns true is it is boolean.
     * @return true is it is boolean
     */
    boolean isBoolean() ;
}
