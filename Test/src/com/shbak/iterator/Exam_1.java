package com.shbak.iterator;

import java.util.ArrayList;

public class Exam_1 {
	static public void main(String args[]){
		// using Array
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("Around the world in 80 Days"));
		bookShelf.appendBook(new Book("Bible"));
		bookShelf.appendBook(new Book("Cinderella"));
		bookShelf.appendBook(new Book("Daddy-Long-Legs"));
		
		Iterator it = bookShelf.iterator();
		while(it.hasNext()){
			Book book = (Book)it.next();
			System.out.println("book.getName() : " + book.getName());
		}
		
		// using ArrayList
		System.out.println("=========================== ArrayList ============================");		
		BookShelfArrayList bookShelfArrayList = new BookShelfArrayList();
		bookShelfArrayList.appendBook(new Book("Around the world in 80 Days"));
		bookShelfArrayList.appendBook(new Book("Bible"));
		bookShelfArrayList.appendBook(new Book("Cinderella"));
		bookShelfArrayList.appendBook(new Book("Daddy-Long-Legs"));
		Iterator itar = bookShelfArrayList.iterator();
		while(itar.hasNext()){
			Book book = (Book)itar.next();
			System.out.println("book.getName() : " + book.getName());
		}
	}
}
// interfaces

interface Iterator {
	public abstract boolean hasNext();
	public abstract Object next();
}

interface Aggregate {
	abstract Iterator iterator();
}

// common class
class Book {
	String name;

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}


// using array
class BookShelf implements Aggregate {
	private Book[] books;
	private int last = 0;

	public BookShelf(int maxsize) {
		this.books = new Book[maxsize];
	}

	public Book getBookAt(int index) {
		return books[index];
	}

	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}

	public int getLength() {
		return last;
	}

	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
}


class BookShelfIterator implements Iterator {
	private BookShelf bookShelf;
	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	public boolean hasNext() {
		if (index < bookShelf.getLength())
			return true;
		// else case
		return false;
	}

	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}
}


// using ArrayList
class BookShelfArrayList implements Aggregate {
	private ArrayList<Book> books;

	public BookShelfArrayList() {
		this.books = new ArrayList<Book>();
	}

	public Book getBookAt(int index) {
		return books.get(index);		
	}
	
	public void appendBook(Book book) {
		this.books.add(book);
	}

	public int getLength() {
		return this.books.size();
	}

	public Iterator iterator() {
		return new BookShelfIteratorArrayList(this);
	}
}

class BookShelfIteratorArrayList implements Iterator {
	private BookShelfArrayList bookShelfArrayList;
	private int index;
	
	public BookShelfIteratorArrayList(BookShelfArrayList bookShelfArrayList) {
		this.bookShelfArrayList = bookShelfArrayList;
		index = 0;
	}

	public boolean hasNext() {
		if (index < bookShelfArrayList.getLength())
			return true;
		// else case
		return false;
	}

	public Object next() {
		Book book = bookShelfArrayList.getBookAt(index);
		index++;
		return book;
	}
}
