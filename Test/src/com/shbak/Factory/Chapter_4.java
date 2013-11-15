package com.shbak.Factory;

import java.util.*;

public class Chapter_4 {
	
	static final String SERIAL = "SERIAL_VERSION";
	
	static public void main(String args[]){
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("홍길동");
		Product card2 = factory.create("이순신");
		Product card3 = factory.create("강감찬");
		
		card1.use();
		card2.use();
		card3.use();		
		
	}
}

abstract class Product{
	public Product(String name) {
	}
	public abstract void use();
}
// serial 변수의 생성
abstract class Factory{
	
	public final Product create(String owner){
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
	
	abstract public Product createProduct(String owner);
	abstract public void registerProduct(Product product);
}

class IDCard extends Product{
	private String owner;
	IDCard(String owner, int serial){
		super("hello"); //must understanding this!!!
		System.out.println(owner + "의 카드를 만듭니다., Serial : " + serial);
		this.owner = owner;
	}
	
	IDCard(String owner){
		super("hello"); //must understanding this!!!
		System.out.println(owner + "의 카드를 만듭니다.");
		this.owner = owner;
	}
	public void use(){
		System.out.println(owner + "의 카드를 사용합니다.");
	};
	
	public String getOwner(){
		return owner;
	};
}

class IDCardFactory extends Factory{
	
	private List<String> owners = new ArrayList<String>();
	private int serial = 100;
	
	public Product createProduct(String owner){
		return new IDCard(owner, this.serial++);
	}
	public void registerProduct(Product product){
		owners.add(((IDCard)product).getOwner());
	}
	public List<String> getOwners(){
		return owners;
	}
}
