package com.shbak.singleton;

public class chapter_5 {
	
	static public void main(String args[]){
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		if(s1 == s2)
			System.out.println("s1 and s2 are same");
		else
			System.out.println("s1 and s2 are different");
		
	}
}


class Singleton{
	private static Singleton singleton = new Singleton();
	private Singleton(){
		System.out.println("인스턴스를 생성했습니다.");
	}
	public static Singleton getInstance(){
		return singleton;
	};
}