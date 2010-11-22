package springbook.learningtest.junit;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class JUnitTest {

	// static JUnitTest testObject;
	static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();

	@Test
	public void test1() {
		// assertThat(this, is(not(sameInstance(testObject))));
		// testObject = this;

		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}

	@Test
	public void test2() {
		// assertThat(this, is(not(sameInstance(testObject))));
		// testObject = this;

		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}

	@Test
	public void test3() {
		// assertThat(this, is(not(sameInstance(testObject))));
		// testObject = this;

		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}
}
