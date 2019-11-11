import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class NumberParserTest {

	Map<String, Integer> countryCodes = new HashMap<>();
	Map<String, String> prefix = new HashMap<>();
	NumberParser parser = new NumberParser(countryCodes, prefix);

	@Test
	public void test() {
		
		countryCodes.put("GB", 44);
		prefix.put("GB", "0");
		
		countryCodes.put("US", 1);
		prefix.put("US", "1");
		
		countryCodes.put("XX", 55);
		prefix.put("XX", "8");
		
	    assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));
	    assertEquals("+442079460056", parser.parse("+442079460056", "+441614960148"));
	    assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));
	    
	    assertEquals("+12079460056", parser.parse("12079460056", "11614960148"));
	    assertEquals("+12079460056", parser.parse("+12079460056", "+11614960148"));
	    assertEquals("+12079460056", parser.parse("12079460056", "+11614960148"));
	    
	    assertEquals("+552079460056", parser.parse("82079460056", "551614960148"));
	    assertEquals("+552079460056", parser.parse("+552079460056", "+551614960148"));
	    assertEquals("+552079460056", parser.parse("82079460056", "+551614960148"));

	}
	
	@Test
	public void nullTest() {
		
		countryCodes.put(null, null);
		prefix.put(null, null);
		
		assertNull(null, parser.parse(null, null));
		
	}


}
