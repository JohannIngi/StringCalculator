package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void EmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	@Test
	public void OneNumber() {
	assertEquals(2, StringCalculator.add("2"));
	assertEquals(109, StringCalculator.add("109"));
	}
	@Test
	public void TwoNumber() {
		assertEquals(7, StringCalculator.add("5,2"));
		assertEquals(2, StringCalculator.add("1,1"));
	}
	@Test
	public void MultipleNumber() {
		assertEquals(42, StringCalculator.add("2,8,13,9,10"));
		assertEquals(14, StringCalculator.add("2,4,8"));
	}
	@Test
	public void NewLineBetweenNumbers() {
		assertEquals(42, StringCalculator.add("2\r\n8,13\r\n9,10"));
		assertEquals(15, StringCalculator.add("1,2\r\n9,3"));
	}
	@Test
	public void NumberOverOnethousand() {
		assertEquals(3, StringCalculator.add("1010,3,2000"));
	}
	@Test
	public void NewDelimeter() {
		assertEquals(42, StringCalculator.add("//;\r\n2\r\n8,13\r\n9,10"));
	}	
}