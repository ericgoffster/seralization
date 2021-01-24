package org.granitesoft.serialization.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

import org.junit.Test;

public class NumberSerializedObjectTest {
	@Test
	public void testEquals() {
		Serialized so = SerializedFactory.of(5);
		assertEquals(so, so);
		assertNotEquals(so, null);
		assertNotEquals(so, "");
		assertNotEquals(so, SerializedFactory.of(4));
		assertEquals(so, SerializedFactory.of(5));
	}
	@Test
	public void testHashCode() {
		Serialized so = SerializedFactory.of(5);
		HashSet<Serialized> h = new HashSet<>();
		h.add(so);
		assertTrue(h.contains(so));
	}
	@Test
	public void testToString() {
		assertEquals(SerializedFactory.of(5).toString(), "5");
		assertEquals(SerializedFactory.of(5.5).toString(), "5.5");
	}
	@Test
	public void testValues() {
		assertTrue(SerializedFactory.of((BigDecimal)null).asByte() == 0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asShort() == 0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asInt() == 0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asLong() == 0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asChar() == '\0');
		assertNull(SerializedFactory.of((BigDecimal)null).asString());
		assertTrue(SerializedFactory.of((BigDecimal)null).asFloat() == 0.0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asDouble() == 0.0);
		assertFalse(SerializedFactory.of((BigDecimal)null).asBoolean());
		assertNull(SerializedFactory.of((BigDecimal)null).asBigDecimal());
		assertNull(SerializedFactory.of((BigDecimal)null).asBigInteger());
		
		assertTrue(SerializedFactory.of((BigInteger)null).asByte() == 0);
		assertTrue(SerializedFactory.of((BigInteger)null).asShort() == 0);
		assertTrue(SerializedFactory.of((BigInteger)null).asInt() == 0);
		assertTrue(SerializedFactory.of((BigInteger)null).asLong() == 0);
		assertTrue(SerializedFactory.of((BigInteger)null).asChar() == '\0');
		assertNull(SerializedFactory.of((BigInteger)null).asString());
		assertTrue(SerializedFactory.of((BigInteger)null).asFloat() == 0.0);
		assertTrue(SerializedFactory.of((BigInteger)null).asDouble() == 0.0);
		assertFalse(SerializedFactory.of((BigInteger)null).asBoolean());
		assertNull(SerializedFactory.of((BigInteger)null).asBigDecimal());
		assertNull(SerializedFactory.of((BigInteger)null).asBigInteger());
		
		assertTrue(SerializedFactory.of(5).asByte() == 5);
		assertTrue(SerializedFactory.of(5).asShort() == 5);
		assertTrue(SerializedFactory.of(5).asInt() == 5);
		assertTrue(SerializedFactory.of(5).asLong() == 5);
		assertTrue(SerializedFactory.of(5).asChar() == '5');
		assertEquals(SerializedFactory.of(5).asString(), "5");
		assertTrue(SerializedFactory.of(5).asFloat() == 5.0);
		assertTrue(SerializedFactory.of(5).asDouble() == 5.0);
		assertEquals(SerializedFactory.of(5).asBigDecimal(), new BigDecimal("5"));
		assertEquals(SerializedFactory.of(5).asBigInteger(), new BigInteger("5"));
		
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asByte() == 5);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asShort() == 5);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asInt() == 5);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asLong() == 5);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asChar() == '5');
		assertEquals(SerializedFactory.of(BigInteger.valueOf(5)).asString(), "5");
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asFloat() == 5.0);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asDouble() == 5.0);
		assertEquals(SerializedFactory.of(BigInteger.valueOf(5)).asBigDecimal(), new BigDecimal("5"));
		assertEquals(SerializedFactory.of(BigInteger.valueOf(5)).asBigInteger(), new BigInteger("5"));
		
		assertTrue(SerializedFactory.of(5.1).asByte() == 5);
		assertTrue(SerializedFactory.of(5.1).asShort() == 5);
		assertTrue(SerializedFactory.of(5.1).asInt() == 5);
		assertTrue(SerializedFactory.of(5.1).asLong() == 5);
		assertTrue(SerializedFactory.of(5.1).asChar() == '5');
		assertEquals(SerializedFactory.of(5.1).asString(), "5.1");
		assertTrue(SerializedFactory.of(5.1).asFloat() == 5.1F);
		assertTrue(SerializedFactory.of(5.1).asDouble() == 5.1);
		assertEquals(SerializedFactory.of(5.1).asBigDecimal(), new BigDecimal("5.1"));
		assertEquals(SerializedFactory.of(5.1).asBigInteger(), new BigInteger("5"));
		
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asByte() == 5);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asShort() == 5);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asInt() == 5);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asLong() == 5);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asChar() == '5');
		assertEquals(SerializedFactory.of(BigDecimal.valueOf(5.1)).asString(), "5.1");
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asFloat() == 5.1F);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asDouble() == 5.1);
		assertEquals(SerializedFactory.of(BigDecimal.valueOf(5.1)).asBigDecimal(), new BigDecimal("5.1"));
		assertEquals(SerializedFactory.of(BigDecimal.valueOf(5.1)).asBigInteger(), new BigInteger("5"));

		assertTrue(SerializedFactory.of(0).asByte() == 0);
		assertTrue(SerializedFactory.of(0).asShort() == 0);
		assertTrue(SerializedFactory.of(0).asInt() == 0);
		assertTrue(SerializedFactory.of(0).asLong() == 0);
		assertTrue(SerializedFactory.of(0).asChar() == '0');
		assertEquals(SerializedFactory.of(0).asString(), "0");
		assertTrue(SerializedFactory.of(0).asFloat() == 0.0);
		assertTrue(SerializedFactory.of(0).asDouble() == 0.0);
		assertEquals(SerializedFactory.of(0).asBigDecimal(), new BigDecimal("0"));
		assertEquals(SerializedFactory.of(0).asBigInteger(), new BigInteger("0"));
		{
			Serialized so = SerializedFactory.of(5);			
			assertFalse(so.isNull());
			assertFalse(so.isBoolean());
			assertTrue(so.isNumeric());
		}
	}
}
