package listener.mode.makeup;

/**
 * 所有的调料底汤的超类
 * 调料类
 * 
 * 
 * 
 * 也就是装饰着类
 * Condiment:调味品
 * Decorator:装饰
 * 需要让CondimentDecorator能取代Beverage类
 * @author PC
 *
 */
public abstract class CondimentDecorator extends Beverage{

	//所有的的调料装饰着都必须重新实现getDescription()方法
	public abstract String getDescription();
	
	
}
