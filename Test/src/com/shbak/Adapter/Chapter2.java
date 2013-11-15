package com.shbak.Adapter;

import java.util.Properties;

// Adapter pattern or Wrapper pattern

public class Chapter2 {
	public static void main(String args[]){
		Print p = new PrintBanner("Hello");
		p.printStrong();
		p.printWeak();
	}
}
// interface
interface Print{
	public void printWeak();
	public void printStrong();
}
// classes
class PrintBanner extends Banner implements Print{
	public PrintBanner(String string){
		super(string);
	}
	public void printWeak(){
		showWithParen();
	};
	public void printStrong(){
		showWithAster();
	};
//	public void showWithParen(){};
//	public void showWithAster(){};
}

class Banner{
	private String string;
	public Banner(String string){
		this.string = string;
	}
	public void showWithParen(){
		System.out.println("(" + this.string + ")");
	};
	public void showWithAster(){
		System.out.println("*" + this.string + "*");
	};
}

