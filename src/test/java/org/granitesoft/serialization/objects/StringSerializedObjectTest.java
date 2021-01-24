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
		assertEquals(SerializedFactory.of("5").asString(), "5");
	}
	@Test
	public void testValues() {
		assertTrue(SerializedFactory.of((String)null).asByte() == 0);
		assertTrue(SerializedFactory.of((String)null).asShort() == 0);
		assertTrue(SerializedFactory.of((String)null).asInt() == 0);
		assertTrue(SerializedFactory.of((String)null).asLong() == 0);
		assertTrue(SerializedFactory.of((String)null).asChar() == '\0');
		assertNull(SerializedFactory.of((String)null).asString());
		assertTrue(SerializedFactory.of((String)null).asFloat() == 0.0);
		assertTrue(SerializedFactory.of((String)null).asDouble() == 0.0);
		assertFalse(SerializedFactory.of((String)null).asBoolean());
		assertNull(SerializedFactory.of((String)null).asBigDecimal());
		assertNull(SerializedFactory.of((String)null).asBigInteger());
		
		assertTrue(SerializedFactory.of("5").asChar() == '5');
		assertEquals(SerializedFactory.of("5").asString(), "5");
		
		assertTrue(SerializedFactory.of("").asChar() == '\0');
		assertTrue(SerializedFactory.of('5').asChar() == '5');
		assertEquals(SerializedFactory.of('5').asString(), "5");
				
		{
			Serialized so = SerializedFactory.of("5");
			assertFalse(so.isNull());
			assertFalse(so.isBoolean());
			assertFalse(so.isNumeric());
		}
	}
	
	@Test
	public void testExceptions() {
 		assertThrows(UnsupportedOperationException.class, () -> SerializedFactory.of("x").asBigDecimal());
 		assertThrows(UnsupportedOperationException.class, () -> SerializedFactory.of("x").asBoolean());
 	}
}
