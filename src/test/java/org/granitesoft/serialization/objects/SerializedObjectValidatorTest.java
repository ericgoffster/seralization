package org.granitesoft.serialization.objects;

import org.granitesoft.requirement.Requirements;
import org.junit.Test;

import collections.immutable.ImmCollections;

public class SerializedObjectValidatorTest {

	@Test
	public void test() {
		Requirements.require(SerializedFactory.NULL, SerializedFactory.IS_VALID_SERIAL);
		Requirements.require(SerializedFactory.of(1), SerializedFactory.IS_VALID_SERIAL);
		Requirements.require(SerializedFactory.of(true), SerializedFactory.IS_VALID_SERIAL);
		Requirements.require(SerializedFactory.of("string"), SerializedFactory.IS_VALID_SERIAL);
		Requirements.require(SerializedFactory.array(), SerializedFactory.IS_VALID_SERIAL);
		Requirements.require(SerializedFactory.object(), SerializedFactory.IS_VALID_SERIAL);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		Requirements.require(null, SerializedFactory.IS_VALID_SERIAL);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testBadObj() {
		Serialized obj = new Serialized() {

            @Override
            public AtomSerialized asAtom() {
                return new AtomicSerializedObject("1", AtomType.numeric);
            }

            @Override
            public ArraySerialized asArray() {
                return new ArraySerializedObject(ImmCollections.emptyList());
            }

            @Override
            public StructSerialized asObject() {
                return new StructSerializedObject(ImmCollections.emptyMap());
            }

            @Override
            public boolean isNull() {
                return false;
            }
		};
		Requirements.require(obj, SerializedFactory.IS_VALID_SERIAL);
	}
}
