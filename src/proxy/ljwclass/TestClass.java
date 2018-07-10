package proxy.ljwclass;

import proxy.ljwclass.proxy.ProxyHandler;
import proxy.ljwclass.service.HarmSubject;
import proxy.ljwclass.service.KillSubject;
import proxy.ljwclass.service.Subject;

public class TestClass {
	public static void main(String[] args) {
		
		ProxyHandler proxy = new ProxyHandler();
		
		Subject sub1 = (Subject) proxy.bind(new KillSubject());
		String result1 = sub1.doSomething();
		System.out.println(result1);
		System.out.println("----------------------------------------------");
		
		Subject sub2 = (Subject) proxy.bind(new HarmSubject());
		String result2 = sub2.doSomething();
		System.out.println(result2);
		System.out.println("----------------------------------------------");
		Subject sub3 = (Subject) proxy.bind(new KillSubject());
		String result3 = sub3.doSomething();
		System.out.println(result3);
		System.out.println("----------------------------------------------");
		Subject sub4 = (Subject) proxy.bind(new HarmSubject());
		String result4 = sub4.doSomething();
		System.out.println(result4);
		System.out.println("----------------------------------------------");
		
	}
}
