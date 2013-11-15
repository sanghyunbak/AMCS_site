package com.shbak.figure;

public class Figure0_6 {
	
	static Client clnt	= new Client();
	static Server serv	= new Server();
	static Device dev	= new Device();
	
	public static void main(String args[]){
		clnt.work();
		serv.open();
		serv.print();
		dev.write();
		serv.close();
	}
}


class Client{
	void work(){}
}

class Server{
	void open(){}
	void print(){}
	void close(){}
}

class Device{
	void write(){};
}