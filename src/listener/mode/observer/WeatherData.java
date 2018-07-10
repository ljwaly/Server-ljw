package listener.mode.observer;

import java.util.Observable;


/**
 * 某一个注册号主题
 * 
 * 此处为气象主题
 * 
 * @author PC
 *
 */
public class WeatherData extends Observable{

	private float temperature;
	private float humidiry;
	private float pressure;
	
	
	/**
	 * 创建主题
	 * 
	 * 构造方法
	 */
	public WeatherData(){
		
	}
	
	
	/**
	 * 可以暴露给外部观察者，观察者可以主动拉取
	 * 
	 * 刷新所有的数据
	 * 
	 */
	public void measurementsChanged(){
		setChanged();//刷新前要进行设置允许刷新的判断
		notifyObservers();//进行刷新数据
	}
	
	/**
	 * 在启用notifyObservers（），要事先将参数重新查一下
	 * 
	 * 如果数据发生改变，则进行提示观察者变化
	 * 
	 */	
	public void setMeasurements(float temperature, float humidiry, float pressure){
		this.temperature = temperature;
		this.humidiry = humidiry;
		this.pressure = pressure;
		measurementsChanged();
	}


	public float getTemperature() {
		return temperature;
	}


	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}


	public float getHumidiry() {
		return humidiry;
	}


	public void setHumidiry(float humidiry) {
		this.humidiry = humidiry;
	}


	public float getPressure() {
		return pressure;
	}


	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	
	
	
}
