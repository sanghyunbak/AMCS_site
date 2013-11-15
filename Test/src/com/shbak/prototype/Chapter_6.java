package com.shbak.prototype;

import java.lang.*;
import java.util.*;

// 복사해서 인스턴스 만들기

public class Chapter_6 {
	public static void main(String args[]) {
		Manager manager = new Manager();
		UnderlinePen upen = new UnderlinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');

		manager.register("strong message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);

		// construction
		Product p1 = manager.create("strong message");
		p1.use("hello world!");
		Product p2 = manager.create("warning box");
		p2.use("hello world!");
		Product p3 = manager.create("slash box");
		p3.use("hello world!");
		
		try{
			// if case
			
			Manager manager2 = new Manager();
			MessageBox dbox = new MessageBox('$');
			manager2.register("dollar box", dbox);
			Product p4 = manager2.create("dollar box");
			p4.use("hello TEST!");	
		}catch (Exception e){
			e.printStackTrace();
		}
		
		UnderlinePen testUnderline =new UnderlinePen('@');
		Product Pclone = (Product)testUnderline;
		Pclone.c	
	}
}

// interface는 상속을 받을 수 있다.
interface Product extends Cloneable {
	public abstract void use(String s);

	public abstract Product createClone();
}

class Manager {
	private HashMap showcase = new HashMap();

	public void register(String name, Product proto) {
		showcase.put(name, proto);
	}

	public Product create(String protoname) {
		Product p = (Product) showcase.get(protoname);
		return p.createClone();
	}
}

class MessageBox implements Product {
	private char decochar;

	public MessageBox(char decochar) {
		this.decochar = decochar;
	}

	public void use(String s) {
		int length = s.getBytes().length;
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println(" ");
		System.out.println(decochar + " " + s + " " + decochar);
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println(" ");
	}

	public Product createClone() {
		Product p = null;
		try {
			p = (Product) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}

class UnderlinePen implements Product {
	private char ulchar;

	public UnderlinePen(char ulchar) {
		this.ulchar = ulchar;
	}

	public void use(String s) {
		int length = s.getBytes().length;
		System.out.println("\"" + s + "\"");
		System.out.print(" ");
		for (int i = 0; i < length; i++) {
			System.out.print(ulchar);
		}
		System.out.println(" ");
	}

	public Product createClone() {
		Product p = null;
		try {
			p = (Product) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}
