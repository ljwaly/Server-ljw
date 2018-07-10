package proxy.ljwclass.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class ProxyHandler implements InvocationHandler{

	private Map<String, Object> cached = new HashMap<String, Object>();//添加换存
	private Object tar;

    //绑定委托对象，并返回代理类
    public Object bind(Object tar)
    {
        this.tar = tar;
        //绑定该类实现的所有接口，取得代理类 
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(), 
                                      tar.getClass().getInterfaces(), 
                                      this);
    }


	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		
		
		Object result = null;
		result = cached.get(tar.getClass().getName());
		
		if (result == null) {
	        //这里就可以进行所谓的AOP编程了
	        //在调用具体函数方法前，执行功能处理
			result = method.invoke(tar, args);//此处结果为方法返回值，如果无返回值，则result=null
			cached.put(tar.getClass().getName(), result);
			System.out.println("解析方法");
		}
		//在调用具体函数方法后，执行功能处理
        return result;
        
	}

}
