package ch.stfw.hfit18.oldmacdonaldsfarm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CowTest {

	@Test
	void setName_is_getName() throws Exception {
		Cow cow = new Cow();
		cow.setName("Lisa");
		assertEquals("Lisa", cow.getName());
	}
	
	@Test
	void setAge_is_getAge() throws Exception {
		Cow cow = new Cow();
		cow.setAge(12);
		assertEquals(12, cow.getAge());
	}

}
