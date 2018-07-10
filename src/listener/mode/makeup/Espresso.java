package listener.mode.makeup;

/**
 * 意大利底汤
 * 
 * Espresso:意大利浓咖啡
 * @author PC
 *
 */
public class Espresso extends Beverage{

	
	public Espresso() {
		description = "Espresso";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}

}
