package listener.mode.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 批发工厂
 * 
 * @author PC
 *
 */
public class PizzaFactory {

	private static final Map<String, Integer> typeMap = new HashMap<String, Integer>();

	static {
		typeMap.put("cheese", 1);
		typeMap.put("pepperoni", 2);
		typeMap.put("clam", 3);
		typeMap.put("veggie", 4);
		typeMap.put("gongyi", 5);
	}

	public Pizza getInstance(String type) {
		Integer keyType = typeMap.get(type);
		switch (keyType) {
		case 1:
			return new Cheese(); 
			
		case 2:
			return new Pepperoni(); 
			
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;

		default:
			break;
		}
		return null;
	}

}
