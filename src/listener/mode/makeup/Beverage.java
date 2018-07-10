package listener.mode.makeup;



/**
 * 
 * 所有底汤的超类
 * 
 * 星巴兹原始设计
 * Beverage:饮料
 * @author PC
 *
 */
public abstract class Beverage {

	protected String description = "Unknow Beverage";
	
	public String getDescription(){
		
		
		
		return description;
		
	}
	
	
	public abstract double cost();
	
}
