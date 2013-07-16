package org.kranonit.tdd.stringCalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
    @Rule
    public ExpectedException ex = ExpectedException.none();


    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void shouldReturnZeroWhenEmptyString()  {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnTheSameNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void shouldReturnSumOfTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void shouldReturnSumOfThreeNumbers() {
        assertThat(calculator.add("1,2,3"), is(6));
    }

    @Test
    public void shouldAllowNewLineAsDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void shouldSupportDifferentDelimiters() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void shouldThrowExceptionWhenNegative() {
        ex.expect(NumberFormatException.class);
        ex.expectMessage("negatives not allowed");
        calculator.add("1,-2");
    }

    @Test
    public void shouldThrowExceptionContainingAllNegatives() {
        ex.expectMessage("-2");
        ex.expectMessage("-3");
        calculator.add("1,-2,-3");
    }

}
