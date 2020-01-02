package com.bcits.constructor.abstraction;

public class ClassX implements Connection {

	@Override
	public Statement createStatement() {
//		return new ClassA();
		return new ClassC();

	}

}
