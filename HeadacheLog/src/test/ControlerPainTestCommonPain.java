package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controler.ControlerPain;

class ControlerPainTestCommonPain {

	@Test
	void testCommonPain() {
		ControlerPain cp = new ControlerPain();
		String resultado = "PRESSÃO";
		String result = cp.commonPain();
		assertTrue(result.equals(resultado));
	}

}
