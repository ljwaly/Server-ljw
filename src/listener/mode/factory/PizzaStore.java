package listener.mode.factory;


/**
 * 店家
 * 
 * 
 * @author PC
 *
 */
public class PizzaStore {

	/**
	 * 应为店家可以有不同的批发工厂类，
	 * （可以将批发工厂设置为接口，所有的可配置工厂都要事先这个接口，
	 * 	就像苹果公司从来不做手机，但是富士康要做苹果手机，必须要得到苹果公司授权，一个接口就是一个授权
	 * 	此例子中设置为一个实体类，配置的话 可以配置这个类的所有子类）
	 * 
	 * 所以是可以配置的
	 * 
	 * 
	 * 目的主要是为了将容易修改的地方和不容易修改的地方分开，容易修改的在工厂中进行封装，比如添加pizza的种类
	 * 
	 */
	private PizzaFactory factory;

	public PizzaStore(PizzaFactory factory){
		this.factory = factory;
	}
	
	public Pizza orderPizza(String type){
		Pizza pizza = factory.getInstance(type);
		
		pizza.prapare();
		
		pizza.box();
		return pizza;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public PizzaFactory getFactory() {
		return factory;
	}

	public void setFactory(PizzaFactory factory) {
		this.factory = factory;
	}
	
}
