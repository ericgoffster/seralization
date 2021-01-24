package org.granitesoft.serialization.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import collections.immutable.ImmCollections;

public class ArraySerializedObjectTest {

	@Test
	public void testEquals() {
		Serialized so = SerializedFactory.array(5);
		assertEquals(so, so);
		assertEquals(so, SerializedFactory.array(ImmCollections.asList(SerializedFactory.of(5))));
		assertNotEquals(so, null);
		assertNotEquals(so, "");
		assertNotEquals(so, SerializedFactory.array());
		assertNotEquals(so, SerializedFactory.array(6));
		assertNotEquals(so, SerializedFactory.array(5, 6));
		assertEquals(so, SerializedFactory.array(5));
	}
	@Test
	public void testHashCode() {
		Serialized so = SerializedFactory.array(5);
		HashSet<Serialized> h = new HashSet<>();
		h.add(so);
		assertTrue(h.contains(so));
	}
	@Test
	public void testToString() {
		assertEquals(SerializedFactory.array(5, 6).toString(), "[5, 6]");
		assertEquals(SerializedFactory.array(5).toString(), "[5]");
		assertEquals(SerializedFactory.array().toString(), "[]");
	}
	@Test
	public void testNull() {
	    Serialized[] foo = null;
		assertThrows(IllegalArgumentException.class, () -> SerializedFactory.array(foo));
	}
	@Test
	public void testIsNull() {
		assertFalse(SerializedFactory.array().isNull());
	}
	@Test
	public void testExceptions() {
		Serialized so = SerializedFactory.array();
		assertThrows(UnsupportedOperationException.class, () -> so.asAtom());
 	}
}
