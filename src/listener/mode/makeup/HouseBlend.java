package listener.mode.makeup;


/**
 * 房子底汤
 * 
 * 房子的混合咖啡
 * @author PC
 *
 */
public class HouseBlend extends Beverage{

	public HouseBlend(){
		description = "House Blend Coffee";
	}
	
	
	@Override
	public double cost() {
		return 0.89;
	}

}
