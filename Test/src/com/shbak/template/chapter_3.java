package com.shbak.template;

public class chapter_3 {
	static public void main(String args[]){
		
		// AbstractDisplay(abstract class) type can cover any child concrete class
		// derived classes, subclasses, or child classes.
		// base classes, superclasses, or parent classes.
		AbstractDisplay cd = new CharDisplay('H');
		cd.display();
		AbstractDisplay sd = new StringDisplay("Hello World!");
		sd.display();
	} 
}

abstract class AbstractDisplay{
	public abstract void open();
	public abstract void print();
	public abstract void close();
	public final void display(){
		open();
		for(int i = 0; i<5; i++){
			print();
		}
		close();
	}
}

class CharDisplay extends AbstractDisplay{
	char c;
	CharDisplay(char c){
		this.c = c;
	}
	public void open(){
		System.out.print("<<");		
	};
	public void print(){
		System.out.print(this.c);	
	};
	public void close(){
		System.out.println(">>");
	};
}

class StringDisplay extends AbstractDisplay{
	private String string;
	private int width;
	
	StringDisplay(String string){
		this.string = string;
	}
	
	void printLine(){
		System.out.print("+");
		//for(int i = 0; i < this.string.getBytes().length; i++)
		for(int i = 0; i < this.string.length(); i++)
			System.out.print("-");
		System.out.println("+");
	}
	
	public void open(){
		printLine();		
	};
	public void print(){
		System.out.println("|" + this.string + "|");	
	};
	public void close(){
		printLine();
	};
}
