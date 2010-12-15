package javaxtest.annotation;

import javax.annotation.PostConstruct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PostConstructTest {



	@Test
	public void testPostConstruct() {
		TClass test = new TClass();
		assertEquals("test", test.getX());
	}


	private class TClass {
		private String x;

		public TClass(){

		}

		@PostConstruct
		public void setX() {
			this.x = "test";
		}

		public String getX() {
			return x;
		}

	}
}
