package listener.mode.factory;


/**
 * 奶酪披萨
 * @author PC
 *
 */
public class Cheese extends Pizza {
	
	private String box;
	
	public Cheese() {
		name = "cheese";
	}

	@Override
	public void prapare() {
		description = "加奶油";
		
		
	}

	@Override
	public void cut() {
		
		
	}

	@Override
	public void box() {
		box="白盒子";
		
	}

	@Override
	public String toString() {
		return "Cheese [box=" + box + ", name="+ name + ", description="+ description + "]";
	}
	
}
