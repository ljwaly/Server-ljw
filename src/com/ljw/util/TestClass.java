package com.ljw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

import com.alibaba.fastjson.JSON;

public class TestClass {
//	public static void main(String[] args) throws ParseException {
//		String str ="00:00:00";
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		Date date = sdf.parse(str);
//		System.out.println(date);
//		System.out.println(date.getTime());
//		System.out.println(8*3600*1000);
//		String str1 ="01:22:22";
//		
//		
//		System.out.println(str.compareTo(str1));
//		System.out.println(str.compareTo("00:00:00"));
//		System.out.println(str1.compareTo(str));
//	}
	
	
//	public static void main(String[] args) {
//		
//		
//		Student stu=null;
//		get(stu);
//		System.out.println(stu);
//		
//		Student stu1 = new Student();
//		stu1.setAge("23");
//		get(stu1);
//		System.out.println(stu1);
//	}
//	
//	
//	static void get(Student stu){
//		if (stu==null) {
//			stu =new Student();
//			stu.setAge("24");
//			stu.setName("wutian");
//		}else{
//			stu.setName("wufa");
//		}
//	}
	
	
	
	public static void main(String[] args) {
		
		Map<Integer,Long> map = new HashMap<Integer, Long>(16);
		map.put(1, 2L);
		map.put(2, 3L);
		map.put(4, 5L);
		map.put(5, 6L);
		map.put(6, 7L);
		map.put(7, 8L);
		
		Set<Entry<Integer,Long>> entrySet = map.entrySet();
		Iterator<Entry<Integer, Long>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Long> next = iterator.next();
			System.out.println("key="+next.getKey()+",value="+next.getValue());
			
		}
		
		
		MapAction action=new MapAction();
		
		map.forEach(action);
		
		Long result = action.getSum();
 		System.out.println(result);
	}
}

class MapAction implements BiConsumer<Integer, Long>{

	private Long sum = 0L;
	
	@Override
	public void accept(Integer t, Long u) {
		System.out.println(t+":"+u);
		
		sum+=(t+u);
		System.out.println(sum);
	}

	public Long getSum() {
		return sum;
	}
}
