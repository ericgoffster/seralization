package org.granitesoft.serialization.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class NullSerializedObjectTest {
	@Test
	public void testEquals() {
		Serialized so = SerializedFactory.NULL;
		assertEquals(so, so);
		assertNotEquals(SerializedFactory.NULL, null);
		assertNotEquals(SerializedFactory.NULL, "");
		assertEquals(SerializedFactory.NULL, SerializedFactory.NULL);
	}
	@Test
	public void testHashCode() {
		Serialized so = SerializedFactory.NULL;
		HashSet<Serialized> h = new HashSet<>();
		h.add(so);
		assertTrue(h.contains(so));
	}
	@Test
	public void testToString() {
		assertEquals(SerializedFactory.NULL.toString(), "null");
	}
	@Test
	public void testValues() {
		Serialized so = SerializedFactory.NULL;
		assertTrue(so.asByte() == 0);
		assertTrue(so.asShort() == 0);
		assertTrue(so.asInt() == 0);
		assertTrue(so.asLong() == 0);
		assertTrue(so.asChar() == '\0');
		assertNull(so.asString());
		assertTrue(so.asFloat() == 0.0);
		assertTrue(so.asDouble() == 0.0);
		assertFalse(so.asBoolean());
		assertNull(so.asBigDecimal());
		assertNull(so.asBigInteger());
		assertTrue(so.asList().size() == 0);
		assertNull(so.asMap().get("7"));
		assertTrue(so.isNumeric());
		assertTrue(so.isBoolean());
	}
}
