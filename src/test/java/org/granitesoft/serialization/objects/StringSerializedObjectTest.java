package org.granitesoft.serialization.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class StringSerializedObjectTest {

	@Test
	public void testEquals() {
		Serialized so = SerializedFactory.of("5");
		assertEquals(so, so);
		assertNotEquals(SerializedFactory.of("5"), null);
		assertNotEquals(SerializedFactory.of("5"), "");
		assertNotEquals(SerializedFactory.of("5"), SerializedFactory.of("4"));
		assertEquals(SerializedFactory.of("5"), SerializedFactory.of("5"));
	}
	@Test
	public void testHashCode() {
		Serialized so = SerializedFactory.of("5");
		HashSet<Serialized> h = new HashSet<>();
		h.add(so);
		assertTrue(h.contains(so));
	}
	@Test
	public void testToString() {
		assertEquals(SerializedFactory.of("5").toString(), "\"5\"");
	}
	@Test
	public void testToStringValue() {
		assertEquals(SerializedFactory.of("5").asAtom().asString(), "5");
	}
	@Test
	public void testValues() {
		assertTrue(SerializedFactory.of((String)null).asAtom().asByte() == 0);
		assertTrue(SerializedFactory.of((String)null).asAtom().asShort() == 0);
		assertTrue(SerializedFactory.of((String)null).asAtom().asInt() == 0);
		assertTrue(SerializedFactory.of((String)null).asAtom().asLong() == 0);
		assertTrue(SerializedFactory.of((String)null).asAtom().asChar() == '\0');
		assertNull(SerializedFactory.of((String)null).asAtom().asString());
		assertTrue(SerializedFactory.of((String)null).asAtom().asFloat() == 0.0);
		assertTrue(SerializedFactory.of((String)null).asAtom().asDouble() == 0.0);
		assertFalse(SerializedFactory.of((String)null).asAtom().asBoolean());
		assertNull(SerializedFactory.of((String)null).asAtom().asBigDecimal());
		assertNull(SerializedFactory.of((String)null).asAtom().asBigInteger());
		
		assertTrue(SerializedFactory.of("5").asAtom().asChar() == '5');
		assertEquals(SerializedFactory.of("5").asAtom().asString(), "5");
		
		assertTrue(SerializedFactory.of("").asAtom().asChar() == '\0');
		assertTrue(SerializedFactory.of('5').asAtom().asChar() == '5');
		assertEquals(SerializedFactory.of('5').asAtom().asString(), "5");
				
		{
			Serialized so = SerializedFactory.of("5");
			assertFalse(so.isNull());
			assertFalse(so.asAtom().isBoolean());
			assertFalse(so.asAtom().isNumeric());
		}
	}
	
	@Test
	public void testExceptions() {
 		assertThrows(UnsupportedOperationException.class, () -> SerializedFactory.of("x").asAtom().asBigDecimal());
 		assertThrows(UnsupportedOperationException.class, () -> SerializedFactory.of("x").asAtom().asBoolean());
 	}
}
