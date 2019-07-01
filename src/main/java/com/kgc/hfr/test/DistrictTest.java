package com.kgc.hfr.test;

import com.fasterxml.jackson.core.io.UTF8Writer;
import com.kgc.hfr.entity.District;
import com.kgc.hfr.entity.DistrictExample;
import com.kgc.hfr.service.DistrictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/Spring_Mybatis.xml")*/
public class DistrictTest {
	/*@Autowired
	DistrictService service;*/
	@Test
	public void getDistritTest() throws UnsupportedEncodingException {
		ArrayList list=new ArrayList();
		list.add(2);
		System.out.println("ArrayList初始容量:"+getArrayListCapacity(list));
		ArrayList list2=new ArrayList();
		for (int i = 0; i < 12; i++) {
			list2.add(i);
		}
		System.out.println("啦啦");
		System.out.println("ArrayList初始容量扩容后:"+getArrayListCapacity(list2));
	}
	public static int getArrayListCapacity(ArrayList<?> arrayList) {
		Class<ArrayList> arrayListClass = ArrayList.class;
		try {
			Field field = arrayListClass.getDeclaredField("elementData");
			field.setAccessible(true);
			Object[] objects = (Object[])field.get(arrayList);
			return objects.length;
		}
			catch (NoSuchFieldException e) {
			e.printStackTrace();            return -1;        }
			catch (IllegalAccessException e) {
			e.printStackTrace();            return -1;
		}
}


}
