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
		assertTrue(SerializedFactory.of((BigDecimal)null).asAtom().asByte() == 0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asAtom().asShort() == 0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asAtom().asInt() == 0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asAtom().asLong() == 0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asAtom().asChar() == '\0');
		assertNull(SerializedFactory.of((BigDecimal)null).asAtom().asString());
		assertTrue(SerializedFactory.of((BigDecimal)null).asAtom().asFloat() == 0.0);
		assertTrue(SerializedFactory.of((BigDecimal)null).asAtom().asDouble() == 0.0);
		assertFalse(SerializedFactory.of((BigDecimal)null).asAtom().asBoolean());
		assertNull(SerializedFactory.of((BigDecimal)null).asAtom().asBigDecimal());
		assertNull(SerializedFactory.of((BigDecimal)null).asAtom().asBigInteger());
		
		assertTrue(SerializedFactory.of((BigInteger)null).asAtom().asByte() == 0);
		assertTrue(SerializedFactory.of((BigInteger)null).asAtom().asShort() == 0);
		assertTrue(SerializedFactory.of((BigInteger)null).asAtom().asInt() == 0);
		assertTrue(SerializedFactory.of((BigInteger)null).asAtom().asLong() == 0);
		assertTrue(SerializedFactory.of((BigInteger)null).asAtom().asChar() == '\0');
		assertNull(SerializedFactory.of((BigInteger)null).asAtom().asString());
		assertTrue(SerializedFactory.of((BigInteger)null).asAtom().asFloat() == 0.0);
		assertTrue(SerializedFactory.of((BigInteger)null).asAtom().asDouble() == 0.0);
		assertFalse(SerializedFactory.of((BigInteger)null).asAtom().asBoolean());
		assertNull(SerializedFactory.of((BigInteger)null).asAtom().asBigDecimal());
		assertNull(SerializedFactory.of((BigInteger)null).asAtom().asBigInteger());
		
		assertTrue(SerializedFactory.of(5).asAtom().asByte() == 5);
		assertTrue(SerializedFactory.of(5).asAtom().asShort() == 5);
		assertTrue(SerializedFactory.of(5).asAtom().asInt() == 5);
		assertTrue(SerializedFactory.of(5).asAtom().asLong() == 5);
		assertTrue(SerializedFactory.of(5).asAtom().asChar() == '5');
		assertEquals(SerializedFactory.of(5).asAtom().asString(), "5");
		assertTrue(SerializedFactory.of(5).asAtom().asFloat() == 5.0);
		assertTrue(SerializedFactory.of(5).asAtom().asDouble() == 5.0);
		assertEquals(SerializedFactory.of(5).asAtom().asBigDecimal(), new BigDecimal("5"));
		assertEquals(SerializedFactory.of(5).asAtom().asBigInteger(), new BigInteger("5"));
		
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asByte() == 5);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asShort() == 5);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asInt() == 5);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asLong() == 5);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asChar() == '5');
		assertEquals(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asString(), "5");
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asFloat() == 5.0);
		assertTrue(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asDouble() == 5.0);
		assertEquals(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asBigDecimal(), new BigDecimal("5"));
		assertEquals(SerializedFactory.of(BigInteger.valueOf(5)).asAtom().asBigInteger(), new BigInteger("5"));
		
		assertTrue(SerializedFactory.of(5.1).asAtom().asByte() == 5);
		assertTrue(SerializedFactory.of(5.1).asAtom().asShort() == 5);
		assertTrue(SerializedFactory.of(5.1).asAtom().asInt() == 5);
		assertTrue(SerializedFactory.of(5.1).asAtom().asLong() == 5);
		assertTrue(SerializedFactory.of(5.1).asAtom().asChar() == '5');
		assertEquals(SerializedFactory.of(5.1).asAtom().asString(), "5.1");
		assertTrue(SerializedFactory.of(5.1).asAtom().asFloat() == 5.1F);
		assertTrue(SerializedFactory.of(5.1).asAtom().asDouble() == 5.1);
		assertEquals(SerializedFactory.of(5.1).asAtom().asBigDecimal(), new BigDecimal("5.1"));
		assertEquals(SerializedFactory.of(5.1).asAtom().asBigInteger(), new BigInteger("5"));
		
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asByte() == 5);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asShort() == 5);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asInt() == 5);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asLong() == 5);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asChar() == '5');
		assertEquals(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asString(), "5.1");
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asFloat() == 5.1F);
		assertTrue(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asDouble() == 5.1);
		assertEquals(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asBigDecimal(), new BigDecimal("5.1"));
		assertEquals(SerializedFactory.of(BigDecimal.valueOf(5.1)).asAtom().asBigInteger(), new BigInteger("5"));

		assertTrue(SerializedFactory.of(0).asAtom().asByte() == 0);
		assertTrue(SerializedFactory.of(0).asAtom().asShort() == 0);
		assertTrue(SerializedFactory.of(0).asAtom().asInt() == 0);
		assertTrue(SerializedFactory.of(0).asAtom().asLong() == 0);
		assertTrue(SerializedFactory.of(0).asAtom().asChar() == '0');
		assertEquals(SerializedFactory.of(0).asAtom().asString(), "0");
		assertTrue(SerializedFactory.of(0).asAtom().asFloat() == 0.0);
		assertTrue(SerializedFactory.of(0).asAtom().asDouble() == 0.0);
		assertEquals(SerializedFactory.of(0).asAtom().asBigDecimal(), new BigDecimal("0"));
		assertEquals(SerializedFactory.of(0).asAtom().asBigInteger(), new BigInteger("0"));
		{
			Serialized so = SerializedFactory.of(5);			
			assertFalse(so.isNull());
			assertFalse(so.asAtom().isBoolean());
			assertTrue(so.asAtom().isNumeric());
		}
	}
}
