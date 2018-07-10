package listener.mode.makeup;

public class TheTest {
	public static void main(String[] args) {
		
		
		//Beverage houseblend = new HouseBlend();
		
		System.out.println("************************一杯意大利浓咖啡****************************");
		Beverage espresso = new Espresso();
		System.out.println(espresso.getDescription()+":"+espresso.cost());
		
		
		System.out.println("************************加摩卡****************************");
		espresso = new Mocha(espresso);
		System.out.println(espresso.getDescription()+":"+espresso.cost());
		
		System.out.println("************************加摩卡*2倍****************************");
		espresso = new Mocha(espresso);
		System.out.println(espresso.getDescription()+":"+espresso.cost());
		
		System.out.println("************************加一点大豆酱油****************************");
		espresso = new Soy(espresso);
		System.out.println(espresso.getDescription()+":"+espresso.cost());
		
	}
}
