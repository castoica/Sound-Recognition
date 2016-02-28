package com.Helpers;

public class Log {
	public static void console(String text){
		System.out.println(text);
	}
	
	public static void console(byte[] byteArray){
		for(byte i: byteArray){
			System.out.print(i);
		}
		System.out.println();
	}
}
