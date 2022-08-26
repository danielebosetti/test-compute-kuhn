package kuhn;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeGeneratorTest {

	@Test
	public void testCompute() throws Exception {
		
		TreeGenerator gen = new TreeGenerator();
		gen.generate();
	}
}
