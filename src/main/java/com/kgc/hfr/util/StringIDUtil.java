package com.kgc.hfr.util;

import org.junit.Test;

public class StringIDUtil {
	public static void main(String[] args) {
		getId();
	}
	public static String getId(){
		long time = System.currentTimeMillis();
		String s=String.valueOf(time);
		System.out.println("s = " + s);
		s=s.substring(3);
		System.out.println("s = " + s);
		return s;
	}
}
