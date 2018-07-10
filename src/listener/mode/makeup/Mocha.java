package listener.mode.makeup;




/**
 * 加有摩卡的各种底汤
 * 
 * 摩卡调料
 * @author PC
 *
 */

public class Mocha extends CondimentDecorator{

	
	private Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	
	
	@Override
	public String getDescription() {
		
		/**
		 * 底汤+调料都描述出来
		 */
		return beverage.getDescription()+", Mocha";
	}

	@Override
	public double cost() {
		/**
		 * 要计算摩卡饮料的价格，首先把调用委托给被装饰对象，以计算价格，
		 * 然后再加上摩卡的价格，得到最后的结果
		 */
		return 0.20 + beverage.cost();
	}

}
