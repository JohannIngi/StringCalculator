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
	@Test
	public void MultipleNumberString() {
		assertEquals(42, StringCalculator.add("2,8,13,9,10"));
	}
	@Test
	public void NewLineNumberString() {
		assertEquals(42, StringCalculator.add("2\n8,13\n9,10"));
	}
}