package listener.mode.observer;



/**
 * 观察者模式
 * @author PC
 *
 */
public class MainTest {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		
		
		currentConditionsDisplay.display();
		System.out.println("*************************************************");
		
		weatherData.setMeasurements(100, 98, 97);
		
	}
}
