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
		assertTrue(so.asAtom().asByte() == 0);
		assertTrue(so.asAtom().asShort() == 0);
		assertTrue(so.asAtom().asInt() == 0);
		assertTrue(so.asAtom().asLong() == 0);
		assertTrue(so.asAtom().asChar() == '\0');
		assertNull(so.asAtom().asString());
		assertTrue(so.asAtom().asFloat() == 0.0);
		assertTrue(so.asAtom().asDouble() == 0.0);
		assertFalse(so.asAtom().asBoolean());
		assertNull(so.asAtom().asBigDecimal());
		assertNull(so.asAtom().asBigInteger());
		assertTrue(so.asArray().size() == 0);
		assertNull(so.asObject().get("7"));
		assertTrue(so.asAtom().isNumeric());
		assertTrue(so.asAtom().isBoolean());
	}
}
