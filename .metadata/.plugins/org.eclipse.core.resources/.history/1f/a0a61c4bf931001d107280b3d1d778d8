package test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import controler.ControlerMedicine;
import model.Medicine;

class ControlerMedicineTestCreate {

	@Test
	void testCreate() {
		try {
			ControlerMedicine cm = new ControlerMedicine();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Medicine m = new Medicine("Paracetamol",1, "Comprimido", format.parse("04/06/2022"));
			boolean result = cm.create(m);
			assertTrue(result);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
