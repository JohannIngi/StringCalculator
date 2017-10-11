package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void EmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	@Test
	public void OneNumberString() {
	assertEquals(2, StringCalculator.add("2"));
	}
	@Test
	public void TwoNumberString() {
		assertEquals(7, StringCalculator.add("5,2"));
	}
		/*@Test
	public void MultipleNumberString() {
		assertEquals(23, StringCalculator.add("8, 2, 13"));
	}*/
}