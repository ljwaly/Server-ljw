package listener.mode.factory;



/**
 * 此栗子为简单工厂模式
 * 
 * 
 * 正常工厂模式是：
 * 一个抽象类店铺：里面包含2个方法：
 * 						一个实例方法：加工披萨，加工的方法是pizza自身的方法，pizza自身可以是一个接口，所有的具体的不同种类的pizza实现这个接口，进行自己pizza的制作步骤
 * 						一个抽象方法：工厂方法，需要每一个具体的pizza店铺的子店铺去实现，到底创建那种类型的pizza
 * 
 * 
 * @author PC
 *
 */
public class TestMain {
	public static void main(String[] args) {
		
		/**
		 * 开店的时候，给pizza店配置pizza工厂
		 */
		PizzaStore pizzaStore = new PizzaStore(new PizzaFactory());
		
		
		Pizza p1 = pizzaStore.orderPizza("cheese");
		System.out.println(p1);
		
		System.out.println("***************************************************");
		Pizza p2 = pizzaStore.orderPizza("pepperoni");
		System.out.println(p2);
	}
}
