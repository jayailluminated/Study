package springbook.learningtest.template;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GenericsLineCallbackCalculatorTest {
	GenericsLineCallbackCalculator calculator;
	String numFilepath;

	@Before
	public void setUp() {
		this.calculator = new GenericsLineCallbackCalculator();
		this.numFilepath = getClass().getResource("number.txt").getPath();

	}

	@Test
	public void concatenateStrings() throws IOException {
		assertThat(calculator.concatenate(this.numFilepath), is("23"));
	}

	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calSum(this.numFilepath), is(5));
	}

	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMultiply(this.numFilepath), is(6));
	}

}
