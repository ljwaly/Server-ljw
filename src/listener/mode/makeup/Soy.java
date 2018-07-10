package listener.mode.makeup;


/**
 * 加有大豆(大豆酱油，大豆制作的调味品)调料各种底汤
 * 
 * 
 * 
 * @author PC
 *
 */
public class Soy extends CondimentDecorator{
	
	
	private Beverage beverage;
	
	public Soy(Beverage beverage){
		this.beverage = beverage;
	}
	

	@Override
	public String getDescription() {
		
		return beverage.getDescription()+", Soy";
	}

	@Override
	public double cost() {
		return 0.35+beverage.cost();
	}

}
