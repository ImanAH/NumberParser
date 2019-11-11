import java.util.HashMap;
import java.util.Map;

public class NumberParser {

	public static String PLUS_SIGN = "+";

	private Map<String, Integer> countryCodes = new HashMap<>();
	private Map<String, String> prefixes = new HashMap<>();

	public NumberParser(Map<String, Integer> callingCodes, Map<String, String> prefixes) {
		this.countryCodes = callingCodes;
		this.prefixes = prefixes;

	}

	public String parse(String dialledNumber, String userNumber) {

		Object key = null;
		Object value = null;
		String valueString = null;

		if (dialledNumber != null) {
			valueString = dialledNumber.substring(0, 1);

			for (Map.Entry entry : prefixes.entrySet()) {
				if (entry.getValue() != null && entry.getValue().equals(valueString)) {
					key = entry.getKey();
				}
			}

			for (Map.Entry entry : countryCodes.entrySet()) {
				if (key != null && entry.getKey().equals(key)) {
					value = entry.getValue();
					valueString = value.toString();

					StringBuilder sb = new StringBuilder(valueString);
					valueString = sb.insert(0, PLUS_SIGN).toString();

				}
			}

			if (key != null && valueString != null) {

				StringBuilder str = new StringBuilder(dialledNumber);
				dialledNumber = str.replace(0, 1, valueString).toString();
				System.out.println("dialledNumber: " + dialledNumber);

			}
		}
		return dialledNumber;

	}

}
