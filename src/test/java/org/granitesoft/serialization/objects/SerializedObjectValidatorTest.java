package org.granitesoft.serialization.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.granitesoft.requirement.Requirements;
import org.junit.Test;

import collections.immutable.ImmCollections;
import collections.immutable.ImmList;
import collections.immutable.ImmMap;

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
		    public Serialized set(int index, Serialized value) {
		        return null;
		    }
		    
		    @Override
		    public Serialized add(Serialized value) {
		        return null;
		    }
		    
		    @Override
		    public Serialized set(String name, Serialized value) {
		        return null;
		    }

			@Override
			public String asString() {
				return null;
			}

			@Override
			public char asChar() {
				return 0;
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

			@Override
			public boolean isNull() {
				return false;
			}


			@Override
			public boolean isNumeric() {
				return false;
			}

			@Override
			public boolean isBoolean() {
				return false;
			}

            @Override
            public ImmList<Serialized> asList() {
                return ImmCollections.emptyList();
            }

            @Override
            public ImmMap<String, Serialized> asMap() {
                return ImmCollections.emptyMap();
            }
		};
		Requirements.require(obj, SerializedFactory.IS_VALID_SERIAL);
	}
}
