package listener.mode.observer;

import java.util.Observable;
import java.util.Observer;


/**
 * 某一个主题的观察者
 * (此处为气象观察者)
 * @author PC
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement{

	Observable observable;
	private float template;
	private float humidity;
	
	
	/**
	 * 创建一个观察者
	 * 现在构造器需要一个Observable当参数，并将this为观察者
	 * 
	 * 构造方法
	 */
	public CurrentConditionsDisplay(Observable observable) {
		super();
		this.observable = observable;
		observable.addObserver(this);
	}


	/**
	 * 重新update()方法，增加Observe和数据对象作为参数
	 */
	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)obs;
			this.template = weatherData.getTemperature();
			this.humidity = weatherData.getHumidiry();
			display();
		}
		
	}

	/**
	 * 实现功能
	 */
	@Override
	public void display() {
		System.out.println("CurrentConditionsDisplay [template=" + template + ", humidity=" + humidity + "]");
		
	}


	
}
