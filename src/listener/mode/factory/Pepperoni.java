package listener.mode.factory;

public class Pepperoni extends Pizza{
	
	private String box;
	public Pepperoni(){
		name = "pepperoni";
	}

	@Override
	public void prapare() {
		description = "加肉";
		
	}

	@Override
	public void cut() {
		
		
	}

	@Override
	public void box() {
		box="黑盒子";
		
	}

	@Override
	public String toString() {
		return "Pepperoni [box=" + box + ", name="+ name + ", description="+ description + "]";
	}
	
}
